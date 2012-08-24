
import java.io.*;

public class Biblioteca {

    private PrintStream printStream;

    public Biblioteca(PrintStream printStream){
        this.printStream = printStream;
    }

    public void run(){
        String welcomeMessage = "Welcome to the Bangalore Public Library System!!";
        String Option1Message =  "To view a list all the books in the library, type 1";
        String Option2Message =  "To reserve a book, type 2";

        printToScreen(welcomeMessage + "\n" + Option1Message + "\n" + Option2Message + "\n");

    }

    public void printToScreen(String message){
        printStream.println(message);
    }

    public void printAllBooks(String filename){
        String fileContent = readAFile(filename);
        printToScreen(fileContent);
    }

    public String readAFile(String filename) {
        File asFile = new File(filename);
        String fileContentString = "";

        try{
            BufferedReader input;
            input = new BufferedReader(new FileReader(asFile));

            fileContentString = readLineToString(input);

        } catch (IOException e){
            System.out.println("File " + filename + " not Found!!");
            e.printStackTrace();
        }

        return fileContentString;
    }

    public String readLineToString( BufferedReader input) {
        StringBuilder fileContent = new StringBuilder();

        try {
            String line = null;

            while ((line = input.readLine() ) != null){
                fileContent.append(line + "\n");
            }
       } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }


    ///////////////////////////////////////// MAIN ///////////////////////////////////////////////////



    public static void main(String[] args) {

        Biblioteca welcome = new Biblioteca(System.out);
        welcome.run();
        welcome.printAllBooks("/Users/Farism/thoughtworks/training/twu_assignment/biblioteca/src/ListOfBooks.txt");
    }

}

