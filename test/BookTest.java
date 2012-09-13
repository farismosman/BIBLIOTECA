import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void testReserveABook() throws Exception {
        Book book = new Book("0", "title", "author");
        book.reserve();
        assertEquals(true, book.isReserved());
    }


}
