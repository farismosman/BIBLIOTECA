class ListAllMoviesCommand implements Command {
    private Biblioteca biblioteca;
    private Library library;

    public ListAllMoviesCommand(Biblioteca biblioteca, Library library) {
        this.biblioteca = biblioteca;
        this.library = library;
    }

    public void execute() {
        processPrintAllMovies();
    }

    private void printMovieHeader() {
        String formatter = "%-" + Movie.STRING_LENGTH + "s";
        biblioteca.printToScreen(String.format("ID " + formatter + formatter + formatter + "%-1s", "Title", "Actor", "Director", "Rating"));
    }


    private void processPrintAllMovies() {
        printMovieHeader();
        biblioteca.printToScreen(library.allMovieRecords());
    }
}
