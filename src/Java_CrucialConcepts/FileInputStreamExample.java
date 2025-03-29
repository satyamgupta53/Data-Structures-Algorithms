package Java_CrucialConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileInputStreamExample {
    private static final Logger logger = Logger.getLogger(String.valueOf(FileInputStreamExample.class));

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("src\\Assets\\FileInputStream.txt")) {
            int data;
            while ((data = fileInputStream.read()) != -1)
                System.out.print((char) data);
        } catch (IOException e) {
            logger.log(Level.INFO, "An error occurred: ", e);
        }
    }
}
