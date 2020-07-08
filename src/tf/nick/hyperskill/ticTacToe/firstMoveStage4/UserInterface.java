package tf.nick.hyperskill.ticTacToe.firstMoveStage4;

import java.util.Scanner;

public class UserInterface {
    private final Scanner sc;
    private TicTacToe game;

    public UserInterface(Scanner sc) {
        this.sc = sc;
    }

    void start() {
        System.out.print("Enter cells: ");
        String userBoard = sc.nextLine().trim();
        game = new TicTacToe(userBoard);
        game.renderGameBoard();
        while (true) {
            System.out.println("Enter the coordinates: ");
            String userInput = sc.nextLine();
            UserMoveResult parseResult = parseUserMoveInput(userInput);
            if (parseResult == UserMoveResult.SUCCESS) {
                game.renderGameBoard();
                break;
            }
            System.out.println(parseResult.getMsg());
        }
    }

    public UserMoveResult parseUserMoveInput(String userInput) {
        int row;
        int col;

        try {
            String[] coords = userInput.split(" ");
            int userRow = Integer.parseInt(coords[0]);
            int userCol = Integer.parseInt(coords[1]);
            if (coordinateOutOfBounds(userRow) || coordinateOutOfBounds(userCol)) {
                return UserMoveResult.FAIL_OUT_OF_BOUNDS;
            }
            row = normalizeUserCoordinate(userRow, userCol, true);
            col = normalizeUserCoordinate(userRow, userCol, false);
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

    private int normalizeUserCoordinate(int userRow, int userCol, boolean isRow) {
        // this is ugly
        // todo : find a better way to translate coords from one system to another
        switch (userRow) {
            case 1:
                switch (userCol) {
                    case 1:
                        return isRow ? 2 : 0;
                    case 2:
                        return isRow ? 1 : 0;
                    case 3:
                        return isRow ? 0 : 0;
                }
            case 2:
                switch (userCol) {
                    case 1:
                        return isRow ? 2 : 1;
                    case 2:
                        return isRow ? 1 : 1;
                    case 3:
                        return isRow ? 0 : 1;
                }
            case 3:
                switch (userCol) {
                    case 1:
                        return isRow ? 2 : 2;
                    case 2:
                        return isRow ? 1 : 2;
                    case 3:
                        return isRow ? 0 : 2;
                }
        }
        return -1;
    }
}
