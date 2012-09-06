import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UserTest {

    private String libraryNumber;
    private String password;

    @Test
    public void testIsLoggedIn() throws Exception {
        assertEquals(false, new User("someLibraryNumber","somePassword").isLoggedIn());
    }

    @Test
    public void testLoggin() throws Exception {

        libraryNumber = "111-1111";
        password = "password";
        User user = new User(libraryNumber, password);
        
        user.login("wrongLibraryNumber", password);
        assertEquals(false, user.isLoggedIn());

        user.login(libraryNumber, "wrong_password");
        assertEquals(false, user.isLoggedIn());

        user.login("wrongLibrary_Number", "wrong_password");
        assertEquals(false, user.isLoggedIn());


        user.login(libraryNumber, password);
        assertEquals(true, user.isLoggedIn());

    }
    
    
    
}
