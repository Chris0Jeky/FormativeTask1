package formativetask1;

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

    public static int getCharValue(char ch, int[][] bidimArr) {

        // the following if will make the character passed as parameter
        // lower case
        if (ch > 64 && ch < 91) {
            ch = (char) (ch + 32);
        }
        // returns the value of the character passed as parameter
        // based on its position in the alphabet
        for (int i = 0; i < 26; i++) {
            if (ch == bidimArr[0][i]) {
                return bidimArr[1][i];
            }
        }
        return 0;
    }
}
