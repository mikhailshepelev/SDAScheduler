package service;

import dto.ScheduleDTO;
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

public class ScheduleService {

    public List<ScheduleDTO> getStudentSchedule(String phoneNumber){
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query1 = session.createQuery("from Student where phoneNumber = :b");
        query1.setParameter("b", phoneNumber);
        Student student = (Student) query1.getSingleResult();
        Course course = student.getCourse();
        List<Topic> listOfTopics = course.getTopicsList();
        List<Lesson> listOfLessons = ejectTopics(listOfTopics);
        for (Lesson l: listOfLessons) {
            ScheduleDTO schedule = createObject(course, l);
            scheduleDTOS.add(schedule);
        }
        tx.commit();
        session.close();
        return scheduleDTOS;
    }

    private List<Lesson> ejectTopics(List<Topic> listOfTopics){
        List<Lesson> listOfLessons = new ArrayList<>();
        for (Topic t: listOfTopics) {
            listOfLessons.addAll(t.getLessonsList());
        }
        return listOfLessons;
    }

    private ScheduleDTO createObject(Course course, Lesson lesson) {
        String courseName = course.getName();
        String topicName = lesson.getTopic().getTopicName();
        String time = lesson.getLessonTime().time;
        String date = lesson.getLessonDate();
        String venuePlace = lesson.getVenuePlace().venuePlace;
        return new ScheduleDTO(courseName, topicName, time, date, venuePlace);
    }
}
