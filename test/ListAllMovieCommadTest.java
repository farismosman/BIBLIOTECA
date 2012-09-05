import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ListAllMovieCommadTest {


    private final String ALL_MOVIES = "ID Title               Actor               Director            Rating\n" +
            "1- Faris1              Naval1              Dave1               N/A\n" +
            "2- Faris2              Naval2              Dave2               2\n" +
            "3- Faris3, Faris2      Naval3              Dave3               3\n" +
            "4- Faris4              Naval4              Dave4               4\n" +
            "5- Faris5              Naval5, Naval8      Dave5               5";

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream outContentStream = new PrintStream(outContent);
    ByteArrayInputStream inContentStream = new ByteArrayInputStream("someInputString".getBytes());
    Biblioteca biblioteca = new Biblioteca(outContentStream, inContentStream);

    @Test
    public void testProcessPrintAllMovies() throws Exception {
        biblioteca.processUserChoice(MenuItem.LIST_ALL_MOVIES.getId());

        assertEquals(ALL_MOVIES, outContent.toString().trim());
    }
}
