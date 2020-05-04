package controller;

import entities.Course;
import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.CourseService;
import service.StudentService;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class AllStudentsController implements Initializable{

    static Stage allStudents = new Stage();
    StudentService studentService = new StudentService();
    CourseService courseService = new CourseService();

    ObservableList<Course> courseList = FXCollections.observableArrayList(courseService.getListOfCourses());

    int studentID, courseID;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> IDcolumn;

    @FXML
    private TableColumn<Student, String> fullnameColumn;

    @FXML
    private TableColumn<Student, String> genderCollumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    private TableColumn<Student, String> phoneNumberColumn;

    @FXML
    private TableColumn<Student, Integer> courseColumn;

    @FXML
    private ChoiceBox<Course> selectedCourse;

    @FXML
    private Button newStudent;

    @FXML
    private Button deleteStudent;

    @FXML
    private Button closeButton;

    @FXML
    private Button toCourseButton;

    @FXML
    void closeTable(ActionEvent event) {
        allStudents.close();

    }

    @FXML
    void newStudent(ActionEvent event) throws IOException {
        URL url = Paths.get("./src/main/java/fxmlfiles/CreateStudentWindow.fxml").toUri().toURL();
        Parent createStudent = FXMLLoader.load(url);
        Scene createScene = new Scene(createStudent);
        NewStudentController.createStudentStage = new Stage();
        NewStudentController.createStudentStage.setTitle("SDA Scheduler");
        NewStudentController.createStudentStage.setScene(createScene);
        NewStudentController.createStudentStage.initModality(Modality.APPLICATION_MODAL);
        NewStudentController.createStudentStage.showAndWait();

        tableView.setItems(getAllStudents());
    }

    @FXML
    void deleteStudent(ActionEvent event){

        studentService.deleteStudent(studentID);
        setStudentTable();
    }

    @FXML
    void addToCourse(ActionEvent event){
        studentService.addToCourse(studentID, courseID);
        setStudentTable();
    }


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        setStudentTable();
        selectedCourse.setItems(courseList);

        tableView.getSelectionModel().selectedItemProperty().
                addListener((((observable, oldValue, newValue) -> studentID = newValue.getSID())));

        selectedCourse.getSelectionModel().selectedItemProperty().
                addListener((((observable, oldValue, newValue) ->
                        courseID = newValue.getCourseID())));
    }

    private void setStudentTable(){
        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("SID"));
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderCollumn.setCellValueFactory(new PropertyValueFactory<>("Male"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));

        tableView.setItems(getAllStudents());
    }

    private ObservableList<Student> getAllStudents(){
        ObservableList<Student> listOfStudents = FXCollections.observableArrayList(studentService.getFullListOfStudents());
        return listOfStudents;
    }
}
