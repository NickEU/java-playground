package tf.nick.hyperskill.ticTacToe.stage3FieldAnalyzer;

enum GameState {
    IN_PROGRESS("Game not finished"),
    DRAW("Draw"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    IMPOSSIBLE("Impossible");

    private final String msg;

    GameState(String msg) {
        this.msg = msg;
    }

    String getMsg() {
        return msg;
    }
}
