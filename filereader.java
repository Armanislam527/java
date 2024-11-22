
import java.nio.file.Files;
import java.nio.file.Paths;

public class filereader {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java filereader <filaname>");
        }
        String file = args[0];
        try {
            String content = new String(Files.readAllBytes(Paths.get(file)));
            System.err.println("File Content: " + content);
        } catch (Exception e) {
            System.err.println("Error reading the file:" + e.getMessage());
        }
    }
}
