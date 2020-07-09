package tf.nick.hyperskill.ticTacToe.stage4FirstMove;

import java.util.Scanner;

public class UserInterface {
    private final Scanner sc = new Scanner(System.in);
    private TicTacToe game;

    void start() {
        getInitialBoardStateFromUser();
        renderGameBoard();
        getMoveCoordinatesFromUser();
    }

    private void getInitialBoardStateFromUser() {
        System.out.print("Enter cells: ");
        String userBoard = sc.nextLine().trim();
        game = new TicTacToe(userBoard);
    }

    private void getMoveCoordinatesFromUser() {
        while (true) {
            System.out.println("Enter the coordinates: ");
            String userInput = sc.nextLine();
            UserMoveResult parseResult = parseUserMoveInput(userInput);
            if (parseResult == UserMoveResult.SUCCESS) {
                renderGameBoard();
                break;
            }
            System.out.println(parseResult.getMsg());
        }
    }

    UserMoveResult parseUserMoveInput(String userInput) {
        int row;
        int col;

        try {
            String[] coords = userInput.split(" ");
            int userRow = Integer.parseInt(coords[0]);
            int userCol = Integer.parseInt(coords[1]);
            if (coordinateOutOfBounds(userRow) || coordinateOutOfBounds(userCol)) {
                return UserMoveResult.FAIL_OUT_OF_BOUNDS;
            }
            row = Math.abs(userCol - 3);
            col = userRow - 1;
        } catch(Exception e) {
            return UserMoveResult.FAIL_NAN;
        }

        return game.tryMakeMove(row, col, 'X')
                ? UserMoveResult.SUCCESS
                : UserMoveResult.FAIL_CELL_OCCUPIED;
    }

    private boolean coordinateOutOfBounds(int coord) {
        return coord < 1 || coord > 3;
    }

    private void renderGameBoard() {
        String DECOR_BORDER = "---------";
        System.out.println(DECOR_BORDER);
        for (char[] row : game.getCells()) {
            System.out.printf("| %c %c %c |\n", row[0], row[1], row[2]);
        }
        System.out.println(DECOR_BORDER);
    }
}
