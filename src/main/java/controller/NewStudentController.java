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
import service.StudentService;

public class NewStudentController {

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
        ManagerController.createStudentStage.close();
    }

    @FXML
    void createButton(ActionEvent event) {
        Student student = new Student();
        student.setName(getStudentName(event) + " " + getStudentSurname(event));
        student.setPhoneNumber(getStudentNumber(event));
        student.setEmail(getStudentEmail(event));
        student.setMale(getGender());
        StudentService createStudent = new StudentService();
        createStudent.createStudent(student);
        ManagerController.createStudentStage.close();

    }

    @FXML
    String getStudentEmail(ActionEvent event) {
        return studentEmail.getText();
    }

    @FXML
    String getStudentName(ActionEvent event) {
        return studentName.getText();
    }

    @FXML
    String getStudentNumber(ActionEvent event) {
        return studentNumber.getText();
    }

    @FXML
    String getStudentSurname(ActionEvent event) {
        return studentSurname.getText();
    }
    @FXML
    boolean getGender(){
        if(gender.getValue().equals("Male"))return true;
        else return false;
    }
    @FXML
    void initialize() {
        gender.setItems(studentsGenders);

    }
}