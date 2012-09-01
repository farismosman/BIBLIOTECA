import java.util.*;


public class Library {

    private SortedMap<String, Book> allBooks = new TreeMap<String, Book>();
    private final int BOOK_RESERVED = 1;
    private final int BOOK_ALREADY_RESERVED = -1;
    private final int BOOK_UNAVAILABLE = 0;

    public Library() {
        createAllBooks();
    }

    public int getBOOK_RESERVED() {
        return BOOK_RESERVED;
    }

    public int getBOOK_ALREADY_RESERVED() {
        return BOOK_ALREADY_RESERVED;
    }

    public int getBOOK_DOES_NOT_EXIST() {
        return BOOK_UNAVAILABLE;
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
            return BOOK_UNAVAILABLE;
        }
        if (theBook.isReserved()) {
            return BOOK_ALREADY_RESERVED;
        }

        theBook.reserve();
        return BOOK_RESERVED;
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
