package service;

import dao.TimeTableDAO;
import entities.Lesson;
import entities.Topic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TimeTableService implements TimeTableDAO {

    //All fields should be filled in GUI, create object and transfer to this method.
    //All exceptions cause by incorrect input should be caught before object creation in GUI

    @Override
    public void createTimeTable(Lesson lesson) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(lesson);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }

    @Override
    public void updateTimeTable(Lesson lesson) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(lesson);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public List<Lesson> showAllTimeTables() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            // Create CriteriaQuery
            CriteriaQuery<Lesson> criteria = builder.createQuery(Lesson.class);
            // Specify criteria root
            criteria.from(Lesson.class);
            // Execute query
            List<Lesson> lessonList = session.createQuery(criteria).getResultList();
            session.close();
            return lessonList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Lesson> showLessonsForTopic(Topic topic) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Lesson where topic_topicID = :b");
            query.setParameter("b", topic.getTopicID());
            List<Lesson> list = query.getResultList();
            tx.commit();
            session.close();
            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public Lesson getTimeTable(Lesson lesson) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Lesson lesson1 = session.find(Lesson.class, lesson.getLessonID());
            session.close();
            return lesson1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteTimeTable(Lesson lesson) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Lesson lesson1 = new Lesson();
            lesson1.setLessonID(lesson.getLessonID());
            session.delete(lesson1);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

}
