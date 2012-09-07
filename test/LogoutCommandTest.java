import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNull;

public class LogoutCommandTest {


    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca bibliotecaInput(String inputString) {
        ByteArrayInputStream thisInContent = new ByteArrayInputStream(inputString.getBytes());
        return new Biblioteca(new PrintStream(outContent), thisInContent);
    }



    @Test
    public void testLogoutCommand() throws Exception {
        Biblioteca biblioteca = bibliotecaInput("logout");
        Library library = new Library();
        
        new LogoutCommand().execute(biblioteca, library);
        
        assertNull(UsersDataBase.getCurrentLibraryNumber());
//        assertEquals("You are logged out successfully", outContent.toString().trim());
    }
}
