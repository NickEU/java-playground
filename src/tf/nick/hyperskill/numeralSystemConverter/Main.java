package tf.nick.hyperskill.numeralSystemConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int srcRadix = Integer.parseInt(sc.nextLine());
        String srcNum = sc.nextLine();
        int targetRadix = Integer.parseInt(sc.nextLine());

        String result = NumConverter.convert(srcNum, srcRadix, targetRadix);
        System.out.println(result);
    }
}
