package tf.nick.spec.spec7Files;

import java.io.IOException;
import java.nio.file.*;

public class WatchdogExample {
  public static void main(String[] args) throws IOException, InterruptedException {
    Path targetDir = Paths.get(System.getProperty("user.dir"));
    WatchService watchDog = FileSystems.getDefault().newWatchService();
    targetDir.register(watchDog, StandardWatchEventKinds.ENTRY_CREATE);

    WatchKey key = watchDog.take();

    for (WatchEvent<?> e : key.pollEvents()) {
      @SuppressWarnings("unchecked")
      WatchEvent<Path> pathEvent = (WatchEvent<Path>) e;
      Path fileName = pathEvent.context();
      System.out.println(fileName);
    }
  }


}
