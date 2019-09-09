package section14._09_filesystem;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributes {

    public static void main(String[] args) {
        try {
            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1/file1.txt");
            System.out.println("File: " + filePath.toAbsolutePath());
            System.out.println("Size: " + Files.size(filePath));
            System.out.println("Last modified: " + Files.getLastModifiedTime(filePath));

            System.out.println("With the class BasicFileAttributes:");
            BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size: " + attributes.size());
            System.out.println("Last modified: " + attributes.lastModifiedTime());
            System.out.println("Created: " + attributes.creationTime());
            System.out.println("Is directory: " + attributes.isDirectory());
            System.out.println("Is regular file: " + attributes.isRegularFile());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
