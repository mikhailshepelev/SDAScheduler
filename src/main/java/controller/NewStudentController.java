package controller;

import entities.Student;
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
import service.StudentService;


public class NewStudentController {
    static Stage createStudentStage = new Stage();

    ObservableList<String> studentsGenders = FXCollections.observableArrayList("Male", "Female");

    @FXML
    private Button close;

    @FXML
    private Button create;

    @FXML
    private Pane newStudent;

    @FXML
    private TextField studentName;

    @FXML
    private TextField studentSurname;

    @FXML
    private TextField studentNumber;

    @FXML
    private TextField studentEmail;

    @FXML
    private ChoiceBox<String> gender;


    @FXML
    private ImageView sdaLogo;

    @FXML
    void closeWindow(ActionEvent event) {
        createStudentStage.close();
    }

    @FXML
    void createButton(ActionEvent event) {
        Student student = new Student(getStudentName(event),getGender(event),
                getStudentNumber(event), getStudentEmail(event));

        StudentService createStudent = new StudentService();
        createStudent.createStudent(student);
        createStudentStage.close();

    }

    @FXML
    String getStudentEmail(ActionEvent event) {
        return studentEmail.getText();
    }

    @FXML
    String getStudentName(ActionEvent event) {
        return studentName.getText() + " " + studentSurname.getText();
    }

    @FXML
    String getStudentNumber(ActionEvent event) {
        return studentNumber.getText();
    }


    @FXML
    boolean getGender(ActionEvent event){
        return gender.getValue().equals("Male") ? true : false;
    }
    @FXML
    void initialize() {
        gender.setItems(studentsGenders);

    }
}