public class CheckLibraryNumberCommand implements Command {    
    public void execute(Biblioteca biblioteca, Library library) {      
        biblioteca.printToScreen("Please talk to a Librarian. Thank You.");
    }
}