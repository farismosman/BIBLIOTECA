import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;



public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void FunctionalTestPrintWelcome() {

        String welcomeMessage = "Welcome to the Bangalore Public Library System!!";
        String Option1Message =  "To view a list all the books in the library, type 1";
        String Option2Message =  "To reserve a book, type 2";

        String expectedMessages  = welcomeMessage + "\n" + Option1Message + "\n" + Option2Message;

        Biblioteca welcometest = new Biblioteca(new PrintStream(outContent));
        welcometest.run();
        assertEquals(expectedMessages,outContent.toString().trim());
    }

    @Test
    public void testPrintWelcomeMessage() {
        String message = "some test text";
        Biblioteca printMethodtest = new Biblioteca(new PrintStream(outContent));
        printMethodtest.printWelcomeMessages(message);
        assertEquals(message,outContent.toString().trim());
    }
}
