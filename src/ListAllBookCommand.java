public class ListAllBookCommand implements Command {

    private final Biblioteca biblioteca;
    private final Library library;

    public ListAllBookCommand(Biblioteca biblioteca, Library library) {

        this.biblioteca = biblioteca;
        this.library = library;
    }

    public void execute() {
        biblioteca.printToScreen("");
        biblioteca.printToScreen(library.allBooksTitles());
    }
}
