package formativetask1;

import static formativetask1.FormativeTask1.isAsterisc;
import java.util.Scanner;
import java.util.Vector;

public class UserInput {
    
    // promptes a get string function and returns the string
    public static String getUserInput() {
        Scanner inputFromUser = new Scanner(System.in);
        String word = inputFromUser.nextLine();
        return word;
    }
    
    // checks are made based on a number of factors
    // it will check following this sequence:
    // length of string -> only letters -> is present in datafile.txt ->
    // -> (if it's not the first turn) first letter of the word ->
    // -> (if it's the first turn) 20 points word rule.
    public static boolean checks(String newWord, Vector datafile,
            boolean isFirstTurn, String previousWord, int[][] dataMap) {
        boolean end = true;

        if (!Mechanics.isThreeLetters(newWord)) {
            System.out.println("\nInvalid input. \n"
                    + "You must enter a word of an acceptable length. \n"
                    + "The only acceptable length is 3 letters. \n");
            end = false;
        } else if (!Mechanics.validInput(newWord)) {
            System.out.println("\nThe input is invalid. \n"
                    + "Please enter words that only contain letters. \n");
            end = false;
        } else if (!Mechanics.isPresentInVector(datafile, newWord)) {
            System.out.println("\nNo such word in the datafile. \n"
                    + "Please try another word. \n");
            end = false;
        } else if (!isFirstTurn) {
            if (!Mechanics.startWithEnd(previousWord, newWord)) {
                System.out.println("\nThe word entered does not start with"
                        + " the same latter as the last letter of the previous"
                        + " word. \n"
                        + "Please enter a word that starts with the same letter"
                        + " as the previously entered word (by the other player)"
                        + "\n");
                end = false;
            }
        } else if (isFirstTurn) {
            if (Mechanics.evaluateWord(newWord, dataMap) > 20) {
                System.out.println("\nThe entered word's value mustn't exceed 20 points. \n");
                end = false;
            }
        }
        return end;

    }

    public static void playerWinsMessage(int player) {
        if (player == 1) {
            System.out.println("Player 2 wins.");
        } else if (player == 2) {
            System.out.println("player 1 wins.");
        }
    }
    // messages of introduction after every round and at the beggining of the game
    public static void introductionaryMessage(int player, boolean isFirstTurn, String previousWord) {
        if (isFirstTurn) {
            System.out.println("Player No." + player + " please insert a valid 3-letters word. \n"
                    + "Or enter * to give up. \n");

        } else {
            System.out.println("Player No." + player + " please insert a valid 3-letters word. \n"
                    + "Such word should have the letter '" + previousWord.charAt(2)
                    + "' as first letter. \n"
                    + "Or enter * to give up. \n");
        }
    }
    // iterated input prompt
    public static String inputPrompt(String word, Vector datafileVectorised, 
            boolean isFirstTurn, String previousWord, int[][] dataMap) {
        // it will stop only when all the conditions from "checks" are met
        while (!isAsterisc(word) && !UserInput.checks(word, datafileVectorised,
                isFirstTurn, previousWord, dataMap)) {
            word = UserInput.getUserInput();
        }
        return word;
    }

    public static void twentyPointsMessage(boolean isFirstTurn) {
        if (isFirstTurn) {
            System.out.println("\nThe entered word's value mustn't exceed 20 points. \n");
        }
    }

}
