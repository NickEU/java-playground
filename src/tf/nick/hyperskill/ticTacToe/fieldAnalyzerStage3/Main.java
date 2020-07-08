package tf.nick.hyperskill.ticTacToe.fieldAnalyzerStage3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String userBoard = sc.nextLine();
        TicTacToe game = new TicTacToe(userBoard);
        game.play();
    }
}
