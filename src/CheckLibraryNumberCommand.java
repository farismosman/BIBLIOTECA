public class CheckLibraryNumberCommand implements Command {
    public void execute(Biblioteca biblioteca, Library library) {

        String theLibraryNumber;

        if (biblioteca.aUserisLoggedIn()) {
            
            theLibraryNumber = "Your Library Number is: " + biblioteca.currentUserLibraryNumber();
        } else {

            biblioteca.printToScreen("username: ");
            String libraryNumber = biblioteca.getUserInput();

            biblioteca.printToScreen("password: ");
            String password = biblioteca.getUserInput();

            String libraryNUmberFromDataBase = new UsersDataBase(biblioteca).getLibraryNumber(libraryNumber, password);

            if (libraryNUmberFromDataBase == null) {
                theLibraryNumber = "Please talk to a Librarian. Thank You.";
            } else {
                theLibraryNumber = "Your Library Number is: " + libraryNumber;
            }            
        }
        
        biblioteca.printToScreen(theLibraryNumber);
    }
}