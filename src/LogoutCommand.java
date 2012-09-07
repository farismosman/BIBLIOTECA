public class LogoutCommand implements Command {
    @Override
    public void execute(Biblioteca biblioteca, Library library) {
        UsersDataBase.logoutCurrentUser();
    }
}
