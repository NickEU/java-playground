package tf.nick.interviewCamp.ic03reverseTraversal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInSentence {
  public static void main(String[] args) {
    String input = "i live in a house";
    String expected = "house a in live i";
    String actual = reverseImperative(input);
    System.out.println(actual.equals(expected));
    actual = reverseDeclarative(input);
    System.out.println(actual.equals(expected));
  }

  private static String reverseImperative(String sentence) {
    if (sentence == null) {
      return null;
    }
    String[] words = sentence.split(" ");
    for (int i = 0, j = words.length - 1; i < j; i++, j--) {
      String temp = words[i];
      words[i] = words[j];
      words[j] = temp;
    }
    return String.join(" ", words);
  }

  private static String reverseDeclarative(String sentence) {
    if (sentence == null) {
      return null;
    }
    List<String> words = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
    Collections.reverse(words);
    return String.join(" ", words);
  }
}
