public class Card {

        private String suit;
        private String color;
        private int suit_id; // ID 0-3 for numeric suit select. alphabetical
        private int color_id; // for numeric select 0-1, alphabetical
        private int suitValue; // suit strength 0-3
        private int cardValue;
        private static final String[] nameList = {"", "", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace", "Joker"};
        private static final String[] suitList = {"Clubs", "Diamonds", "Hearts", "Spades"};
        private String name;
        private boolean isJoker;

        public Card(int name_id, int suit_id) {
            this(nameList[name_id], suit_id);
        }

        public Card(String name, int suit_id) {

                this.suit_id = suit_id;
                this.suit = suitList[suit_id];

                // errors handled
                checkValidSuit();
                checkValidCard(name);
                initializeFields();
        }
        public String toString() {
                if (!isJoker) {
                        return this.name + " of " + this.suitList[suit_id];
                } else {
                        return this.color + " " + this.name;
                }
        }
        public int compareTo(Card card) {
            if (this.cardValue > card.cardValue) {
                return 1;
            } else if (this.cardValue < card.cardValue) {
                return -1;
            } else {
                return 0; //they are equal
            }
        }
        public boolean isGreater(Card card) {
            if (this.cardValue > card.cardValue) {
                return true;
            } else if (this.cardValue < card.cardValue) {
                return false;
            } else { //cardValues are equal
                if (this.suitValue > card.suitValue) {
                    return true;
                } else {//if (this.suitValue > card.suitValue); ALSO NEED FOR EQUAL :'(
                    return false;
                }
            }
        }
        public int isGreaterNoSuit(Card card) {
            return 0;
        }
        public int getCardValue() {
            return cardValue;
        }
        public int getSuitValue() {
            return suitValue;
        }

        //helper methods
        private void initializeFields() {
                if (this.suit_id == 0) { //clubs
                        this.color = "Black";
                        this.color_id = 0;
                        this.suitValue = 0;
                        this.suit_id = 0;
                } else if (this.suit_id == 1) { //diamonds
                        this.color = "Red";
                        this.color_id = 1;
                        this.suitValue = 2;
                        this.suit_id = 1;
                } else if (this.suit_id == 2) { //hearts
                        this.color = "Red";
                        this.color_id = 1;
                        this.suitValue = 3;
                        this.suit_id = 2;
                } else { // spades
                        this.color = "Black";
                        this.color_id = 0;
                        this.suitValue = 1;
                        this.suit_id = 3;
                }
        }


        //error handling methods
        private void checkValidSuit() {
                boolean isValidSuit = false;
                for (int i = 0; i < this.suitList.length; i++) {
                        if (this.suitList[i].toLowerCase().equals(this.suit.toLowerCase())) {
                                isValidSuit = true;
                        }
                }
                if (!isValidSuit) {
                        throw new IllegalArgumentException("Suit must be a valid suit");
                }
        }
        private void checkValidCard(String name) {
                boolean isValidCard = false;
                for (int i = 0; i < this.nameList.length; i++) {
                        if (name.toLowerCase().equals(this.nameList[i].toLowerCase())) {
                                isValidCard = true;
                                cardValue = i;
                                this.name = nameList[i];
                                if (this.name.toLowerCase().equals("joker")) {
                                        isJoker = true;
                                }
                        }
                }
                if (!isValidCard) {
                        throw new IllegalArgumentException("Must provide a valid card");
                }
        }


}




		