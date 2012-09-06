public class CheckLibraryNumberCommand implements Command {    
    public void execute(Biblioteca biblioteca, Library library) {
        biblioteca.printToScreen("username: ");
        String libraryNumber = biblioteca.getUserInput();

        biblioteca.printToScreen("password: ");
        String password = biblioteca.getUserInput();

        String libraryNUmberFromDataBase = new UsersDataBase().getLibraryNumber(libraryNumber, password);
        
        if (libraryNUmberFromDataBase == null){                
            biblioteca.printToScreen("Please talk to a Librarian. Thank You.");
        } else {
            biblioteca.printToScreen("Your Library Number is: " + libraryNumber );
        }
    }
}