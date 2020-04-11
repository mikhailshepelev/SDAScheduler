package service;

import dao.TopicDAO;
import entities.Lesson;
import entities.Topic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TopicService implements TopicDAO {

    //All fields should be filled in GUI, create object and transfer to this method.
    //All exceptions cause by incorrect input should be caught before object creation in GUI

    @Override
    public void createTopic(Topic topic) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(topic);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction !=null) {
                transaction.rollback();
            } ex.printStackTrace();
        }
    }

    @Override
    public void updateTopic(Topic topic) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(topic);
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
    public List<Topic> getTopics() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            // Create CriteriaQuery
            CriteriaQuery<Topic> criteria = builder.createQuery(Topic.class);
            // Specify criteria root
            criteria.from(Topic.class);
            // Execute query
            List<Topic> topicList = session.createQuery(criteria).getResultList();
            session.close();
            return topicList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Topic getTopicInfo(Topic topic) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Topic topic1 = session.find(Topic.class, topic.getTopicID());
            session.close();
            return topic1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Topic> getTopicWithoutTrainer(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Topic> topicNoTrainer = session.createQuery("from Topic T WHERE trainer_trainerID IS null", Topic.class).list();
        tx.commit();
        session.close();
        return topicNoTrainer;
    }

    @Override
    public void deleteTopic(Topic topic) {
        removeTopicTimeTableConstraint(topic);
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Topic topic1 = new Topic();
            topic1.setTopicID(topic.getTopicID());
            session.delete(topic1);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction !=null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void removeTopicTimeTableConstraint(Topic topic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Lesson where topic_topicID = :b");
        query.setParameter("b", topic.getTopicID());
        List<Lesson> timeTables = query.getResultList();
        for (Lesson lesson : timeTables) {
            lesson.setTopic(null);
        }
        tx.commit();
        session.close();
    }
}


