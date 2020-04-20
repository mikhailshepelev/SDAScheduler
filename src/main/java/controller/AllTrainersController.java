package controller;

import entities.Trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.TrainerService;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
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
    private Button newTrainer;

    @FXML
    private Button deleteTrainer;

    @FXML
    private Button closeButton;

    @FXML
    void createTrainer(ActionEvent event) throws IOException {
        URL url = Paths.get("./src/main/java/fxmlfiles/CreateTrainerWindow.fxml").toUri().toURL();

        Parent createTrainer = FXMLLoader.load(url);
        Scene createScene = new Scene(createTrainer);
        NewTrainerController.createTrainerStage = new Stage();
        NewTrainerController.createTrainerStage.setTitle("SDA ScheduleDTO");
        NewTrainerController.createTrainerStage.setScene(createScene);
        NewTrainerController.createTrainerStage.initModality(Modality.APPLICATION_MODAL);
        NewTrainerController.createTrainerStage.showAndWait();

        tableView.setItems(getAllTrainers());
    }

    @FXML
    void deleteTrainer(ActionEvent event){

        int trainerID = tableView.getSelectionModel().getSelectedItem().getTrainerID();
        trainerService.deleteTrainer(trainerID);
        tableView.setItems(getAllTrainers());
    }

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
        topicsColumn.setCellValueFactory(new PropertyValueFactory<>("topics"));
        skillsColumn.setCellValueFactory(new PropertyValueFactory<>("skills"));

        tableView.setItems(getAllTrainers());

    }

    private ObservableList<Trainer> getAllTrainers(){
        ObservableList<Trainer> allTrainers = FXCollections.observableArrayList(trainerService.getFullListOfTrainers());

        return allTrainers;
    }
}
