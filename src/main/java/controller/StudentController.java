package controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class StudentController {
    MainWindowController mainWindowController = new MainWindowController();
    String menuLink = "./src/main/java/fxmlfiles/MainWindow.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane studentWindow;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button viewSchedule;

    @FXML
    private ImageView logo;

    @FXML
    String getPhoneNumber(ActionEvent event) {
        return this.phoneNumber.getText();
    }

    @FXML
    void getStudentSchedule(ActionEvent event) {
    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        mainWindowController.navigate(event, menuLink);

    }

    @FXML
    void initialize() {
        assert studentWindow != null : "fx:id=\"studentWindow\" was not injected: check your FXML file 'Untitled'.";
        assert phoneNumber != null : "fx:id=\"phoneNumber\" was not injected: check your FXML file 'Untitled'.";
        assert viewSchedule != null : "fx:id=\"viewSchedule\" was not injected: check your FXML file 'Untitled'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'Untitled'.";

    }
}
