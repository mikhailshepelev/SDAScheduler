package dao;

import entities.Student;

import java.util.List;

public interface StudentDAO {

    //create elements in database representation
    void createStudent(Student student);

    //update elements in database representation
    void updateStudent(int id);

    //read elements from database representation
    List<Student> getFullListOfStudents();
    List<Student> getListOfStudentsFromCourse(int id);

    //delete elements from database representation
    void deleteStudent(int id);

    void addToCourse(int id);
    void removeFromCourse(int id);
}
