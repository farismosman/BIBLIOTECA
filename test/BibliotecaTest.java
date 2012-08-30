import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String inputString = "1";
    private byte[] inputByte = inputString.getBytes();
    private ByteArrayInputStream inContent = new ByteArrayInputStream(inputByte);

    private final String welcome = "Welcome to the Bangalore Public Library System!!\n";
    private final String menu = "To view a list all the books in the library, type 1\nTo reserve a book, type 2 \n>";
    private final String reserveABookOption = " \n\nEnter Book Number: \n>";
    private final String bookReserved = " Thank you! Enjoy the book.\n";
    private final String bookCanNotBeReserved = " Book has already been reserved by someone else.\n";
    private final String listAllBooks = "1- Little Red Riding Hood, Will Smith\n" +
                                        "2- Small Giants, Bo Burlingham\n" +
                                        "3- The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
                                        "4- The Whuffie Factor, Tara Hunt";


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
                "To reserve a book, type 2\n" +
                "To check your library number, type 3";
        biblioteca.printMenu();
        assertEquals(message, outputConsole());
    }


    /////////////////////////////// user input functionality /////////////////////////////////////

    @Test
    public void testUserInput() {
        biblioteca = bibliotecaWithInput("3");

        assertEquals("3", biblioteca.getUserInput());
    }

    @Test
    public void testPrintAllBooks() {
        biblioteca.printAllBooks();
        assertEquals(listAllBooks, outputConsole());
    }


    ////////////////////////////////////// test process User choices /////////////////////////

    @Test
    public void testProcessCheckUserLibraryNumber() throws Exception {
        biblioteca.processUserChoice("3");

        assertEquals("Please talk to a Librarian. Thank You.", outputConsole());

    }


    //////////////////////// Functional test //////////////////////////////////////
//
//    @Test
//    public void testSuccesookReservation() throws Exception {
//        String expectedMessage = generateExpectedMessage(bookReserved);
//
//        biblioteca = bibliotecaWithInput("1\n2\n3\nq");
//        biblioteca.run();
//
//        assertEquals(expectedMessage, outputConsole());
//    }
//
//    @Test
//    public void testFailingBookReservation() throws Exception {
//        String expectedMessage = generateExpectedMessage(bookReserved + "\n\n" + menu + reserveABookOption + bookCanNotBeReserved);
//
//        biblioteca = bibliotecaWithInput("1\n2\n3\n2\n3\nq");
//        biblioteca.run();
//
//        assertEquals(expectedMessage, outputConsole());
//    }
//
//    @Test
//     public void testUnavailableBook() throws Exception {
//        String bookUnavailable = " Sorry we don't have that book yet.\n";
//        String expectedMessage = generateExpectedMessage(bookUnavailable);
//
//        biblioteca = bibliotecaWithInput("1\n2\nfafhaj\nq");
//        biblioteca.run();
//
//        assertEquals(expectedMessage , outputConsole());
//    }
//
//    @Test
//    public void testInvalidOption() throws Exception {
//        String invalidOption = " \n\nSelect a valid option!!\n\n>";
//        String expectedMessage = welcome + menu + invalidOption ;
//
//        biblioteca = bibliotecaWithInput("fafhaj\nq");
//        biblioteca.run();
//
//        assertEquals(expectedMessage , outputConsole());
//    }
//
//    public String generateExpectedMessage(String result) {
//        return welcome + menu + " \n\n" + listAllBooks + "\n\n" + menu + reserveABookOption + result + "\n\n" + menu;
//
//    }



    private Biblioteca bibliotecaWithInput(String inputString) {
        inputByte = inputString.getBytes();
        ByteArrayInputStream thisInContent = new ByteArrayInputStream(inputByte);

        return new Biblioteca(new PrintStream(outContent), thisInContent);
    }


}
