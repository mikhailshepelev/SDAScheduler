package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Lesson {
    @Id
    private int lessonID;
    private Date lessonDate;
    private Time timeStart;
    private Time timeEnd;

    @ManyToOne
    private Topic topic;

    public Lesson(int lessonID, Date lessonDate, Time timeStart, Time timeEnd, Topic topic) {
        this.lessonID = lessonID;
        this.lessonDate = lessonDate;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.topic = topic;
    }

    public Lesson() {
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonID=" + lessonID +
                ", lessonDate=" + lessonDate +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", topic=" + topic +
                '}';
    }
}
