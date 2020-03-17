package sample;

import entities.Lesson;
import entities.Student;
import entities.Trainer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("SDA Scheduler");
        primaryStage.setScene(new Scene(root, 659, 418));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Lesson lesson = session.get(Lesson.class, 1);
        System.out.println(lesson.getLessonTime().time);

        Trainer trainer = session.get(Trainer.class, 3);
        System.out.println(trainer.toString());

        Student student = session.get(Student.class, 2);
        System.out.println(student.toString());
    }
}
