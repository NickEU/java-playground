package tf.nick.hypertrash.findTheSeed;

import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

// If there are some seeds with equal minimal maximums,
// you should output the seed that is less than all other seeds.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seedsFrom = sc.nextInt();
        int seedsTo = sc.nextInt();
        int numsEachRound = sc.nextInt();
        int maxNumLimit = sc.nextInt();

        SortedSet<SeedNumWithMax> maximumsOfSeeds = new TreeSet<>();
        for (int seed = seedsFrom; seed <= seedsTo; seed++) {
            Random rnd = new Random(seed);
            int curSeedMaxNum = Integer.MIN_VALUE;
            for (int i = 0; i < numsEachRound; i++) {
                int nextNum = rnd.nextInt(maxNumLimit);
                if (nextNum > curSeedMaxNum) {
                    curSeedMaxNum = nextNum;
                }
            }
            maximumsOfSeeds.add(new SeedNumWithMax(seed, curSeedMaxNum));
        }

        SeedNumWithMax result = maximumsOfSeeds.first();
        System.out.println("Found the seed with lowest max:");
        System.out.println("Seed: " + result.getSeed());
        System.out.println("Max number: " + result.getMaxNum());
    }
}
