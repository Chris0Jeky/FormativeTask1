package formativetask1;

import java.util.Scanner;

public class UserInput {

    public static String getUserInput() {
        Scanner inputFromUser = new Scanner(System.in);
        String word = inputFromUser.nextLine();
        return word;
    }
}
