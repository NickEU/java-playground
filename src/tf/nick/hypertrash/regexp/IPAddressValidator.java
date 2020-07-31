package tf.nick.hypertrash.regexp;

import java.util.Collections;
import java.util.Scanner;

public class IPAddressValidator {
    public static void main(String[] args) {
        String numRegex = "(2[0-4]\\d|25[0-5]|1\\d\\d|[1-9]?\\d)";
        String fullRegex = String.join("\\.", Collections.nCopies(4, numRegex));
        boolean isValidIp = new Scanner(System.in).nextLine().trim().matches(fullRegex);
        System.out.println(isValidIp ? "YES" : "NO");
    }
}
