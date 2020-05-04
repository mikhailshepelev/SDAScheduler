import entities.Course;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.StudentService;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import static org.junit.Assert.*;

public class StudentsServiceTest {
    private static StudentService studentService;
    private Transaction firstTransaction;
    private Transaction secondTransaction;
    private Session firstSession;
    private Session secondSession;

    @BeforeClass
    public static void beforeClass() {
        studentService = new StudentService();
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
    public void createStudentTestToEquals() {
        Student createdStudent = new Student();
        studentService.createStudent(createdStudent);
        Query query = firstSession.createQuery("from Student where id = :b");
        query.setParameter("b", createdStudent.getSID());
        Student fetchedStudent = (Student) query.getSingleResult();
        assertEquals(fetchedStudent, createdStudent);
    }

    @Test
    public void createStudentTestListSizeNotEquals() {
        Student createdStudent = new Student();
        List<Student> listBeforeCreation = firstSession.createQuery("from Student ", Student.class).list();
        studentService.createStudent(createdStudent);
        List<Student> listAfterCreation = secondSession.createQuery("from Student ", Student.class).list();
        assertNotEquals(listBeforeCreation.size(), listAfterCreation.size());
    }

    @Test(expected = NoResultException.class)
    public void deleteStudent() {
        List<Student> allStudents = firstSession.createQuery("from Student ", Student.class).list();
        Query query = firstSession.createQuery("from Student where id = :b");
        query.setParameter("b", allStudents.get(0).getSID());
        Student fetchedStudent = (Student) query.getSingleResult();
        studentService.deleteStudent(fetchedStudent.getSID());
        Student actualStudent = (Student) query.getSingleResult();
    }

    @Test
    public void addStudentToCourseWhenCourseIsNull(){
        Query query = firstSession.createQuery("from Student where course is null");
        Student student = (Student) query.getResultList().get(0);
        List<Course> allCoursesBefore = firstSession.createQuery("from Course", Course.class).list();
        int initialStudentsListSize = allCoursesBefore.get(0).getStudentsList().size();
        studentService.addToCourse(student.getSID(), allCoursesBefore.get(0).getCourseID());
        List<Course> allCoursesAfter = secondSession.createQuery("from Course", Course.class).list();
        Query query1 = secondSession.createQuery("from Student where id = :b");
        query1.setParameter("b", student.getSID());
        Student studentAfterAddition = (Student) query1.getSingleResult();
        int resultStudentsListSize = allCoursesAfter.get(0).getStudentsList().size();
        assertNotEquals(initialStudentsListSize, resultStudentsListSize);
        assertNotNull(studentAfterAddition.getCourse());
    }

    @Test
    public void addToCourseWhenCourseNotNull(){
        Query query = firstSession.createQuery("from Student where course is not null");
        Student fetchedStudent = (Student) query.getResultList().get(0);
        Query query1 = firstSession.createQuery("from Course where id != :b");
        query1.setParameter("b", fetchedStudent.getCourse().getCourseID());
        List<Course> initialCoursesList = query1.getResultList();
        fetchedStudent.setCourse(initialCoursesList.get(0));
        firstTransaction.commit();
        Query query2 = firstSession.createQuery("from Student where id = :c");
        query2.setParameter("c", fetchedStudent.getSID());
        Student resultStudent = (Student) query2.getSingleResult();
        Query query3 = secondSession.createQuery("from Course where id = :d");
        query3.setParameter("d", initialCoursesList.get(0).getCourseID());
        List<Course> listAfterChange = query3.getResultList();
        assertEquals(resultStudent.getCourse().getCourseID(), initialCoursesList.get(0).getCourseID());
        assertEquals(initialCoursesList.get(0).getStudentsList().size()+1, listAfterChange.get(0).getStudentsList().size());
    }

    @Test
    public void getFullListOfStudents(){
        Query query = firstSession.createQuery("from Student");
        List<Student> listTargeted = query.getResultList();
        List<Student> listActual = studentService.getFullListOfStudents();
        for (int i = 0; i < listTargeted.size(); i++) {
            assertEquals(listTargeted.get(i), listActual.get(i));
        }
    }

    @Test
    public void getListOfStudentsForCourse(){
        Query query1 = firstSession.createQuery("from Course");
        Course targetedCourse = (Course) query1.getResultList().get(0);
            if (targetedCourse.getStudentsList().size() == 0) {
                System.out.println("No students for this course: add students to course first and test again");
                assertEquals(1, 0);
                return;
            }
        List<Student> actualList = studentService.getListOfStudentsFromCourse(targetedCourse.getCourseID());
        for(int i = 0; i<actualList.size(); i++) {
            assertEquals(targetedCourse.getStudentsList().get(i), actualList.get(i));
        }
    }

    @Test
    public void overallListSizeShouldBeChangedAfterDel(){
        List<Student> allStudents = firstSession.createQuery("from Student ", Student.class).list();
        int initialListSize = allStudents.size();
        Query query = firstSession.createQuery("from Student where id = :b");
        query.setParameter("b", allStudents.get(0).getSID());
        Student targetedStudent = (Student) query.getSingleResult();
        studentService.deleteStudent(targetedStudent.getSID());
        int resultListSize = secondSession.createQuery("from Student ", Student.class).list().size();
        assertNotEquals(initialListSize, resultListSize);
    }

    @Test
    public void studentsListForCourseShouldBeChangedAfterDel(){
        List<Course> allCoursesBefore = firstSession.createQuery("from Course", Course.class).list();
        if (allCoursesBefore.get(0).getStudentsList().size() == 0) {
            System.out.println("Add students to first course in list");
            assertEquals(1, 0);
            return;
        }
        Student studentToDelete = allCoursesBefore.get(0).getStudentsList().get(0);
        int initialSize = allCoursesBefore.get(0).getStudentsList().size();
        studentService.deleteStudent(studentToDelete.getSID());
        List<Course> allCoursesAfter = secondSession.createQuery("from Course", Course.class).list();
        int sizeAfterDeletion = allCoursesAfter.get(0).getStudentsList().size();
        assertNotEquals(initialSize, sizeAfterDeletion);
    }

    @Test
    public void courseShouldBeNullAfterDelStudentFromCourse(){
        Query query = firstSession.createQuery("from Student where course is not null");
        Student fetchedStudent = (Student) query.getResultList().get(0);
        studentService.removeFromCourse(fetchedStudent.getSID());
        Query query1 = secondSession.createQuery("from Student where id = :a");
        query1.setParameter("a", fetchedStudent.getSID());
        Student studentAfterOperation = (Student) query1.getSingleResult();
        assertNull(studentAfterOperation.getCourse());
    }

    @Test
    public void stListSizeShouldBeChangedAfterDelStFromCourse(){
        Query query = firstSession.createQuery("from Student where course is not null");
        Student fetchedStudent = (Student) query.getResultList().get(0);
        studentService.removeFromCourse(fetchedStudent.getSID());
        Query query1 = secondSession.createQuery("from Course where id = :b");
        query1.setParameter("b", fetchedStudent.getCourse().getCourseID());
        Course course = (Course) query1.getSingleResult();
        assertEquals(fetchedStudent.getCourse().getStudentsList().size(), course.getStudentsList().size()+1);
    }
}
