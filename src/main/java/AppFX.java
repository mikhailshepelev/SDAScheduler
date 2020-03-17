import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;

public class AppFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = Paths.get("./src/main/java/fxmlfiles/MainWindow.fxml").toUri().toURL();
        Pane mainWindow = FXMLLoader.load(url);
        Scene entryScene = new Scene(mainWindow);

        primaryStage.setScene(entryScene);
        primaryStage.show();
    }
}
