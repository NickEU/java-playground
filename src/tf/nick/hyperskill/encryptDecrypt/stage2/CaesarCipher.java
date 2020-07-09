package tf.nick.hyperskill.encryptDecrypt.stage2;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phraseToEncrypt = sc.nextLine();
        int key = sc.nextInt();
        System.out.println(encrypt(phraseToEncrypt, key));
    }

    private static String encrypt(String phraseToEncrypt, int key) {
        if (key < 0) {
            System.out.println("Error! Negative keys not supported");
            return phraseToEncrypt;
        }

        StringBuilder result = new StringBuilder();
        for (char curChar : phraseToEncrypt.toCharArray()) {
            char baseLetter; // 65 - 90 upper 97 - 122 lower
            if (curChar >= 97 && curChar <= 122) {
                baseLetter = 97;
            } else if (curChar >= 65 && curChar <= 90) {
                baseLetter = 65;
            } else {
                result.append(curChar);
                continue;
            }
            result.append((char)(baseLetter + (curChar - baseLetter + key) % 26));
        }
        return result.toString();
    }
}
