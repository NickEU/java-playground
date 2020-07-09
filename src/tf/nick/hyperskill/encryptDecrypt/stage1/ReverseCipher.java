package tf.nick.hyperskill.encryptDecrypt.stage1;

public class ReverseCipher {
    public static void main(String[] args) {
        String phraseToEncrypt = "we found a treasure!";
        System.out.println(encrypt(phraseToEncrypt));
    }

    private static String encrypt(String phraseToEncrypt) {
        StringBuilder result = new StringBuilder();
        for (char c : phraseToEncrypt.toCharArray()) {
            int offset = (c - 97) % 13;
            char toAppend = c >= 97 && c <= 109 ? (char) (122 - offset)
                    : c >= 110 && c <= 122 ? (char) (109 - offset) : c;
            result.append(toAppend);
        }
        return result.toString();
    }


}
