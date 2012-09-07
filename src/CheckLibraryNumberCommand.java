public class CheckLibraryNumberCommand implements Command {
    public void execute(Biblioteca biblioteca, Library library) {

        String theLibraryNumber;

        if (UsersDataBase.getCurrentLibraryNumber() != null) {
            theLibraryNumber = "Your Library Number is: " + UsersDataBase.getCurrentLibraryNumber() + ", to logout type logout.";
            
        } else {
            String libraryNumber = biblioteca.loginDetails("username: ");
            String password = biblioteca.loginDetails("password: ");
            theLibraryNumber = new UsersDataBase().getLibraryNumber(libraryNumber, password);           
        }
        
        biblioteca.printToScreen(theLibraryNumber);
    }
   
}