package tf.nick.spec6Exceptions;

public class MyException extends Exception {
    private final int ID;
    private final String msg;

    public int getID() {
        return this.ID;
    }

    public String getMsg() {
        return this.msg;
    }

    public MyException(String msg, int userInputID) {
        this.msg = msg;
        this.ID = userInputID;
    }
}
