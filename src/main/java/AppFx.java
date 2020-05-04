import entities.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.CourseService;
import service.StudentService;
import util.HibernateUtil;

import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class AppFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = Paths.get("./src/main/java/fxmlfiles/MainWindow.fxml").toUri().toURL();
        Pane mainWindow = FXMLLoader.load(url);
        Scene entryScene = new Scene(mainWindow);
        primaryStage.setTitle("SDA Scheduler");

        primaryStage.setScene(entryScene);
        primaryStage.show();
    }
}