/**
 * Created by user on 12/28/14.
 */
public class War {

    protected static Deck deckTest;
    protected static PlayerHand p1 = new PlayerHand();
    protected static PlayerHand p2 = new PlayerHand();
    public static boolean war = false;
/*
    public static void main(String[] args) {

        //CardTableGUI.drawGUI();

        deckTest = new Deck();
        p1.setPlayerName("Foxsh");
        p2.setPlayerName("Kitty");
        deckTest.shuffle(10);
        dealCards();

        fightCards();

        p1.printDeck();
        System.out.println(p1.size());
        System.out.println(p1.discardSize());
        p2.printDeck();
        System.out.println(p2.size());
        System.out.println(p2.discardSize());
        System.out.println(war);
        printWinner();

    }*/
    private static void printWinner() {
        if (!p1.isEmpty()) {
            System.out.println("Winner is " + p1.getPlayerName());
        } else {
            System.out.println("Winner is " + p2.getPlayerName());
        }
    }
    private static void fightCards() {

        int moveCounter = 0;
        while (!p1.isEmpty() && !p2.isEmpty()) {
            System.out.println("Move " + moveCounter);

            p1.playCard(p1.drawCard());
            p2.playCard(p2.drawCard());

            //player 1 wins the hand
            if (p1.viewTopCardInPlay().compareTo(p2.viewTopCardInPlay()) == 1) {
                //give both cards to p1 deck
                System.out.println("p1");
                p1.add(p1.drawTopCardInPlay());
                p1.add(p2.drawTopCardInPlay());
            } else if (p2.viewTopCardInPlay().compareTo(p1.viewTopCardInPlay()) == -1) {
                //give both cards to p2 deck
                System.out.println("p2");
                p2.add(p1.drawTopCardInPlay());
                p2.add(p2.drawTopCardInPlay());
            } else { //WAR, LAY DOWN THREE CARDS ETC
                war();
            }
            moveCounter++;

        }
    }
    private static void dealCards() {
        while (!deckTest.isEmpty()) {
            p1.add(deckTest.drawCard());
            if (!deckTest.isEmpty()) {
                p2.add(deckTest.drawCard());
             }
        }

    }
    private static void war() {
        war = true;
        System.out.println("\n\n\n\n WARRRRRR");

        //lay down three cards "face down" and the fourth "face up" to decide the hand
        //if not have enough cards, play all cards in order, last one decides the hand
        if (p1.size() == 0) {
            while (p1.hasCardsInPlay()) {
                p2.add(p1.drawTopCardInPlay());
            }
        } else if (p2.size() == 0) {
            while (p2.hasCardsInPlay()) {
                p1.add(p2.drawTopCardInPlay());
            }
        } else if (p1.size() < 4 && p1.size() != 0) {
            for (int i = 0; i < p1.size(); i++) {
                p1.playCard(p1.drawCard());
            }
        } else if (p2.size() < 4 && p2.size() != 0) {
            for (int i = 0; i < p2.size(); i++) {
                p2.playCard(p2.drawCard());
            }
        } else {
            for (int i = 0; i < 4; i++) {
                p1.playCard(p1.drawCard());
                p2.playCard(p2.drawCard());
            }
        }
        if (p1.viewTopCardInPlay().compareTo(p2.viewTopCardInPlay()) == 1) { //p1 > p2
            System.out.println("winner is " + p1.getPlayerName());
            while (p1.hasCardsInPlay()) {
                p1.add(p1.drawTopCardInPlay());
            }
            while (p2.hasCardsInPlay()) {
                p1.add(p2.drawTopCardInPlay());
            }
        } else if (p1.viewTopCardInPlay().compareTo(p2.viewTopCardInPlay()) == -1) { //p1 < p2
            System.out.println("winner is " + p2.getPlayerName());
            while (p1.hasCardsInPlay()) {
                p2.add(p1.drawTopCardInPlay());
            }
            while (p2.hasCardsInPlay()) {
                p2.add(p2.drawTopCardInPlay());
            }
        } else { //p1 == p2
            war();
        }
    }
}
