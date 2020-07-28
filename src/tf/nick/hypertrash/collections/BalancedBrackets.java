package tf.nick.hypertrash.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(isSequenceBalanced("{}[]()"));
        System.out.println(isSequenceBalanced("{[]()}"));
        System.out.println(!isSequenceBalanced("{}[]((()"));
        System.out.println(!isSequenceBalanced("([)]"));
        String input = new Scanner(System.in).nextLine();
        System.out.println(isSequenceBalanced(input));

    }

    private static boolean isSequenceBalanced(String input) {
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
