public class ListAllBookCommand implements Command {
    public void execute(Biblioteca biblioteca, Library library) {
        biblioteca.printToScreen("");
        biblioteca.printToScreen(library.allBooksTitles());
    }
}
