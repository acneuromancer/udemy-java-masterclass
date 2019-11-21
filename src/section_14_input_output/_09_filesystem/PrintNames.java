package section_14_input_output._09_filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintNames extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + e.getMessage());
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        System.out.println("Walking tree for Dir1");
        Path dir1Path = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir1");
        try {
            Files.walkFileTree(dir1Path, new PrintNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
