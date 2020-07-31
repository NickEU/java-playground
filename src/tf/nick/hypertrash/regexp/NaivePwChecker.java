package tf.nick.hypertrash.regexp;

import java.util.Scanner;

public class NaivePwChecker {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine().trim();
        boolean isPwHard =
            input.matches("(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{12,}");
        System.out.println(isPwHard ? "YES" : "NO");
    }
}
