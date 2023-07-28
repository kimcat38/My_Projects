import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destinationPath = "destination.txt";

        try {
            CopyFile.CopyFiles(sourcePath, destinationPath);
            System.out.println("File copied successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
    }
}
