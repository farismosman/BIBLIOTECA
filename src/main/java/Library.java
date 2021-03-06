import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Library {
    public static final String BOOK_ALREADY_RESERVED = "Book has already been reserved by someone else.";
    public static final String BOOK_RESERVED = "Thank you! Enjoy the book.";
    public static final String BOOK_UNAVAILABLE = "Sorry we don't have that book yet.";
    private SortedMap<String, Book> allBooks = new TreeMap<String, Book>();
    private SortedMap<String, Movie> allMovies = new TreeMap<String, Movie>();

    public Library() {
        createAllBooks();
        createAllMovies();
    }

    private void createAllMovies() {
        Movie[] movies = {
                new Movie("1", "Faris1", "Naval1", "Dave1", "N/A"),
                new Movie("2", "Faris2", "Naval2", "Dave2", "2"),
                new Movie("3", "Faris3, Faris2", "Naval3", "Dave3", "3"),
                new Movie("4", "Faris4", "Naval4", "Dave4", "4"),
                new Movie("5", "Faris5", "Naval5, Naval8", "Dave5", "5")
        };
        for (Movie movie : movies) {
            allMovies.put(movie.getId(), movie);
        }
    }

    private void createAllBooks() {
        Book[] books = {
                new Book("1", "Little Red Riding Hood", "Will Smith"),
                new Book("2", "Small Giants", "Bo Burlingham"),
                new Book("3", "The Starfish and the Spider", "Rod Beckstrom, Ori Brafman"),
                new Book("4", "The Whuffie Factor", "Tara Hunt")
        };

        for (Book book : books) {
            allBooks.put(book.getId(), book);
        }

    }

    public SortedMap<String, Book> getAllBooks() {
        return Collections.unmodifiableSortedMap(allBooks);
    }

    public String requestABook(String bookKey) {
        Book theBook = allBooks.get(bookKey);
        if (theBook == null) {
            return BOOK_UNAVAILABLE;
        }
        if (theBook.isReserved()) {
            return BOOK_ALREADY_RESERVED;
        }

        theBook.reserve();
        return BOOK_RESERVED;
    }

    public String allBooksTitles() {
        return StringUtils.join(allBooks.values(), "\n");
    }

    public String allMovieRecords() {
        return StringUtils.join(allMovies.values(), "\n");
    }
}
