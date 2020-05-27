package tf.nick;

public class AdvancedAstrology {

    public static void printStars(int number) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number; i++) {
            sb.append('*');
        }
        System.out.println(sb.toString());
    }

    public static void printSpaces(int number) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number; i++) {
            sb.append(' ');
        }
        System.out.print(sb.toString());
    }

    public static void printTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            printSpaces(size - i);
            printStars(i);
        }
    }

    public static void christmasTree(int height) {
        // print top
        int bottomStars = height * 2 - 1;
        for (int i = 1; i <= bottomStars; i += 2) {
            printSpaces((bottomStars - i) / 2);
            printStars(i);
        }
        // print base
        for(int i = 0; i < 2; i++) {
            printSpaces((bottomStars - 3) / 2);
            printStars(3);
        }
    }

    public static void main(String[] args) {
        printTriangle(5);
        System.out.println("---");
        christmasTree(4);
        System.out.println("---");
        christmasTree(10);
    }
}
