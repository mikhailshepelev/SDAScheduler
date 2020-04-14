package controller;

import entities.Trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.TrainerService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(isFilled()) {
            if(isRightEmail()) {
                if(isRightNumber()) {
                    Trainer trainer = new Trainer(getTrainerName(),
                            getGender(), getTrainerEmail(),
                            getTrainerNumber(), getSkills());
                    TrainerService trainerService = new TrainerService();
                    trainerService.createTrainer(trainer);
                    createTrainerStage.close();
                }else{
                    wrongNumberAlert();
                }

            }else {
                wrongEmailAlert();
            }
        }else{
            notFilledAlert();
        }
    }


    String getSkills() {
       return this.trainerSkills.getText();
    }


    String getTrainerEmail( ) {
        return this.trainerEmail.getText() ;
    }


    String getTrainerName( ) {
        return this.trainerName.getText() + " " + this.trainerSurname.getText();
    }


    String getTrainerNumber( ) {
        return this.trainerNumber.getText();
    }



    boolean getGender( ){
       return gender.getValue().equals("Male") ? true : false;
    }

    @FXML
    void initialize(){
        gender.setItems(trainersGender);
        gender.setValue("Male");
    }

    private boolean isFilled(){
        Pattern p = Pattern.compile("^(\\s|\\S)*(\\S)+(\\s|\\S)*$");
        Matcher name = p.matcher(trainerName.getText());
        Matcher surname = p.matcher(trainerSurname.getText());
        Matcher number = p.matcher(trainerNumber.getText());
        Matcher email = p.matcher(trainerEmail.getText());
        if(name.matches() && surname.matches() && number.matches() && email.matches()) return true;
        else return false;
    }

    private void notFilledAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");

        alert.setContentText("You should fill up your personal information");
        alert.showAndWait();

    }


    private boolean isRightEmail(){
        Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher rightEmail = p.matcher(trainerEmail.getText());
        if(rightEmail.matches()) return true;
        else return false;
    }
    private void wrongEmailAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");

        alert.setContentText("You should fill up your e-mail correctly");
        alert.showAndWait();

    }

    private boolean isRightNumber(){
        Pattern p = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");
        Matcher phoneNumber = p.matcher(trainerNumber.getText());
        if(phoneNumber.matches()) return true;
        else return false;
    }
    private void wrongNumberAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");

        alert.setContentText("You should fill up your phone number according to \"+111 1111...\"");
        alert.showAndWait();

    }

}
