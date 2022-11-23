package hr.algebra.tablic_game.model;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Card implements Serializable{
    private final Suit suit;
    private final Value value;
    private  transient Image cardImage;
    private final int cardPoints = 0;

    public  int getCardPoints() {
        return cardPoints;
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            in.defaultReadObject();
        String url = (String) in.readObject();
        if (url != null) {
            cardImage = new Image(url);
    }
        }

    private void writeObject(ObjectOutputStream s) throws IOException {
            s.defaultWriteObject();
            s.writeObject(cardImage == null ? null : cardImage.getUrl());
        }
    public  int setCardPoints(Card card){
        if (card.getSuit().name().equals("clubs") && card.getValue().name().equals("two")){
            return 1;
        }
        else if (card.getSuit().name().equals("diamonds") && card.getValue().name().equals("ten")){
            return 2;
        }
        else if ( card.getValue().name().equals("ace") || card.getValue().name().equals("jack") || card.getValue().name().equals("queen") || card.getValue().name().equals("king")){
            return 1;
        }
        else {
            return 0;
        }

    }
    public Card(Suit suit, Value value, Image cardImage) {
        this.suit = suit;
        this.value = value;
           this.cardImage = cardImage;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public Image getCardImage() {
        return cardImage;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}
