
import java.io.*;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Biblioteca {

    private PrintStream printStream;

    private BufferedReader bufferRead;
    private boolean quit;

    private  Library library = new Library();

    public Biblioteca(PrintStream printStream, InputStream inStream){
        this.printStream = printStream;
        this.bufferRead  = new BufferedReader(new InputStreamReader(inStream));

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
        String Option2Message =  "To reserve a book, type 2 ";
        printToScreen(Option2Message);
    }

    private void printToScreen(String message){
        printStream.println(message);
    }

    public void printAllBooks(String filename){
        String listOfAllBooks = library.readFileToString(filename);
        printToScreen(listOfAllBooks);
    }


    /////////////////////////////////////////////////////// Get user input //////////////////////////////

    private String  prompt() {
        printStream.print("> ");
        return getUserInput();
    }

    public String getUserInput(){

        String userInput = "";

        try{
//            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(inStream));
            userInput = bufferRead.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return userInput;
    }


    public void processUserChoice(){
        String userInput= prompt();

        if (userInput.equals("1")) {
            processPrintAllBooks(library);

        } else if (userInput.equals("2")) {
            processReserveABook(library);

        } else if (userInputExit(userInput)){
                quit = true;

        } else {
            processSelectValidMethod();
        }
     }

    private void processReserveABook(Library library) {
        printToScreen("\n");
        printToScreen("Enter Book number:");
        String bookNumber = prompt();
        int bookStatus = -1;
        bookStatus = library.requestABook(Integer.valueOf(bookNumber));

        if (bookStatus == -1){
            printToScreen("Book unavailable.");
            returnToWelcomeScreen();

        } else {
            printToScreen("Book reserved successfully. Thank you for using our library.");
            returnToWelcomeScreen();
        }
    }

    private void returnToWelcomeScreen() {
        printToScreen("\n");
        printMenu();
        processUserChoice();
    }

    private boolean userInputExit(String userInput){
        return (userInput.equals("q") || userInput.equals("Q"));
    }

    private void processSelectValidMethod() {
        printToScreen("\n");
        printToScreen("Select a valid option!!\n");
        processUserChoice();
    }

    private void processPrintAllBooks(Library library) {
        printToScreen("\n");
        printAllBooks("src/ListOfBooks.txt");
        printMenu();
        processUserChoice();
    }



    ///////////////////////////////////////// MAIN ///////////////////////////////////////////////////

    public void run(){
        printWelcomeMessage();
        while(!quit) {
            printMenu();
            processUserChoice();
        }
    }


    public static void main(String[] args) {
       new Biblioteca(System.out, System.in).run();
    }

}

