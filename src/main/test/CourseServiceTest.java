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

import static org.junit.Assert.assertEquals;

public class CourseServiceTest {

    private static CourseService courseService;
    private Transaction transaction;
    private Session session;

    @BeforeClass
    public static void beforeClass() {
        courseService = new CourseService();
    }

    @Before
    public void setUpSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void closeSession() {
        transaction = null;
        session = null;
    }

    @Test
    public void createCourseTest() {
        Course actualCourse = new Course();
        courseService.createCourse(actualCourse);
        Query query = session.createQuery("from Course where id = :b");
        query.setParameter("b", actualCourse.getCourseID());
        Course targetedCourse = (Course) query.getSingleResult();
        assertEquals(targetedCourse, actualCourse);
    }

    @Test
    public void getListOfCoursesTest() {
        List<Course> coursesTarget = session.createQuery("from Course", Course.class).list();
        List<Course> courseActual = courseService.getListOfCourses();
        for (int i = 0; i < coursesTarget.size(); i++) {
            assertEquals(coursesTarget.get(i), courseActual.get(i));
        }
    }

    @Test(expected = NoResultException.class)
    public void deleteCourse() {
        List<Course> allCourses = session.createQuery("from Course", Course.class).list();
        Query query = session.createQuery("from Course where id = :b");
        query.setParameter("b", allCourses.get(0).getCourseID());
        Course targetedCourse = (Course) query.getSingleResult();
        courseService.deleteCourse(targetedCourse);
        Course actualCourse = (Course) query.getSingleResult();
    }
}
