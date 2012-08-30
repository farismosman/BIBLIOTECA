import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.io.PrintStream;
import java.util.*;


public class Library {

    public SortedMap allBooks = new TreeMap();
    private final int BookIsAvailable = 0;
    private final int BookIsUnAvailable = 1;


    private  List<String> listOfBooks = Library.readFile( "src/ListOfBooks.txt");

    public Library() {
        createAllBooks();
    }

    private void createAllBooks(){
        int i = 0;
        for (String s:listOfBooks){
            allBooks.put(i += 1, BookIsAvailable);
        }
    }


    public SortedMap getAllBooks() {
        return Collections.unmodifiableSortedMap(allBooks);
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

        if (bookExistsAndIsAvailable(bookNumber)){
            allBooks.put(bookNumber, BookIsUnAvailable);
            return 1;
        } else {
            return -1;

        }
    }

    public boolean bookExistsAndIsAvailable(int bookNumber){
        return  ( (bookNumber < allBooks.size()) && (allBooks.get(bookNumber).equals(BookIsAvailable)));
    }
}
