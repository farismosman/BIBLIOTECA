import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CheckLibraryNumberCommandTest {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream outContentStream = new PrintStream(outContent);
    ByteArrayInputStream inContentStream = new ByteArrayInputStream("someInputString".getBytes());
    Biblioteca biblioteca = new Biblioteca(outContentStream, inContentStream);


    @Test
    public void testProcessCheckUserLibraryNumber() throws Exception {
        biblioteca.processUserChoice(MenuItem.CHECK_LIBRARY_NUMBER.getId());

        assertEquals("Please talk to a Librarian. Thank You.", outContent.toString().trim());

    }
}
