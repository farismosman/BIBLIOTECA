class RequestABookCommand implements Command {
    public void execute(Biblioteca biblioteca, Library library) {
        biblioteca.printToScreen("Enter Book Number: ");
        String bookKey = biblioteca.getUserInput();
        String bookStatus = library.requestABook(bookKey);

        biblioteca.printToScreen(bookStatus);
    }
}
