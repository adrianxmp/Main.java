package project.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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


}