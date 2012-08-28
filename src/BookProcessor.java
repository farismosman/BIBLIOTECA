import org.apache.commons.io.FileUtils;

import javax.jnlp.IntegrationService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.PrintStream;
import java.util.*;


public class BookProcessor {

    public static SortedMap allBooks = new TreeMap();
    private static List<String> listOfBooks = readFile( "src/ListOfBooks.txt");

//    public BookProcessor() {
//        createAllBooksMap();
//    }

    static{
        int i = 0;
        for (String s:listOfBooks){
            allBooks.put(i += 1, 0);
        }
    }



    public void printAllBooks(String filename, PrintStream printStream){
        String fileContent = readFileToString(filename);
        printStream.println(fileContent);
    }

    public static List<String> readFile( String filename) {

        List<String> lines = null;

        File asFile = new File(filename);
        try {
             lines = FileUtils.readLines(asFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public String readFileToString( String filename){

        List<String> lines = readFile(filename);
        StringBuilder toLine= new StringBuilder();
        for (String s:lines){
            toLine.append(s + "\n");
        }
        return toLine.toString();
    }



    public int requestABook(int bookNumber){

        if (allBooks.get(bookNumber).equals(0)){
            allBooks.put(bookNumber, 1);
            return 1;
        }
        else{
            return -1;

        }
    }

}
