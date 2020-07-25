package tf.nick.hyperskill.stuff;

import java.util.Arrays;
import java.util.Scanner;

public class FindNearestNumber {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).sorted().toArray();
        int target = sc.nextInt();
        // find min difference
        int minDiff = Integer.MAX_VALUE;
        int startingIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            int curDiff = Math.abs(target - nums[i]);
            if (curDiff < minDiff) {
                minDiff = curDiff;
                startingIdx = i;
            }
        }
        // print result
        var result = new StringBuilder();
        for (int i = startingIdx; i < nums.length; i++) {
            int num = nums[i];
            if (minDiff != Math.abs(target - num)) {
                result.deleteCharAt(result.length() - 1);
                break;
            }
            result.append(num).append(" ");
        }

        System.out.println(result);
    }
}
