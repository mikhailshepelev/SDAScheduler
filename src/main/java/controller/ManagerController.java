package controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private Button newCourse;

    @FXML
    private Button manageCourses;

    @FXML
    private Button allCourses;

    @FXML
    private Button newTrainer;

    @FXML
    private Button manageTrainers;

    @FXML
    private Button allTrainers;

    @FXML
    private Button newStudent;

    @FXML
    private Button manageStudents;

    @FXML
    private Button allStudents;



    @FXML
    void changeCourses(ActionEvent event) {

    }

    @FXML
    void changeStudents(ActionEvent event) {

    }

    @FXML
    void changeTrainers(ActionEvent event) {

    }

    @FXML
    void createCourse(ActionEvent event) {

    }

    @FXML
    void createStudent(ActionEvent event) throws IOException {
        URL url = Paths.get("./src/main/java/fxmlfiles/CreateStudentWindow.fxml").toUri().toURL();
        Parent createStudent = FXMLLoader.load(url);
        Scene createScene = new Scene(createStudent);
        NewStudentController.createStudentStage = new Stage();
        NewStudentController.createStudentStage.setScene(createScene);
        NewStudentController.createStudentStage.initModality(Modality.APPLICATION_MODAL);
        NewStudentController.createStudentStage.showAndWait();


    }
    @FXML
    void createTrainer(ActionEvent event) {

    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {

       mainWindowController.navigate(event, menuLink);
    }

    @FXML
    void viewAllCourses(ActionEvent event) {

    }

    @FXML
    void viewStudents(ActionEvent event) throws IOException {

        URL url = Paths.get("./src/main/java/fxmlfiles/AllStudentsController.fxml").toUri().toURL();
        Parent viewAllStudents = FXMLLoader.load(url);
        Scene createScene = new Scene(viewAllStudents);
        AllStudentsController.allStudents = new Stage();
        AllStudentsController.allStudents.setScene(createScene);
        AllStudentsController.allStudents.initModality(Modality.APPLICATION_MODAL);
        AllStudentsController.allStudents.showAndWait();

    }

    @FXML
    void viewTrainers(ActionEvent event) {

    }

    @FXML
    void initialize() {


    }
}
