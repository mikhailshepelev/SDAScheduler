package dao;

import entities.Course;

import java.util.List;

public interface CourseDAO {

    //create elements in database representation
    void createCourse(Course course);

    //update elements in database representation
    void updateCourse(Course course);

    //read elements from database representation
    List<Course> getListOfCourses();
    Course getCourseInfo(int id);

    // delete course
    void deleteCourse(Course course);
}
