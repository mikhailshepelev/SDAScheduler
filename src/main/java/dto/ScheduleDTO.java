package dto;

import entities.Course;
import entities.Lesson;
import entities.Student;
import entities.Topic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDTO {

    private String courseName;
    private String topicName;
    private String time;
    private String date;
    private String venuePlace;
    private String trainerName;

    public ScheduleDTO(String courseName, String topicName, String time, String date, String venuePlace, String trainerName) {
        this.courseName = courseName;
        this.topicName = topicName;
        this.time = time;
        this.date = date;
        this.venuePlace = venuePlace;
        this.trainerName = trainerName;
    }

    public ScheduleDTO() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenuePlace() {
        return venuePlace;
    }

    public void setVenuePlace(String venuePlace) {
        this.venuePlace = venuePlace;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "courseName='" + courseName + '\'' +
                ", topicName='" + topicName + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", venuePlace='" + venuePlace + '\'' +
                ", trainerName='" + trainerName + '\'' +
                '}';
    }
}
