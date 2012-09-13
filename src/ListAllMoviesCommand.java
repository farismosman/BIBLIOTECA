class ListAllMoviesCommand implements Command {
    public void execute(Biblioteca biblioteca, Library library) {
        String header = String.format(Movie.FORMAT, "ID ", "Title", "Actor", "Director", "Rating");
        biblioteca.printToScreen(header);
        biblioteca.printToScreen(library.allMovieRecords());

    }

}
