import java.util.ArrayList;

public class Player {
    private int numberOfCards;
    private ArrayList<Card> hand;
    private int handSize = 0;

// add player hit
    public Player (Card card1, Card card2){

        hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        handSize = 2;
    }

    public void hit(Card newCard){
        hand.add(newCard);
        handSize++;

        printInfo();
        System.out.println("------");
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void stand (){

    }

    public void printInfo (){
        for(int i = 0; i < handSize; i++){
            hand.get(i).printInfo(); // hand.get(i)
        }
    }

    public int getHandValue() {
        int sum = 0;
        for (int i = 0; i < handSize; i++) {
            sum = sum + hand.get(i).getValue();
        }
        return sum;
    }
}
