import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CheckLibraryNumberCommandTest {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final  String libraryNumber = "111-1111";
    private final String loginMessages = "username: \n> password: \n> ";
    private final String then = "\n";

    private Biblioteca bibliotecaInput(String inputString) {
        ByteArrayInputStream thisInContent = new ByteArrayInputStream(inputString.getBytes());
        return new Biblioteca(new PrintStream(outContent), thisInContent);
    }

    @Test
    public void testProcessCheckUserLibraryNumberWithWrongPassword() throws Exception {

        String password = "wrong_password";

        Biblioteca biblioteca = bibliotecaInput(libraryNumber + then + password);

        biblioteca.processUserChoice(MenuItem.CHECK_LIBRARY_NUMBER.getId());
        String expectedMessages = loginMessages + "Please talk to a Librarian. Thank You.";

        assertEquals(expectedMessages, outContent.toString().trim());

    }
    
    @Test
    public void testProcessCheckUserLibraryNumber() throws Exception {        
        
        String password = "password_0";
        
        Biblioteca biblioteca = bibliotecaInput(libraryNumber + then + password);        
        
        biblioteca.processUserChoice(MenuItem.CHECK_LIBRARY_NUMBER.getId());        
        
        String expectedMessages = loginMessages + "Your Library Number is: " + libraryNumber + ", to logout type logout.";  

        assertEquals(expectedMessages, outContent.toString().trim());

    }

  

    
}
