import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsersDataBaseTest {
    @Test
    public void testMyLibraryNumber() throws Exception {
        String libraryNumber = "111-1111";
        String password = "password_0";
        assertEquals("Your Library Number is: " + libraryNumber + ", to logout type logout.", new UsersDataBase().getLibraryNumber(libraryNumber, password));
    }

    @Test
    public void testMyLibraryNumberWithWrongPassword() throws Exception {
        String libraryNumber = "111-1111";
        String password = "wrong_password";
        assertEquals("Please talk to a Librarian. Thank You.", new UsersDataBase().getLibraryNumber(libraryNumber, password));
    }


    @Test
    public void testMyLibraryNumberWithWrongUsername() throws Exception {
        String libraryNumber = "wrong_username";
        String password = "password_0";
        assertEquals("Please talk to a Librarian. Thank You.", new UsersDataBase().getLibraryNumber(libraryNumber, password));
    }
}
