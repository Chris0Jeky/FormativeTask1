package formativetask1;

import java.util.Vector;

public class FormativeTask1 {

    public static void main(String[] args) {

        Vector datafileVectorised = new Vector();
        datafileVectorised = ReadFile.read();

    }

    public static boolean checks(String newWord, Vector datafile,
            boolean isFirstTurn, String previousWord) {
        boolean end = true;
        if (!Mechanics.validInput(newWord)) {
            System.out.println("The input is invalid. \n"
                    + "Please enter words that only contain letters. \n"
                    + "Please enter words no longer than 3 characters.");
            end = false;
        }
        if (!Mechanics.isPresentInVector(datafile, newWord)) {
            System.out.println("No such word in the datafile. \n"
                    + "Please try another word.");
            end = false;
        }
        if (isFirstTurn) {
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
