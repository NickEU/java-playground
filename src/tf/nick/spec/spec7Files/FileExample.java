package tf.nick.spec.spec7Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileExample {
  public static void main(String[] args) {
    String fileName = "test.txt";
    File projectDir = new File(System.getProperty("user.dir"));
    printDirContents(projectDir);

    printDirUsingStreams(projectDir);

    List<String> fileContents = readEverythingAtOnce(fileName);
    System.out.println("\n3) Reading all the lines from a file in one go: ");
    fileContents.forEach(System.out::println);
  }

  private static void printDirUsingStreams(File projectDir) {
    try {
      System.out.println("2) Listing dir content using streams(java.nio): ");
      Files.newDirectoryStream(projectDir.toPath()).forEach(System.out::println);
    }
    catch(IOException ex) {
      System.out.println(ex.toString());
    }
  }

  private static void printDirContents(File projectDir) {
    File[] projectDirContents = projectDir.listFiles();
    if (projectDirContents == null) {
      return;
    }

    System.out.println("1) ls: Iterating over an array of pathnames: ");

    StringBuilder files = new StringBuilder();
    StringBuilder dirs = new StringBuilder();

    String strFormatTemplate = "%-45s - %s%n";
    for (File file : projectDirContents) {
      StringBuilder target = file.isFile() ? files : dirs;
      Date d = new Date(file.lastModified());
      target.append(String.format(strFormatTemplate, file.toString(), d));
    }

    System.out.printf(strFormatTemplate, "Files:", "Last modified:");
    System.out.println(files);
    System.out.printf(strFormatTemplate, "Directories:", "Last modified:");
    System.out.println(dirs);
  }

  private static List<String> readEverythingAtOnce(String fileName) {
    try {
      // Paths.get separates the args using File.separator - system specific;
      return Files.readAllLines(Paths.get("src","tf", fileName));
    } catch(IOException ex) {
      System.out.println(ex.toString());
      return new ArrayList<>();
    }
  }
}
