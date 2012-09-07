import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Biblioteca biblioteca = bibliotecaSetOptions("1");

   
    
    private final String PRINT_ALL_BOOKS = MenuItem.LIST_ALL_BOOKS.getId();
    private final String REQUEST_A_BOOK = MenuItem.RESERVE_A_BOOK.getId();
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
                "To check your library number, type 3\n" +
                "To view movie records, type 4";
        biblioteca.printMenu();
        assertEquals(message, outputConsole());
    }

  


    /////////////////////////////// user input functionality /////////////////////////////////////

    @Test
    public void testUserInput() {
        biblioteca = bibliotecaSetOptions("some text sent through input injection");

        assertEquals("some text sent through input injection", biblioteca.getUserInput());
    }

    @Test
    public void testUserInptIsLowerCased() {
        biblioteca = bibliotecaSetOptions("Q");

        assertEquals("q", biblioteca.getUserInput());
    }
    
    

    ////////////////////////////////////// test process User choices /////////////////////////

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

    @Test
    public void testProcessLogout() throws Exception {
        biblioteca.processUserChoice("logout");

        assertEquals("You are logged out successfully.", outputConsole());

    }

    //////////////////////// Functional test //////////////////////////////////////

    @Test
    public void testBibliotecaMain() throws Exception {
        String expectedMessage = expectedOutputOfPrintAllBooksAndReserveABook("test/printAllBooksAndReserveABookOutputMessage.txt");
        String aBookNumber = "3";

        biblioteca = bibliotecaSetOptions(PRINT_ALL_BOOKS + AND + REQUEST_A_BOOK + AND + aBookNumber + AND + QUIT);
        biblioteca.run();

        assertEquals(expectedMessage, outputConsole());
    }



    private String expectedOutputOfPrintAllBooksAndReserveABook(String filename) {
        File file = new File(filename);

        String expectedMessage = "";
        try
        {
            expectedMessage = FileUtils.readFileToString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expectedMessage;
    }


}
