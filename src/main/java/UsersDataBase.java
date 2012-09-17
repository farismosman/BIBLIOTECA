import java.util.HashMap;
import java.util.Map;

public class UsersDataBase {
    public static final int USER_DATA_BASE_SIZE = 10;
    private Map<String, User> userDataBase = new HashMap<String, User>();
    private static String currentLibraryNumber = null;

    public UsersDataBase() {
        createUserDataBase();
    }

    private void createUserDataBase() {
        int baseLibraryNumber = 1111;

        for (int i = 0; i < USER_DATA_BASE_SIZE; i++) {
            String libraryNumber = "111-" + String.valueOf(baseLibraryNumber + i);
            String password = "password_" + String.valueOf(i);
            userDataBase.put(libraryNumber, new User(libraryNumber, password));
        }
    }

    public String getLibraryNumber(String libraryNumber, String password) {
        User theUser = userDataBase.get(libraryNumber);

        if (theUser != null && theUser.login(libraryNumber, password)) {
            currentLibraryNumber = libraryNumber;
            return "Your Library Number is: " + libraryNumber + ", to logout type logout.";
        }

        return "Please talk to a Librarian. Thank You.";
    }

    public static String getCurrentLibraryNumber() {
        return currentLibraryNumber;
    }

    public static void logoutCurrentUser() {
        currentLibraryNumber = null;
    }
}
