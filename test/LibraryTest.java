import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    private Library library = new Library();

    private final String listAllBooks = "1- Little Red Riding Hood, Will Smith\n" +
            "2- Small Giants, Bo Burlingham\n" +
            "3- The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
            "4- The Whuffie Factor, Tara Hunt\n";


    @Test
    public void testListAllBooks() throws Exception {
        assertEquals(listAllBooks, library.allBooksTitles());
    }

    @Test
    public void testLibraryConstructor() throws Exception {
        assertEquals(false, library.getAllBooks().isEmpty());

    }

    @Test
    public void testAvailableBook() {
        assertEquals(false, library.getAllBooks().get("1").isReserved());
        assertEquals(library.getBOOK_RESERVED(), library.requestABook("1"));
        assertEquals(true, library.getAllBooks().get("1").isReserved());

    }

    @Test
    public void testUnAvailableBook() {
        library.requestABook("1");
        assertEquals(library.getBOOK_ALREADY_RESERVED(), library.requestABook("1"));
        assertEquals(true, library.getAllBooks().get("1").isReserved());

    }

    @Test
    public void testBookNotExisting(){
        assertEquals(library.getBOOK_DOES_NOT_EXIST(), library.requestABook("79009u8"));

    }


}
