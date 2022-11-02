package formativetask1;

import java.util.Vector;

public class FormativeTask1 {

    public static void main(String[] args) {
        int score = 0;
        boolean isFirstTurn = true;
        boolean end = false;
        int player = 1;
        Vector datafileVectorised = ReadFile.read();
        int[][] dataMap = Mechanics.arrayCreation();

        String word = UserInput.getUserInput();

        if (UserInput.checks(word, datafileVectorised, isFirstTurn, "")) {
            System.out.println(Mechanics.evaluateWord(word, dataMap));
        }

    }

    public static boolean isAsterisc(String word) {
        if ("*".equals(word)) {
            boolean end = true;
            return end;
        }
        return false;
    }

    public static void playerWinsMessage(int player) {
        if (player == 1) {
            System.out.println("Player 2 wins.");
        } else if (player == 2) {
            System.out.println("player 1 wins.");
        }
    }

}
