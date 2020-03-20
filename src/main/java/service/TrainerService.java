package service;

import dao.TrainerDAO;
import entities.Topic;
import entities.Trainer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class TrainerService implements TrainerDAO {
    @Override
    public void createTrainer(Trainer trainer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(trainer);
        tx.commit();
        session.close();
    }

    @Override
    public List<Trainer> getFullListOfTrainers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Trainer> trainers = session.createQuery("from Trainer", Trainer.class).list();
        tx.commit();
        session.close();
        return trainers;
    }

    @Override
    public List<Trainer> getListOfTrainersAndTopics() {
        return null;
    }

    @Override
    public void deleteTrainer(int trainerID) {
        removeTrainerTopicConstraint(trainerID);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Trainer trainer = new Trainer();
        trainer.setTrainerID(trainerID);
        session.delete(trainer);
        tx.commit();
        session.close();
    }

    //this method created to remove trainer from Topic object before trainer deletion to prevent unexpected errors
    private void removeTrainerTopicConstraint(int trainerID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Topic where trainer_trainerID = :b");
        query.setParameter("b", trainerID);
        List<Topic> list = query.getResultList();
        for (Topic t : list){
            t.setTrainer(null);
        }
        tx.commit();
        session.close();
    }

    @Override
    public void addTrainerToTopic(int trainerID, int topicID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from Trainer where id = :a");
            query.setParameter("a", trainerID);
            Trainer trainer = (Trainer) query.getSingleResult();
            Query query1 = session.createQuery("from Topic where id = :b");
            query1.setParameter("b", topicID);
            Topic topic = (Topic) query1.getSingleResult();
            trainer.getTopicsList().add(topic);
            topic.setTrainer(trainer);
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeTrainerFromTopic(int topicID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from Topic where id = :a");
            query.setParameter("a", topicID);
            Topic topic = (Topic) query.getSingleResult();
            topic.setTrainer(null);
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
