package section_14_input_output._09_filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Separators {

    public static void main(String[] args) {
        String separator = File.separator;
        System.out.println("Separator: " + separator);

        separator = FileSystems.getDefault().getSeparator();
        System.out.println("Separator: " + separator);

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path path) throws IOException {
                return Files.isRegularFile(path);
            }
        };

        Path directory = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir1");

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
    }

}
