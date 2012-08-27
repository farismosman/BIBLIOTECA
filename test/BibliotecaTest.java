import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String inputString = "1";
    private byte[] inputByte = inputString.getBytes();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream(inputByte);

    Biblioteca biblioteca = new Biblioteca(new PrintStream(outContent), inContent);

    private String outputConsole() {
        return outContent.toString().trim();
    }

    /////////////////////////////// print menu functionality ///////////////////////////////////

    @Test
    public void testPrintWelcomeMessage() {
        String message = "Welcome to the Bangalore Public Library System!!";
        biblioteca.printToScreen(message);
        assertEquals(message, outputConsole());
    }

    @Test
    public void testPrintAllBooksMenu() {
        String message = "To view a list all the books in the library, type 1";
        biblioteca.printToScreen(message);
        assertEquals(message, outputConsole());
    }


    /////////////////////////////// user input functionality /////////////////////////////////////

    @Test
    public void testUserInput(){
        assertEquals(inputString, biblioteca.getUserInput());
    }

    ////////////////////////////////// print AllBooks functionality /////////////////////////////////

    private BookProcessor bookProcessor = new BookProcessor();

    @Test
    public void   testPrintAllBooks(){
        String expectedBookList="Little Red Riding Hood, Will Smith\n" +
                "Small Giants, Bo Burlingham\n" +
                "The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
                "The Whuffie Factor, Tara Hunt";

        bookProcessor.printAllBooks("src/ListOfBooks.txt", new PrintStream(outContent));
        assertEquals(expectedBookList, outputConsole());
    }

    //////////////////////// Functional test //////////////////////////////////////

    @Test
    public void FunctionalTestPrintWelcome() {

        String expectedMessages = "Welcome to the Bangalore Public Library System!!\n"  +
                "To view a list all the books in the library, type 1\n"  +
                "To reserve a book, type 2 \n" +
                ">";

        biblioteca.run();
        assertEquals(expectedMessages, outputConsole());
    }

}
