package section_14._09_filesystem;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileOperations {

    private static Path source;
    private static Path destination;

    public static void main(String[] args) {
        deleteFileDemo();
    }

    private static void copyFileDemo() {
        try {
            source = FileSystems.getDefault().getPath("Examples", "file1.txt");
            destination = FileSystems.getDefault().getPath("Examples", "fileCopy.txt");
            System.out.println("Examples/file1.txt exists? " + Files.exists(source));
            System.out.println("Examples/fileCopy.txt exists? " + Files.exists(destination));

            if (!Files.exists(destination)) {
                System.out.println("Copying...");
                Files.copy(source, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDirDemo() {
        try {
            source = FileSystems.getDefault().getPath("Examples", "Dir1");
            // Copies only the directory without the contained files
            destination = FileSystems.getDefault().getPath("Examples", "Dir4");
            if (Files.exists(destination)) {
                System.out.println("Destination already exists, will be replaced");
            }
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void moveFileDemo() {
        try {
            source = FileSystems.getDefault().getPath("Examples", "fileCopy.txt");
            destination = FileSystems.getDefault().getPath("Examples/Dir4", "fileCopy.txt");
            if (Files.exists(source)) {
                Files.move(source, destination);
            } else {
                System.out.println("Source does not exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void renameFileDemo() {
        try {
            // The source and the destination should be in the same location while renamed
            source = FileSystems.getDefault().getPath("Examples", "Dir4", "fileCopy.txt");
            destination = FileSystems.getDefault().getPath("Examples", "Dir4", "fileCopyRenamed.txt");
            if (Files.exists(source)) {
                Files.move(source, destination);
            } else {
                System.out.println("Source does not exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFileDemo() {
        try {
            source = FileSystems.getDefault().getPath("Examples", "Dir4", "fileCopy.txt");
            Files.deleteIfExists(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
