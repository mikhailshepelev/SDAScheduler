package controller;

import entities.Course;
import entities.Student;
import entities.Topic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.CourseService;
import service.StudentService;
import service.TopicService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseWindowController implements Initializable {

    StudentService studentService = new StudentService();
    TopicService topicService = new TopicService();

    MainWindowController mainWindowController = new MainWindowController();
    String backPath = "./src/main/java/fxmlfiles/ManagerWindow.fxml";

    int course;

    @FXML
    private TableView<Course> coursesTable;

    @FXML
    private TableColumn<Course, Integer> courseID;

    @FXML
    private TableColumn<Course, String> courseName;

    @FXML
    private TableView<Topic> topicTable;

    @FXML
    private TableColumn<Topic, Integer> topicID;

    @FXML
    private TableColumn<Topic, String> topicName;

    @FXML
    private TableColumn<Topic, String> trainerName;

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, Integer> studentsID;

    @FXML
    private TableColumn<Student, String> studentsName;

    @FXML
    private TableColumn<Student, String> studentsPhone;

    @FXML
    private Button deleteTopicButton;

    @FXML
    private Button deleteStudentButton;

    @FXML
    private Button setStudentButton;

    @FXML
    private Button createTopicButton;

    @FXML
    private Button backButton;

    @FXML
    void createTopic(ActionEvent event) {

    }

    @FXML
    void deleteStudent(ActionEvent event) {

    }

    @FXML
    void deleteTopic(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        mainWindowController.navigate(event, backPath);

    }

    @FXML
    void setStudent(ActionEvent event) {




    }

    void getCoursesTable(){
        courseID.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
        courseName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        coursesTable.setItems(getCourseList());

    }

    ObservableList<Course> getCourseList(){
        CourseService courseService = new CourseService();

        ObservableList<Course> coursesList = FXCollections.observableArrayList(courseService.getListOfCourses());
        return coursesList;
    }

    void getStudentsTable(){
        studentsID.setCellValueFactory(new PropertyValueFactory<>("SID"));
        studentsName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        studentsPhone.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));

        studentsTable.setItems(getStudentsList());
    }

    ObservableList<Student> getStudentsList(){

        ObservableList<Student> studentList = FXCollections.observableList
                (studentService.getListOfStudentsFromCourse(course));
        return studentList;

    }
    void getTopicTable(){
        topicID.setCellValueFactory(new PropertyValueFactory<>("TopicID"));
        topicName.setCellValueFactory(new PropertyValueFactory<>("TopicName"));

        topicTable.setItems(getTopicList());
    }

    ObservableList<Topic> getTopicList(){

        ObservableList<Topic> listOfTopics = FXCollections.
                observableArrayList(topicService.getTopics());

        return listOfTopics;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getCoursesTable();


        coursesTable.getSelectionModel().selectedItemProperty().
                addListener(((observable, oldValue, newValue) ->
                {
                    course = newValue.getCourseID();
                    getStudentsTable();
                    getTopicTable();
                }));
    }
}
