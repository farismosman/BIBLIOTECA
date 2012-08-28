
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
        String Option2Message =  "To reserve a book, type 2 ";
        printToScreen(Option2Message);
    }

    public void printToScreen(String message){
        printStream.println(message);
    }

    private void prompt() {
        printStream.print("> ");
    }

    /////////////////////////////////////////////////////// Get user input //////////////////////////////


    public String getUserInput(){

        String userInput = "";

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(inStream));
            userInput = bufferRead.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return userInput;
    }


    public void processUserChoice(){
        prompt();
        String userInput= getUserInput();
        BookProcessor bookProcessor = new BookProcessor();

        if (userInput.equals("1")) {
            processPrintAllBooks(bookProcessor);

        } else if (userInput.equals("2")) {
            processReserveABook(bookProcessor);

        } else if (userInputExit(userInput)){
                System.exit(0);

        } else {
            processSelectValidMethod();
        }
     }

    private void processReserveABook(BookProcessor bookProcessor) {
        printToScreen("\n");
        printToScreen("Enter Book number:");
        prompt();
        String bookNumber = getUserInput();
        int bookStatus = -1;
        bookStatus = bookProcessor.requestABook(Integer.valueOf(bookNumber));

        if (bookStatus == -1){
            printToScreen("Book unavailable.");
            printToScreen("\n");
            printMenu();
            processUserChoice();

        } else {
            printToScreen("Book reserved successfully. Thank you for using our library.");
            printToScreen("\n");
            printMenu();
            processUserChoice();
        }
    }

    private boolean userInputExit(String userInput){
        return (userInput.equals("q") || userInput.equals("Q"));
    }

    private void processSelectValidMethod() {
        printToScreen("\n");
        printToScreen("Select a valid option!!\n");
        processUserChoice();
    }

    private void processPrintAllBooks(BookProcessor bookProcessor) {
        printToScreen("\n");
        bookProcessor.printAllBooks("src/ListOfBooks.txt", printStream);
        printMenu();
        processUserChoice();
    }


    ///////////////////////////////////////// MAIN ///////////////////////////////////////////////////

    public void run(){
        printWelcomeMessage();
        printMenu();
        processUserChoice();
    }


    public static void main(String[] args) {
       new Biblioteca(System.out, System.in).run();
    }

}

