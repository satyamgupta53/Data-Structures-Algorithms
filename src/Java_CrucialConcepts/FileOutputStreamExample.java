package Java_CrucialConcepts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOutputStreamExample {
    private static final Logger logger = Logger.getLogger(String.valueOf(FileOutputStreamExample.class));

    public static void main(String[] args) {
        String data = "Hi! this is the test data for output file stream.\nThank you so much !";
        try(FileOutputStream fileOutputStream = new FileOutputStream("src\\Assets\\FileOutputStream.txt")) {
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            logger.log(Level.INFO, "An error occurred: ", e);
        }
    }
}
