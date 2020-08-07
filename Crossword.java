package crossword1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.lang.System;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author Rachel Kwan
 */
public class Crossword extends JFrame implements ActionListener {

    private JFrame JFrame1, Game, home, hints, userGuide;
    private JPanel mainJPanel, inputPanel, homePanel, hintPanel, userPanel;
    private JTextArea inputText, userLabel, hint;
    private JTextField[] letters = new JTextField[225];
    private JButton playButton, playFromPremade, createMyOwn, showAnswers, userButton;
    private JLabel explanation, explanation2, explanation3, welcomeText, welcomeText2, hintText, hintText2, hintText3, hintText4, hintText5, hintText6, hintWelcome;
    private int mainCounter = 2;
    private String[] words = new String[100];
    private String[] clues = new String[100];
    private ArrayList<String> usedWords = new ArrayList<String>();
    private String completeInput;

    public Crossword() {

        //menu screen
        home = new JFrame(" Menu ");
        home.setSize(700, 700);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setResizable(false);

        //set up JFrame (User inputs information in this panel)
        JFrame1 = new JFrame(" Crossword Puzzles ");
        JFrame1.setSize(700, 700);
        JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame1.setResizable(false);

        //game JFrame (generated puzzle)
        Game = new JFrame(" Game ");
        Game.setSize(700, 700);
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.setResizable(false);

        //clue JFrame
        hints = new JFrame(" Hints ");
        hints.setSize(500, 500);
        hints.setLocation(720, 0);
        hints.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hints.setResizable(false);

        userGuide = new JFrame(" User Guide ");
        userGuide.setSize(300, 310);
        userGuide.setLocation(20, 0);
        userGuide.setResizable(false);

        Font f = new Font("Serif", Font.PLAIN, 35);

        //creates the crossword layout
        mainJPanel = new JPanel();
        mainJPanel.setSize(100, 100);
        mainJPanel.setBackground(new Color(125, 50, 100));
        mainJPanel.setLayout(new GridLayout(15, 15, 0, 0));

        inputPanel = new JPanel();
        inputPanel.setSize(700, 700);
        inputPanel.setBackground(Color.white);

        userPanel = new JPanel();
        userPanel.setSize(300, 200);
        userPanel.setBackground(Color.white);

        //created to put text into hint JFrame
        hintPanel = new JPanel();
        hintPanel.setSize(500, 500);
        hintPanel.setBackground(Color.white);

        homePanel = new JPanel();
        homePanel.setSize(700, 700);
        homePanel.setBackground(Color.white);
        homePanel.setLayout(new GridLayout(0, 1, 10, 10));

        //assigns the grid layout to these JTextFields (will contain all the separateletters)
        for (int i = 0; i < 225; i++) {

            letters[i] = new JTextField(" ");
            letters[i].setBackground(Color.white);
            letters[i].setForeground(Color.black);
            letters[i].setSize(1, 1);
            letters[i].setVisible(false);

            mainJPanel.add(letters[i]);

        }

        //initiates game
        playButton = new JButton(" Play ");
        playButton.setVisible(true);
        playButton.addActionListener(this);
        playButton.setBackground(Color.black);
        playButton.setForeground(Color.white);
        playButton.setFont(f);
        playButton.setSize(150, 100);
        playButton.setLocation(700, 700);

        userButton = new JButton("i");
        userButton.addActionListener(this);
        userButton.setBackground(Color.white);
        userButton.setForeground(Color.black);
        userButton.setFont(new Font("Serif", Font.PLAIN, 20));
        userButton.setSize(10, 10);

        playFromPremade = new JButton(" Play from a Premade Crossword ");
        playFromPremade.setVisible(true);
        playFromPremade.addActionListener(this);
        playFromPremade.setBackground(new Color(125, 50, 100));
        playFromPremade.setForeground(Color.white);
        playFromPremade.setFont(f);
        playFromPremade.setSize(100, 100);
        playFromPremade.setLocation(250, 100);

        createMyOwn = new JButton(" Create my own Crossword ");
        createMyOwn.setVisible(true);
        createMyOwn.addActionListener(this);
        createMyOwn.setBackground(new Color(125, 50, 100));
        createMyOwn.setForeground(Color.white);
        createMyOwn.setFont(f);
        createMyOwn.setSize(100, 100);
        createMyOwn.setLocation(500, 500);

        //shown in the hints JFrame
        showAnswers = new JButton(" Show Answers ");
        showAnswers.setVisible(true);
        showAnswers.addActionListener(this);
        showAnswers.setBackground(new Color(125, 50, 100));
        showAnswers.setForeground(Color.white);
        showAnswers.setFont(new Font("Serif", Font.PLAIN, 15));
        showAnswers.setSize(70, 70);

        //area where the user can enter their clues and words
        inputText = new JTextArea(17, 45);
        inputText.setFont(new Font("Serif", Font.PLAIN, 20));
        inputText.setBackground(new Color(125, 50, 100));
        inputText.setForeground(Color.white);
        inputText.setVisible(true);
        inputText.setLocation(500, 500);

        userLabel = new JTextArea(15, 15);
        userLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        userLabel.setPreferredSize(new Dimension(300, 200));
        userLabel.setMaximumSize(new Dimension(300, 200));
        userLabel.setMinimumSize(new Dimension(300, 200));

        hint = new JTextArea(25, 25);
        hint.setFont(new Font("Serif", Font.PLAIN, 15));

        hintText = new JLabel();
        hintText.setFont(new Font("Serif", Font.PLAIN, 20));
        hintText.setForeground(Color.black);
        hintText.setSize(500, 100);
        hintText.setLocation(0, 0);

        hintText2 = new JLabel();
        hintText2.setFont(new Font("Serif", Font.PLAIN, 20));
        hintText2.setForeground(Color.black);
        hintText2.setSize(500, 100);
        hintText2.setLocation(100, 102);

        hintText3 = new JLabel();
        hintText3.setFont(new Font("Serif", Font.PLAIN, 20));
        hintText3.setForeground(Color.black);
        hintText3.setSize(500, 100);
        hintText3.setLocation(200, 202);

        hintText4 = new JLabel();
        hintText4.setFont(new Font("Serif", Font.PLAIN, 20));
        hintText4.setForeground(Color.black);
        hintText4.setSize(500, 100);

        hintText5 = new JLabel();
        hintText5.setFont(new Font("Serif", Font.PLAIN, 20));
        hintText5.setForeground(Color.black);
        hintText5.setSize(500, 100);

        hintText6 = new JLabel();
        hintText6.setFont(new Font("Serif", Font.PLAIN, 20));
        hintText6.setForeground(Color.black);
        hintText6.setSize(500, 100);

        hintWelcome = new JLabel("                              CLUES                            ");
        hintWelcome.setFont(new Font("Serif", Font.BOLD, 30));
        hintWelcome.setForeground(Color.black);
        hintWelcome.setSize(100, 100);

        explanation = new JLabel();
        explanation.setText("Enter the words and the clues in the textbox below.");
        explanation.setFont(new Font("Serif", Font.BOLD, 30));

        explanation2 = new JLabel();
        explanation2.setText("Ex: dog/animal with fur. Make sure to add the slash between the clues");
        explanation2.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 20));

        explanation3 = new JLabel();
        explanation3.setText(" and the words, and a period at the end of each sentence! ");
        explanation3.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 20));

        welcomeText = new JLabel();
        welcomeText.setText(" Crossword "
                + "Puzzles");
        welcomeText.setFont(new Font("Serif", Font.PLAIN, 60));
        welcomeText.setSize(500, 200);

        homePanel.add(welcomeText);
        homePanel.add(createMyOwn, BorderLayout.SOUTH);
        homePanel.add(playFromPremade, BorderLayout.NORTH);
        homePanel.add(userButton);

        home.add(homePanel);

        inputPanel.add(explanation);
        inputPanel.add(explanation2);
        inputPanel.add(explanation3);
        //inputPanel.add(userButton);

        hintPanel.add(hintWelcome);
        hintPanel.add(hintText);
        hintPanel.add(hintText2);
        hintPanel.add(hintText3);
        hintPanel.add(hintText4);
        hintPanel.add(hintText5);
        hintPanel.add(hintText6);
        hintPanel.add(showAnswers);

        //hintPanel.add(userButton);
        userPanel.add(userLabel);

        inputPanel.add(inputText);
        inputPanel.add(playButton, BorderLayout.SOUTH);

        JFrame1.add(inputPanel);

        userGuide.add(userPanel);

        hints.add(hintPanel);

        Game.add(mainJPanel, BorderLayout.CENTER);

        home.setVisible(true);

    }

    /**
     * when button is pressed, will bring carry out specified actions
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == userButton) {
            String str = "";
            try {

                FileReader fr1 = new FileReader(" userGuide.txt ");
                BufferedReader br1 = new BufferedReader(fr1);
                String input = br1.readLine();

                //reads text from file
                while (input != null) {
                    str += input + "\n";

                    input = br1.readLine();

                }
                userLabel.setText(str);

                userGuide.setVisible(true);
                br1.close();

            } catch (IOException f) {
                System.out.println("ERROR");
            }
        }

        if (e.getSource() == createMyOwn) {

            //switch JFrames
            home.setVisible(false);
            JFrame1.setVisible(true);

        }
        if (e.getSource() == playButton) {

            completeInput = inputText.getText();
            sortWords(completeInput);
            orderWords();
            setBoard();

            JFrame1.setVisible(false);
            Game.setVisible(true);
            hints.setVisible(true);

            //usedWords.toArray();
            Object array[] = new Object[usedWords.size()];
            array = usedWords.toArray();
            String previous = array[0].toString();
            int counters = 0;

            for (int j = 0; j < usedWords.size(); j++) {
                if (array[j + 1] == previous) {
                    counters++;
                }
                if (counters >= 1) {
                    usedWords.remove(j);
                    usedWords.remove(j - 1);
                }
                previous = array[j].toString();
            }

            array = usedWords.toArray();
            String str = "";
            int v = 2;
            for (int i = 0; i < usedWords.size(); i++) {

                hint.setText(1 + ". " + str);

                str = str += array[i].toString() + "\n" + Integer.toString(v) + ". ";
                if (i == usedWords.size() - 1) {
                    str = array[usedWords.size() - 1].toString();
                    //System.out.println(str);
                }
                v++;
            }
            showAnswers.setVisible(false);
            hintPanel.add(hint);

        }
        if (e.getSource() == showAnswers) {
            for (int i = 0; i < words[0].length(); i++) {
                String separateLetter = String.valueOf(words[0].charAt(i));

                letters[i].setVisible(true);
                letters[i].setText(separateLetter);

            }
            usedWords.add(words[0]);

            String verticalArray[] = new String[words.length / 2];

            for (int j = 0; j < words.length; j++) {

                if (words[j] != null && words[j] != words[0]) {

                    verticalArray[j] = words[j];
                }

            }
            //oracle
            for (int q = 0; q < verticalArray[1].length(); q++) {
                String separateLetter1 = String.valueOf(verticalArray[1].charAt(q));
                letters[2 + (q * 15)].setText(separateLetter1);
                letters[2 + (q * 15)].setVisible(true);
            }

            //apple
            for (int q = 0; q < verticalArray[2].length(); q++) {
                String separateLetter1 = String.valueOf(verticalArray[2].charAt(q));
                letters[31 + (q + 1)].setText(separateLetter1);
                letters[31 + (q + 1)].setVisible(true);
            }
            //leaf
            for (int q = 0; q < verticalArray[4].length(); q++) {
                String separateLetter1 = String.valueOf(verticalArray[4].charAt(q));
                letters[35 + (q * 15)].setText(separateLetter1);
                letters[35 + (q * 15)].setVisible(true);
            }

            //fall
            for (int q = 0; q < verticalArray[7].length(); q++) {
                String separateLetter1 = String.valueOf(verticalArray[7].charAt(q));
                letters[79 + (q + 1)].setText(separateLetter1);
                letters[79 + (q + 1)].setVisible(true);
            }

            //pill
            for (int q = 0; q < verticalArray[5].length(); q++) {
                String separateLetter1 = String.valueOf(verticalArray[5].charAt(q));
                letters[38 + (q * 15)].setText(separateLetter1);
                letters[38 + (q * 15)].setVisible(true);

            }

        }
        if (e.getSource() == playFromPremade) {
            completeInput = "";
            try {

                FileReader fr = new FileReader("Storage.txt");
                BufferedReader br = new BufferedReader(fr);
                String input = br.readLine();

                //reads text from file
                while (input != null) {
                    completeInput += input + "\n";
                    input = br.readLine();
                }

                sortWords(completeInput);
                orderWords();

                //starter word
                for (int i = 0; i < words[0].length(); i++) {
                    letters[i].setVisible(true);

                }
                usedWords.add(words[0]);

                String verticalArray[] = new String[words.length / 2];

                for (int j = 0; j < words.length; j++) {

                    if (words[j] != null && words[j] != words[0]) {

                        verticalArray[j] = words[j];
                    }

                }
                //oracle
                for (int q = 0; q < verticalArray[1].length(); q++) {
                    letters[2 + (q * 15)].setVisible(true);
                }

                //apple
                for (int q = 0; q < verticalArray[2].length(); q++) {
                    letters[31 + (q + 1)].setVisible(true);
                }
                //leaf
                for (int q = 0; q < verticalArray[4].length(); q++) {
                    letters[35 + (q * 15)].setVisible(true);
                }

                //fall
                for (int q = 0; q < verticalArray[7].length(); q++) {
                    letters[79 + (q + 1)].setVisible(true);
                }

                //pill
                for (int q = 0; q < verticalArray[5].length(); q++) {
                    letters[38 + (q * 15)].setVisible(true);
                }

                JFrame1.setVisible(false);
                Game.setVisible(true);
                hints.setVisible(true);
                hintText.setText("                                   1. game                                   ");
                hintText2.setText("                                   2. java                                   ");
                hintText3.setText("                                   3. fruit                                   ");
                hintText4.setText("                                   4. fall                                   ");
                hintText5.setText("                                   5. autumn                                   ");
                hintText6.setText("                                   6. medicine                                 ");
                br.close();

            } catch (IOException b) {
                System.out.println("ERROR");
            }

        }

    }

    /**
     * separates the user's input into separate arrays (Words and clues)
     *
     */
    public void sortWords(String completeInput) {
        String restOfInput = " " + completeInput;

        int beginning = 0;
        int periodCount = 0;

        //goes through each point so that the next for loop will go through less "trials"
        for (int i = 0; i < completeInput.length(); i++) {
            if (completeInput.charAt(i) == '.') {
                periodCount++;
            }

        }

        for (int i = 0; i < periodCount; i++) {

            restOfInput = restOfInput.substring(beginning + 1, restOfInput.length());

            int slash = restOfInput.indexOf('/');
            int period = restOfInput.indexOf('.');

            words[i] = restOfInput.substring(0, slash);
            clues[i] = restOfInput.substring(slash + 1, period);

            beginning = restOfInput.indexOf("\n");

        }
    }

    /**
     * orders words from greatest length to least greatest length
     *
     */
    public void orderWords() {
        int numWords = 0;
        boolean game = true;
        int counters = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                numWords++;
            }
        }

        //using the swap method we discussed in class
        while (game == true) {
            counters = 0;
            for (int i = 0; i < numWords; i++) {

                int pairIndex = i + 1;

                if (pairIndex == numWords) {
                    pairIndex = i + 0;
                }

                if (words[i].length() < words[pairIndex].length()) {
                    swap(words, i, pairIndex);
                    game = true;

                } else {
                    counters++;
                }

                if (counters == numWords) {
                    game = false;
                }

            }

        }

    }

    public static void swap(String[] a, int i, int j) {

        String temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    /**
     * main algorithm method (puts words on the board)
     *
     */
    public void setBoard() {
        String previousWord = words[0];
        boolean game = true;
        int testCounters = 0;
        int counters[] = new int[1000];

        //starter word
        for (int i = 0; i < words[0].length(); i++) {
            String separateLetter = String.valueOf(words[0].charAt(i));

            letters[i].setVisible(true);
            //letters[i].setText(separateLetter);

        }
        usedWords.add(words[0]);

        String verticalArray[] = new String[words.length / 2];

        for (int j = 0; j < words.length; j++) {

            if (words[j] != null && words[j] != words[0]) {

                verticalArray[j] = words[j];
            }

        }

        int verticalArrayLength = 0;

        for (String elements : words) {

            if (elements != null && elements != words[0]) {
                testCounters++;
                verticalArrayLength = testCounters;

            }

        }

        final boolean verticalBoolean[] = new boolean[testCounters];
        verticalBoolean[0] = false;
        int falseCount = 0;
        int trueCount = 0;

        for (int j = 1; j < testCounters; j += 2) {
            verticalBoolean[j] = false;

            if (j + 1 >= testCounters) {
                verticalBoolean[j] = false;
            } else {
                verticalBoolean[j + 1] = true;
            }

            if (verticalBoolean[j] = false) {
                falseCount++;
            }

            if (verticalBoolean[j] = true) {
                trueCount++;
            }

        }

        String separateLetter = "";
        boolean isTrue = true;
        boolean isFalse = true;
        int verticalCount = 0;
        int horizontalCount = 0;

        while (game == true) {

            for (int j = 0; j <= testCounters; j++) {

                if (!words[j].equals(null) && !words[j].equals(words[0])) {

                    verticalArray[j] = words[j];

                    if (verticalArray[j] != null) {

                        if (j < testCounters) {

                            //make it horizontal
                            if (verticalBoolean[j] == true) {

                                //rechecking it it's not null and that it's going into the right loops
                                if (!verticalArray[j].equals(null)) {

                                    while (isTrue == true) {

                                        //will compare previous letters to the word in the array
                                        for (int m = 0; m < previousWord.length(); m++) {
                                            char previousLetter1 = previousWord.charAt(m);
                                            for (int t = 0; t < verticalArray[j].length(); t++) {
                                                if (verticalArray[j].charAt(t) == previousLetter1) {

                                                    previousWord = verticalArray[j];

                                                    //loop to go through each separate letter
                                                    for (int q = 0; q < verticalArray[j].length(); q++) {
                                                        separateLetter = String.valueOf(verticalArray[j].charAt(q));

                                                        if (previousWord.length() == 3) {

                                                            letters[m * 15 + (q + 1) - 1].setVisible(true);
                                                            letters[m * 15 + (q + 1) - 1].setText(separateLetter);
                                                            usedWords.add(verticalArray[j]);

                                                        } else {
                                                            letters[m * 15 + (q + 1) - 1].setVisible(true);
                                                            letters[m * 15 + (q + 1) - 1].setText(separateLetter);
                                                            usedWords.add(verticalArray[j]);
                                                        }

                                                    }

                                                    //code to remove an element
                                                    for (int p = j; p < verticalArrayLength + 2; p++) {

                                                        verticalArray[p] = verticalArray[p + 1];
                                                        verticalArray[verticalArrayLength + 2] = null;

                                                    }
                                                    verticalArrayLength--;

                                                    //break so that the loop can move on to the next "previousLetter"
                                                    break;

                                                } else {

                                                    //tracking counters for the ending code 
                                                    counters[j]++;
                                                }

                                            }
                                        }
                                        horizontalCount++;
                                        if (horizontalCount >= trueCount - 1) {
                                            isTrue = false;
                                        }
                                    }

                                }
                            } //make it vertical
                            else if (verticalBoolean[j] == false) {
                                System.out.println(previousWord);
                                if (!verticalArray[j].equals(null)) {

                                    while (isFalse == true) {

                                        for (int r = 0; r < previousWord.length(); r++) {

                                            char previousLetter1 = previousWord.charAt(r);

                                            for (int m = 0; m < verticalArray[j].length(); m++) {

                                                if (verticalArray[j].charAt(0) == previousLetter1) {
                                                    System.out.println(verticalArray[j]);

                                                    previousWord = verticalArray[j];
                                                    separateLetter = String.valueOf(verticalArray[j].charAt(m));

                                                    letters[r + (m * 15)].setVisible(true);
                                                    letters[r + (m * 15)].setText(separateLetter);
                                                    
                                                    usedWords.add(verticalArray[j]);
                                                } else {
                                                    counters[j]++;

                                                }

                                            }

                                        }

                                        //code to remove an element from an array (idea borrowed from youtube video mentioned in the daily log)
                                        for (int p = j; p < verticalArrayLength + 2; p++) {

                                            verticalArray[p] = verticalArray[p + 1];
                                            verticalArray[verticalArrayLength + 2] = null;

                                        }
                                        verticalArrayLength--;

                                        verticalCount++;
                                        if (verticalCount >= falseCount - 1) {
                                            isTrue = false;
                                        }
                                    }
                                }
                            }

                            if (counters[j] > verticalArrayLength) {
                                for (int p = j; p < verticalArrayLength + 2; p++) {

                                    verticalArray[p] = verticalArray[p + 1];
                                    verticalArray[verticalArrayLength + 2] = null;

                                }
                                verticalArrayLength--;

                            }

                        }

                    }
                }
            }

            //code to end the game(some words have a possibilty of not fiting into other words)
            for (int j = 0; j < words.length; j++) {
                if (counters[j] > testCounters) {
                    game = false;

                }
            }

            //code to end the game (if array is empty)
            if (Arrays.toString(verticalArray) == null) {

                game = false;
            }

        }
    }
}
