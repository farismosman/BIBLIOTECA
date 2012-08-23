
// import java.io.BufferedOutputStream;

public class WelcomeScreen {

    private PrintMessage printMethod;

    public WelcomeScreen (PrintMessage printMethod){
        this.printMethod = printMethod;
    }

    public void printMessage(String message) {
        printMethod.printMessageOnScreen(message);
    }

    public static void main(String[] args) {
        String welcomeMessage = "Welcome to the Bangalore Public Library System!!";
//        String optionOneMessage =  "To view a list all the books in the library, type 1";
//        String optionTwoMessage =  "To reserve a book, type 2";
        WelcomeScreen welcome = new WelcomeScreen(new PrintMessage(System.out));
        welcome.printMessage(welcomeMessage);
    }

}

