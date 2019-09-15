package section14._09_filesystem;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IoNioMapping {

    public static void main(String[] args) {
        printContentsWithListFiles();
    }

    public static void convertFileToPath() {
        File file = new File("/Examples/file1.txt");
        Path convertedPath = file.toPath();
        System.out.println("file = " + file);
        System.out.println("convertedPath = " + convertedPath);
    }

    public static void resolvingWithFile() {
        File parent = new File("/Examples");
        File resolvedFile = new File(parent, "Dir1/file1.txt");
        System.out.println("parent = " + parent);
        System.out.println("resolvedFile = " + resolvedFile);
        System.out.println("resolvedFile converted to  Path = " + resolvedFile.toPath());
    }

    public static void resolvingWithPath() {
        Path parentPath = Paths.get("/Examples");
        Path childRelativePath = Paths.get("Dir1/file1.txt");
        System.out.println("parentPath = " + parentPath);
        System.out.println("childRelativePath = " + childRelativePath);
        System.out.println("parentPath.resolve(childRelativePath) = " + parentPath.resolve(childRelativePath));
    }

    public static void gettingWorkingDirectory() {
        System.out.print("Getting working directory with the File class: ");
        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println(workingDirectory);
    }

    public static void printContentsWithList() {
        System.out.println("Print Dir4 contents using list():");
        File workingDirectory = new File("").getAbsoluteFile();
        File dir4File = new File(workingDirectory, "Examples/Dir4");

        String[] dir4Contents = dir4File.list();
        for (int i = 0; i < dir4Contents.length; i++) {
            System.out.println(i + ": " + dir4Contents[i]);
        }
    }

    public static void printContentsWithListFiles() {
        System.out.println("Print Dir4 contents using listFiles():");
        File workingDirectory = new File("").getAbsoluteFile();
        File dir4File = new File(workingDirectory, "Examples/Dir4");

        File[] dir4Files = dir4File.listFiles();
        for (int i = 0; i < dir4Files.length; i++) {
            System.out.println(i + ": " + dir4Files[i].getName());
        }
    }

}
