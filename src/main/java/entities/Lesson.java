package entities;

import enums.LessonTime;
import enums.VenuePlace;

import javax.persistence.*;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonID;

    private String lessonDate;

    @Enumerated(EnumType.STRING)
    private LessonTime lessonTime;

    @Enumerated(EnumType.STRING)
    private VenuePlace venuePlace;

    @ManyToOne
    private Topic topic;

    //removed int lessonID from constructor:Triin
    public Lesson(String lessonDate, LessonTime lessonTime, VenuePlace venuePlace, Topic topic) {
        this.lessonDate = lessonDate;
        this.lessonTime = lessonTime;
        this.venuePlace = venuePlace;
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

    public String getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(String lessonDate) {
        this.lessonDate = lessonDate;
    }

    public LessonTime getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(LessonTime lessonTime) {
        this.lessonTime = lessonTime;
    }

    public VenuePlace getVenuePlace() {
        return venuePlace;
    }

    public void setVenuePlace(VenuePlace venuePlace) {
        this.venuePlace = venuePlace;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonID=" + lessonID +
                ", lessonDate=" + lessonDate +
                ", lessonTime=" + lessonTime.time +
                ", venuePlace=" + venuePlace.venuePlace +
                ", topic=" + topic.getTopicName() +
                '}';
    }
}
