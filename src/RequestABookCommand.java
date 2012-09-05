class RequestABookCommand implements Command {
     public void execute(Biblioteca biblioteca, Library library) {
        biblioteca.printToScreen("Enter Book Number: ");
        String bookKey = biblioteca.getUserInput();
        int bookStatus = library.requestABook(bookKey);
        
        if (bookStatus == Library.BOOK_ALREADY_RESERVED) {
            biblioteca.printToScreen("Book has already been reserved by someone else.");
        } else if (bookStatus == Library.BOOK_RESERVED) {
            biblioteca.printToScreen("Thank you! Enjoy the book.");
        } else if (bookStatus == Library.BOOK_UNAVAILABLE) {
            biblioteca.printToScreen("Sorry we don't have that book yet.");
        }
    }
}
