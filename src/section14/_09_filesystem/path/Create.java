package section14._09_filesystem.path;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Create {

    public static void createFile() {
        try {
            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
            Files.createFile(fileToCreate);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createDir() {
        try {
            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
            Files.createDirectory(dirToCreate);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createDirs() {
        try {
            Path dirsToCreate = FileSystems.getDefault().getPath("Examples", "Dir2/Dir3/Dir4/Dir5/Dir6/Dir7");
            Files.createDirectories(dirsToCreate);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createDirs();
    }

}
