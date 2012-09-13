import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BibliotecaTest {

    BibliotecaTestDouble biblioteca = new BibliotecaTestDouble("sometext");

    private final String PRINT_ALL_BOOKS = MenuItem.LIST_ALL_BOOKS.getId();
    private final String REQUEST_A_BOOK = MenuItem.RESERVE_A_BOOK.getId();
    private final String QUIT = "q";
    private final String AND = "\n";

    /////////////////////////////// print MENU functionality ///////////////////////////////////
    @Test
    public void testPrintWelcomeMessage() {        
        String message = "Welcome to the Bangalore Public Library System!!";
        biblioteca.printWelcomeMessage();
        assertEquals(message, biblioteca.consoleOutput());
    }

    @Test
    public void testPrintAllBooksMenu() {
        String message = "To view a list all the books in the library, type 1\n" +
                "To reserve a book, type 2\n" +
                "To check your library number, type 3\n" +
                "To view movie records, type 4";
        biblioteca.printMenu();
        assertEquals(message, biblioteca.consoleOutput());
    }

  


    /////////////////////////////// user input functionality /////////////////////////////////////

    @Test
    public void testUserInput() {
        biblioteca = new BibliotecaTestDouble("some text sent through input injection");

        assertEquals("some text sent through input injection", biblioteca.getUserInput());
    }

    @Test
    public void testUserInptIsLowerCased() {
        biblioteca = new BibliotecaTestDouble("Q");

        assertEquals("q", biblioteca.getUserInput());
    }
    
    

    ////////////////////////////////////// test process User choices /////////////////////////

    @Test
    public void testProcessInvalidOption() throws Exception {
        biblioteca.processUserChoice("unknown command");

        assertEquals("Select a valid option!!", biblioteca.consoleOutput());

    }

    @Test
    public void testProcessQuit() throws Exception {
        biblioteca.processUserChoice("q");

        assertEquals(true, biblioteca.isQuit());

    }

    @Test
    public void testProcessLogout() throws Exception {
        biblioteca.processUserChoice("logout");

        assertEquals("You are logged out successfully.", biblioteca.consoleOutput());

    }

    @Test
    public void testGetCurrentUserReturnsNullIfNoOneIsLoggedIn() throws Exception {
        assertNull(biblioteca.getCurrentUser());
    }

    @Test
    public void testGetCurrentUserReturnsLoggedInUser() throws Exception {
        User loggedInUser = new User("111-1111", "password_0");
        biblioteca.setCurrentUser(loggedInUser);
        
        assertEquals(loggedInUser, biblioteca.getCurrentUser());

    }
    
    
   // to test that there is a current user logged in, if you choose to print your library number, it will print it.
    
    
    @Test
    public void testIfAUserIsLoggedInAndYouChooseToPrintOutTheLibraryNumberItWillPrintTheLibraryNumber() throws Exception {
        User loggedInUser = new User("111-1111", "password_0");
        biblioteca.setCurrentUser(loggedInUser);
        
        biblioteca.processUserChoice("3");
        
        assertEquals("Your library number is 111-1111.", biblioteca.consoleOutput());
        
    }

    @Test
    public void testIfNoUserIsLoggedInAndYouChooseToPrintLibraryNumberItWillSayTalkToALibrarian() throws Exception {
      biblioteca.setCurrentUser(null);
        
      biblioteca.processUserChoice("3");
        
      assertEquals("Talk to a librarian.", biblioteca.consoleOutput());  
    }


    //////////////////////// Functional test //////////////////////////////////////

    @Test
    public void testBibliotecaMain() throws Exception {
        String expectedMessage = expectedOutputOfPrintAllBooksAndReserveABook("test/printAllBooksAndReserveABookOutputMessage.txt");
        String aBookNumber = "3";

        biblioteca = new BibliotecaTestDouble(PRINT_ALL_BOOKS + AND + REQUEST_A_BOOK + AND + aBookNumber + AND + QUIT);
        biblioteca.run();

        assertEquals(expectedMessage, biblioteca.consoleOutput());
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
