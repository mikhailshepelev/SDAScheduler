package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane entryWindow;

    @FXML
    private Button goToTrainer;

    @FXML
    private ImageView logo;

    @FXML
    void managerWindow(ActionEvent event) throws IOException {
        URL url = Paths.get("./src/main/java/fxmlfiles/ManagerWindow.fxml").toUri().toURL();
        Pane managerWindow = FXMLLoader.load(url);
        Scene managerScene = new Scene(managerWindow);

        Stage entryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        entryStage.setScene(managerScene);
        entryStage.show();
    }

    @FXML
    void studentWindow(ActionEvent event) throws IOException {

        URL url = Paths.get("./src/main/java/fxmlfiles/StudentWindow.fxml").toUri().toURL();
        Pane studentWindow = FXMLLoader.load(url);
        Scene studentScene = new Scene(studentWindow);


        Stage students = (Stage)((Node)event.getSource()).getScene().getWindow();

        students.setScene(studentScene);
        students.show();
    }

    @FXML
    void trainerWindow(ActionEvent event) throws IOException {



        URL url = Paths.get("./src/main/java/fxmlfiles/TrainerWindow.fxml").toUri().toURL();

        Parent trainerWindow = FXMLLoader.load(url);
        Scene trainerScene = new Scene(trainerWindow);


        Stage trainers = (Stage)((Node)event.getSource()).getScene().getWindow();

        trainers.setScene(trainerScene);
        trainers.show();

    }

    @FXML
    void initialize() {
        assert entryWindow != null : "fx:id=\"entryWindow\" was not injected: check your FXML file 'Untitled'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'Untitled'.";

    }
}

