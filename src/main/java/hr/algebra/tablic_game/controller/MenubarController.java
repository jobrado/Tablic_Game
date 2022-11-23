package hr.algebra.tablic_game.controller;

import hr.algebra.tablic_game.Utils.ReflectionUtils;
import hr.algebra.tablic_game.Utils.SceneUtil;
import hr.algebra.tablic_game.model.Card;
import hr.algebra.tablic_game.model.CellState;
import hr.algebra.tablic_game.model.GameState;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class MenubarController {

    public static final String GAME_STATE_SER = "gameState.ser";
    public static final String CLASS = ".class";
    public static final String DOCUMENTATION_HTML = "documentation.html";

    public void showNewGameScreen() {
        SecondScreenViewController.lastGameMoves.clear();
        SceneUtil.setNewSceneToStage("view/second-screen-view.fxml", 900, 900, "Tablic!");
    }
    public void showHighScoresScreen() {
        SceneUtil.setNewSceneToStage("view/highscore_view.fxml", 600, 400, "High score!");
    }

    public void showGameMoves() {
        SceneUtil.setNewSceneToStage("view/gameMoves.fxml", 600, 400, "High score!");
    }

    public void saveGame() throws IOException {
        GameState gameState = new GameState();
        List<CellState> cellStateList = new ArrayList<>();
        for (int row = 0; row < SecondScreenViewController.NUMBER_OF_ROWS; row++) {
            for (int col = 0; col < SecondScreenViewController.NUMBER_OF_COLUMNS; col++) {
                if (SecondScreenViewController.board[row][col].getUserData() != null) {
                    CellState cellState = new CellState(row, col, (Card) SecondScreenViewController.board[row][col].getUserData());
                    cellStateList.add(cellState);
                }
            }
        }
        gameState.setCellStateList(cellStateList);
        gameState.setPlayerOneName(SecondScreenViewController.playerOne.getName());

        gameState.setPlayerOneCardsPicked(SecondScreenViewController.playerOneCardPicked);
        gameState.setPlayerTwoCardsPicked(SecondScreenViewController.playerTwoCardPicked);
        gameState.setPlayerThreeCardsPicked(SecondScreenViewController.playerThreeCardPicked);
        gameState.setPlayerFourCardsPicked(SecondScreenViewController.playerFourCardPicked);

        gameState.setPlayerOneCurrentCardsList(SecondScreenViewController.playerOne.getPlayerCards());
        gameState.setPlayerTwoCurrentCardsList(SecondScreenViewController.playerTwo.getPlayerCards());
        gameState.setPlayerThreeCurrentCardsList(SecondScreenViewController.playerThree.getPlayerCards());
        gameState.setPlayerFourCurrentCardsList(SecondScreenViewController.playerFour.getPlayerCards());


        gameState.setPlayerOneTurn(SecondScreenViewController.playerOneTurn);
        gameState.setPlayerTwoTurn(SecondScreenViewController.playerTwoTurn);
        gameState.setPlayerThreeTurn(SecondScreenViewController.playerThreeTurn);
        gameState.setPlayerFourTurn(SecondScreenViewController.playerFourTurn);


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GAME_STATE_SER))) {

            oos.writeObject(gameState);
        }
    }

    public void loadGame() throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(GAME_STATE_SER))) {
            for (int row = 0; row < SecondScreenViewController.NUMBER_OF_ROWS; row++) {
                for (int col = 0; col < SecondScreenViewController.NUMBER_OF_COLUMNS; col++) {
                    if (SecondScreenViewController.board[row][col].getUserData() != null) {
                        SecondScreenViewController.board[row][col].setImage(null);
                    }
                }
            }
            GameState gameState = (GameState) ois.readObject();
            for (CellState cellState : gameState.getCellStateList()) {
                if (SecondScreenViewController.board[cellState.getCoordinateX()][cellState.getCoordinateY()] != null) {
                    SecondScreenViewController.board[cellState.getCoordinateX()][cellState.getCoordinateY()].setUserData(cellState.getCardOnTable());
                    SecondScreenViewController.board[cellState.getCoordinateX()][cellState.getCoordinateY()].setImage(cellState.getCardOnTable().getCardImage());
                }
            }

            SecondScreenViewController.playerOne.setName(gameState.getPlayerOneName());
            SecondScreenViewController.playerOneCardPicked.addAll(gameState.getPlayerOneCardsPicked());
            SecondScreenViewController.playerTwoCardPicked.addAll(gameState.getPlayerTwoCardsPicked());
            SecondScreenViewController.playerThreeCardPicked.addAll(gameState.getPlayerThreeCardsPicked());
            SecondScreenViewController.playerFourCardPicked.addAll(gameState.getPlayerFourCardsPicked());

            SecondScreenViewController.playerOne.setPlayerCards(gameState.getPlayerOneCurrentCardsList());
            SecondScreenViewController.playerTwo.setPlayerCards(gameState.getPlayerTwoCurrentCardsList());
            SecondScreenViewController.playerThree.setPlayerCards(gameState.getPlayerThreeCurrentCardsList());
            SecondScreenViewController.playerFour.setPlayerCards(gameState.getPlayerFourCurrentCardsList());

            SecondScreenViewController.playerOneTurn = gameState.getPlayerOneTurn();
            SecondScreenViewController.playerTwoTurn = gameState.getPlayerTwoTurn();
            SecondScreenViewController.playerThreeTurn = gameState.getPlayerThreeTurn();
            SecondScreenViewController.playerFourTurn = gameState.getPlayerFourTurn();
            setCards();
        }

    }

    final String IMAGE = "C:\\Users\\Jo\\Documents\\Svi predmeti\\5. PETI SEMESTAR\\JAVA2\\Tablic_Game\\src\\main\\resources\\images\\Back_of_card.png";

    private void setCards() {
        Image image = new Image(IMAGE);
        for (ImageView iv : SecondScreenViewController.playerOneCardPlaceholders) {
            iv.setImage(null);
        }
        for (int i = 0; i < SecondScreenViewController.playerOne.getPlayerCards().size(); i++)
            SecondScreenViewController.playerOneCardPlaceholders.get(i).setImage(SecondScreenViewController.playerOne.getPlayerCards().get(i).getCardImage());

        for (ImageView iv : SecondScreenViewController.playerTwoCardPlaceholders) {
            iv.setImage(null);
        }
        for (ImageView iv : SecondScreenViewController.playerThreeCardPlaceholders) {
            iv.setImage(null);
        }
        for (ImageView iv : SecondScreenViewController.playerFourCardPlaceholders) {
            iv.setImage(null);
        }
        for (int i = 0; i < SecondScreenViewController.playerTwo.getPlayerCards().size(); i++) {
            SecondScreenViewController.playerTwoCardPlaceholders.get(i).setImage(image);
        }
        for (int i = 0; i < SecondScreenViewController.playerThree.getPlayerCards().size(); i++) {
            SecondScreenViewController.playerThreeCardPlaceholders.get(i).setImage(image);
        }
        for (int i = 0; i < SecondScreenViewController.playerFour.getPlayerCards().size(); i++) {
            SecondScreenViewController.playerFourCardPlaceholders.get(i).setImage(image);
        }
    }
    public void generateDocumentation() {
        try {
            List<Path> filesList = Files.walk(Path.of(".")).filter(p -> p.getFileName().toString().endsWith(CLASS)).toList();
            filesList.forEach(System.out::println);
            List<Class> metaInfo = new ArrayList<>();
            for (Path path : filesList) {
                String fullQualifiedClassName = "";
                String[] paths = path.toString().split("\\\\");
                boolean startJoining = false;
                for (String segment : paths) {
                    if ("classes".equals(segment)) {
                        startJoining = true;
                        continue;
                    }
                    if (startJoining) {
                        if (segment.endsWith(CLASS)) {
                            fullQualifiedClassName += segment.substring(0, segment.lastIndexOf("."));
                        } else {
                            fullQualifiedClassName += segment + ".";
                        }
                    }
                }
                Class clazz = Class.forName(fullQualifiedClassName);
                metaInfo.add(clazz);
            }
            String documentationString = "";
            for (Class clazz : metaInfo) {
                documentationString += "<h2>" + clazz.getSimpleName() + "</h2>\n";
                documentationString += "<h3>  List of member variables: </h3\n>";
                for (Field f : clazz.getDeclaredFields()) {
                    documentationString += ReflectionUtils.retrieveModifiers(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName() + "<br />\n";
                }
                Constructor[] constructors = clazz.getConstructors();
                documentationString += "<h3>  List of constructors: </h3\n>";
                for (Constructor c : constructors) {

                    documentationString += "<h4>" + ReflectionUtils.retrieveModifiers(c.getModifiers()) + c.getName() + "(" + ReflectionUtils.retrieveParams(c.getParameters()) + ")" + "</h4>\n";
                }
                documentationString += "<h3> List of Methods: </h3>\n";
                for (Method method : clazz.getDeclaredMethods()){


                   documentationString += "<h4>"+ ReflectionUtils.retrieveModifiers(method.getModifiers()) +
                           method.getReturnType().getSimpleName() + " "
                           + method.getName() + "(" + ReflectionUtils.retrieveParams(method.getParameters()) + ")" +"</h4>";
                }
            }
            String content = "" + "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<title>Class Documentation</title>\n" + "</head>\n" + "<body>\n" + "\n" + "<h1>List of classes</h1>\n" + documentationString + "\n" + "</body>\n" + "</html>";
            Files.writeString(Path.of(DOCUMENTATION_HTML), content, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
