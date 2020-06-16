package tf.nick.hyperskill.stuff;

import java.util.Scanner;

class SimplePalindrome {
  public static void main(String[] args) {
    char[] userWord = new Scanner(System.in).nextLine()
            .replaceAll("\\s", "")
            .toLowerCase().toCharArray();
    int lastElIdx = userWord.length - 1;
    for (int i = 0; i < lastElIdx - i; i++) {
      if (userWord[i] != userWord[lastElIdx - i]) {
        System.out.println("no");
        return;
      }
    }
    System.out.println("yes");
  }
}
