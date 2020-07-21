package tf.nick.hypertrash.files;

import java.io.File;
import java.util.Objects;


public class FindDirWithMostFiles {
    private static int maxFiles;
    private static String dirNameWithMaxFiles;

    public static void main(String[] args) {
        maxFiles = 0;
        dirNameWithMaxFiles = "";
        File f = new File(System.getProperty("user.dir"), "countFiles");
        doStuff(Objects.requireNonNull(f.listFiles()), f.getName());
        System.out.println(dirNameWithMaxFiles + " " + maxFiles);
    }

    private static void doStuff(File[] contents, String dirName) {
        int filesInside = 0;
        for (File f : contents) {
            if (f.isDirectory()) {
                doStuff(Objects.requireNonNull(f.listFiles()), f.getName());
            } else if (f.isFile()) {
                filesInside++;
            }
        }

        if (filesInside > maxFiles) {
            maxFiles = filesInside;
            dirNameWithMaxFiles = dirName;
        }
    }
}
