
import java.io.PrintStream;

public class Biblioteca {

    private PrintStream printStream;

    public Biblioteca(PrintStream printStream){
        this.printStream = printStream;
    }

    public void run(){
        String welcomeMessage = "Welcome to the Bangalore Public Library System!!";
        String Option1Message =  "To view a list all the books in the library, type 1";
        String Option2Message =  "To reserve a book, type 2";

        printWelcomeMessages(welcomeMessage + "\n" + Option1Message + "\n" + Option2Message + "\n");

    }

    public void printWelcomeMessages(String message){
        printStream.println(message);
    }

    public static void main(String[] args) {

        Biblioteca welcome = new Biblioteca(System.out);
        welcome.run();
    }

}

