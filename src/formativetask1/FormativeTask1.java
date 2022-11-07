package formativetask1;

import java.util.Vector;

public class FormativeTask1 {

    public static void main(String[] args) {
         startGame();
    }
    
// initialisation of core variables

    public static void startGame() {
        int score = 0;
        boolean isFirstTurn = true;
        boolean end = false;
        int player = 1;

        String word;
        String previousWord = "";
        // read file and transfer its contents into a vector
        Vector datafileVectorised = ReadFile.read();
        // creates a bidimensional array for letters and their value
        int[][] dataMap = Mechanics.arrayCreation();

        System.out.println("Player No." + player + " starts.");
        
        // while loop will iterate until something sets end as true
        while (!end) {
            System.out.println("______________________________________________");

            // a set of introductionary messages
            UserInput.introductionaryMessage(player, isFirstTurn, previousWord);
            UserInput.twentyPointsMessage(isFirstTurn);

            // get input
            word = UserInput.getUserInput();

            // asks for an input unitl an asterisc is enetered or the criteria
            // are met
            if (!isAsterisc(word)) {
                word = UserInput.inputPrompt(word, datafileVectorised, isFirstTurn, previousWord, dataMap);
                if (isAsterisc(word)) {
                    end = true;
                }
            }

            // after the user input, it checks whether the game as ended
            // it would end by entering an asterisc
            if (end) {
                System.out.println("\nPlayer No." + changePlayer(player) + " wins!");
            } else {
                System.out.println("\nPlayer No." + player + " entered " + word);
                // if the game hasn't ended yet, the functions necessary to 
                // carry out the rest of the match will be executed
                score = Mechanics.keepScore(score, word, dataMap);
                System.out.println("\nWord Score: " + Mechanics.evaluateWord(word, dataMap) + "\tRunning Score: " + score + "\n");
                System.out.println("Last letter: " + word.charAt(2));

                isFirstTurn = false;
                previousWord = word;
                player = changePlayer(player);

                // if, after updating the score, the total score is more than
                // 200, the player that has not entered the last word wins
                if (score > 200) {
                    System.out.println("\nMax score of 200 exceeded! \n"
                            + "Player No." + player + " wins!");
                    end = true;
                }
            }
        }
    }

    public static boolean isAsterisc(String word) {
        // simply returns whether an asterisc has been entered
        boolean result = false;
        if ("*".equals(word)) {
            result = true;
            return result;
        }
        return result;
    }

    public static int changePlayer(int player) {
        // returns the number of the player which is not playing at the moment
        if (player == 1) {
            player = 2;
        } else if (player == 2) {
            player = 1;
        }
        return player;
    }
}
