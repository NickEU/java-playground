package tf.nick.hyperskill.stuff;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class CountLettersUsingRegex {
  public static void main(String[] args) {
    System.out.println("Input the genome sequence: ");
    String userInput = new Scanner(System.in).nextLine();
    Pattern pattern = Pattern.compile("[gc]", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(userInput);
    int gcCount = 0;
    while (matcher.find()) {
      gcCount++;
    }
    double gcContent = 100.0 * gcCount / userInput.length();
    System.out.printf("GC-content is %.2f%%%n", gcContent);
  }
}
