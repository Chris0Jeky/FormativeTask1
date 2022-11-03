package formativetask1;

import java.util.Vector;

public class FormativeTask1 {

    public static void main(String[] args) {
        startGame();              

    }
    
    public static void startGame(){
        int score = 0;
        boolean isFirstTurn = true;
        boolean end = false;
        int player = 1;
        String word;
        String previousWord = "";
        Vector datafileVectorised = ReadFile.read();
        int[][] dataMap = Mechanics.arrayCreation();
        
        while(end != true){
            
            do{
             word = UserInput.getUserInput();
            }
            while(UserInput.checks(word, datafileVectorised, isFirstTurn, previousWord)
                    || isAsterisc(word));
            isAsterisc(word);
            if(end == true) {
                System.out.println("Player No." + changePlayer(player) + " wins!");
                break;
            }
            else {
                System.out.println("Player No." + player + " entered " + word);
                Mechanics.keepScore(score, word, dataMap);
                isFirstTurn = false;
                previousWord = word;
                changePlayer(player);
            }
            
        }
    }

    public static boolean isAsterisc(String word) {
        if ("*".equals(word)) {
            boolean end = true;
            return end;
        }
        return false;
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
