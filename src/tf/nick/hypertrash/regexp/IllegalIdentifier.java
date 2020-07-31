package tf.nick.hypertrash.regexp;

import java.util.Scanner;

public class IllegalIdentifier {
    // There is a set of rules for identifiers (names) of variables:
    //
    // It can include lower and upper letters, digits and the underscore character _;
    // It can only start with a letter or the underscore;
    // If an identifier starts with the underscore,
    // the second character should be either a letter or a digit, but not the underscore;
    // Note that a single _ is not a valid identifier.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfVariables = Integer.parseInt(scanner.nextLine());

        String regex = "(?!^_$|^__.*|.*\\W.*)(^\\D.*$)";

        for (int i = 0; i < numberOfVariables; i++) {
            String identifier = scanner.nextLine();
            if (!identifier.matches(regex)) {
                System.out.println(identifier);
            }
        }
    }
}
