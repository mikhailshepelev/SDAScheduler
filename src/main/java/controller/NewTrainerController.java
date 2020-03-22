package controller;

import entities.Trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.TrainerService;

public class NewTrainerController {

    static Stage createTrainerStage = new Stage();
    private ObservableList<String> trainersGender = FXCollections.observableArrayList("Male", "Female");

    @FXML
    private Pane newTrainer;

    @FXML
    private TextField trainerName;

    @FXML
    private TextField trainerSurname;

    @FXML
    private TextField trainerNumber;

    @FXML
    private TextField trainerEmail;

    @FXML
    private ImageView sdaLogo;

    @FXML
    private Button close;

    @FXML
    private Button create;

    @FXML
    private ChoiceBox<String> gender;

    @FXML
    private TextField trainerSkills;



    @FXML
    void closeWindow(ActionEvent event) {
        createTrainerStage.close();
    }

    @FXML
    void createButton(ActionEvent event) {
        Trainer trainer = new Trainer(getTrainerName(event),
                getGender(event), getTrainerEmail(event),
                getTrainerNumber(event), getSkills(event));
        TrainerService trainerService = new TrainerService();
        trainerService.createTrainer(trainer);
        createTrainerStage.close();
    }

    @FXML
    String getSkills(ActionEvent event) {
       return this.trainerSkills.getText();
    }

    @FXML
    String getTrainerEmail(ActionEvent event) {
        return this.trainerEmail.getText() ;
    }

    @FXML
    String getTrainerName(ActionEvent event) {
        return this.trainerName.getText() + " " + this.trainerSurname.getText();
    }

    @FXML
    String getTrainerNumber(ActionEvent event) {
        return this.trainerNumber.getText();
    }


    @FXML
    boolean getGender(ActionEvent event){
       return gender.getValue().equals("Male") ? true : false;
    }

    @FXML
    void initialize(){
        gender.setItems(trainersGender);
    }
}
