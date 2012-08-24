import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;



public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Biblioteca bibliotecaInjectionObject = new Biblioteca(new PrintStream(outContent));

    @Test
    public void FunctionalTestPrintWelcome() {

        String welcomeMessage = "Welcome to the Bangalore Public Library System!!";
        String Option1Message =  "To view a list all the books in the library, type 1";
        String Option2Message =  "To reserve a book, type 2";

        String expectedMessages  = welcomeMessage + "\n" + Option1Message + "\n" + Option2Message;

        bibliotecaInjectionObject.run();
        assertEquals(expectedMessages,outContent.toString().trim());
    }

    @Test
    public void testPrintWelcomeMessage() {
        String message = "some test text";

        bibliotecaInjectionObject.printToScreen(message);
        assertEquals(message,outContent.toString().trim());
    }

    private String expectedBookList="Little Red Riding Hood, Will Smith\n" +
            "Small Giants, Bo Burlingham\n" +
            "The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
            "The Whuffie Factor, Tara Hunt";
    @Test
    public void   testPrintAllBooks(){
        bibliotecaInjectionObject.printAllBooks("/Users/Farism/thoughtworks/training/twu_assignment/biblioteca/src/ListOfBooks.txt");
        assertEquals(expectedBookList, outContent.toString().trim());
    }

    @Test
    public void   testReadAFile(){
        String expectedFromFile = "Little Red Riding Hood, Will Smith";
        String contentOfTheBook = bibliotecaInjectionObject.readAFile("/Users/Farism/thoughtworks/training/twu_assignment/biblioteca/test/bla.txt");
        assertEquals(expectedFromFile, contentOfTheBook);
    }

    @Test
    public void testFile()  {
        File asFile = new File("/Users/Farism/thoughtworks/training/twu_assignment/biblioteca/test/bla.txt");
        assertEquals( true, asFile.exists() );

    }
}
