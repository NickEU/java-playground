package tf.nick.hyperskill.numeralSystemConverter;

import java.math.BigDecimal;

class NumConverter {
    static String convert(String srcNum, int srcRadix, int targetRadix) {
        System.out.printf("Converting %s in radix %d to radix %d:\n"
            , srcNum, srcRadix, targetRadix);
        double srcInDecimal =
                srcRadix == 1 ? srcNum.length() :
                srcRadix == 10 ? Double.parseDouble(srcNum) :
                        toDecimal(srcNum, srcRadix);
        return targetRadix == 1 ? "1".repeat((int) srcInDecimal)
                : toTargetRadix(srcInDecimal, targetRadix);
    }

    private static double toDecimal(String srcNum, int srcRadix) {
        String[] numAsArr = srcNum.split("\\.");
        String intPart = numAsArr[0];
        int intResult = Integer.parseInt(intPart, srcRadix);
        String fractPart = numAsArr.length > 1 ? numAsArr[1] : "";
        double decResult = 0;
        int exp = 1;
        for (char c : fractPart.toCharArray()) {
            decResult += Integer.parseInt(String.valueOf(c), srcRadix) / Math.pow(srcRadix, exp++);
        }

        return intResult + decResult;
    }

    private static String toTargetRadix(double srcInDecimal, int targetRadix) {
        BigDecimal[] intFrac = BigDecimal.valueOf(srcInDecimal)
                .divideAndRemainder(BigDecimal.ONE);
        int intPart = intFrac[0].intValue();
        String intResult = Long.toString(intPart, targetRadix);
        double fractPart = intFrac[1].doubleValue();
        if (fractPart == 0) {
            return intResult;
        }

        final int precision = 5;
        String fractResult = convertFractionalPartOfDecimalToTarget(fractPart, targetRadix, precision);
        return intResult + "." + fractResult;
    }

    private static String convertFractionalPartOfDecimalToTarget(double fractPart, int targetRadix, int precision) {
        StringBuilder result = new StringBuilder();
        double acc = fractPart;
        for (int i = 0; i < precision; i++) {
            acc *= targetRadix;
            int nextDigit = (int) acc;
            result.append(digitInDecToRadix(nextDigit, targetRadix));
            acc %= 1;
        }

        return result.toString();
    }

    private static String digitInDecToRadix(int nextDigit, int targetRadix) {
        if (nextDigit < 10) {
            return String.valueOf(Integer.parseInt(String.valueOf(nextDigit), targetRadix));
        } else {
            return String.valueOf((char) ('a' + nextDigit - 10));
        }
    }
}
