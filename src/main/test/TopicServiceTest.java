import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import service.TopicService;
import util.HibernateUtil;

public class TopicServiceTest {

    private static TopicService topicService;
    private Transaction firstTransaction;
    private Transaction secondTransaction;
    private Session firstSession;
    private Session secondSession;

    @BeforeClass
    public static void beforeClass() {
        topicService = new TopicService();
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

    //TODO: Test add topic
    //TODO: Test delete topic
    //TODO: Test add topic to course
    //TODO: Test remove topic from course
    //TODO: Test add lesson to topic
    //TODO: Test remove lesson from topic

    //TODO: Test methods from ScheduleService

}
