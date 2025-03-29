package Java_CrucialConcepts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReaderStreamExample {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\Assets\\FileOutputStream.txt"));
        String line;
        while((line = bufferedReader.readLine()) != null) System.out.println(line);
    }
}