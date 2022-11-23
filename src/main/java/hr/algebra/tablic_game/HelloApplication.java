package hr.algebra.tablic_game;

import hr.algebra.tablic_game.Utils.SceneUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static  Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        SceneUtil.setNewSceneToStage("view/first_screen_view.fxml",600,400, "Tablic!" );
    }
    public static Stage getMainStage(){
        return mainStage;
    }
    public static void main(String[] args) {
        launch();
    }
}