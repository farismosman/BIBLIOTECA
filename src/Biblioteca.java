
import java.io.*;

public class Biblioteca {

    private PrintStream printStream;

    private BufferedReader bufferRead;
    private boolean quit;

    private  Library library = new Library();
    private final int BookReserved = 1;
    private final int BookCanNotBeReserved = -1;
    private final int BookUnavailable = 0;


    public Biblioteca(PrintStream printStream, InputStream inStream){
        this.printStream = printStream;
        this.bufferRead  = new BufferedReader(new InputStreamReader(inStream));

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


    public void processUserChoice(String userInput){

        if (userInput.equals("1")) {
            processPrintAllBooks(library);

        } else if (userInput.equals("2")) {
            processReserveABook(library);

        } else if (userInputExit(userInput)){
                quit = true;
        } else if (userInput.equals("3")) {
            printToScreen("Please talk to a Librarian. Thank You.");

        } else {
            processSelectValidMethod();
        }
     }

    private void processReserveABook(Library library) {
        printToScreen("\n");
        printToScreen("Enter Book Number: ");
        String bookKey = prompt();
        int bookStatus = library.requestABook(bookKey);

        if (bookStatus == BookCanNotBeReserved){
            printToScreen("Book has already been reserved by someone else.");
            returnToWelcomeScreen();

        } else if (bookStatus == BookReserved) {
            printToScreen("Thank you! Enjoy the book.");
            returnToWelcomeScreen();
        } else if (bookStatus == BookUnavailable) {
            printToScreen("Sorry we don't have that book yet.");
            returnToWelcomeScreen();
        }

    }

    private void returnToWelcomeScreen() {
        printToScreen("\n");
        printMenu();
        getAndProcessUserChoice();
    }

    private void getAndProcessUserChoice() {
        String userInput = prompt();
        processUserChoice(userInput);
    }

    private boolean userInputExit(String userInput){
        return (userInput.equals("q") || userInput.equals("Q"));
    }

    private void processSelectValidMethod() {
        printToScreen("\n");
        printToScreen("Select a valid option!!\n");
        getAndProcessUserChoice();
    }

    private void processPrintAllBooks(Library library) {
        printToScreen("\n");
        printAllBooks();
        printMenu();
        getAndProcessUserChoice();
    }



    ///////////////////////////////////////// MAIN ///////////////////////////////////////////////////

    public void run(){
        printWelcomeMessage();
        while(!quit) {
            printMenu();
            getAndProcessUserChoice();
        }
    }


    public static void main(String[] args) {
       new Biblioteca(System.out, System.in).run();
    }

}

