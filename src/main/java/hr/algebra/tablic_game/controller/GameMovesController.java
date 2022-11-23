package hr.algebra.tablic_game.controller;

import hr.algebra.tablic_game.model.GameMove;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class GameMovesController {
    @FXML
    private TextArea gameMovesTextArea;

    public void initialize() {
        for(GameMove gameMove : SecondScreenViewController.lastGameMoves) {
            gameMovesTextArea.appendText(gameMove.toString() + "\n");
        }
    }
}
