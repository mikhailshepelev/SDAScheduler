package controller;

import entities.Course;
import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.CourseService;
import service.StudentService;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NewStudentController implements Initializable {

    static Stage createStudentStage = new Stage();
    CourseService courseService= new CourseService();

    ObservableList<String> studentsGenders = FXCollections.observableArrayList("Male", "Female");

    ObservableList<Course> courseList = FXCollections.observableArrayList(courseService.getListOfCourses());

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
    ChoiceBox<Course> course;

    @FXML
    private ImageView sdaLogo;

    @FXML
    void closeWindow(ActionEvent event) {
        createStudentStage.close();
    }

    @FXML
    void createButton(ActionEvent event) {
        if(isFilled()){
            if(isRightEmail()){
                if(isRightNumber()) {
                    Student student = new Student(getStudentName(), getGender(),
                            getStudentNumber(), getStudentEmail());
                    student.setCourse(getCourse());
                    StudentService createStudent = new StudentService();
                    createStudent.createStudent(student);
                    createStudentStage.close();
                }else{
                    wrongNumberAlert();
                }
            }else{
                wrongEmailAlert();
            }
        }else{
            notFilledAlert();
        }


    }


    String getStudentEmail() {
        return studentEmail.getText();
    }


    String getStudentName() {
        return studentName.getText() + " " + studentSurname.getText();
    }


    String getStudentNumber() {
        return studentNumber.getText();
    }



    boolean getGender(){
        return gender.getValue().equals("Male") ? true : false;
    }

    Course getCourse(){
        return course.getValue();
    }


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        gender.setItems(studentsGenders);
        gender.setValue("Male");

        course.setItems(courseList);
    }

    private boolean isFilled(){
        Pattern p = Pattern.compile("^(\\s|\\S)*(\\S)+(\\s|\\S)*$");
        Matcher name = p.matcher(studentName.getText());
        Matcher surname = p.matcher(studentSurname.getText());
        Matcher number = p.matcher(studentNumber.getText());
        Matcher email = p.matcher(studentEmail.getText());
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
        Matcher rightEmail = p.matcher(studentEmail.getText());
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
        Matcher phoneNumber = p.matcher(studentNumber.getText());
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