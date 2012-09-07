public class User {
    private boolean userStatus = false;
    private final String libraryNumber;
    private final String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean login(String libraryNumber, String password) {
        if (libraryNumber.equals(this.libraryNumber) && password.equals(this.password)) {
            userStatus = true;
        }
        return userStatus;
    }

    public boolean logout() {
        userStatus = false;
        UsersDataBase.logoutCurrentUser();
        return userStatus;
    }
}
