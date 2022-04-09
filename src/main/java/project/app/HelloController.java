package project.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import project.data.Timeline;

public class HelloController {
    @FXML
    private TextField homeFoulsInput;

    @FXML
    private TextField homeGoalsInput;

    @FXML
    private TextField homeShotsInput;

    @FXML
    private TextField homeTeamNameInput;

    @FXML
    private TextField awayFoulsInput;

    @FXML
    private TextField awayGoalsInput;

    @FXML
    private TextField awayShotsInput;

    @FXML
    private TextField awayTeamNameInput;

    @FXML
    private TextField gameDateInput;

    @FXML
    private TextField yearNumberInput;

    @FXML
    void addYearAction(MouseEvent event) {
        Timeline.addYear(Integer.parseInt(yearNumberInput.getText()));
    }

    @FXML
    void addGameAction(MouseEvent event) {

    }



}