import com.sun.jdi.Value;

public class Card {
    private int value;
    private String suit;
    private String name;

    public int getValue(){
        return value;
    }

    // getName return name
    public String getName (){
        return name;
    }
    // getSuit return suit
    public String getSuit (){
        return suit;
    }

    public Card(String suitInput, String nameInput){
        suit = suitInput;
        name = nameInput;
       if (name == "Ace") {
           value = 1;

       }
       else if (name == "King"){
           value = 10;
       }
       else if (name == "Queen"){
           value = 10;
       }
       else if (name == "Jack"){
           value = 10;
       }
       else if (name == "Spades"){

       }
       else {
           value = Integer.parseInt(name);
       }
    }



    public void printInfo (){
        System.out.println(name + " of " + suit);
    }

}
