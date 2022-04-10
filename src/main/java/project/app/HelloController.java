package project.app;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.data.Timeline;

public class HelloController {
    @FXML private TextField homeFoulsInput;
    @FXML private TextField homeGoalsInput;
    @FXML private TextField homeShotsInput;
    @FXML private TextField homeTeamNameInput;
    @FXML private TextField awayFoulsInput;
    @FXML private TextField awayGoalsInput;
    @FXML private TextField awayShotsInput;
    @FXML private TextField awayTeamNameInput;
    @FXML private TextField gameDateInput;
    @FXML private TextField yearNumberInput;
    @FXML private TextField generalHomeInput;
    @FXML private TextField generalAwayInput;
    @FXML private TextField generalDateInput;
    @FXML private TextField generalYearInput;
    @FXML private TextArea display;
    @FXML private Label errorStatus;
    @FXML private Label displayStatus;

    @FXML
    void addYearAction(MouseEvent event) {
        Timeline.addYear(Integer.parseInt(yearNumberInput.getText()));
    }

    @FXML
    void addGameAction(MouseEvent event) {

    }
    /**
     * General GUI setup stuff
     * @author Robert Engel, T03, April 9 2022
     * (I'm sure Adrian will add stuff here too)
     */
    @FXML
    public void initialize(){
        displayStatus.setText("");
        errorStatus.setText("");
    }
    @FXML
    private void onSaveClick(){

    }
    @FXML
    private void onSaveAsClick(){

    }
    @FXML
    private void onAboutClick(){
        Text text = new Text();
        text.setText("Author: Robert Engel and Adrian Ponce\nVersion:" + Main.version + "\nThis is a Premier League Data Tracker");
        VBox vbox = new VBox(text);
        Scene scene = new Scene(vbox, 300, 50);
        Stage stage = new Stage();
        stage.setTitle("About");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void onLoadClick(){

    }

}