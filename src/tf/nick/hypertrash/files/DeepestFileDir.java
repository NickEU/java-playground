package tf.nick.hypertrash.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class DeepestFileDir {
    public static void main(String[] args) {
        Path root = Paths.get(System.getProperty("user.dir"), "deepestOne");
        try {
            Path deepest = Files.walk(root)
                    .max(Comparator.comparingInt(Path::getNameCount))
                    .orElseThrow().getFileName();
            System.out.println(deepest.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
