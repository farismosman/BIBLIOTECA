public class CheckLibraryNumberCommand implements Command {

    private Biblioteca biblioteca;

    public CheckLibraryNumberCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void execute() {      
        biblioteca.printToScreen("Please talk to a Librarian. Thank You.");
    }
}