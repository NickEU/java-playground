package tf.nick.hypertrash.collections.greedyLoadBalancer;

import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
//        var sc = new Scanner("6 \n" +
//                "1 1 \n" +
//                "2 1 \n" +
//                "3 1 \n" +
//                "4 3 \n" +
//                "5 1 \n" +
//                "6 1");
        var sc = new Scanner(System.in);
        var balancer = new LoadBalancer(2);
        IntStream.range(0, sc.nextInt())
            .mapToObj(i -> new Task(sc.nextInt(), sc.nextInt()))
            .forEachOrdered(balancer::addTask);
        System.out.print(balancer.getStatus());
    }
}



