package tf.nick.hyperskill.ticTacToe.stage5Final;

enum UserMoveResult {
    SUCCESS(""),
    FAIL_CELL_OCCUPIED("This cell is occupied! Choose another one!"),
    FAIL_NAN("You should enter numbers!"),
    FAIL_OUT_OF_BOUNDS("Coordinates should be from 1 to 3!");

    private final String msg;

    UserMoveResult(String msg) {
        this.msg = msg;
    }

    String getMsg() {
        return msg;
    }

}
