package section14._09_filesystem.path;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) {
        // Search for the file in the working directory (the Idea project directory)
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        // Search for the file in the files subdirectory in the working directory
        path = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
        System.out.println("--------------------------\n");
        printFile(path);

        // Defining the location of the file in the filesystem with its absolute path (started from the root node)
        path = Paths.get("/home/xxxx/OutThere.txt");
        System.out.println("--------------------------\n");
        printFile(path);
    }


    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)){
            String line;

            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
