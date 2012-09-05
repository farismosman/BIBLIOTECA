import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

    private PrintStream printStream;

    private BufferedReader bufferRead;
    private boolean quit = false;

    private Library library = new Library();

    public static String LIST_ALL_BOOKS = "1";
    public static final String REQUEST_A_BOOK = "2";
    public static final String CHECK_LIBRARY_NUMBER = "3";
    public static final String LIST_ALL_MOVIES = "4";
    Map<String, Command> commands = userChoices();

    public Biblioteca(PrintStream printStream, InputStream inStream) {
        this.printStream = printStream;
        this.bufferRead = new BufferedReader(new InputStreamReader(inStream));        
    }

    ////////////////////////////////////////////////////// Print Menu //////////////////////////////////////

    public void printWelcomeMessage() {
        printToScreen("Welcome to the Bangalore Public Library System!!");
    }

    public void printMenu() {
        printToScreen("");
        printToScreen("To view a list all the books in the library, type 1");
        printToScreen("To reserve a book, type 2");
        printToScreen("To check your library number, type 3");
        printToScreen("To view movie records, type 4");
    }

    public void printToScreen(String message) {
        printStream.println(message);
    } 
   

    /////////////////////////////////////////////////////// Get user input //////////////////////////////

    public String getUserInput() {

        printStream.print("> ");
        String userInput = "";

        try {
            userInput = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput.toLowerCase();
    }

    public boolean isQuit() {
        return quit;
    }

    public void processUserChoice(String userInput) {   
        Command aCommand = commands.get(userInput);

        if (userInput.equals("q")) {
            quit = true;
        } else if (aCommand != null) {
            aCommand.execute();
        } else {
            processSelectValidOption();
        }
    }

    private Map<String, Command> userChoices() {
        Map<String, Command> commands = new HashMap<String, Command>();
        commands.put(LIST_ALL_BOOKS, new ListAllBookCommand(this, library));
        commands.put(REQUEST_A_BOOK, new RequestABookCommand(this , library));
        commands.put(CHECK_LIBRARY_NUMBER, new CheckLibraryNumberCommand(this));
        commands.put(LIST_ALL_MOVIES, new ListAllMoviesCommand(this, library));
        return commands;
    }    

    private void getAndProcessUserChoice() {
        String userInput = getUserInput();
        processUserChoice(userInput);
    }

    private void processSelectValidOption() {
        printToScreen("");
        printToScreen("Select a valid option!!");
    }
 
    ///////////////////////////////////////// MAIN ///////////////////////////////////////////////////

    public void run() {
        printWelcomeMessage();
        while (!quit) {
            printMenu();
            getAndProcessUserChoice();
        }
    }

    public static void main(String[] args) {
        new Biblioteca(System.out, System.in).run();
    }

}

