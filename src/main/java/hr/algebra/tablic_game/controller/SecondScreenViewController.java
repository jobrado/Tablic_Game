package hr.algebra.tablic_game.controller;

import hr.algebra.tablic_game.model.Card;
import hr.algebra.tablic_game.model.DeckOfCards;
import hr.algebra.tablic_game.model.GameMove;
import hr.algebra.tablic_game.model.Player;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class SecondScreenViewController {
    public static final String SACEKAJ_SVOJ_RED = "Sacekaj svoj red!!!";
    public static final String GOTOVA_IGRA = "Gotova igra!!!";
    public static final String VI_STE_NA_POTEZU = "Vi ste na potezu!!!";
    private static List<Card> cardsOnTable;
    @FXML
    private ImageView imgDeckOfCards;
    @FXML
    private ImageView cardPlaceholder1;
    @FXML
    private ImageView cardPlaceholder2;
    @FXML
    private ImageView cardPlaceholder3;
    @FXML
    private ImageView cardPlaceholder4;
    @FXML
    private ImageView cardPlaceholder5;
    @FXML
    private ImageView cardPlaceholder6;
    @FXML
    private ImageView playerTwoCardPlaceholder1;
    @FXML
    private ImageView playerTwoCardPlaceholder2;
    @FXML
    private ImageView playerTwoCardPlaceholder3;
    @FXML
    private ImageView playerTwoCardPlaceholder4;
    @FXML
    private ImageView playerTwoCardPlaceholder5;
    @FXML
    private ImageView playerTwoCardPlaceholder6;
    @FXML
    private ImageView playerThreeCardPlaceholder1;
    @FXML
    private ImageView playerThreeCardPlaceholder2;
    @FXML
    private ImageView playerThreeCardPlaceholder3;
    @FXML
    private ImageView playerThreeCardPlaceholder4;
    @FXML
    private ImageView playerThreeCardPlaceholder5;
    @FXML
    private ImageView playerThreeCardPlaceholder6;
    @FXML
    private ImageView playerFourCardPlaceholder2;
    @FXML
    private ImageView playerFourCardPlaceholder3;
    @FXML
    private ImageView playerFourCardPlaceholder4;
    @FXML
    private ImageView playerFourCardPlaceholder5;
    @FXML
    private ImageView playerFourCardPlaceholder6;
    @FXML
    private ImageView playerFourCardPlaceholder1;
    /*---------------------------*/
    @FXML
    private Label playerOneNameLabel;
    @FXML
    private Label playerTwoNameLabel;
    @FXML
    private Label playerThreeNameLabel;
    @FXML
    private Label playerFourNameLabel;
    private static final String playerTwoName = "Mirko";
    private static final String playerThreeName = "Slavko";
    private static final String playerFourName = "Perica";
    public static final int NUMBER_OF_ROWS = 4;
    public static final int NUMBER_OF_COLUMNS = 6;
    public final static ImageView[][] board = new ImageView[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    public static Map<String, Integer> allScores = new HashMap<>();
    @FXML
    private ImageView zeroZero;
    @FXML
    private ImageView oneZero;
    @FXML
    private ImageView twoZero;
    @FXML
    private ImageView threeZero;
    @FXML
    private ImageView fourZero;
    @FXML
    private ImageView fiveZero;
    @FXML
    private ImageView zeroOne;
    @FXML
    private ImageView oneOne;
    @FXML
    private ImageView twoOne;
    @FXML
    private ImageView threeOne;
    @FXML
    private ImageView fourOne;
    @FXML
    private ImageView fiveOne;
    @FXML
    private ImageView zeroTwo;
    @FXML
    private ImageView oneTwo;
    @FXML
    private ImageView twoTwo;
    @FXML
    private ImageView threeTwo;
    @FXML
    private ImageView fourTwo;
    @FXML
    private ImageView fiveTwo;
    @FXML
    private ImageView zeroThree;
    @FXML
    private ImageView oneThree;
    @FXML
    private ImageView fiveThree;
    @FXML
    private ImageView twoThree;
    @FXML
    private ImageView threeThree;
    @FXML
    private ImageView fourThree;
    @FXML
    GridPane mainGridPane;

    private int cardValue;

    public static List<ImageView> playedCardsList = new ArrayList<>();
    public static List<ImageView> playerTwoCardPlaceholders = new ArrayList<>();
    public static List<ImageView> playerThreeCardPlaceholders = new ArrayList<>();
    public static List<ImageView> playerFourCardPlaceholders = new ArrayList<>();
    public static List<ImageView> playerOneCardPlaceholders = new ArrayList<>();

    public static Player playerOne = new Player();
    public static Player playerTwo = new Player();
    public static Player playerThree = new Player();
    public static Player playerFour = new Player();
    public static boolean playerOneTurn = true;
    public static boolean playerTwoTurn = false;
    public static boolean playerThreeTurn = false;
    public static boolean playerFourTurn = false;
    private static Card cardThrown;
    public static List<Card> playerOneCardPicked = new ArrayList<>();
    public static List<Card> playerTwoCardPicked = new ArrayList<>();
    public static List<Card> playerThreeCardPicked = new ArrayList<>();
    public static List<Card> playerFourCardPicked = new ArrayList<>();
    public static List<GameMove> lastGameMoves = new ArrayList<>();
    static int playerCardCollected2 = 0;
    static int playerCardCollected3 = 0;
    static int playerCardCollected4 = 0;
    static int i = 0;
    static int collectedCards = 0;


    /*---------------------------*/
    public void initialize() {
        DeckOfCards.fill();
        board[0][0] = zeroZero;
        board[0][1] = oneZero;
        board[0][2] = twoZero;
        board[0][3] = threeZero;
        board[0][4] = fourZero;
        board[0][5] = fiveZero;
        board[1][0] = zeroOne;
        board[1][1] = oneOne;
        board[1][2] = twoOne;
        board[1][3] = threeOne;
        board[1][4] = fourOne;
        board[1][5] = fiveOne;
        board[2][0] = zeroTwo;
        board[2][1] = oneTwo;
        board[2][2] = twoTwo;
        board[2][3] = threeTwo;
        board[2][4] = fourTwo;
        board[2][5] = fiveTwo;
        board[3][0] = zeroThree;
        board[3][1] = oneThree;
        board[3][2] = twoThree;
        board[3][3] = threeThree;
        board[3][4] = fourThree;
        board[3][5] = fiveThree;
        initializeTeams();
        initializeCards();
        playerOneTurn = true;

    }

    private void initializeCards() {
        cardsOnTable = DeckOfCards.putFourCardsOnTable();
        twoOne.setImage(cardsOnTable.get(0).getCardImage());
        twoOne.setUserData(cardsOnTable.get(0));
        threeOne.setImage(cardsOnTable.get(1).getCardImage());
        threeOne.setUserData(cardsOnTable.get(1));
        twoTwo.setImage(cardsOnTable.get(2).getCardImage());
        twoTwo.setUserData(cardsOnTable.get(2));
        threeTwo.setImage(cardsOnTable.get(3).getCardImage());
        threeTwo.setUserData(cardsOnTable.get(3));
    }

    void initializeTeams() {
        playerOne.setName(FirstScreenViewController.playerOneName);
        playerOne.setPlayerCards(DeckOfCards.dealCards());
        playerTwo.setName(playerTwoName);
        playerTwo.setPlayerCards(DeckOfCards.dealCards());
        playerThree.setName(playerThreeName);
        playerThree.setPlayerCards(DeckOfCards.dealCards());
        playerFour.setName(playerFourName);
        playerFour.setPlayerCards(DeckOfCards.dealCards());

        playerOneNameLabel.setText(FirstScreenViewController.playerOneName);
        playerTwoNameLabel.setText(playerTwoName);
        playerThreeNameLabel.setText(playerThreeName);
        playerFourNameLabel.setText(playerFourName);

        drawPlayerCards();
    }

    private void drawPlayerCards() {
        cardPlaceholder1.setPickOnBounds(true);
        cardPlaceholder2.setPickOnBounds(true);
        cardPlaceholder3.setPickOnBounds(true);
        cardPlaceholder4.setPickOnBounds(true);
        cardPlaceholder5.setPickOnBounds(true);
        cardPlaceholder6.setPickOnBounds(true);

        cardPlaceholder1.setImage(playerOne.getPlayerCards().get(0).getCardImage());
        cardPlaceholder1.setUserData(playerOne.getPlayerCards().get(0));
        cardPlaceholder2.setImage(playerOne.getPlayerCards().get(1).getCardImage());
        cardPlaceholder2.setUserData(playerOne.getPlayerCards().get(1));
        cardPlaceholder3.setImage(playerOne.getPlayerCards().get(2).getCardImage());
        cardPlaceholder3.setUserData(playerOne.getPlayerCards().get(2));
        cardPlaceholder4.setImage(playerOne.getPlayerCards().get(3).getCardImage());
        cardPlaceholder4.setUserData(playerOne.getPlayerCards().get(3));
        cardPlaceholder5.setImage(playerOne.getPlayerCards().get(4).getCardImage());
        cardPlaceholder5.setUserData(playerOne.getPlayerCards().get(4));
        cardPlaceholder6.setImage(playerOne.getPlayerCards().get(5).getCardImage());
        cardPlaceholder6.setUserData(playerOne.getPlayerCards().get(5));

        playerOneCardPlaceholders.add(cardPlaceholder1);
        playerOneCardPlaceholders.add(cardPlaceholder2);
        playerOneCardPlaceholders.add(cardPlaceholder3);
        playerOneCardPlaceholders.add(cardPlaceholder4);
        playerOneCardPlaceholders.add(cardPlaceholder5);
        playerOneCardPlaceholders.add(cardPlaceholder6);

        playerTwoCardPlaceholders.add(playerTwoCardPlaceholder1);
        playerTwoCardPlaceholders.add(playerTwoCardPlaceholder2);
        playerTwoCardPlaceholders.add(playerTwoCardPlaceholder3);
        playerTwoCardPlaceholders.add(playerTwoCardPlaceholder4);
        playerTwoCardPlaceholders.add(playerTwoCardPlaceholder5);
        playerTwoCardPlaceholders.add(playerTwoCardPlaceholder6);
        playerThreeCardPlaceholders.add(playerThreeCardPlaceholder1);
        playerThreeCardPlaceholders.add(playerThreeCardPlaceholder2);
        playerThreeCardPlaceholders.add(playerThreeCardPlaceholder3);
        playerThreeCardPlaceholders.add(playerThreeCardPlaceholder4);
        playerThreeCardPlaceholders.add(playerThreeCardPlaceholder5);
        playerThreeCardPlaceholders.add(playerThreeCardPlaceholder6);
        playerFourCardPlaceholders.add(playerFourCardPlaceholder1);
        playerFourCardPlaceholders.add(playerFourCardPlaceholder2);
        playerFourCardPlaceholders.add(playerFourCardPlaceholder3);
        playerFourCardPlaceholders.add(playerFourCardPlaceholder4);
        playerFourCardPlaceholders.add(playerFourCardPlaceholder5);
        playerFourCardPlaceholders.add(playerFourCardPlaceholder6);
    }

    private void clear() {
        i = 0;
        playedCardsList.clear();

    }

    public void resetCurrentHand() {
        clear();
    }

    public void getCardValue(MouseEvent mouseEvent) {

        if (((ImageView) mouseEvent.getSource()).getImage() == null) {
            return;
        }

        if (playerOneTurn) {
            try {
                animateToGrowSelectedCard((ImageView) mouseEvent.getSource());
                playedCardsList.add(((ImageView) mouseEvent.getSource()));
                Card card = (Card) ((ImageView) mouseEvent.getSource()).getUserData();
                cardValue = card.getValue().GetValue();

                //              collectedCards++;
                int i = calculateValues(cardValue);
                System.out.println(card);
                System.out.println(i);
                playerOneCardPicked.add(card);
                cardsOnTable.remove(card);


            } catch (NullPointerException e) {
                e.getMessage();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(SACEKAJ_SVOJ_RED);
            alert.setContentText(SACEKAJ_SVOJ_RED);

            alert.showAndWait();
        }
    }


    private void animateToGrowSelectedCard(ImageView source) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(500), source);
        scale.setByX(0.5f);
        scale.setByY(0.5f);
        scale.setCycleCount(2);
        scale.setAutoReverse(true);
        scale.play();
    }


    private int calculateValues(int cardValue) {

        i += cardValue;
        return i;
    }

    public void setOnDragDetected(MouseEvent mouseEvent) {
        if (!playerOneTurn) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(SACEKAJ_SVOJ_RED);
            alert.setContentText(SACEKAJ_SVOJ_RED);

            alert.showAndWait();
        } else {
            Dragboard db = ((ImageView) mouseEvent.getSource()).startDragAndDrop(TransferMode.ANY);
            cardThrown = (Card) ((ImageView) mouseEvent.getSource()).getUserData();
            playerOne.getPlayerCards().remove(cardThrown);
            recordGameMove(playerOne, cardThrown, playerOneCardPicked);
            cardsOnTable.add(cardThrown);

            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) mouseEvent.getSource()).getImage());
            db.setContent(content);

        }
    }

    public void setOnDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        if (db.hasImage()) {
            System.out.println("Dropped: " + db.getImage());
            ((ImageView) dragEvent.getSource()).setImage(db.getImage());
            ((ImageView) dragEvent.getSource()).setUserData(cardThrown);


            System.out.println("test " + cardThrown);
            dragEvent.setDropCompleted(true);

        } else {
            dragEvent.setDropCompleted(false);
        }
        dragEvent.consume();
    }

    public void setOnDragOver(DragEvent dragEvent) {
        if (((ImageView) dragEvent.getSource()).getImage() != null) {
            return;
        } else {
            dragEvent.acceptTransferModes(TransferMode.MOVE);
            dragEvent.consume();
        }
    }


    public void setOnDragDone(DragEvent dragEvent) {
        if (dragEvent.getTransferMode() == TransferMode.MOVE) {

            mainGridPane.getChildren().remove(((ImageView) dragEvent.getSource()));
            //     ((ImageView) dragEvent.getSource()).setImage(null);
            playerOneTurn = false;
            playerTwoTurn = true;

        }
        dragEvent.consume();
    }

    public void pickUpCardsOffTheTable(MouseEvent mouseEvent) {
        if (!playerOneTurn) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(SACEKAJ_SVOJ_RED);
            alert.setContentText(SACEKAJ_SVOJ_RED);

            alert.showAndWait();
        } else {
            try {
                if (((ImageView) mouseEvent.getSource()).getImage() != null) {

                    if (playerOneTurn) {

                        Card card = (Card) ((ImageView) mouseEvent.getSource()).getUserData();
                        if (i == card.getValue().GetValue() && i > 0) {

                            playedCardsList.add(((ImageView) mouseEvent.getSource()));

                            for (ImageView i : playedCardsList) {
                                collectedCards++;
                                i.setImage(null);
                            }

                            int numberOfPoints = playerOne.getPoints() + setCardPoints(card);
                            playerOne.setPoints(numberOfPoints);
                            mainGridPane.getChildren().remove(((ImageView) mouseEvent.getSource()));
                            clear();
                            playerOneTurn = false;
                            playerTwoTurn = true;
                            //  collectedCards++;
                            playerOne.getPlayerCards().remove(card);
                            playerOne.setCardsCollected(collectedCards);
                            cardsOnTable.remove(card);
                            playerOneCardPicked.add(card);
                            System.out.println(playerOneCardPicked);
                            System.out.println("br pn: " + numberOfPoints + " br kk: " + playerOne.getCardsCollected());
                            ///((ImageView) mouseEvent.getSource()).setImage(null);
                            //           animateMovementOfSelectedCard(((ImageView) mouseEvent.getSource()));
                            recordGameMove(playerOne, card, playerOneCardPicked);
                        }
                    }
                }
            } catch (NullPointerException e) {
                e.getMessage();
            }
        }
    }

    public int setCardPoints(Card card) {
        if (card.getSuit().name().equalsIgnoreCase("clubs") && card.getValue().GetValue() == 2) {
            return 1;
        } else if (card.getSuit().name().equalsIgnoreCase("diamonds") && card.getValue().GetValue() == 10) {
            return 2;
        } else if (card.getValue().GetValue() == 11 || card.getValue().GetValue() == 12 || card.getValue().GetValue() == 13 || card.getValue().GetValue() == 14) {
            return 1;
        } else {
            return 0;
        }

    }
    public void passTurnToTheNextPlayer() {
        if (playerTwoTurn) {
            Card card = pickRandomCard(playerTwo.getPlayerCards(), playerTwo);
            List<Card> cardsP = playerPlays(card, playerTwoCardPlaceholders, playerTwo, playerCardCollected2, playerTwoCardPicked);
            playerTwoTurn = false;
            playerThreeTurn = true;
            recordGameMove(playerTwo, card, cardsP);
            passTurnToThirdPlayer();

        }
    }

    private void passTurnToThirdPlayer() {
        Card card = pickRandomCard(playerThree.getPlayerCards(), playerThree);

        List<Card> cardsP = playerPlays(card, playerThreeCardPlaceholders, playerThree, playerCardCollected3, playerThreeCardPicked);
        playerThreeTurn = false;
        playerFourTurn = true;
        recordGameMove(playerThree, card, cardsP);
        passTurnToFourthPlayer();
    }

    private void passTurnToFourthPlayer() {
        Card card = pickRandomCard(playerFour.getPlayerCards(), playerFour);
        List<Card> cardsP = playerPlays(card, playerFourCardPlaceholders, playerFour, playerCardCollected4, playerFourCardPicked);
        playerFourTurn = false;
        playerOneTurn = true;
        recordGameMove(playerFour, card, cardsP);
        if (playerFourCardPlaceholders.size() == 0) {
            endGame();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle(GOTOVA_IGRA);
            alert.setContentText(GOTOVA_IGRA);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(VI_STE_NA_POTEZU);
            alert.setContentText(VI_STE_NA_POTEZU);
            alert.show();
        }
    }

    private int getMaxCollectedCards() {
        return Math.max(Math.max(playerOne.getCardsCollected(), playerTwo.getCardsCollected()), Math.max(playerThree.getCardsCollected(), playerFour.getCardsCollected()));
    }

    private void endGame() {
        if (getMaxCollectedCards() == playerOne.getCardsCollected()) {
            playerOne.setPoints(playerOne.getPoints() + 3);
        } else if (getMaxCollectedCards() == playerTwo.getCardsCollected()) {
            playerTwo.setPoints(playerTwo.getPoints() + 3);
        } else if (getMaxCollectedCards() == playerThree.getCardsCollected()) {
            playerThree.setPoints(playerThree.getPoints() + 3);
        } else if (getMaxCollectedCards() == playerFour.getCardsCollected()) {
            playerFour.setPoints(playerFour.getPoints() + 3);
        }
        System.out.println("END GAME cards on Table" + cardsOnTable);
        allScores.put(playerOne.getName(), playerOne.getPoints());
        allScores.put(playerTwo.getName(), playerTwo.getPoints());
        allScores.put(playerThree.getName(), playerThree.getPoints());
        allScores.put(playerFour.getName(), playerFour.getPoints());

        System.out.println(playerOne.getName() + playerOne.getPoints() + "   sdas " + playerFour.getName() + playerFour.getPoints());
    }

    private List<Card> playerPlays(Card card, List<ImageView> playerCardPlaceholders, Player player, int cardsCollected, List<Card> cardsPicked) {
        boolean playerPlayed = true;
        boolean cardNotOnTable = true;
        Random rnd = new Random();
        ImageView iv;

        for (Card c : cardsOnTable) {
            if (card.getValue().GetValue() == c.getValue().GetValue()) {
                cardsPicked.add(card);
                cardNotOnTable = false;
                playerPlayed = false;

                if (player.getPlayerCards().size() > 1) {
                    iv = playerCardPlaceholders.get(rnd.nextInt(playerCardPlaceholders.size()));
                } else {
                    iv = playerCardPlaceholders.get(0);
                }
                try {

                    for (int row = 0; row < NUMBER_OF_ROWS; row++) {
                        for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                            Card temp = (Card) board[row][col].getUserData();
                            if (board[row][col].getImage() != null && temp.getValue().GetValue() == card.getValue().GetValue()) {
                                board[row][col].setImage(null);
                                cardsPicked.add(temp);
                                cardsOnTable.remove(temp);
                            }
                        }
                    }

                    playerCardPlaceholders.remove(iv);
                    mainGridPane.getChildren().remove(iv);
                    player.getPlayerCards().remove(card);
                    int numberOfPoints = player.getPoints() + setCardPoints(card);
                    player.setPoints(numberOfPoints);
                    //    player.setPoints(player.getPoints() + card.setCardPoints(card));
                    cardsCollected++;
                    player.setCardsCollected(cardsCollected);
                    System.out.println(player.getName() + " card ptn: " + player.getPoints() + " card coll: " + player.getCardsCollected());
                    //   cardsPicked.add(c);
                    System.out.println(cardsPicked);
                    return cardsPicked;

                } catch (NullPointerException e) {
                    e.getMessage();
                }
            }
        }
        if (playerPlayed) {
            System.out.println("usao je drugi put");

            boolean flag = true;
            for (int row = 0; row < NUMBER_OF_ROWS; row++) {
                for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {

                    if (board[row][col].getImage() == null && flag) {
                        board[row][col].setImage(card.getCardImage());
                        board[row][col].setUserData(card);
                        player.getPlayerCards().remove(card);
                        if (player.getPlayerCards().size() > 1) {
                            iv = playerCardPlaceholders.get(rnd.nextInt(playerCardPlaceholders.size()));
                        } else {
                            iv = playerCardPlaceholders.get(0);
                        }
                        //   iv.setImage(null);
                        playerCardPlaceholders.remove(iv);
                        mainGridPane.getChildren().remove(iv);
                        flag = false;
                        System.out.println(player.getName() + " played");
                    }
                }
            }
        }

        if (cardNotOnTable) {
            cardsOnTable.add(card);
            System.out.println("cards on Table" + cardsOnTable);
        } else {
            cardsOnTable.remove(card);
            System.out.println("cards on Table" + cardsOnTable);
        }
        return cardsPicked;
    }
    private Card pickRandomCard(List<Card> c, Player player) {
        c = player.getPlayerCards();
        if (player.getPlayerCards().size() > 1) {
            Random rnd = new Random();
            return c.get(rnd.nextInt(c.size()));
        } else {
            return c.get(0);
        }
    }

    private void recordGameMove(Player player, Card card, List<Card> cardsPicked) {
        GameMove gm = new GameMove(player.getName(), card, cardsPicked, LocalDateTime.now());
        lastGameMoves.add(gm);
    }
}

