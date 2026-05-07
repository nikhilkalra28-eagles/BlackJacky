//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
// Graphics Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
public class BasicGameApp implements Runnable, KeyListener {

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;


    //Variable Definition Section
    //You can set their initial values too
    // Like Mario mario = new Mario(); //
    public Card[] deck;
    public Player user;
    public Player dealer;
    public int indexOfDeck = 0;



    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor
        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game
        deck = getShuffledDeck(); // gives us a fresh, shuffled deck to start the game.

        user = new Player(dealCard(),dealCard());
        System.out.println("Player Hand:");
        user.printInfo();
        System.out.println("-----");

        dealer =  new Player(dealCard(),dealCard());
        System.out.println("Dealer Hand:");
        dealer.hand[0].printInfo();
        System.out.println("----");



    }
    // end BasicGameApp constructor

    public Card[] getShuffledDeck() {
        String[] suites = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "King", "Queen", "Jack"};
        Card[] gameDeck = new Card[52];
        int placeInDeck = 0;

        for (int i = 0; i < suites.length; i++) {
            for (int j = 0; j < names.length; j++) {
                gameDeck[placeInDeck] = new Card(suites[i], names[j]);
                placeInDeck++;
                // add if method

            }
        }


        // for every card (0-51) pick a random card


        for(int i = 0; i < gameDeck.length; i++){
            double randomNum = (int)(Math.random()*52); // random int [0,51]
            Card temp = gameDeck[i];
            gameDeck[i] = gameDeck[(int) randomNum];
            gameDeck[(int) randomNum] = temp;
            // save ith card to temp
            // swap ith card with random
            // swap random with temp

        }
        return gameDeck;
    }

    public Card dealCard (){
        Card card = deck[indexOfDeck];
        indexOfDeck++;
        return card;

    }

    public void moveThings() {
        //call the move() code for each object  -

    }

    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the images
        // Signature: drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)



        // Keep the code below at the end of render()
        g.dispose();
        bufferStrategy.show();
    }


    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    // PSVM: This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    private Image getImage(String filename){
        return Toolkit.getDefaultToolkit().getImage(filename);
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);
        canvas.addKeyListener(this);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // hit
        if (key == 72 && user.getHandValue() < 21) {
            System.out.println("You Hit");
            user.hit(dealCard());
            user.printInfo();
            System.out.println("Total: " + user.getHandValue());

            if (user.getHandValue() > 21) {
                System.out.println("You Lose");
            }
            System.out.println("---------");
        }

        if (key == 83) {
            // stand
            System.out.println("You Chose Stand");

            if (dealer.getHandValue() < 17) {
                dealer.hit(dealCard());
            }
            if (dealer.getHandValue() < 17) {
                dealer.hit(dealCard());
            }
            if (dealer.getHandValue() < 17) {
                dealer.hit(dealCard());
            }
            if (dealer.getHandValue() < 17) {
                dealer.hit(dealCard());
            }
            System.out.println("Dealer Hand:");
            dealer.printInfo();
            System.out.println("Dealer Total:" + dealer.getHandValue());
            System.out.println("-----");

            if (user.getHandValue() > 21) {
                System.out.println("You lost");
            } else if (dealer.getHandValue() > 21) {
                System.out.println("You win");
            } else if (dealer.getHandValue() > user.getHandValue()) {
                System.out.println("Dealer wins");
            } else if (user.getHandValue() > dealer.getHandValue()){
                System.out.println("You win");
            } else {
                System.out.println("Push");
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
}
