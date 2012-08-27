
import java.io.*;

public class Biblioteca {

    private PrintStream printStream;
    private InputStream inStream;

    public Biblioteca(PrintStream printStream, InputStream inStream){
        this.printStream = printStream;
        this.inStream = inStream;
    }

    ////////////////////////////////////////////////////// Print Menu //////////////////////////////////////

    public void printWelcomeMessage(){
        String welcomeMessage = "Welcome to the Bangalore Public Library System!!";
        printToScreen(welcomeMessage);
    }

    public void printMenu(){
        printAllBooksMenu();
        printReserveABookMenu();
    }

    public void printAllBooksMenu(){
        String Option1Message =  "To view a list all the books in the library, type 1";
        printToScreen(Option1Message);
    }

    public void printReserveABookMenu(){
        String Option2Message =  "To reserve a book, type 2";
        printToScreen(Option2Message);
    }

    public void printToScreen(String message){
        printStream.println(message);
    }

    /////////////////////////////////////////////////////// Get user input //////////////////////////////

    


    ///////////////////////////////////////// MAIN ///////////////////////////////////////////////////

    public void run(){
        printWelcomeMessage();
        printMenu();
    }

    public static void main(String[] args) {
       new Biblioteca(System.out, System.in).run();
    }

}

