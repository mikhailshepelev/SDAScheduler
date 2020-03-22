package controller;

import entities.Trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.TrainerService;

import java.net.URL;
import java.util.ResourceBundle;

public class AllTrainersController implements Initializable {

    static Stage allTrainers = new Stage();
    TrainerService trainerService = new TrainerService();

    @FXML
    private TableView<Trainer> tableView;

    @FXML
    private TableColumn<Trainer, Integer> IDcolumn;

    @FXML
    private TableColumn<Trainer, String> fullnameColumn;

    @FXML
    private TableColumn<Trainer, String> genderCollumn;

    @FXML
    private TableColumn<Trainer, String> emailColumn;

    @FXML
    private TableColumn<Trainer, String> phoneNumberColumn;

    @FXML
    private TableColumn<Trainer, String> topicsColumn;

    @FXML
    private TableColumn<Trainer, String> skillsColumn;

    @FXML
    private Button closeButton;

    @FXML
    void closeTable(ActionEvent event) {
        allTrainers.close();
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("trainerID"));
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderCollumn.setCellValueFactory(new PropertyValueFactory<>("male"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        //topicsColumn.setCellValueFactory(new PropertyValueFactory<>("topicsList"));
        skillsColumn.setCellValueFactory(new PropertyValueFactory<>("skills"));

        tableView.setItems(getAllTrainers());

    }

    private ObservableList<Trainer> getAllTrainers(){
        ObservableList<Trainer> allTrainers = FXCollections.observableArrayList(trainerService.getFullListOfTrainers());

        return allTrainers;
    }
}
