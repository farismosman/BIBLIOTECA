import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class Biblioteca {

    private PrintStream printStream;

    private BufferedReader bufferRead;
    private boolean quit = false;

    private Library library = new Library();

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
        printToScreen(StringUtils.join(MenuItem.values(),  "\n"));
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
        
        MenuItem menuItem = MenuItem.getFromCode(userInput);   
        
        
        if (userInput.equals("q")) {
            quit = true;
        } else if (menuItem != null) {
            menuItem.getCommand().execute(this, library);
        } else {
            processSelectValidOption();
        }
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
