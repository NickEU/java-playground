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
    StringBuilder reversedSentence = new StringBuilder();
    int strLen = sentence.length();
    int wordEndIdx = strLen;
    for (int i = strLen - 1; i >= 0; i--) {
      if (sentence.charAt(i) == ' ') {
        String word = sentence.substring(i + 1, wordEndIdx);
        reversedSentence.append(word).append(" ");
        wordEndIdx = i;
      }
    }
    reversedSentence.append(sentence, 0, wordEndIdx);
    return reversedSentence.toString();
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
