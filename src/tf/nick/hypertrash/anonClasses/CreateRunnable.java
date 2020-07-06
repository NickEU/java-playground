package tf.nick.hypertrash.anonClasses;

public class CreateRunnable {
    public static void main(String[] args) {
        Runnable a = createRunnable("abc", 5);
        a.run();
    }

    public static Runnable createRunnable(String text, int repeats) {
        return () -> System.out.print((text + "\n").repeat(repeats));
    }
}
