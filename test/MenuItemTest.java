import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MenuItemTest {
    @Test
    public void testTestToString() throws Exception {
       assertEquals("To view a list all the books in the library, type 1", MenuItem.LIST_ALL_BOOKS.toString());
    }

    @Test
    public void testGetFromCode() throws Exception {
        assertEquals(MenuItem.LIST_ALL_BOOKS, MenuItem.getFromCode("1"));
        assertEquals(MenuItem.RESERVE_A_BOOK, MenuItem.getFromCode("2"));
        assertEquals(MenuItem.CHECK_LIBRARY_NUMBER, MenuItem.getFromCode("3"));
        assertEquals(MenuItem.LIST_ALL_MOVIES, MenuItem.getFromCode("4"));
    }
}
