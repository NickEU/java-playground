package tf.nick.hypertrash.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        System.out.println(checkSequenceForBalance(input));

    }

    private static boolean checkSequenceForBalance(String input) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char bracket : input.toCharArray()) {
            switch (bracket) {
                case '(':
                case '{':
                case '[':
                    stack.push(bracket);
                    break;
                case ')':
                case '}':
                case ']':
                    if (brackets.get(bracket) != stack.poll()) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return stack.peek() == null;
    }

    static Map<Character, Character> brackets = Map.of(
            ')' , '(',
            '}' , '{',
            ']' , '['
    );
}
