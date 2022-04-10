package project.app;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.data.Game;
import project.data.Timeline;

import java.util.ArrayList;

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
    @FXML public Label errorStatus;
    @FXML public Label displayStatus;

    /**
     * Adds a year to the data structure
     * @author Robert Engel AND Adrian Ponce, T03, April 9 2022
     */
    @FXML
    void addYearAction(MouseEvent event) {
        try{
            Timeline.addYear(Integer.parseInt(yearNumberInput.getText()));
            displayStatus.setText("Year added Successfully!");
        }
        catch(NumberFormatException e){
            errorStatus.setText("Error, Invalid Input! Please try Again!");
        }

    }
    /**
     * Adds a game to the data structure
     * @author Robert Engel, T03, April 9 2022
     */
    @FXML
    void addGameAction(MouseEvent event) {
        try{
            Game game = new Game(homeTeamNameInput.getText(),awayTeamNameInput.getText(),Integer.parseInt(homeFoulsInput.getText()),Integer.parseInt(awayFoulsInput.getText()),Integer.parseInt(homeShotsInput.getText()),Integer.parseInt(awayShotsInput.getText()),Integer.parseInt(homeGoalsInput.getText()),Integer.parseInt(awayGoalsInput.getText()),gameDateInput.getText());
            Game.addGameToYear(game, Integer.parseInt(gameDateInput.getText().substring(0, 4)));
            displayStatus.setText("Game Added successfully!");
        }
        catch(NumberFormatException e){
            errorStatus.setText("Error, Invalid Input! Please try Again!");
        }
    }
    @FXML
    void getAllYearsAction(MouseEvent event) {
        if (Timeline.getAllYears().isEmpty()) {
            errorStatus.setText("Error! No Year found!");
        }else
            display.setText(Timeline.getAllYears().toString());
            displayStatus.setText("Success! Got all years!");
    }

    /**
     * General GUI setup stuff
     * @author Robert Engel, T03, April 9 2022
     * (I'm sure Adrian will add stuff here too)
     */
    @FXML
    public void initialize(){
        displayStatus.setText("");
        errorStatus.setTextFill(Paint.valueOf("RED"));
        errorStatus.setText("");
        display.setText("");
    }
    /**
     * Saves the current data in the program to 'data.csv'
     * @author Robert Engel, T03, April 9 2022
     */
    @FXML
    private void onSaveClick(){
        int successCheck = project.menu.csvIo.createCsv("data");
        if(successCheck == 1){
            displayStatus.setText("File Saved Successfully!");
        }
        else{
            errorStatus.setText("Error! Something went wrong!");
        }
    }
    /**
     * Saves the current data in the program to the chosen filename
     * @author Robert Engel, T03, April 9 2022
     */
    @FXML
    private void onSaveAsClick(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        String filename = fileChooser.showSaveDialog(stage).getName();
        int successCheck = project.menu.csvIo.createCsv(filename);
        if(successCheck == 1){
            displayStatus.setText("File Saved Successfully!");
        }
        else{
            errorStatus.setText("Error! Something went wrong!");
        }
    }
    /**
     * Gives a short description and its creators (myself and Adrian)
     * @author Robert Engel, T03, April 9 2022
     */
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
    /**
     * Loads a given CSV file, if it is of the correct type, it will load the data from the CSV into the program
     * @author Robert Engel, T03, April 9 2022
     */
    @FXML
    private void onLoadClick(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        String filename = fileChooser.showSaveDialog(stage).getName();
        int successCheck = project.menu.csvIo.loadCsv(filename);
        if(successCheck == 1){
            displayStatus.setText("File Loaded Successfully!");
        }
        else{
            errorStatus.setText("Error! Something went wrong!");
        }
    }

}