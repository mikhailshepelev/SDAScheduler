package controller;

import entities.Topic;
import entities.Trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.TopicService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

    static Stage courseWindowController = new Stage();
    TopicService topicService = new TopicService();

    @FXML
    private ImageView logo;

    @FXML
    private Button closeButton;

    @FXML
    private TableView<Topic> topicTable;

    @FXML
    private TableColumn<Topic, Integer> topicId;

    @FXML
    private TableColumn<Topic, String> topicName;

    @FXML
    private TableColumn<Topic, String> courseName;

    @FXML
    private TableColumn<Trainer, String> trainerName;

    @FXML
    void closeWindow(ActionEvent event) throws IOException {

        courseWindowController.close();
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        topicId.setCellValueFactory(new PropertyValueFactory<>("topicID"));
        topicName.setCellValueFactory(new PropertyValueFactory<>("topicName"));
        courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        trainerName.setCellValueFactory(new PropertyValueFactory<>("name"));

        topicTable.setItems(getTopicTable());
    }

    ObservableList<Topic> getTopicTable(){
        ObservableList<Topic> topicList = FXCollections.observableArrayList(topicService.getTopics());
        return topicList;
    }
}
