public class Player {
    int numberOfCards;
    Card[] hand;
    int handSize = 0;

// add player hit
    public Player (Card card1, Card card2){
        hand = new Card[11];
        hand[0] = card1;
        hand[1] = card2;
        handSize = 2;
    }

    public void hit(Card newCard){
        hand[handSize] = newCard;
        handSize++;

        printInfo();
        System.out.println("------");


    }

    public void stand (){

    }

    public void printInfo (){
        for(int i = 0; i < handSize; i++){
            hand[i].printInfo();
        }
    }

    public int getHandValue() {
        int sum = 0;
        for (int i = 0; i < handSize; i++) {
            sum = sum + hand[i].value;
        }
        return sum;
    }
}
