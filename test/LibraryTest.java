import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    private Library library = new Library();
    private final int BookIsAvailable = 0;
    private final int BookIsUnAvailable = 1;
    private final int InvalidOption = -1;

    @Test
    public void testAllBooksMap()  {
        assertEquals(BookIsAvailable, library.getAllBooks().get(1));
        assertEquals(BookIsAvailable, library.getAllBooks().get(2));
        assertEquals(BookIsAvailable, library.getAllBooks().get(3));
        assertEquals(BookIsAvailable, library.getAllBooks().get(4));
    }

    @Test
    public void testAvailableBook() {
        library.requestABook(1);
        assertEquals(BookIsUnAvailable, library.getAllBooks().get(1));

    }

    @Test
    public void testUnAvailableBook() {
        library.requestABook(1);
        assertEquals(InvalidOption, library.requestABook(1));
        assertEquals(BookIsUnAvailable, library.getAllBooks().get(1));

    }

    @Test
    public void testBookNotExisting(){
        assertEquals(InvalidOption, library.requestABook(7));

    }


}
