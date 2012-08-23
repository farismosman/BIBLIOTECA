import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;



public class WelcomeScreenTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void main(){
        String expectedGreetingMessage = "Welcome to the Bangalore Public Library System!!";
        WelcomeScreen ws = new WelcomeScreen(outContent);
        ws.printMessage(expectedGreetingMessage);
        assertEquals("welcome not printing", expectedGreetingMessage, outContent.toString().trim());

    }

}
