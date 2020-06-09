package tf.nick.spec3ClassInit;

public class Program {
  public static void main(String[] args) {
    System.out.println(FancyList.numbers);
    findGCDTest();
    // isPowerOfTwoTest();
  }

  private static void isPowerOfTwoTest() {
    System.out.println(isPowerOfTwo(16));
    System.out.println(!isPowerOfTwo(3));
    System.out.println(!isPowerOfTwo(470));
    System.out.println(isPowerOfTwo(1024));
    System.out.println(isPowerOfTwo(1));
    System.out.println(isPowerOfTwo(2));
  }

  private static boolean isPowerOfTwo(int i) {
    // only allowed to use bitwise & logical operators
    int down = i;
    while (down > 1) {
      down = down >> 1;
    }
    while (down < i) {
      down = down << 1;
    }
    return down == i;
  }

  private static void findGCDTest() {
    // TODO: show individual test cases on failure

    System.out.println("Testing findGCD: ");
    boolean allPassed =
        findGCD(70, 50) == 10
            && findGCD(111, 87) == 3
            && findGCD(47637, 37656) == 9
            && findGCD(462, 1071) == 21;
    String result =
        allPassed ? "All tests have passed!" : "Good luck figuring out which one failed!!";
    System.out.println(result);
  }

  private static int findGCD(int a, int b) {
    int remainder = a % b;
    if (remainder == 0) {
      return b;
    } else {
      return findGCD(b, remainder);
    }
  }
}
