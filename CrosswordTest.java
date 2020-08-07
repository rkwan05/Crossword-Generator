package crossword1;

import crossword1.Crossword;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;


/**
 *
 * @author rkwan
 */
public class CrosswordTest {

    public static void main(String[] args) {
         //inputting text into a file. (The game will later grab this information and display it on the board)
        try {
            FileWriter fw = new FileWriter("Storage.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.print("crossword/game.\n"
                    + "oracle/java.\n"
                    + "clap/nuage.\n"
                    + "leaf/fall.\n"
                    + "apple/fruit.\n"
                    + "pill/medecine.\n"
                    + "door/furniture.\n"
                    + "eat/food.\n"
                    + "fall/autumn.");

            pw.close();

        } catch (IOException e) {
            System.out.println("ERROR");
        }

        //user Guide
        try {
            FileWriter fw1 = new FileWriter(" userGuide.txt ");
            PrintWriter pw1 = new PrintWriter(fw1);
            pw1.println("Welcome to Crossword Puzzles.\n"
                    + " In this game, you will be able to input\n"
                    + " any words and clues and have it \n"
                    + " generate onto the board.\n"
                    + " The \"Make your own Crossword\" button\n"
                    + " allows you to personalize your \n"
                    + " crossword. Remember to add a slash\n"
                    + " before the clue and a period at the \n"
                    + " end of each line.\n"
                    + " The \"Play from a generated \n"
                    + " crossword\" will load a set crossword \n"
                    + " that you can try to solve. ");

            pw1.close();

        } catch (IOException e) {
            System.out.println("ERROR");
        }

        //makes a new JFrame
        Crossword Cal = new Crossword();
        }

}
