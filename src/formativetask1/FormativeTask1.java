package formativetask1;

import java.util.Scanner;
import java.util.Vector;

public class FormativeTask1 {

    public static void main(String[] args) {
        
        Vector datafileVectorised = new Vector();
        datafileVectorised = ReadFile.read();
        System.out.println("Please insert a word: \n");
        Scanner inputFromUser = new Scanner(System.in);
        String word = inputFromUser.nextLine();
        
    }

}
