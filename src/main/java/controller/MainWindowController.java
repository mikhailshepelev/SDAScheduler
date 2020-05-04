package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

        navigate(event, "./src/main/java/fxmlfiles/ManagerWindow.fxml");

    }

    @FXML
    void studentWindow(ActionEvent event) throws IOException {

       navigate(event,"./src/main/java/fxmlfiles/StudentSchedule.fxml" );

    }

    @FXML
    void trainerWindow(ActionEvent event) throws IOException {

        navigate(event,"./src/main/java/fxmlfiles/TrainerSchedule.fxml" );

    }

    @FXML
    void initialize() {
        assert entryWindow != null : "fx:id=\"entryWindow\" was not injected: check your FXML file 'Untitled'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'Untitled'.";

    }

    protected void navigate(Event event, String link) throws IOException {
        URL url = Paths.get(link).toUri().toURL();
        Parent parentPage = FXMLLoader.load(url);

        Scene scene = new Scene(parentPage);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("SDA Scheduler");

        stage.setScene(scene);
        stage.show();
    }
}

