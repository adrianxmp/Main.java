package project.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.menu.csvIo;
import java.io.IOException;

public class Main extends Application {
    static final String version = "1.0";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1040, 480);
        stage.setTitle("Premier League Tracker v" + version);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        if(args.length > 0){
            csvIo.loadCsv(args[1]);
        }
        launch();
    }
}