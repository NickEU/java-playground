package tf.nick.hypertrash.files;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LargestPopulationDelta {
    public static void main(String[] args) {
        final String fileURL = "https://stepik.org/media/attachments/lesson/91069/dataset_91069.txt";

        System.out.println("World population by year: ");

        try (var sc = new Scanner(new URL(fileURL).openStream(), StandardCharsets.UTF_8)) {
            sc.nextLine(); // skip the row with names of columns

            long largestIncrease = Long.MIN_VALUE;
            int yearWithLargestInc = 0;
            Long prevYearPop = null;
            while (sc.hasNextLine()) {
                int year = sc.nextInt();
                String population = sc.nextLine().replaceAll(",", "").trim();
                long currYearPop = Long.parseLong(population);
                if (prevYearPop != null) {
                    long currInc = currYearPop - prevYearPop;
                    if (currInc > largestIncrease) {
                        largestIncrease = currInc;
                        yearWithLargestInc = year;
                    }
                }
                prevYearPop = currYearPop;
                System.out.printf("Year: %d  Population: %,d\n", year, currYearPop);
            }
            System.out.printf("Year with largest delta: %d\n", yearWithLargestInc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
