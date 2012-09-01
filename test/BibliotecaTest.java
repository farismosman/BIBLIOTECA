import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Biblioteca biblioteca = bibliotecaSetOptions("1");


    private final String WELCOME = "Welcome to the Bangalore Public Library System!!\n";
    private final String MENU = "To view a list all the books in the library, type 1\nTo reserve a book, type 2\nTo check your library number, type 3\n> ";
    private final String RESERVE_A_BOOK_MESSAGE = "Enter Book Number: \n>";
    private final String BOOK_RESERVED_MESSAGE = " Thank you! Enjoy the book.";
    private final String BOOK_ALREADY_RESERVED = " Book has already been reserved by someone else.\n";
    private final String ALL_BOOKS = "1- Little Red Riding Hood, Will Smith\n" +
                                        "2- Small Giants, Bo Burlingham\n" +
                                        "3- The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
                                        "4- The Whuffie Factor, Tara Hunt";

    private final String PRINT_ALL_BOOKS = biblioteca.getLIST_ALL_BOOKS();
    private final String REQUEST_A_BOOK = biblioteca.getREQUEST_A_BOOK();
    private final String CHECK_LIBRARY_NUMBER_OPTION = biblioteca.getCHECK_LIBRARY_NUMBER();
    private final String QUIT = "q";
    private final String AND = "\n";


    private Biblioteca bibliotecaSetOptions(String inputString) {
        ByteArrayInputStream thisInContent = new ByteArrayInputStream(inputString.getBytes());
        return new Biblioteca(new PrintStream(outContent), thisInContent);
    }

    private String outputConsole() {
        return outContent.toString().trim();
    }


    /////////////////////////////// print MENU functionality ///////////////////////////////////
    @Test
    public void testPrintWelcomeMessage() {
        String message = "Welcome to the Bangalore Public Library System!!";
        biblioteca.printWelcomeMessage();
        assertEquals(message, outputConsole());
    }

    @Test
    public void testPrintAllBooksMenu() {
        String message = "To view a list all the books in the library, type 1\n" +
                "To reserve a book, type 2\n" +
                "To check your library number, type 3";
        biblioteca.printMenu();
        assertEquals(message, outputConsole());
    }


    /////////////////////////////// user input functionality /////////////////////////////////////

    @Test
    public void testUserInput() {
        biblioteca = bibliotecaSetOptions("some text sent through input injection");

        assertEquals("some text sent through input injection", biblioteca.getUserInput());
    }

    ////////////////////////////////////// test process User choices /////////////////////////


    @Test
    public void testProcessPrintAllBooks() throws Exception {
        biblioteca.processUserChoice(PRINT_ALL_BOOKS);

        assertEquals(ALL_BOOKS, outputConsole());

    }


    @Test
    public void testProcessRequestABook() throws Exception {
        biblioteca.processUserChoice(REQUEST_A_BOOK);

        assertEquals(RESERVE_A_BOOK_MESSAGE + BOOK_RESERVED_MESSAGE, outputConsole());

    }



    @Test
    public void testProcessCheckUserLibraryNumber() throws Exception {
        biblioteca.processUserChoice(CHECK_LIBRARY_NUMBER_OPTION);

        assertEquals("Please talk to a Librarian. Thank You.", outputConsole());

    }

    @Test
    public void testProcessInvalidOption() throws Exception {
        biblioteca.processUserChoice("unknown command");

        assertEquals("Select a valid option!!", outputConsole());

    }

    @Test
    public void testProcessQuit() throws Exception {
        biblioteca.processUserChoice("q");

        assertEquals(true, biblioteca.isQuit());

    }



    //////////////////////// Functional test //////////////////////////////////////

    @Test
    public void testBibliotecaMain() throws Exception {
        String expectedMessage = expectedOutputOfMain();
        String aBookNumber = "4";

        biblioteca = bibliotecaSetOptions(PRINT_ALL_BOOKS + AND + REQUEST_A_BOOK + AND + aBookNumber + AND + QUIT);
        biblioteca.run();

        assertEquals(expectedMessage, outputConsole());
    }

//
//    @Test
//    public void testProcessBookAlreadyReserved() throws Exception {
//        String aBookNumber = "4";
//        biblioteca = bibliotecaSetOptions(REQUEST_A_BOOK + AND + aBookNumber + AND + REQUEST_A_BOOK + AND + aBookNumber + AND + QUIT);
//        biblioteca.run();
//
//        assertEquals(RESERVE_A_BOOK_MESSAGE + BOOK_RESERVED_MESSAGE + RESERVE_A_BOOK_MESSAGE + BOOK_ALREADY_RESERVED, outputConsole());
//
//    }
//


    private String expectedOutputOfMain() {
        String expectedMessage = WELCOME + MENU + AND + ALL_BOOKS + AND + AND + AND + MENU + RESERVE_A_BOOK_MESSAGE + BOOK_RESERVED_MESSAGE + AND + AND + MENU;
        expectedMessage = expectedMessage.trim();
        return expectedMessage;
    }


}
