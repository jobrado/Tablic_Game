package hr.algebra.tablic_game.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class HighscoreViewController {
    @FXML
    private TextArea highScoresTextArea;

    public void initialize() {
        highScoresTextArea.setText(SecondScreenViewController.allScores.toString());
    }
}
