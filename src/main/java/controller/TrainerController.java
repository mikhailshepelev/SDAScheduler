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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TrainerController {

    MainWindowController mainWindowController = new MainWindowController();
    String menuLink = "./src/main/java/fxmlfiles/MainWindow.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane trainerWindow;

    @FXML
    private Button viewTrainerSchedule;

    @FXML
    private Button backButton;

    @FXML
    private TextField phoneNumber;

    @FXML
    void getPhoneNumber(ActionEvent event) {

    }

    @FXML
    void getTrainerSchedule(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        mainWindowController.navigate(event, menuLink);
    }

    @FXML
    void initialize() {
        assert trainerWindow != null : "fx:id=\"trainerWindow\" was not injected: check your FXML file 'TrainerWindow.fxml'.";
        assert viewTrainerSchedule != null : "fx:id=\"viewTrainerSchedule\" was not injected: check your FXML file 'TrainerWindow.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'TrainerWindow.fxml'.";
        assert phoneNumber != null : "fx:id=\"phoneNumber\" was not injected: check your FXML file 'TrainerWindow.fxml'.";

    }
}
