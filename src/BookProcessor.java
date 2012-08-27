import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.PrintStream;
import java.util.*;


public class BookProcessor {

    private SortedMap AllBooks = new TreeMap();

    public void printAllBooks(String filename, PrintStream printStream){
        String fileContent = readFileToString(filename);
        printStream.println(fileContent);
    }

    public String readFileToString( String filename) {

        File asFile = new File(filename);

        StringBuilder toLine= new StringBuilder();

        try {
             List<String> lines = FileUtils.readLines(asFile);
             for (String s:lines){
                 toLine.append(s + "\n");
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toLine.toString();
    }


    public void requestABook(String key){

    }



}
