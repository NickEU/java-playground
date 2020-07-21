package tf.nick.hyperskill.numeralSystemConverter;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input radix of the source number: ");
            int srcRadix = Integer.parseInt(sc.nextLine());
            System.out.println("Input the source number: ");
            String srcNum = sc.nextLine();
            System.out.println("Input the desired radix: ");
            int targetRadix = Integer.parseInt(sc.nextLine());
            if (inputIsValid(srcNum, srcRadix, targetRadix)) {
                String result = NumConverter.convert(srcNum, srcRadix, targetRadix);
                System.out.println(result);
            }
        } catch(NumberFormatException e) {
            System.out.println("Error! Radix should be a valid integer!");
        } catch(NoSuchElementException e) {
            final String scErrorMsg
                    = "Error! Expected input - Line 1: src radix. Line 2: src num. Line 3: target radix";
            System.out.println(scErrorMsg);
        }
    }

    private static boolean inputIsValid(String srcNum, int srcRadix, int targetRadix) {
        if (!radixIsValid(srcRadix) || !radixIsValid(targetRadix)) {
            System.out.println("Error! Radix cannot be < 1 or > 36!");
            return false;
        }

        if (srcNumIsValid(srcNum, srcRadix)) {
            return true;
        } else {
            System.out.println("Error! Source number is not a number");
            return false;
        }
    }

    private static boolean srcNumIsValid(String srcNum, int srcRadix) {
        if (srcRadix == 1) {
            return srcNum.matches("^1+$");
        }

        String digits = ".0123456789abcdefghijklmnopqrstuvwxyz".substring(0, srcRadix + 1);
        for (char digit : srcNum.toCharArray()) {
            if (!digits.contains(String.valueOf(digit))) {
                return false;
            }
        }

        return srcNum.matches("^[a-z0-9]*\\.?[a-z0-9]*$");
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private static boolean radixIsValid(int radix) {
        final int minRadix = 1;
        final int maxRadix = 36;
        return radix >= minRadix && radix <= maxRadix;
    }
}
