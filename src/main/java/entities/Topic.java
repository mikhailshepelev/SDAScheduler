package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicID;
    private String name;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Trainer trainer;

    @OneToMany(mappedBy = "topic")
    private List<Lesson> lessonsList = new ArrayList<>();

    public Topic(String name, Course course, Trainer trainer) {
        this.name = name;
        this.course = course;
        this.trainer = trainer;
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
                ", course=" + course.getName() +
                ", trainer=" + trainer.getName() +
                ", city=" + course.getCity() +
                '}';
    }
}
