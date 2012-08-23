
// import java.io.BufferedOutputStream;

import java.io.IOException;
import java.io.OutputStream;

public class WelcomeScreen {


    private OutputStream os;

    public WelcomeScreen (OutputStream someOutputStream){
        this.os = someOutputStream;
    }

    public void printMessage(String message) {
        message = message + "\n";
        try {
            os.write(message.getBytes());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String welcomeMessage = "Welcome to the Bangalore Public Library System!!";
//        String optionOneMessage =  "To view a list all the books in the library, type 1";
//        String optionTwoMessage =  "To reserve a book, type 2";
        WelcomeScreen welcome = new WelcomeScreen(System.out);
        welcome.printMessage(welcomeMessage);
    }

}

