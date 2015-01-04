/**
 * Created by user on 12/29/14.
 */
import java.util.ArrayList;
import java.util.Stack;

public class PlayerHand extends Deck {

    private String playerName = "Default";
    private Stack<Card> cardsInPlay = new Stack<Card>();

    public PlayerHand() {
        super();
        this.clear();
    }
    public PlayerHand(String playerName) {
        this();
        this.playerName = playerName;
    }
    public Card viewTopCardInPlay() {
        return cardsInPlay.peek();
    }
    public Card drawTopCardInPlay() {
        return cardsInPlay.pop();
    }
    public boolean hasCardsInPlay() {
        return !cardsInPlay.isEmpty();
    }
    public void playCard(Card card){
        cardsInPlay.push(card);
    }
    public void add(Card card) {
        super.add(card);
    }
    public void printDeck() {
        System.out.println(playerName);
        super.printDeck();
    }
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    public String getPlayerName() {
        return playerName;
    }
}
