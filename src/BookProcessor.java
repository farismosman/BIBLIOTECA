import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.PrintStream;


public class BookProcessor {

    public void printAllBooks(String filename, PrintStream printStream){
        String fileContent = readFileToString(filename);
        printStream.println(fileContent);
    }

    public String readFileToString( String filename) {

        File asFile = new File(filename);

        StringBuilder toline= new StringBuilder();

        try {
             List<String> lines = FileUtils.readLines(asFile);
             for (String s:lines){
                 toline.append(s + "\n");
             }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return toline.toString();

    }

}
