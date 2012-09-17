import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RequestABookCommandTest {

    private static final String RESERVE_A_BOOK_MESSAGE = "Enter Book Number: \n>";
    private static final String BOOK_RESERVED_MESSAGE = " Thank you! Enjoy the book.";
    private static final String BOOK_ALREADY_RESERVED = " Book has already been reserved by someone else.";
    String aBookNumber = "4";


    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream outContentStream = new PrintStream(outContent);
    ByteArrayInputStream inContentStream = new ByteArrayInputStream(aBookNumber.getBytes());
    Biblioteca biblioteca = new Biblioteca(outContentStream, inContentStream);

    @Test
    public void testProcessRequestABook() throws Exception {
        biblioteca.processUserChoice(MenuItem.RESERVE_A_BOOK.getId());

        assertEquals(RESERVE_A_BOOK_MESSAGE + BOOK_RESERVED_MESSAGE, outContent.toString().trim());

    }

    @Test
    public void testProcessRequestABookTwice() throws Exception {

        Library library = new Library();
        library.getAllBooks().get(aBookNumber).reserve();

        new RequestABookCommand().execute(biblioteca, library);

        assertEquals(RESERVE_A_BOOK_MESSAGE + BOOK_ALREADY_RESERVED, outContent.toString().trim());

    }

}
