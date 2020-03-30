package controller;

import entities.Student;
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
import service.StudentService;

import java.net.URL;
import java.util.ResourceBundle;

public class AllStudentsController implements Initializable{

    static Stage allStudents = new Stage();
    StudentService studentService = new StudentService();

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
    private Button deleteStudent;

    @FXML
    private Button closeButton;

    @FXML
    void closeTable(ActionEvent event) {
        allStudents.close();

    }

    @FXML
    void deleteStudent(ActionEvent event){
        int studentID = tableView.getSelectionModel().getSelectedItem().getSID();
        studentService.deleteStudent(studentID);
        tableView.setItems(getAllStudents());
    }


    @FXML
    public void initialize(URL location, ResourceBundle resources) {

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
