package formativetask1;

import java.io.File;

public class ReadFileAlt {

    public static File read() {
        String dataFile = System.getProperty("user.dir") + File.separator + "datafile.txt";
        File data = new File(dataFile);
        return data;
    }
}
