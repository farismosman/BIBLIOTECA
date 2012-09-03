public class Movie {


    public static final String STRING_LENGTH = "20";
    private String key;
    private String title;
    private String actor;
    private String director;
    private String rating;

    public Movie(String key, String title, String actor, String director, String rating) {
        this.key = key;
        this.title = title;
        this.actor = actor;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        String formatter = "%-"+ STRING_LENGTH+ "s";
        return  key + "- " + String.format(formatter+ "%-20s%-20s%-1s", title , actor , director , rating);
    }

    public String getKey() {
        return key;
    }
}
