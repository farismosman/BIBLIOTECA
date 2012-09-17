import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class BibliotecaTestDouble extends Biblioteca {
    private OutputStream out;

    public BibliotecaTestDouble(String input) {
        this(input, new ByteArrayOutputStream());
    }

    private BibliotecaTestDouble(String input, OutputStream out) {
        super(new PrintStream(out), new ByteArrayInputStream(input.getBytes()));
        this.out = out;
    }

    public String consoleOutput() {
        return out.toString().trim();
    }
}
