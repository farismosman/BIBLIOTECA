import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    private Library library = new Library();

    private final String listAllBooks = "1- Little Red Riding Hood, Will Smith\n" +
            "2- Small Giants, Bo Burlingham\n" +
            "3- The Starfish and the Spider, Rod Beckstrom, Ori Brafman\n" +
            "4- The Whuffie Factor, Tara Hunt\n";


    private final String allMovies ="1- Faris1              Naval1              Dave1               N/A\n" +
                                    "2- Faris2              Naval2              Dave2               2\n" +
                                    "3- Faris3, Faris2      Naval3              Dave3               3\n" +
                                    "4- Faris4              Naval4              Dave4               4\n" +
                                    "5- Faris5              Naval5, Naval8      Dave5               5";
                            
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
        assertEquals(Library.BOOK_RESERVED, library.requestABook("1"));
        assertEquals(true, library.getAllBooks().get("1").isReserved());

    }

    @Test
    public void testUnAvailableBook() {
        library.requestABook("1");
        assertEquals(Library.BOOK_ALREADY_RESERVED, library.requestABook("1"));
        assertEquals(true, library.getAllBooks().get("1").isReserved());

    }

    @Test
    public void testBookNotExisting(){
        assertEquals(Library.BOOK_UNAVAILABLE, library.requestABook("79009u8"));

    }

    @Test
    public void testListAllMovies() throws Exception {
        assertEquals(allMovies, library.allMovieRecords());

    }
}
