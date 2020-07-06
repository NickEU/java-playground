package tf.nick.hypertrash.anonClasses;

import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        String line = new Scanner(System.in).nextLine();

        IStringReverser reverser = str -> new StringBuilder(str).reverse().toString();

        System.out.println(reverser.reverse(line));
    }

    interface IStringReverser {

        String reverse(String str);
    }
}
