import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;



public class WelcomeScreenTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testWelcomeGreeting(){
        String expectedGreetingMessage = "Welcome to the Bangalore Public Library System!!";
        System.setOut(new PrintStream(outContent));
        WelcomeScreen.printGreetingScreen();
        assertEquals("welcome not printing", expectedGreetingMessage, outContent.toString().trim());
        System.setOut(null);

    }

    @Test
    public void testPrintOptions() {
        String expectedOptionMessage = "To view a list all the books in the library, type 1 \n" +
                "To reserve a book, type 2";
        System.setOut(new PrintStream(outContent));
        WelcomeScreen.printOptions();
        assertEquals("options  not printed", expectedOptionMessage, outContent.toString().trim());
        System.setOut(null);
    }


}
