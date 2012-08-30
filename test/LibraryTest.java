import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    private Library library = new Library();
    private final int BookReserved = 1;
    private final int BookCanNotBeReserved = -1;
    private final int BookUnavailable = 0;

    @Test
    public void testLibraryConstructor() throws Exception {
        assertEquals(false, library.getAllBooks().isEmpty());

    }

    @Test
    public void testAvailableBook() {
        assertEquals(false, library.getAllBooks().get("1").isReserved());
        assertEquals(BookReserved, library.requestABook("1"));
        assertEquals(true, library.getAllBooks().get("1").isReserved());

    }

    @Test
    public void testUnAvailableBook() {
        library.requestABook("1");
        assertEquals(BookCanNotBeReserved, library.requestABook("1"));
        assertEquals(true, library.getAllBooks().get("1").isReserved());

    }

    @Test
    public void testBookNotExisting(){
        assertEquals(BookUnavailable, library.requestABook("79009u8"));

    }


}
