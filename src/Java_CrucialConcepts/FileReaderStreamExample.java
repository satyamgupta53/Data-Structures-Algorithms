package Java_CrucialConcepts;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReaderStreamExample {
    private static final Logger logger = Logger.getLogger(String.valueOf(FileReaderStreamExample.class));

    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src\\Assets\\FileInputStream.txt")) {
            int data;
            while((data = fileReader.read()) != -1) System.out.print((char) data);
        } catch (IOException e) {
            logger.log(Level.INFO, "An error occurred: ", e);
        }
    }
}
