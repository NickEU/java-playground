package tf.nick.spec.spec8Concurrency.integral;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.function.DoubleFunction;

public class Integral {
    static final int STEPS = 100_000_000;

    public static void main(String[] args) {
        System.out.println(singleThread(Math::sin, 0, Math.PI / 2));
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println(multiThreadPools(Math::sin, 0, Math.PI / 2, STEPS, threadCount));
        System.out.println(multiThread(Math::sin, 0, Math.PI / 2, STEPS, threadCount));
    }

    static double singleThread(DoubleFunction<Double> f, double a, double b) {
        System.out.printf("From point %f to point %f\n", a, b);
        System.out.println("Single-threaded: ");
        return singleThread(f, a, b, STEPS);
    }

    static double singleThread(DoubleFunction<Double> f, double a, double b, int steps) {
        long t1 = System.currentTimeMillis();
        double h = (b - a) / steps;
        double sum = 0;

        for (int i = 0; i < steps; i++) {
            double x = a + h * i + h / 2;
            double y = f.apply(x);
            sum += y * h;
        }

        long t2 = System.currentTimeMillis();
        System.out.printf(Thread.currentThread().getName() + " time : %s ms\n", (t2 - t1));
        return sum;
    }

    static double multiThreadPools(DoubleFunction<Double> f, double a, double b, int steps, int threadCount) {
        System.out.println("MT using pools: ");
        long t1 = System.currentTimeMillis();

        int stepsPerThread = steps / threadCount;

        ExecutorService pool = Executors.newWorkStealingPool(threadCount);

        ArrayList<Future<Double>> tasks = new ArrayList<>();

        double xAxisDelta = b / threadCount;
        double start = a;
        double end = a + xAxisDelta;

        for (int i = 0; i < threadCount; i++, start += xAxisDelta, end += xAxisDelta) {
            double finalStart = start;
            double finalEnd = end;
            System.out.printf("First segment: %f to %f in %d steps\n",
                    finalStart, finalEnd, stepsPerThread);
            tasks.add(pool.submit(() -> singleThread(f, finalStart, finalEnd, stepsPerThread)));
        }

        double totalSum = 0;
        for (Future<Double> task : tasks) {
            try {
                totalSum += task.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.printf("Total Time : %s ms\n", (t2 - t1));
        return totalSum;
    }

    static double multiThread(DoubleFunction<Double> f, double a, double b, int steps, int threadCount) {
        System.out.println("MT using threads: ");
        long t1 = System.currentTimeMillis();
        DoubleAdder result = new DoubleAdder();

        ArrayList<Thread> threads = new ArrayList<>();

        int stepsPerThread = steps / threadCount;
        double delta = (b - a) / threadCount;

        for (int i = 0; i < threadCount; i++) {
            final double ax = a + i * delta;
            final double bx = ax + delta;
            System.out.printf("First segment: %f to %f in %d steps\n",
                    ax, bx, stepsPerThread);
            threads.add(new Thread(() -> result.add(singleThread(f, ax, bx, stepsPerThread))));
            threads.get(i).start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.printf("Total Time : %s ms\n", (t2 - t1));

        return result.sum();
    }
}
