package tf.nick.hypertrash.collections.map.multiset;

import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean areAnagrams =
                areAnagrams(sc.nextLine().toLowerCase(),
                        sc.nextLine().toLowerCase());
        System.out.println(areAnagrams ? "yes" : "no");
    }

    private static boolean areAnagrams(String one, String two) {
        Multiset<Character> a = fillSet(one);
        Multiset<Character> b = fillSet(two);
        Multiset<Character> copyOfA = fillSet(one);
        copyOfA.intersect(b);
        return a.size() == b.size() && b.size() == copyOfA.size();
    }

    private static Multiset<Character> fillSet(String word) {
        Multiset<Character> result = new HashMultiset<>();
        word.chars().mapToObj(i -> (char) i)
                .forEach(result::add);
        return result;
    }
}
