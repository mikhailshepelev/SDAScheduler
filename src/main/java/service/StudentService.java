package service;

import dao.StudentDAO;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = new Student();
        student.setsID(id);
        session.delete(student);
        tx.commit();
        session.close();
    }

    @Override
    public void addToCourse(int id) {

    }

    @Override
    public void removeFromCourse(int id) {

    }
}
