package service;

import dao.StudentDAO;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentDAO {
    @Override
    public void createStudent() {

    }

    @Override
    public void updateStudent(int id) {

    }

    @Override
    public List<Student> getFullListOfStudents() {
        List<Student> listOfStudents = new ArrayList<>();
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            int id = 1;
            while (true) {
                Student student = session.get(Student.class, id);
                if (student == null) break;
                listOfStudents.add(student);
                id++;
            }
            tx.commit();
            session.close();
            return listOfStudents;
    }

    @Override
    public List<Student> getListOfStudentsFromCourse() {
        return null;
    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public void addToCourse(int id) {

    }

    @Override
    public void removeFromCourse(int id) {

    }
}
