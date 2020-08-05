package tf.nick.hypertrash.strings;

import java.util.Scanner;

public class IndicesOfAllOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine().trim();
        String text = sc.nextLine().trim();
        System.out.println(findAllOccurrences(pattern, text));
    }

    private static String findAllOccurrences(String pattern, String text) {
        if (pattern.isEmpty()) {
            return "1\n0";
        }

        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            boolean foundMatch = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    foundMatch = false;
                    break;
                }
            }

            if (foundMatch) {
                result.append(i).append(" ");
                count++;
            }
        }

        return count + (count > 0
            ? '\n' + result.toString().trim()
            : "");
    }
}
