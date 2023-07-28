import java.io.FileNotFoundException;

public class TestWriting {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "testWritingNames.txt";
        String[] names = {"jane", "john", "janet"};

        WriteToFile.writeNames(fileName, names);
    }
}
