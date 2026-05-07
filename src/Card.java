import com.sun.jdi.Value;

public class Card {
    int value;
    String suit;
    String name;


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
