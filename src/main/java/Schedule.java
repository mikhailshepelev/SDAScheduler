import entities.Lesson;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private String courseName;
    private String topicName;
    private String time;
    private String date;
    private String trainerName;

    public Schedule(String courseName, String topicName, String time, String date, String trainerName) {
        this.courseName = courseName;
        this.topicName = topicName;
        this.time = time;
        this.date = date;
        this.trainerName = trainerName;
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

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public List<Schedule> getSchedule(){
        ArrayList<Schedule> schedules = new ArrayList<>();


        return schedules;
    }
}
