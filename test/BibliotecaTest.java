import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.apache.commons.io.*;


public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Biblioteca biblioteca = new Biblioteca(new PrintStream(outContent));

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
