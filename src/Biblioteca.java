
import java.io.*;

public class Biblioteca {

    private PrintStream printStream;

    public Biblioteca(PrintStream printStream){
        this.printStream = printStream;
    }

    public void run(){
        printWelcomeMessage();
        printMenu();
    }

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


    ///////////////////////////////////////// MAIN ///////////////////////////////////////////////////



    public static void main(String[] args) {

       new Biblioteca(System.out).run();
       //welcome.printAllBooks("/Users/Farism/thoughtworks/training/twu_assignment/biblioteca/src/ListOfBooks.txt");
    }

}

