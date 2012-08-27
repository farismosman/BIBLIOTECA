import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.PrintStream;
import java.util.*;


public class BookProcessor {

    public SortedMap allBooks = new TreeMap();
    private List<String> listOfBooks = readFile( "src/ListOfBooks.txt");

    public void createAllBooksMap(){

        int i =0;
        for (String s:listOfBooks){
            allBooks.put(i += 1, -1);
        }
    }



    public void printAllBooks(String filename, PrintStream printStream){
        String fileContent = readFileToString(filename);
        printStream.println(fileContent);
    }

    public List<String> readFile( String filename) {

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
        if (allBooks.get(bookNumber).equals(-1)){
            allBooks.put(bookNumber, 1);
            return 1;
        } else {
            return -1;
        }

    }



}
