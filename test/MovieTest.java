import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MovieTest {
    @Test
    public void testMovieConsoleString() throws Exception {
        Movie movie = new Movie("0","Titanic",  "Dicaprio", "James Cameron", "1");
        assertEquals("0- Titanic             Dicaprio            James Cameron       1", movie.toString());
        
    
    }

//    @Test
//    public void testStringFormat() throws Exception {
//
//        String faris0 = "FarisFarisFaris";
//        String faris = "FarisFarisFaris, hgygihiuhui";
//        
////        assertEquals("1 FarisFarisFaris\t Faris", String.format("%d %5s\t Faris",1, faris));
//        System.out.println(String.format("%d %-29s Faris",1, faris0));
//        System.out.println(String.format("%d %-29s Faris",1, faris));
//        
//        
//    }
}
