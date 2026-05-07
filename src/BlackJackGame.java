import java.util.Arrays;

public class BlackJackGame {
    public Card[] deck;


    public BlackJackGame() {

    }

    public static void main(String[] args) {

    }

    public Card[] getShuffledDeck() {
        String[] suites = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "King", "Queen", "Jack", "Spades"};
        Card[] gameDeck = new Card[52];
        int placeInDeck = 0;

        for (int i = 0; i < suites.length; i++) {
            for (int j = 0; j < names.length; j++) {
                gameDeck[placeInDeck] = new Card(suites[i], names[j]);
                placeInDeck++;
            }
        }

        // for every card (0-51) pick a random card


        for(int i = 0; i < gameDeck.length; i++){
            double randomNum = (int)(Math.random()*52); // random int [0,51]
            Card temp = gameDeck[i];
            gameDeck[i] = gameDeck[(int) randomNum];
            gameDeck[(int) randomNum] = temp;
            System.out.println(gameDeck);
            // save ith card to temp
            // swap ith card with random
            // swap random with temp

        }



        return gameDeck;

    }
}


