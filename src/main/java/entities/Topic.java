package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topic {
    @Id
    private int topicID;
    private String name;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Trainer trainer;

    @OneToMany(mappedBy = "topic")
    private List<Lesson> lessonsList = new ArrayList<>();

    public Topic(int topicID, String name, Course course, Trainer trainer, List<Lesson> lessonsList) {
        this.topicID = topicID;
        this.name = name;
        this.course = course;
        this.trainer = trainer;
        this.lessonsList = lessonsList;
    }

    public Topic() {
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<Lesson> getLessonsList() {
        return lessonsList;
    }

    public void setLessonsList(List<Lesson> lessonsList) {
        this.lessonsList = lessonsList;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicID=" + topicID +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", trainer=" + trainer +
                ", lessonsList=" + lessonsList +
                '}';
    }
}
