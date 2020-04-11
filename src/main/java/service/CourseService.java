package service;

import dao.CourseDAO;
import entities.Course;
import entities.Student;
import entities.Topic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CourseService implements CourseDAO {

    //All fields should be filled in GUI, create object and transfer to this method.
    //All exceptions cause by incorrect input should be caught before object creation in GUI

    @Override
    public void createCourse(Course course) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void updateCourse(Course course) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public List<Course> getListOfCourses() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            // Create CriteriaQuery
            CriteriaQuery<Course> criteria = builder.createQuery(Course.class);
            // Specify criteria root
            criteria.from(Course.class);
            // Execute query
            List<Course> courseList = session.createQuery(criteria).getResultList();
            session.close();
            return courseList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Course c");
        List<Course> courseList = query.list();
        transaction.commit();
        session.close();
        return courseList;
         */
    }

    @Override
    public Course getCourseInfo(Course course) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Course course1 = session.find(Course.class, course.getCourseID());
            session.close();
            return course1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteCourse(Course course) {
        removeCourseStudentConstraint(course);
        removeCourseTopicConstraint(course);
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Course course1 = new Course();
            course1.setCourseID(course.getCourseID());
            session.delete(course1);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void removeCourseStudentConstraint(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Student where course_courseID = :b");
        query.setParameter("b", course.getCourseID());
        List<Student> list = query.getResultList();
        for (Student student : list) {
            student.setCourse(null);
        }
        tx.commit();
        session.close();
    }

    public void removeCourseTopicConstraint(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Topic where course_courseID = :b");
        query.setParameter("b", course.getCourseID());
        List<Topic> topic = query.getResultList();
        for (Topic t : topic) {
            t.setCourse(null);
        }
        tx.commit();
        session.close();
    }
}
