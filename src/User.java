public class User {
    private boolean userStatus = false;
    private final String libraryNumber;
    private final String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean isLoggedIn() {
        return userStatus;
    }

    public void changeUserStatus() {
          userStatus = !userStatus;
    }

    public void login(String libraryNumber, String password) {
        if (libraryNumber.equals(this.libraryNumber) && password.equals(this.password)){
            changeUserStatus();
        }
    }
}
