package section14._09_filesystem;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileStoreDemo {

    public static void main(String[] args) {
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println("Volume name / drive: " + store);
            System.out.println("File store: " + store.name());
        }

        System.out.println("--------------");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootPaths) {
            System.out.println(path);
        }
    }

}
