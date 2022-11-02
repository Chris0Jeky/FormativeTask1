package formativetask1;

import java.util.Vector;

public class FormativeTask1 {

    public static void main(String[] args) {

        Vector datafileVectorised = ReadFile.read();

        String word = UserInput.getUserInput();
        checks(word, datafileVectorised, false, "");
    }

    public static boolean checks(String newWord, Vector datafile,
            boolean isFirstTurn, String previousWord) {
        boolean end = true;

        if (!Mechanics.isThreeLetters(newWord)) {
            System.out.println("Invalid input. \n"
                    + "You must enter a word of an acceptable length. \n"
                    + "The only acceptable length is 3 letters.");
            end = false;
        } else if (!Mechanics.validInput(newWord)) {
            System.out.println("The input is invalid. \n"
                    + "Please enter words that only contain letters. \n");
            end = false;
        } else if (!Mechanics.isPresentInVector(datafile, newWord)) {
            System.out.println("No such word in the datafile. \n"
                    + "Please try another word.");
            end = false;
        } else if (isFirstTurn) {
            if (!Mechanics.startWithEnd(previousWord, newWord)) {
                System.out.println("The word entered does not start with"
                        + " the same latter as the last letter of the previous"
                        + " word. \n"
                        + "Please enter a word that starts with the same letter"
                        + " as the previously entered word (by the other player)"
                        + "\n");
                end = false;
            }
        }
        return end;

    }

}
