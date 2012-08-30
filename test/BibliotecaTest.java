import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String inputString = "1";
    private byte[] inputByte = inputString.getBytes();
    private ByteArrayInputStream inContent = new ByteArrayInputStream(inputByte);

    Biblioteca biblioteca = new Biblioteca(new PrintStream(outContent), inContent);

    private String outputConsole() {
        return outContent.toString().trim();
    }


    /////////////////////////////// print menu functionality ///////////////////////////////////
    @Test
    public void testPrintWelcomeMessage() {
        String message = "Welcome to the Bangalore Public Library System!!";
        biblioteca.printWelcomeMessage();
        assertEquals(message, outputConsole());
    }

    @Test
    public void testPrintAllBooksMenu() {
        String message = "To view a list all the books in the library, type 1\n" +
                "To reserve a book, type 2";
        biblioteca.printMenu();
        assertEquals(message, outputConsole());
    }

    /////////////////////////////// user input functionality /////////////////////////////////////

    @Test
    public void testUserInput() {
        assertEquals(inputString, biblioteca.getUserInput());
    }


    /////////////////////////////// test Print All Books //////////////////////////////

    @Test
    public void testPrintAllBooks() {
        String expectedBookList = "Little Red Riding Hood, Will Smith\n" +
                "Small Giants, Bo Burlingham\n" +
                "The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
                "The Whuffie Factor, Tara Hunt";

        biblioteca.printAllBooks("src/ListOfBooks.txt");
        assertEquals(expectedBookList, outputConsole());
    }


    //////////////////////// Functional test //////////////////////////////////////

    @Test
    public void functionalTestBiblioteca() {

        String welcome = "Welcome to the Bangalore Public Library System!!\n";

        String pressed1 = " \n\n" +
                "Little Red Riding Hood, Will Smith\n" +
                "Small Giants, Bo Burlingham\n" +
                "The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
                "The Whuffie Factor, Tara Hunt\n\n";

        String menu = "To view a list all the books in the library, type 1\n" +
                "To reserve a book, type 2 \n" + ">";


        String pressed2 = " \n" +
                "\nEnter Book number:\n" + ">";

        String twoSuccessful = " Book reserved successfully. Thank you for using our library.\n";

//        String pressedq = " \n" +
//                "\nSelect a valid option!!\n\n"+ ">";

        String expectedMessagesAll = welcome + menu + pressed1 + menu + pressed2 + twoSuccessful + "\n\n" + menu;

        biblioteca = bibliotecaWithInput("1\n2\n2\nq");

        biblioteca.run();

        assertEquals(expectedMessagesAll, outputConsole());
    }


    private Biblioteca bibliotecaWithInput(String inputString) {
        inputByte = inputString.getBytes();
        ByteArrayInputStream thisInContent = new ByteArrayInputStream(inputByte);

        return new Biblioteca(new PrintStream(outContent), thisInContent);
    }


}
