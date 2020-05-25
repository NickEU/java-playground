package tf.nick;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;

public class Playground {
    public static void main(String[] args) {
        incVsDec();
        stringFormat();
        dotVsComma();
    }

    private static void incVsDec() {
        int a = 4;
        int b = a++ + ++a;
        System.out.println(b); // 10
    }


    private static void dotVsComma() {
        System.out.println("Enter an integer:");

        Scanner scanner = new Scanner(System.in);
        double userNumber = Double.parseDouble(scanner.nextLine());

        System.out.printf(Locale.GERMANY, "You entered: %.2f%n", userNumber); // 5,00
        System.out.printf(Locale.US, "You entered: %.2f", userNumber); // 5.00
    }

    private static void stringFormat() {
        int waterReq = 250;
        System.out.printf("%d ml of water%n", waterReq); // 250 ml of water
        System.out.printf("PI = %.15f%n", Math.PI); // PI = 3.141592653589793

        Date now = new Date();
        System.out.printf("Date = %tc%n", now); // Sun Jan 01 11:43:02 EEST 2000
        System.out.printf("Date = %tF%n", now); // 2000-01-01
        System.out.printf("Year-Month-Day = %1$tY-%1$tm-%1$td %n", now); // 2000-01-01
        System.out.printf("Year-Month-Day = %tY-%<tm-%<td %n", now); // 2000-01-01
        System.out.printf("Since Unix epoch = %ts%n", now);
    }
}
