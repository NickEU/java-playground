package tf.nick.spec1Syntax;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;

public class Playground {
  public static void main(String[] args) {
    incVsDec();
    stringFormat();
    enums();
    dotVsComma();
  }

  private static void enums() {
    System.out.println(Arrays.toString(Month.values()));
    // [JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC]
    System.out.println(Month.valueOf("JUN")); // JUN
    Month dec1 = Month.DEC;
    System.out.println(dec1); // DEC
    System.out.println(Month.JAN.getNumber()); // 1
    Month aug = Month.AUG;
    System.out.println(aug); // AUG
  }

  private static void incVsDec() {
    int a = 4;
    int b = a++ + ++a;
    System.out.println(b); // 10
  }

  private static void dotVsComma() {
    System.out.println("Enter an integer:");
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.FRANCE);

    NumberFormat nf = NumberFormat.getInstance(new Locale("ru", "ru"));
    try {
      double userNumber = nf.parse(scanner.nextLine()).doubleValue();
      System.out.printf(Locale.GERMANY, "You entered: %.2f%n", userNumber); // 5,00
      System.out.printf(Locale.US, "You entered: %.2f", userNumber); // 5.00
    } catch (ParseException e) {
      e.printStackTrace();
    }
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
    System.out.printf("Indent %-10d %d %n", 5, 7); // Indent 5          7
  }
}
