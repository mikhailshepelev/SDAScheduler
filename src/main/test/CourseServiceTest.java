import entities.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.CourseService;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import java.util.List;

import static org.junit.Assert.*;

public class CourseServiceTest {

    private static CourseService courseService;
    private Transaction firstTransaction;
    private Transaction secondTransaction;
    private Session firstSession;
    private Session secondSession;

    @BeforeClass
    public static void beforeClass() {
        courseService = new CourseService();
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
    public void createCourseTest() {
        Course actualCourse = new Course();
        courseService.createCourse(actualCourse);
        Query query = firstSession.createQuery("from Course where id = :b");
        query.setParameter("b", actualCourse.getCourseID());
        Course targetedCourse = (Course) query.getSingleResult();
        assertEquals(targetedCourse, actualCourse);
    }

    @Test
    public void createCourseTestListSizeNotEquals() {
        Course actualCourse = new Course();
        List<Course> listBeforeCreation = firstSession.createQuery("from Course ", Course.class).list();
        courseService.createCourse(actualCourse);
        List<Course> listAfterCreation = secondSession.createQuery("from Course ", Course.class).list();
        assertNotEquals(listBeforeCreation.size(), listAfterCreation.size());
    }

    @Test
    public void getListOfCoursesTest() {
        List<Course> coursesTarget = firstSession.createQuery("from Course", Course.class).list();
        List<Course> courseActual = courseService.getListOfCourses();
        for (int i = 0; i < coursesTarget.size(); i++) {
            assertEquals(coursesTarget.get(i), courseActual.get(i));
        }
    }

    @Test(expected = NoResultException.class)
    public void deleteCourse() {
        List<Course> allCourses = firstSession.createQuery("from Course", Course.class).list();
        Query query = firstSession.createQuery("from Course where id = :b");
        query.setParameter("b", allCourses.get(0).getCourseID());
        Course targetedCourse = (Course) query.getSingleResult();
        courseService.deleteCourse(targetedCourse);
        Course actualCourse = (Course) query.getSingleResult();
    }

    @Test
    public void sizeListShouldBeChangedAfterDel(){
        List<Course> allCourses = firstSession.createQuery("from Course", Course.class).list();
        int initialListSize = allCourses.size();
        Query query = firstSession.createQuery("from Course where id = :b");
        query.setParameter("b", allCourses.get(0).getCourseID());
        Course targetedCourse = (Course) query.getSingleResult();
        courseService.deleteCourse(targetedCourse);
        int resultListSize = secondSession.createQuery("from Course", Course.class).list().size();
        assertNotEquals(initialListSize, resultListSize);
    }

    @Test
    public void courseOfRelatedStudentShouldBeNullAfterCourseDeletion() {
        List<Course> allCourses = firstSession.createQuery("from Course where studentsList.size is not null ", Course.class).list();
        Query query1 = firstSession.createQuery("from Student where course is null");
        int initialAmount = query1.getResultList().size();
        Course courseToDelete = allCourses.get(0);
        courseService.deleteCourse(courseToDelete);
        Query query2 = secondSession.createQuery("from Student where course is null");
        int amountAfterOperation = query2.getResultList().size();
        if (initialAmount > 0) {
            assertNotEquals(initialAmount, amountAfterOperation);
        }
        else {
            System.out.println("No students for this course: add students to course first and test again");
            assertEquals(1, 0);
        }
    }

    //TODO: Create test like above for Topic constraint after method "addTopicToCourse" will be created
}
