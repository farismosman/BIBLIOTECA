
import java.io.*;

public class Biblioteca {

    private PrintStream printStream;

    private BufferedReader bufferRead;
    private boolean quit = false;

    private  Library library = new Library();
    private final int BOOK_RESERVED = library.getBOOK_RESERVED();
    private final int BOOK_ALREADY_RESERVED = library.getBOOK_ALREADY_RESERVED();
    private final int BOOK_DOES_NOT_EXIST = library.getBOOK_DOES_NOT_EXIST();

    private final String LIST_ALL_BOOKS = "1";
    private final String REQUEST_A_BOOK = "2";
    private final String CHECK_LIBRARY_NUMBER = "3";


    public Biblioteca(PrintStream printStream, InputStream inStream){
        this.printStream = printStream;
        this.bufferRead  = new BufferedReader(new InputStreamReader(inStream));

    }

    public String getLIST_ALL_BOOKS() {
        return LIST_ALL_BOOKS;
    }

    public String getREQUEST_A_BOOK() {
        return REQUEST_A_BOOK;
    }

    public String getCHECK_LIBRARY_NUMBER() {
        return CHECK_LIBRARY_NUMBER;
    }

    ////////////////////////////////////////////////////// Print Menu //////////////////////////////////////

    public void printWelcomeMessage(){
        printToScreen("Welcome to the Bangalore Public Library System!!");
    }

    public void printMenu(){
        printToScreen("To view a list all the books in the library, type 1");
        printToScreen("To reserve a book, type 2");
        printToScreen("To check your library number, type 3");
    }

    private void printToScreen(String message){
        printStream.println(message);
    }

    public void printAllBooks(){
        printToScreen(library.allBooksTitles());
    }


    /////////////////////////////////////////////////////// Get user input //////////////////////////////

    private String  prompt() {
        printStream.print("> ");
        return getUserInput();
    }

    public String getUserInput(){

        String userInput = "";

        try{
            userInput = bufferRead.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return userInput;
    }

    public boolean isQuit() {
        return quit;
    }

    public void processUserChoice(String userInput){
        if (userInput.equals(LIST_ALL_BOOKS)) {
            processPrintAllBooks();

        } else if (userInput.equals(REQUEST_A_BOOK)) {
            processReserveABook(library);

        } else if (userInputExit(userInput)){
                quit = true;
        } else if (userInput.equals(CHECK_LIBRARY_NUMBER)) {
            printToScreen("Please talk to a Librarian. Thank You.");

        } else {
            processSelectValidOption();
        }
     }

    private void processReserveABook(Library library) {
        printToScreen("Enter Book Number: ");
        String bookKey = prompt();
        int bookStatus = library.requestABook(bookKey);

        if (bookStatus == BOOK_ALREADY_RESERVED){
            printToScreen("Book has already been reserved by someone else.");
        } else if (bookStatus == BOOK_RESERVED) {
            printToScreen("Thank you! Enjoy the book.");
        } else if (bookStatus == BOOK_DOES_NOT_EXIST) {
            printToScreen("Sorry we don't have that book yet.");
        }

    }

    private void returnToMenuScreen() {
        printToScreen("");
        printMenu();
    }

    private void getAndProcessUserChoice() {
        String userInput = prompt();
        processUserChoice(userInput);
        if (!quit){
            returnToMenuScreen();
            getAndProcessUserChoice();
        }
    }

    private boolean userInputExit(String userInput){
        return (userInput.equals("q") || userInput.equals("Q"));
    }

    private void processSelectValidOption() {
        printToScreen("");
        printToScreen("Select a valid option!!");
    }

    private void processPrintAllBooks() {
        printToScreen("");
        printAllBooks();
    }


    ///////////////////////////////////////// MAIN ///////////////////////////////////////////////////

    public void run(){
        printWelcomeMessage();
        printMenu();
        getAndProcessUserChoice();
    }


    public static void main(String[] args) {
       new Biblioteca(System.out, System.in).run();
    }

}

