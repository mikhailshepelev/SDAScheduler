package service;

import dao.TopicDAO;
import entities.Topic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TopicService implements TopicDAO {

    //All fields should be filled in GUI, create object and transfer to this method.
    //All exceptions cause by incorrect input should be caught before object creation in GUI

    //TODO: Ask about the nullpointerexception, if the course has no trainer
    @Override
    public void createTopic(Topic topic) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(topic);
            transaction.commit();
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
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public List<Topic> getTopics() {
        // doesn't show topics where trainer is null.
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
    public Topic getTopicInfo(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Topic topic = session.find(Topic.class, id);
            return topic;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Topic> getTopicWithoutTrainer(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Topic> topicNoTrainer = session.createQuery("from Topic T WHERE T.trainer_trainerID = null", Topic.class).list();
        tx.commit();
        session.close();
        return topicNoTrainer;
    }

    @Override
    public void deleteTopic(Topic topic) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(topic);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction !=null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}


