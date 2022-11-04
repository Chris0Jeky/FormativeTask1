package formativetask1;

import java.util.Vector;

public class Mechanics {

    // creates a two dimensional array with 2 columns and 26 rows
    // then populates the array with integers representing in order the
    // alphabetic letters and their value based on their position in the 
    // alphabet
    public static int[][] arrayCreation() {
        int[][] charsArr = new int[2][26];
        for (int i = 0; i < 26; i++) {
            charsArr[0][i] = i + 97;
            charsArr[1][i] = i + 1;
        }
        return charsArr;
    }

    public static int getCharValue(char ch, int[][] bidimensionalArr) {

        // the following if will make the character passed as argument
        // lower case
        if (ch > 64 && ch < 91) {
            ch = (char) (ch + 32);
        }
        // returns the value of the character passed as argument
        // based on its position in the alphabet
        for (int i = 0; i < 26; i++) {
            if (ch == bidimensionalArr[0][i]) {
                return bidimensionalArr[1][i];
            }
        }
        return 0;
    }

    // return false if the parameter passed contains a character that is not 
    // contained in the alphabet
    // otherwise it returns true
    // uses a XOR logic gate that connects two OR, and it's all inverted by a NOT
    public static boolean validInput(String word) {
        for (int i = 0; i < 3; i++) {
            if (!((word.charAt(i) < 64
                    || word.charAt(i) > 90)
                    ^ (word.charAt(i) < 97
                    || word.charAt(i) > 122))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isThreeLetters(String word) {
        boolean end = true;
        if (word.length() != 3) {
            end = false;
        }
        return end;
    }

    // it returnes true or false if the word parameter is contained in the 
    // vector
    // it also converts arguments to lower case to match the datafile style
    public static boolean isPresentInVector(Vector vekky, String word) {
        return vekky.contains(word.toLowerCase());
    }

    // checks whether the third letter of the passed strings are the same
    // and returns true or false
    public static boolean startWithEnd(String previousWord, String newWord) {
        return previousWord.charAt(2) == newWord.charAt(0);
    }

    // returns total value of the word, based on its characters
    public static int evaluateWord(String word, int[][] bidimensionalArr) {
        int totalValue = 0;
        totalValue = getCharValue(word.charAt(0), bidimensionalArr) + totalValue;
        totalValue = getCharValue(word.charAt(1), bidimensionalArr) + totalValue;
        totalValue = getCharValue(word.charAt(2), bidimensionalArr) + totalValue;
        return totalValue;
    }

    // will return an updated score, based on the previous score and the value
    // of the newly entered word
    public static int keepScore(int currentScore, String word, int[][] bidimensionalArr) {
        return evaluateWord(word, bidimensionalArr) + currentScore;
    }

}
