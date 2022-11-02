package formativetask1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ReadFile {

    public static Vector read() {

        Vector vectorisedFile = new Vector();
        try {
            File file = new File("datafile.txt");
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNext()) {
                    String data = reader.next();
                    vectorisedFile.addElement(data);
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return vectorisedFile;
    }
}
