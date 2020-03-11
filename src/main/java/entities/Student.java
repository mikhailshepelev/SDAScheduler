package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
    @Id
    private int sID;
    private String name;
    private boolean isMale;
    private int age;
    private String phoneNumber;
    private String email;

    @ManyToOne
    private Course course;

    public Student(int sID, String name, boolean isMale, int age, String phoneNumber, String email, Course course) {
        this.sID = sID;
        this.name = name;
        this.isMale = isMale;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.course = course;
    }

    public Student() {
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sID=" + sID +
                ", name='" + name + '\'' +
                ", isMale=" + isMale +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", course=" + course +
                '}';
    }
}
