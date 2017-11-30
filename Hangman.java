/*Jade
 * 
 * 
 * JDK Version 1.8.0
 */
package hangman;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
public class Hangman extends JPanel{
JFrame panel = new JFrame("Hangman");
    Container content = panel.getContentPane(); 
    
    public static int counter=0;
    public static void main(String[] args) {
       Hangman drawing = new Hangman();
        drawing.setUp();

       String[] words = {"clot","feet","adequate","mechanical","hour","ultimate","hush","ground","fish","behold","eraser",
           "long","pesky","clever","chamber","biplane","ball","slippery","awkward","cavity"};
        // Pick random index of words array
        int randomWordNumber = (int) (Math.random() * words.length);
        // Create an array to store already entered letters
        char[] enteredLetters = new char[words[randomWordNumber].length()];
        
        boolean wordIsGuessed = false;
        do {
        // infinitely iterate through cycle as long as enterLetter returns true
        // if enterLetter returns false that means user guessed all the letters
        // in the word e. g. no asterisks were printed by printWord
        
        switch (enterLetter(words[randomWordNumber], enteredLetters)) {
            case 0:
                counter++;
                
                break;
            case 1:
               
                
                break;
            case 2:
                break;
            case 3:
                wordIsGuessed = true;
                break;
        }
        } while (! wordIsGuessed);
        System.out.println("\nThe word is " + words[randomWordNumber] +
            " You missed " + (counter -findEmptyPosition(enteredLetters)) +
            " time(s)");
    }

    /* Hint user to enter a guess letter,
    returns 0 if letter entered is not in the word (counts as try),
    returns 1 if letter were entered 1st time (counts as try),
    returns 2 if already guessed letter was REentered,
    returns 3 if all letters were guessed */
    public  static int enterLetter(String word, char[] enteredLetters)    {
        System.out.print("(Guess) Enter a letter in word ");
        // If-clause is true if no asterisks were printed so
        // word is successfully guessed
        if (! printWord(word, enteredLetters))
            return 3;
        System.out.print(" > ");
        Scanner input = new Scanner(System.in);
        int emptyPosition = findEmptyPosition(enteredLetters);
        char userInput = input.nextLine().charAt(0);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " is already in the word");
            
            return 2;
        }
        else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            if(counter==8)
            { JOptionPane.showMessageDialog(null,"Game over");
            System.exit(0);}
            return 1;
        }
        else {
            System.out.println(userInput + " is not in the word");
            if(counter==8)
            { JOptionPane.showMessageDialog(null,"Game over");
            System.exit(0);}
            return 0;
            }
    }
    public void setUp() {
        content.setBackground(Color.WHITE);
        content.add(this);
        
        
        panel.setSize(615, 435);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setVisible(true);
    
}
    
@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(15,30,300,30);//line out holding hangman
        g.drawLine(300,30,300,50);//line down holding hangman
       panel.repaint();
            if(counter == 1){    
        g.drawOval(275,50,50,50);}//head of hangman
        if(counter == 2){
        g.drawOval(275,50,50,50);//head of hangman
        g.drawLine(300,100,300,200);}//body of hangman
        if(counter==3){
        g.drawOval(275,50,50,50);//head of hangman
        g.drawLine(300,100,300,200);//body of hangman
        g.drawLine(300,125,250,150);}//left arm for hangman
        if(counter==4){
        g.drawOval(275,50,50,50);//head of hangman
        g.drawLine(300,100,300,200);//body of hangman
        g.drawLine(300,125,250,150);//left arm for hangman
        g.drawLine(300,125,350,150);}//right arm for hangman
        if(counter==5){
        g.drawOval(275,50,50,50);//head of hangman
        g.drawLine(300,100,300,200);//body of hangman
        g.drawLine(300,125,250,150);//left arm for hangman
        g.drawLine(300,125,350,150);//right arm for hangman
        g.drawLine(300,200,250,275);}//left leg for hangman
        if(counter==6){
        g.drawOval(275,50,50,50);//head of hangman
        g.drawLine(300,100,300,200);//body of hangman
        g.drawLine(300,125,250,150);//left arm for hangman
        g.drawLine(300,125,350,150);//right arm for hangman
        g.drawLine(300,200,250,275);//left leg for hangman
        g.drawLine(300,200,350,275);}//right leg for hangman
        if(counter==7){
        g.drawOval(275,50,50,50);//head of hangman
        g.drawLine(300,100,300,200);//body of hangman
        g.drawLine(300,125,250,150);//left arm for hangman
        g.drawLine(300,125,350,150);//right arm for hangman
        g.drawLine(300,200,250,275);//left leg for hangman
        g.drawLine(300,200,350,275);//right leg for hangman
        g.drawLine(285,85,315,85);}//mouth for hangman
        if(counter==8){
        g.drawOval(275,50,50,50);//head of hangman
        g.drawLine(300,100,300,200);//body of hangman
        g.drawLine(300,125,250,150);//left arm for hangman
        g.drawLine(300,125,350,150);//right arm for hangman
        g.drawLine(300,200,250,275);//left leg for hangman
        g.drawLine(300,200,350,275);//right leg for hangman
        g.drawLine(285,85,315,85);//mouth for hangman
        g.drawOval(285,65,10,10);}//left eye for hangman
        if(counter==9){
        g.drawOval(275,50,50,50);//head of hangman
        g.drawLine(300,100,300,200);//body of hangman
        g.drawLine(300,125,250,150);//left arm for hangman
        g.drawLine(300,125,350,150);//right arm for hangman
        g.drawLine(300,200,250,275);//left leg for hangman
        g.drawLine(300,200,350,275);//right leg for hangman
        g.drawLine(285,85,315,85);//mouth for hangman
        g.drawOval(285,65,10,10);//left eye for hangman
        g.drawOval(305,65,10,10);}//right eye for hangman
       
       
}
        
    /* Print word with asterisks for hidden letters, returns true if
    asterisks were printed, otherwise return false */
    public static boolean printWord(String word, char[] enteredLetters) {
        // Iterate through all letters in word
        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            // Check if letter already have been entered bu user before
            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter); // If yes - print it
            else {
                System.out.print('*');
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }

    /* Check if letter is in enteredLetters array */
    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }

    /* Find first empty position in array of entered letters (one with code \u0000) */
    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;
    }



}
