package tf.nick.stuff;

public class BitmaskGeneration {
  public static void main(String[] args) {
    // generate all binary numbers from 0 to 2^n - 1
    // padding the smaller ones with 0 to match the biggest one
    // stolen from https://leetcode.com/articles/subsets/
    maskSimple(3);
    System.out.println("===============");
    maskConvoluted(4);
  }

  private static void maskSimple(int n) {
    for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
      String bitmask = Integer.toBinaryString(i).substring(1);
      System.out.println(bitmask);
    }
  }

  private static void maskConvoluted(int n) {
    int nthBit = 1 << n;
    //System.out.println(Integer.toBinaryString(2 | (1 << 4)));
    for (int i = 0; i < (int)Math.pow(2, n); ++i) {
      // generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i | nthBit).substring(1);
      System.out.println(bitmask);
    }
  }
}
