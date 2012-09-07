import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UserTest {

    private String libraryNumber;
    private String password; 

    @Test
    public void testLogin() throws Exception {

        libraryNumber = "111-1111";
        password = "password";
        User user = new User(libraryNumber, password);       
        
        assertEquals(false, user.login("wrongLibraryNumber", password));    
        assertEquals(false, user.login(libraryNumber, "wrong_password"));
        assertEquals(false, user.login("wrongLibrary_Number", "wrong_password"));
        assertEquals(true, user.login(libraryNumber, password));

    }

    @Test
    public void testLogout() throws Exception {

        libraryNumber = "111-1111";
        password = "password";
        User user = new User(libraryNumber, password);
        user.login(libraryNumber, password);
        
        assertEquals(false, user.logout());

    }
    
}
