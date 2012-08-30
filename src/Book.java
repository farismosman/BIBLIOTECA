public class Book {

    private String title;
    private String author;
    private boolean reserved = false;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void reserve(){
        reserved = true;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String consoleString(String bookKey) {
        return bookKey + "- " + title + ", " + author;
    }
}
