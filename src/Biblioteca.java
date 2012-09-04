
import java.io.*;

public class Biblioteca {

    private PrintStream printStream;

    private BufferedReader bufferRead;
    private boolean quit = false;

    private  Library library = new Library();

    public final String LIST_ALL_BOOKS = "1";
    public final String REQUEST_A_BOOK = "2";
    public final String CHECK_LIBRARY_NUMBER = "3";
    public final String LIST_ALL_MOVIES = "4";


    public Biblioteca(PrintStream printStream, InputStream inStream){
        this.printStream = printStream;
        this.bufferRead  = new BufferedReader(new InputStreamReader(inStream));

    }

    ////////////////////////////////////////////////////// Print Menu //////////////////////////////////////

    public void printWelcomeMessage(){
        printToScreen("Welcome to the Bangalore Public Library System!!");
    }

    public void printMenu(){
        printToScreen("");
        printToScreen("To view a list all the books in the library, type 1");
        printToScreen("To reserve a book, type 2");
        printToScreen("To check your library number, type 3");
        printToScreen("To view movie records, type 4");
    }

    private void printToScreen(String message){
        printStream.println(message);
    }

    public void printAllBooks(){
        printStream.print(library.allBooksTitles());
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
            
        } else if (userInput.equals(LIST_ALL_MOVIES)) {
            processPrintAllMovies();
            
        } else {
            processSelectValidOption();
        }
     }

    private void processPrintAllMovies() {
        printMovieHeader();
        printStream.println(library.allMovieRecords());
    }

    private void printMovieHeader() {
        String formatter = "%-" + Movie.STRING_LENGTH + "s";       
        printStream.println(String.format("ID " + formatter + formatter + formatter + "%-1s",  "Title", "Actor", "Director", "Rating"));
    }

    private void processReserveABook(Library library) {
        printToScreen("Enter Book Number: ");
        String bookKey = prompt();
        int bookStatus = library.requestABook(bookKey);

        if (bookStatus == Library.BOOK_ALREADY_RESERVED){
            printToScreen("Book has already been reserved by someone else.");
        } else if (bookStatus == Library.BOOK_RESERVED) {
            printToScreen("Thank you! Enjoy the book.");
        } else if (bookStatus == Library.BOOK_UNAVAILABLE) {
            printToScreen("Sorry we don't have that book yet.");
        }

    } 

    private void getAndProcessUserChoice() {
        String userInput = prompt();
        processUserChoice(userInput);     
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
        while(!quit){
            printMenu();
            getAndProcessUserChoice();
        }    
    }

    public static void main(String[] args) {
       new Biblioteca(System.out, System.in).run();
    }

}

