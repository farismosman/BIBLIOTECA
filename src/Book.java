public class Book {

    private String id;
    private String title;
    private String author;
    private boolean reserved = false;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void reserve(){
        reserved = true;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return id + "- " + title + ", " + author;
    }
}
