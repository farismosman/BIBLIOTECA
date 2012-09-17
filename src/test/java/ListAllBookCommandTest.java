import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ListAllBookCommandTest {

    private static final String ALL_BOOKS = "1- Little Red Riding Hood, Will Smith\n" +
            "2- Small Giants, Bo Burlingham\n" +
            "3- The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
            "4- The Whuffie Factor, Tara Hunt";

    @Test
    public void testProcessPrintAllBooks() throws Exception {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream outContentStream = new PrintStream(outContent);
        ByteArrayInputStream inContentStream = new ByteArrayInputStream("someInputString".getBytes());
        Biblioteca biblioteca = new Biblioteca(outContentStream, inContentStream);

        biblioteca.processUserChoice(MenuItem.LIST_ALL_BOOKS.getId());

        assertEquals(ALL_BOOKS, outContent.toString().trim());
    }


}
