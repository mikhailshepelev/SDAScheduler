package controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ManagerController {

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
    void createStudent(ActionEvent event) {

    }

    @FXML
    void createTrainer(ActionEvent event) {

    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {

        URL url = Paths.get("./src/main/java/fxmlfiles/MainWindow.fxml").toUri().toURL();
        Pane mainWindow = FXMLLoader.load(url);
        Scene entryScene = new Scene(mainWindow);

        Stage entryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        entryStage.setScene(entryScene);
        entryStage.show();
    }

    @FXML
    void viewAllCourses(ActionEvent event) {

    }

    @FXML
    void viewStudents(ActionEvent event) {

    }

    @FXML
    void viewTrainers(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert managerWindow != null : "fx:id=\"managerWindow\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert menuButton != null : "fx:id=\"menuButton\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert newCourse != null : "fx:id=\"newCourse\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert manageCourses != null : "fx:id=\"manageCourses\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert allCourses != null : "fx:id=\"allCourses\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert newTrainer != null : "fx:id=\"newTrainer\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert manageTrainers != null : "fx:id=\"manageTrainers\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert allTrainers != null : "fx:id=\"allTrainers\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert newStudent != null : "fx:id=\"newStudent\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert manageStudents != null : "fx:id=\"manageStudents\" was not injected: check your FXML file 'ManagerWindow.fxml'.";
        assert allStudents != null : "fx:id=\"allStudents\" was not injected: check your FXML file 'ManagerWindow.fxml'.";

    }
}
