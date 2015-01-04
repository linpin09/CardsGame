/**
 * Created by user on 12/29/14.
 */
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;


public class Deck {
    private Stack<Card> deckPile = new Stack<Card>();
    private Stack<Card> discardPile = new Stack<Card>();

    //private Queue<Card> deckPile = new LinkedList<Card>();
    //private Queue<Card> discardPile = new LinkedList<Card>();


    public Deck() {
        this(true, true);
    }
    public Deck(boolean isFullDeck, boolean hasJokers) {

        if (isFullDeck) {
            for (int suit_id = 0; suit_id < 4; suit_id++) {
                for (int name_id = 2; name_id < 15; name_id++) {
                    add(new Card(name_id, suit_id));
                }
            }
        }
        if (hasJokers) {
            add(new Card(15, 0));
            add(new Card(15, 1));
        }
    }

    public Card drawCard() {
        return deckPile.pop();
    }
    public void clear() {
        deckPile.clear();
        discardPile.clear();
    }
    public boolean isEmpty() {
        return deckPile.size() == 0;
    }
    public int size() {
        return deckPile.size();
    }
    public int discardSize() {
        return discardPile.size();
    }
    public void add(Card card) {
        deckPile.add(card);
    }
    public void addAll(Stack<Card> deck) {
        while (!deck.isEmpty()) {
            this.add(deck.pop());
        }
    }
    public void discardCard(Card card) {
        discardPile.push(card);
    }

    //NOT toString
    public void printDeck() {
        for (Card a : deckPile) {
            System.out.println(a.toString());
        }
    }

    public void shuffle() {
        shuffle(1);
    }
    public void shuffle(int shuffleCount) {
        int currentShuffle = 0;
        while (currentShuffle < shuffleCount) {
            Collections.shuffle(deckPile);
            currentShuffle++;
        }
    }

}
