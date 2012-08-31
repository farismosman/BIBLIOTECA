import java.util.*;


public class Library {

    private SortedMap<String, Book> allBooks = new TreeMap<String, Book>();
    private final int BookReserved = 1;
    private final int BookCanNotBeReserved = -1;
    private final int BookUnavailable = 0;

    public Library() {
        createAllBooks();
    }

    private void createAllBooks() {
        allBooks.put("1", new Book("Little Red Riding Hood", "Will Smith"));
        allBooks.put("2", new Book("Small Giants", "Bo Burlingham"));
        allBooks.put("3", new Book("The Starfish and the Spider", "Rod Beckstrom, Ori Brafman"));
        allBooks.put("4", new Book("The Whuffie Factor", "Tara Hunt"));
    }


    public SortedMap<String, Book> getAllBooks() {
        return Collections.unmodifiableSortedMap(allBooks);
    }

    public int requestABook(String bookKey) {
        Book theBook = allBooks.get(bookKey);
        if (theBook == null) {
            return BookUnavailable;
        }
        if (theBook.isReserved()) {
            return BookCanNotBeReserved;
        }

        theBook.reserve();
        return BookReserved;
    }

    public String allBooksTitles() {
        String allBookTitle = "";
        for (String bookKey : allBooks.keySet()) {
            Book book = allBooks.get(bookKey);
            allBookTitle += book.consoleString(bookKey) + "\n";
        }

        return allBookTitle;
    }

}
