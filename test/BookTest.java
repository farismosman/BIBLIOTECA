import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;


public class BookTest {

    @Test
    public void testReserveABook() throws Exception {
        Book book = new Book("title", "author");
        book.reserve();
        assertEquals(true, book.isReserved());
    }


}
