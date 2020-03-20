package service;

import dao.StudentDAO;
import entities.Course;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
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
    public List<Student> getListOfStudentsFromCourse(int id) {
        List<Student> listOfStudentsFromCourse = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        for (Student s : students) {
            if (s.getCourse() != null && s.getCourse().getCourseID() == id) listOfStudentsFromCourse.add(s);
        }
        tx.commit();
        session.close();
        return listOfStudentsFromCourse;
    }

    @Override
    public void deleteStudent(int id) {
        //TODO: test whether getlist method works after student deletion
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = new Student();
        student.setsID(id);
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
            //TODO: test is this required to add student to listOfStudents of Course class
            student.setCourse(course);
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
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
