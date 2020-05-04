package controller;

import dto.ScheduleDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ScheduleService;

import javax.persistence.NoResultException;
import java.io.IOException;

public class TrainersScheduleController {

    MainWindowController mainWindowController = new MainWindowController();
    String menuLink = "./src/main/java/fxmlfiles/MainWindow.fxml";

    @FXML
    private TableView<ScheduleDTO> trainerSchedule;

    @FXML
    private TableColumn<ScheduleDTO, String> courseName;

    @FXML
    private TableColumn<ScheduleDTO, String> topicName;

    @FXML
    private TableColumn<ScheduleDTO, String> date;

    @FXML
    private TableColumn<ScheduleDTO, String> time;

    @FXML
    private TableColumn<ScheduleDTO, String> venuePlace;

    @FXML
    private Button menu;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button showButton;

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        mainWindowController.navigate(event, menuLink);
    }

    @FXML
    void showSchedule(ActionEvent event) {
        getTable();
    }

    public void getTable() {
        try {
            courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
            topicName.setCellValueFactory(new PropertyValueFactory<>("topicName"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            time.setCellValueFactory(new PropertyValueFactory<>("time"));
            venuePlace.setCellValueFactory(new PropertyValueFactory<>("venuePlace"));


            trainerSchedule.setItems(getSchedule());

            System.out.println();
        } catch (NoResultException e){
            wrongNumber();
        }catch (NullPointerException e){
            wrongNumber();
        }
    }

    public ObservableList<ScheduleDTO> getSchedule(){

        ScheduleService schedule = new ScheduleService();

        ObservableList<ScheduleDTO> scheduleList = FXCollections.
                observableArrayList(schedule.getTrainerSchedule(phoneNumber.getText()));

        return scheduleList;
    }

    private void wrongNumber(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");

        alert.setContentText("Wrong number or you aren't set to the course yet");
        alert.showAndWait();

    }

}
