package formativetask1;

import java.util.Vector;

public class FormativeTask1 {

    public static void main(String[] args) {
        startGame();

    }

    public static void startGame() {
        int score = 0;
        boolean isFirstTurn = true;
        boolean end = false;
        int player = 1;
        String word;
        String previousWord = "";
        Vector datafileVectorised = ReadFile.read();
        int[][] dataMap = Mechanics.arrayCreation();

        System.out.println("Player No." + player + " starts.");

        while (end != true) {

            UserInput.introductionaryMessage(player, isFirstTurn, previousWord);

            word = UserInput.getUserInput();
            if (!isAsterisc(word)) {
                word = UserInput.inputPrompt(word, datafileVectorised, isFirstTurn, previousWord);
            }
            if (isAsterisc(word)) {
                end = true;
            }

            if (end == true) {
                System.out.println("\nPlayer No." + changePlayer(player) + " wins!");
            } else {
                System.out.println("\nPlayer No." + player + " entered " + word);
                score = Mechanics.keepScore(score, word, dataMap);
                System.out.println("\nScore: " + score + "\n");
                isFirstTurn = false;
                previousWord = word;
                player = changePlayer(player);
            }

            if (score > 200) {
                System.out.println("\nMax score of 200 exceeded! \n"
                        + "Player No." + player + " wins!");
                end = true;
            }
        }
    }

    public static boolean isAsterisc(String word) {

        boolean result = false;
        if ("*".equals(word)) {
            result = true;
            return result;
        }
        return result;
    }

    public static int changePlayer(int player) {
        if (player == 1) {
            player = 2;
        } else if (player == 2) {
            player = 1;
        }
        return player;
    }
}
