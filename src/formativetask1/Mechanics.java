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

        // the following if will make the character passed as parameter
        // lower case
        if (ch > 64 && ch < 91) {
            ch = (char) (ch + 32);
        }
        // returns the value of the character passed as parameter
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
    public static boolean validInput(String word) {
        for (int i = 0; i < 3; i++) {
            if (word.toLowerCase().charAt(i) < 97
                    && word.toLowerCase().charAt(i) > 122) {
                System.out.println("Inputed word is not valid. \n It must "
                        + "contain only letters. \n");
                return false;
            }
        }
        return true;
    }

    // it returnes true or false if the word parameter is contained in the 
    // vector parameter
    public static boolean isPresentInVector(Vector vekky, String word) {
        return vekky.contains(word.toLowerCase());
    }

    public static int evaluateWord(String word, int[][] bidimensionalArr) {
        int totalValue = 0;
        totalValue = getCharValue(word.charAt(0), bidimensionalArr) + totalValue;
        totalValue = getCharValue(word.charAt(1), bidimensionalArr) + totalValue;
        totalValue = getCharValue(word.charAt(2), bidimensionalArr) + totalValue;
        return totalValue;
    }
}
