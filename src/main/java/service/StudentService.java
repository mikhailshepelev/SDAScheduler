package service;

import dao.StudentDAO;
import entities.Course;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class StudentService implements StudentDAO {

    //All fields should be filled in GUI, create object and transfer to this method.
    //All exceptions cause by incorrect input should be caught before object creation in GUI
    @Override
    public void createStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }

    @Override
    public void updateStudent(int id) {
        //TODO: consider method which fill student empty fields if it was not filled during creation
    }

    @Override
    public List<Student> getFullListOfStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        tx.commit();
        session.close();
        return students;
    }

    @Override
    public List<Student> getListOfStudentsFromCourse(int courseID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query1 = session.createQuery("from Course where id = :b");
        query1.setParameter("b", courseID);
        Course course = (Course) query1.getSingleResult();
        tx.commit();
        session.close();
        return course.getStudentsList();
    }

    @Override
    public void deleteStudent(int id) {
        //getlist method in course class works after student deletion - tested
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = new Student();
        student.setSID(id);
        session.delete(student);
        tx.commit();
        session.close();
    }

    @Override
    public void addToCourse(int studentID, int courseID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from Student where id = :a");
            query.setParameter("a", studentID);
            Student student = (Student) query.getSingleResult();
            Query query1 = session.createQuery("from Course where id = :b");
            query1.setParameter("b", courseID);
            Course course = (Course) query1.getSingleResult();
            student.setCourse(course);
            //student is automatically adding to listOfStudents in Course class - tested
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeFromCourse(int studentID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from Student where id = :a");
            query.setParameter("a", studentID);
            Student student = (Student) query.getSingleResult();
            student.setCourse(null);
            //student is automatically deleting from listOfStudents in Course class - tested
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
