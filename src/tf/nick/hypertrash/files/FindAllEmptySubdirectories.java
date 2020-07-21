package tf.nick.hypertrash.files;

import java.io.File;
import java.nio.file.Paths;

public class FindAllEmptySubdirectories {
    public static void main(String[] args) {
        System.out.println("Where should i look?");
        String userDirName = new java.util.Scanner(System.in).nextLine();
        File baseDir = new File(String.valueOf
                (Paths.get(System.getProperty("user.dir"), userDirName)));
        String baseDirName = baseDir.getName();
        File[] childrenOfBaseDir = baseDir.listFiles();

        if (childrenOfBaseDir != null) {
            System.out.printf("Found the following empty directories inside %s:\n",
                    baseDirName);
            iterateOverDirContents(childrenOfBaseDir);
        } else {
            pinpointError(baseDir, baseDirName);
        }
    }

    private static void iterateOverDirContents(File[] contents) {
        for (File child : contents) {
            if (child.isDirectory()) {
                File[] childContents = child.listFiles();
                if (childContents == null) {
                    printError(child.getName());
                    return;
                }

                if (childContents.length == 0) {
                    System.out.print(child.getName() + " ");
                } else {
                    iterateOverDirContents(childContents);
                }
            }
        }
    }

    private static void pinpointError(File baseDir, String baseDirName) {
        if (baseDir.isDirectory()) {
            printError(baseDirName);
        } else if (baseDir.isFile()){
            System.out.println(baseDirName + " is not a directory. It's a file");
        } else {
            System.out.printf("Could not find the directory '%s'. Is this the right path?\n",
                    baseDirName);
            System.out.println(baseDir.getAbsolutePath());
        }
    }

    private static void printError(String dirName) {
        System.out.println("Cannot read the directory " + dirName);
    }
}
