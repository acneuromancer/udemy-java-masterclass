package section14._09_filesystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFile {

    public static void main(String[] args) {
        try {
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file path: " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
