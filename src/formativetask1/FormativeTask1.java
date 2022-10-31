package formativetask1;

import java.util.Scanner;
import java.util.Vector;

public class FormativeTask1 {

    public static void main(String[] args) {

        Vector datafileVectorised = new Vector();
        datafileVectorised = ReadFile.read();

        do {
            System.out.println("Please insert a three-letter word: \n");
        } while (!"*".equals(UserInput.getUserInput())
                && !Mechanics.validInput(UserInput.getUserInput()));

    }

}
