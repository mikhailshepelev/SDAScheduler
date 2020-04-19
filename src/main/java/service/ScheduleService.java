package service;

import dto.ScheduleDTO;
import entities.*;
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
            ScheduleDTO schedule = createObject(l);
            scheduleDTOS.add(schedule);
        }
        tx.commit();
        session.close();
        return scheduleDTOS;
    }

    public List<ScheduleDTO> getTrainerSchedule(String phoneNumber){
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query1 = session.createQuery("from Trainer where phoneNumber = :b");
        query1.setParameter("b", phoneNumber);
        Trainer trainer = (Trainer) query1.getSingleResult();
        List<Topic> listOfTopics = trainer.getTopicsList();
        List<Lesson> listOfLessons = ejectTopics(listOfTopics);
        for (Lesson l: listOfLessons) {
            ScheduleDTO schedule = createObject(l);
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

    private ScheduleDTO createObject(Lesson lesson) {
        String courseName = "";
        String topicName = "";
        String time = "";
        String date = "";
        String trainerName = "";
        String venuePlace = "";
        try {
            courseName = lesson.getTopic().getCourseName();
            topicName = lesson.getTopic().getTopicName();
            time = lesson.getLessonTime().time;
            date = lesson.getLessonDate();
            trainerName = lesson.getTopic().getTrainerName();
            venuePlace = lesson.getVenuePlace().venuePlace;
        }
        catch (NullPointerException e) {
            System.out.println(e);
        }
        return new ScheduleDTO(courseName, topicName, time, date, venuePlace, trainerName);
    }
}
