package tf.nick.hyperskill.encryptDecrypt.stage5;

public class Main {
    private static final String INVALID_INPUT_MSG = "Error! Illegal arguments!";

    private String outputDest = "console";
    private Operation mode = Operation.ENCRYPT;
    private int key = 0;
    private String data = "";


    public static void main(String[] args) {
        var o = new Main();
        try {
            o.parseCLIArgs(args);
            String result = o.transform();
            IOHelper.print(o.outputDest, result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(INVALID_INPUT_MSG);
        }
    }

    private void parseCLIArgs(String[] args) throws ArrayIndexOutOfBoundsException {
        final String decCmd = "dec";
        final String modeArg = "mode";
        final String keyArg = "key";
        final String dataArg = "data";
        final String inArg = "in";
        final String outArg = "out";

        for (int i = 0; i < args.length; i += 2) {
            String type = args[i].substring(1);
            String val = args[i + 1];
            switch(type) {
                case modeArg:
                    mode = val.equals(decCmd) ? Operation.DECRYPT : Operation.ENCRYPT;
                    break;
                case keyArg:
                    key = Integer.parseInt(val);
                    break;
                case dataArg:
                    data = val;
                    break;
                case inArg:
                    if (data.isEmpty()) {
                        data = IOHelper.loadDataFromFile(val);
                    }
                    break;
                case outArg:
                    outputDest = val;
                    break;
                default:
                    System.out.println(INVALID_INPUT_MSG);
            }
        }
    }

    private String transform() {
        StringBuilder result = new StringBuilder();
        for (char curChar : data.toCharArray()) {
            if ('\n' == curChar || '\r' == curChar) {
                result.append(curChar);
            } else {
                char transformed = (char) (mode == Operation.DECRYPT
                        ? curChar - key   // decrypt
                        : curChar + key); // encrypt
                result.append(transformed);
            }
        }
        return result.toString();
    }

    enum Operation {
        ENCRYPT, DECRYPT,
    }
}



