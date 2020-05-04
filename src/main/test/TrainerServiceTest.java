import entities.Topic;
import entities.Trainer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.TrainerService;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

import static org.junit.Assert.*;

public class TrainerServiceTest {
    private static TrainerService trainerService;
    private Transaction firstTransaction;
    private Transaction secondTransaction;
    private Session firstSession;
    private Session secondSession;

    @BeforeClass
    public static void beforeClass() {
        trainerService = new TrainerService();
    }

    @Before
    public void setUpSession() {
        firstSession = HibernateUtil.getSessionFactory().openSession();
        secondSession = HibernateUtil.getSessionFactory().openSession();
        firstTransaction = firstSession.beginTransaction();
        secondTransaction = secondSession.beginTransaction();
    }

    @After
    public void closeSession() {
        firstSession.close();
        secondSession.close();
    }

    @Test
    public void createTrainerTestToEquals() {
        Trainer createdTrainer = new Trainer();
        trainerService.createTrainer(createdTrainer);
        Query query = firstSession.createQuery("from Trainer where id = :b");
        query.setParameter("b", createdTrainer.getTrainerID());
        Trainer fetchedTrainer = (Trainer) query.getSingleResult();
        assertEquals(fetchedTrainer, createdTrainer);
    }

    @Test
    public void createTrainerTestListSizeNotEquals() {
        Trainer createdTrainer = new Trainer();
        List<Trainer> listBeforeCreation = firstSession.createQuery("from Trainer ", Trainer.class).list();
        trainerService.createTrainer(createdTrainer);
        List<Trainer> listAfterCreation = secondSession.createQuery("from Trainer ", Trainer.class).list();
        assertNotEquals(listBeforeCreation.size(), listAfterCreation.size());
    }

    @Test
    public void getFullListOfTrainers(){
        Query query = firstSession.createQuery("from Trainer");
        List<Trainer> listTargeted = query.getResultList();
        List<Trainer> listActual = trainerService.getFullListOfTrainers();
        for (int i = 0; i < listTargeted.size(); i++) {
            assertEquals(listTargeted.get(i), listActual.get(i));
        }
    }

    @Test
    public void getListOfTopicsForTrainer(){
        Query query1 = firstSession.createQuery("from Trainer ");
        List<Trainer> listTargeted = query1.getResultList();
        for (int i = 0; i < listTargeted.size(); i++) {
            List<Topic> listActual = trainerService.getListOfTopics(listTargeted.get(i).getTrainerID());
            assertEquals(listTargeted.get(i).getTopicsList().size(), listActual.size());
        }
    }

    @Test(expected = NoResultException.class)
    public void deleteTrainer() {
        List<Trainer> allTrainers = firstSession.createQuery("from Trainer", Trainer.class).list();
        Query query = firstSession.createQuery("from Trainer where id = :b");
        query.setParameter("b", allTrainers.get(0).getTrainerID());
        Trainer targetedTrainer = (Trainer) query.getSingleResult();
        trainerService.deleteTrainer(targetedTrainer.getTrainerID());
        Trainer actualTrainer = (Trainer) query.getSingleResult();
    }

    @Test
    public void sizeListShouldBeChangedAfterDel(){
        List<Trainer> allTrainers = firstSession.createQuery("from Trainer", Trainer.class).list();
        int initialListSize = allTrainers.size();
        Query query = firstSession.createQuery("from Trainer where id = :b");
        query.setParameter("b", allTrainers.get(0).getTrainerID());
        Trainer targetedTrainer = (Trainer) query.getSingleResult();
        trainerService.deleteTrainer(targetedTrainer.getTrainerID());
        int resultListSize = secondSession.createQuery("from Trainer", Trainer.class).list().size();
        assertEquals(initialListSize, resultListSize+1);
    }

