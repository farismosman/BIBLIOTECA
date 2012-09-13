import java.text.MessageFormat;

public class Movie {


    private static final int LENGTH = 20;
    public static final String FORMAT = MessageFormat.format("%s%-{0}s%-{0}s%-{0}s%-1s", LENGTH);
    private String id;
    private String title;
    private String actor;
    private String director;
    private String rating;

    public Movie(String id, String title, String actor, String director, String rating) {
        this.id = id;
        this.title = title;
        this.actor = actor;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, id + "- ", title, actor, director, rating);
    }

    public String getId() {
        return id;
    }
}
