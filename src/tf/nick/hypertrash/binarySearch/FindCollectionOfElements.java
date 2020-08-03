package tf.nick.hypertrash.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindCollectionOfElements {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int numsSize = Integer.parseInt(sc.nextLine().trim());
        int[] nums = new int[numsSize];
        IntStream.range(0, numsSize)
            .forEach(i -> nums[i] = sc.nextInt());

        int collectionSize = sc.nextInt();
        List<Integer> lookingFor = sc.tokens().limit(collectionSize)
            .mapToInt(Integer::parseInt)
            .boxed().collect(Collectors.toList());
        List<Integer> result = searchForNumsInArray(lookingFor, nums);
        result.forEach(n -> System.out.print(n + " "));
    }

    private static List<Integer> searchForNumsInArray(List<Integer> lookingFor, int[] nums) {
        List<Integer> result = IntStream.generate(() -> -1)
            .limit(lookingFor.size())
            .boxed().collect(Collectors.toList());
        List<Integer> copy = new ArrayList<>(lookingFor);
        Map<Integer, List<Integer>> numsToIndices = mapElsToIds(lookingFor);
        //System.out.println(numsToIndices);

        while (numsToIndices.size() > 0) {
            int curTarget = copy.get(0);
            copy.removeAll(List.of(curTarget));
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int curEl = nums[mid];
                if (curEl < curTarget) {
                    start = mid + 1;
                } else if (curEl > curTarget) {
                    end = mid - 1;
                } else {
                    // requirements are asking for the result to be in 1-based indexing
                    numsToIndices.get(curTarget).forEach(i -> result.set(i, mid + 1));
                    break;
                }
            }
            numsToIndices.remove(curTarget);
        }

        return result;
    }

    private static Map<Integer, List<Integer>> mapElsToIds(List<Integer> lookingFor) {
        List<Integer> copy = new ArrayList<>(lookingFor);
        return lookingFor.stream().collect(Collectors.toMap(
            n -> n,
            n -> {
                int id = copy.indexOf(n);
                copy.set(id, null);
                return List.of(id);
            },
            (l1, l2) -> Stream.concat(l1.stream(), l2.stream())
                .collect(Collectors.toList()),
            HashMap::new
        ));
    }
}
