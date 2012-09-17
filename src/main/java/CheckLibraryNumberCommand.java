public class CheckLibraryNumberCommand implements Command {
    public void execute(Biblioteca biblioteca, Library library) {
        if (biblioteca.getCurrentUser() != null) {
            biblioteca.printToScreen("Your library number is " + biblioteca.getCurrentUser().getLibraryNumber() + ".");
        } else {
            biblioteca.printToScreen("Talk to a librarian.");
        }
    }
}