package tf.nick.hypertrash.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumElInStack {
        public static void main(String[] args) {
            var sc = new Scanner(System.in);
            int linesToInput = Integer.parseInt(sc.nextLine());
            Deque<Integer> maximums = new ArrayDeque<>();
            StringBuilder result = new StringBuilder();

            IntStream.range(0, linesToInput)
                    .mapToObj(i -> sc.nextLine())
                    .forEach(s -> processCmd(s, maximums, result));
            System.out.println(result);
        }

        private static void processCmd(String userInput, Deque<Integer> maximums, StringBuilder result) {
            String[] cmd = userInput.split("\\s+");
            switch (cmd[0]) {
                case "pop":
                    maximums.pollFirst();
                    break;
                case "max":
                    result.append(maximums.peekFirst()).append("\n");
                    break;
                case "push":
                    int numToAdd = Integer.parseInt(cmd[1]);
                    Integer currMax = maximums.peekFirst();
                    Integer newMax = currMax == null ? numToAdd : Math.max(currMax, numToAdd);
                    maximums.offerFirst(newMax);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
}
