import java.io.IOException;
import java.io.OutputStream;

public class PrintMessage {

    private OutputStream os;

    public PrintMessage(OutputStream os) {
        this.os = os;
    }

    public void printMessageOnScreen(String message) {
        message = message + "\n";
        try {
            os.write(message.getBytes());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
