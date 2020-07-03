package tf.nick.hypertrash;

import java.util.Arrays;
import java.util.stream.IntStream;

class AsciiCharSequence implements CharSequence {
    private final byte[] chars;

    public static void main(String[] args) {
        System.out.println(new AsciiCharSequence(new byte[] {65, 66, 67}));
    }

    public AsciiCharSequence(byte[] chars) {
        this.chars = chars.clone();
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int index) {
        return (char) chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(chars, start, end));
    }

    @Override
    public String toString() {
//        yes, i am an idiot.
//        return new String(chars);
        return IntStream.range(0, chars.length)
                .map(x -> chars[x])
                .mapToObj(Character::toChars)
                .map(String::valueOf)
                .reduce("", (acc, cur) -> acc += cur);
    }
}
