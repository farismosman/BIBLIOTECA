import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String inputString = "1";
    private byte[] inputByte = inputString.getBytes();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream(inputByte);

    Biblioteca biblioteca = new Biblioteca(new PrintStream(outContent), inContent);

    @Test
    public void FunctionalTestPrintWelcome() {

        String expectedMessages = "Welcome to the Bangalore Public Library System!!\n"  +
                                         "To view a list all the books in the library, type 1\n"  +
                                         "To reserve a book, type 2";

        biblioteca.run();
        assertEquals(expectedMessages, outputConsole());
    }

    private String outputConsole() {
        return outContent.toString().trim();
    }

    @Test
    public void testPrintWelcomeMessage() {
        String message = "some test text";
        biblioteca.printToScreen(message);
        assertEquals(message, outputConsole());
    }

    private BookProcessor bookProcessor = new BookProcessor();

    @Test
    public void   testPrintAllBooks(){
        String expectedBookList="Little Red Riding Hood, Will Smith\n" +
                "Small Giants, Bo Burlingham\n" +
                "The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
                "The Whuffie Factor, Tara Hunt";

        bookProcessor.printAllBooks("src/ListOfBooks.txt", biblioteca);
        assertEquals(expectedBookList, outputConsole());
    }


}
