
// import java.io.BufferedOutputStream;

public class WelcomeScreen {

    public static void printGreetingScreen(){

           String greetingMessage =   "Welcome to the Bangalore Public Library System!!";
           System.out.println(greetingMessage);
    }

    public static void printOptions(){

        String optionMessage = "To view a list all the books in the library, type 1 \n" +
                "To reserve a book, type 2";
        System.out.println(optionMessage);
    }

    public static void main(String[] args) {
        WelcomeScreen welcome = new WelcomeScreen();
        welcome.printGreetingScreen();
        welcome.printOptions();
    }

}

