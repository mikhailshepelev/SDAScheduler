package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private int courseID;
    private String name;
    private String city;

    @OneToMany(mappedBy = "course")
    private List<Student> studentsList = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Topic> topicsList = new ArrayList<>();

    public Course(int courseID, String name, String city, List<Student> studentsList, List<Topic> topicsList) {
        this.courseID = courseID;
        this.name = name;
        this.city = city;
        this.studentsList = studentsList;
        this.topicsList = topicsList;
    }

    public Course() {
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Topic> getTopicsList() {
        return topicsList;
    }

    public void setTopicsList(List<Topic> topicsList) {
        this.topicsList = topicsList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", studentsList=" + studentsList +
                ", topicsList=" + topicsList +
                '}';
    }
}
