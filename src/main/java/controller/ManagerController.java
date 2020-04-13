package controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ResourceBundle;

import entities.Course;
import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.StudentService;

public class ManagerController {

    MainWindowController mainWindowController = new MainWindowController();
    String menuLink = "./src/main/java/fxmlfiles/MainWindow.fxml";


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane managerWindow;

    @FXML
    private Button menuButton;

    @FXML
    private ImageView logo;


    @FXML
    private Button manageCourses;


    @FXML
    private Button manageTrainers;


    @FXML
    private Button manageStudents;



    @FXML
    void goToMenu(ActionEvent event) throws IOException {

       mainWindowController.navigate(event, menuLink);
    }

    @FXML
    void manageCourses(ActionEvent event) throws IOException {

        URL url = Paths.get("./src/main/java/fxmlfiles/CourseWindow.fxml").toUri().toURL();
        Parent courses = FXMLLoader.load(url);
        Scene viewCourses = new Scene(courses);
        CourseController.courseWindowController = new Stage();
        CourseController.courseWindowController.setTitle("SDA Scheduler");
        CourseController.courseWindowController.setScene(viewCourses);
        CourseController.courseWindowController.initModality(Modality.APPLICATION_MODAL);
        CourseController.courseWindowController.showAndWait();


    }

    @FXML
    void manageStudents(ActionEvent event) throws IOException {

        URL url = Paths.get("./src/main/java/fxmlfiles/AllStudentsController.fxml").toUri().toURL();
        Parent viewAllStudents = FXMLLoader.load(url);
        Scene viewAllScene = new Scene(viewAllStudents);
        AllStudentsController.allStudents = new Stage();
        AllStudentsController.allStudents.setTitle("SDA Scheduler");
        AllStudentsController.allStudents.setScene(viewAllScene);
        AllStudentsController.allStudents.initModality(Modality.APPLICATION_MODAL);
        AllStudentsController.allStudents.showAndWait();

    }

    @FXML
    void manageTrainers(ActionEvent event) throws IOException {
        URL url = Paths.get("./src/main/java/fxmlfiles/AllTrainersWindow.fxml").toUri().toURL();
        Parent viewAllTrainers = FXMLLoader.load(url);
        Scene viewAllScene = new Scene(viewAllTrainers);
        AllTrainersController.allTrainers = new Stage();
        AllTrainersController.allTrainers.setTitle("SDA Scheduler");
        AllTrainersController.allTrainers.setScene(viewAllScene);
        AllTrainersController.allTrainers.initModality(Modality.APPLICATION_MODAL);
        AllTrainersController.allTrainers.showAndWait();
    }

    @FXML
    void initialize() {


    }


}
