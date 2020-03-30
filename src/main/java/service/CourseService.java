package service;

import dao.CourseDAO;
import entities.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

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
        } catch (Exception ex) {
            if (transaction !=null) {
                transaction.rollback();
            } ex.printStackTrace();
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
    public Course getCourseInfo(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Course course = session.find(Course.class, id);
            return course;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteCourse(Course course) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(course);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction !=null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
