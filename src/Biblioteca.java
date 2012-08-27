
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
            printToScreen("\n");
            bookProcessor.printAllBooks("src/ListOfBooks.txt", printStream);
            printMenu();
            processUserChoice();

        } else if (userInput.equals("2")) {
            printToScreen("\n");
            printStream.println("Enter Book number:");
            prompt();
            String bookNumber = getUserInput();
            int bookStatus = -1;
            bookStatus = bookProcessor.requestABook(Integer.valueOf(bookNumber));
            printStream.println(bookStatus);
            if (bookStatus == -1){
                printStream.println("Book unavailable.");
                processUserChoice();
            } else {
                printStream.println("Book reserved successfully. Thank you for using our library.");
                processUserChoice();
            }


        } else {
            printStream.println("\n");
            printStream.println("Select a valid option!!\n");
            processUserChoice();
        }
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