    @Test
    public void TrainerOfRelatedTopicShouldBeNullAfterTrainerDeletion() {
        List<Trainer> allTrainers = firstSession.createQuery("from Trainer where topicsList.size is not null", Trainer.class).list();
        Query query1 = firstSession.createQuery("from Topic where trainer is null");
        int initialAmount = query1.getResultList().size();
        Trainer trainerToDelete = allTrainers.get(0);
        trainerService.deleteTrainer(trainerToDelete.getTrainerID());
        Query query2 = secondSession.createQuery("from Topic where trainer is null");
        int amountAfterOperation = query2.getResultList().size();
        if (initialAmount > 0) {
            assertNotEquals(initialAmount, amountAfterOperation);
        }
        else {
            System.out.println("No Topics for this Trainer: add Topics to Trainer first and test again");
            assertEquals(1, 0);
        }
    }

    @Test
    public void addTrainerToTopicWhenTopicIsNull(){
        Query query = firstSession.createQuery("from Topic where trainer is null");
        Topic topic = (Topic) query.getResultList().get(0);
        List<Trainer> allTrainersBefore = firstSession.createQuery("from Trainer ", Trainer.class).list();
        int initialTopicsListSize = allTrainersBefore.get(0).getTopicsList().size();
        trainerService.addTrainerToTopic(allTrainersBefore.get(0).getTrainerID(), topic.getTopicID());
        List<Trainer> allTrainersAfter = secondSession.createQuery("from Trainer", Trainer.class).list();
        Query query1 = secondSession.createQuery("from Topic where id = :b");
        query1.setParameter("b", topic.getTopicID());
        Topic topicAfterAddition = (Topic) query1.getSingleResult();
        int resultTopicsListSize = allTrainersAfter.get(0).getTopicsList().size();
        assertNotEquals(initialTopicsListSize, resultTopicsListSize);
        assertNotNull(topicAfterAddition.getTrainer());
    }

    @Test
    public void addTrainerToTopicWhenTopicNotNull(){
        Query query = firstSession.createQuery("from Topic where trainer is not null");
        Topic fetchedTopic = (Topic) query.getResultList().get(0);
        Query query1 = firstSession.createQuery("from Trainer where id != :b");
        query1.setParameter("b", fetchedTopic.getTrainer().getTrainerID());
        List<Trainer> initialTrainersList = query1.getResultList();
        fetchedTopic.setTrainer(initialTrainersList.get(0));
        firstTransaction.commit();
        Query query2 = firstSession.createQuery("from Topic where id = :c");
        query2.setParameter("c", fetchedTopic.getTopicID());
        Topic resultTopic = (Topic) query2.getSingleResult();
        Query query3 = secondSession.createQuery("from Trainer where id = :d");
        query3.setParameter("d", initialTrainersList.get(0).getTrainerID());
        List<Trainer> listAfterChange = query3.getResultList();
        assertEquals(resultTopic.getTrainer().getTrainerID(), initialTrainersList.get(0).getTrainerID());
        assertEquals(initialTrainersList.get(0).getTopicsList().size()+1, listAfterChange.get(0).getTopicsList().size());
    }

    @Test
    public void trainerShouldBeNullAfterDelTopicFromTrainer(){
        Query query = firstSession.createQuery("from Topic where trainer is not null");
        Topic fetchedTopic = (Topic) query.getResultList().get(0);
        trainerService.removeTrainerFromTopic(fetchedTopic.getTopicID());
        Query query1 = secondSession.createQuery("from Topic where id = :a");
        query1.setParameter("a", fetchedTopic.getTopicID());
        Topic TopicAfterOperation = (Topic) query1.getSingleResult();
        assertNull(TopicAfterOperation.getTrainer());
    }

    @Test
    public void topicsListSizeShouldBeChangedAfterDelTopicFromTrainer(){
        Query query = firstSession.createQuery("from Topic where trainer is not null");
        Topic fetchedTopic = (Topic) query.getResultList().get(0);
        trainerService.removeTrainerFromTopic(fetchedTopic.getTopicID());
        Query query1 = secondSession.createQuery("from Trainer where id = :b");
        query1.setParameter("b", fetchedTopic.getTrainer().getTrainerID());
        Trainer Trainer = (Trainer) query1.getSingleResult();
        assertEquals(fetchedTopic.getTrainer().getTopicsList().size(), Trainer.getTopicsList().size()+1);
    }
}
