public class Movie {


    public static final String STRING_LENGTH = "20";
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
        String formatter = "%-"+ STRING_LENGTH+ "s";
        return  id + "- " + String.format(formatter+ "%-20s%-20s%-1s", title , actor , director , rating);
    }

    public String getId() {
        return id;
    }
}
