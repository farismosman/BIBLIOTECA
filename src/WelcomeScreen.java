
// import java.io.BufferedOutputStream;

public class WelcomeScreen {

    private printOnScreen printMethod;

    public WelcomeScreen (printOnScreen printMethod){
        this.printMethod = printMethod;
    }

    public static void main(String[] args) {
        String welcomeMessage = "Welcome to the Bangalore Public Library System!!";
        String Option1Message =  "To view a list all the books in the library, type 1";
        String Option2Message =  "To reserve a book, type 2";
        WelcomeScreen welcome = new WelcomeScreen(new printMessage(welcomeMessage));
        }

}

