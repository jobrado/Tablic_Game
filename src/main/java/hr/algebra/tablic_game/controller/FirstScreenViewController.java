package hr.algebra.tablic_game.controller;

import hr.algebra.tablic_game.Utils.SceneUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FirstScreenViewController {
    @FXML
    public  TextField tfPlayerOneName;
    public static String playerOneName;

    @FXML
    private void StartGame(){
        if (tfPlayerOneName.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska!");
            alert.setHeaderText(null);
            alert.setContentText("Molim upisite ime igraca!");

            alert.showAndWait();
        }
        else{
            playerOneName = tfPlayerOneName.getText().trim();
            System.out.println("ps" + playerOneName);
            startNewScreen();
        }
    }

    private void startNewScreen() {
        SceneUtil.setNewSceneToStage("view/second-screen-view.fxml",900,900, "Tablic!" );

    }
}
