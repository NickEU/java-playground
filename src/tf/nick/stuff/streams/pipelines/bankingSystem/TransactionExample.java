package tf.nick.stuff.streams.pipelines.bankingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TransactionExample {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfAccounts = Integer.parseInt(scanner.nextLine());
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < numberOfAccounts; i++) {
            String[] accDesc = scanner.nextLine().split(" ");
            String number = accDesc[0];
            Long balance = Long.parseLong(accDesc[1]);

            int numberOfTransByAccount = Integer.parseInt(scanner.nextLine());
            List<Transaction> trans = new ArrayList<>();

            for (int j = 0; j < numberOfTransByAccount; j++) {
                String[] transDesc = scanner.nextLine().split(" ");
                String uuid = transDesc[0];
                State state = convertStringToState(transDesc[1]);
                Long sum = Long.parseLong(transDesc[2]);
                trans.add(new Transaction(uuid, state, sum));
            }

            accounts.add(new Account(number, balance, trans));
        }

        System.out.println(calcSumOfCanceledTransOnNonEmptyAccounts(accounts));
    }

    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        return accounts.stream()
            .filter(a -> a.getBalance() > 0)
            .flatMap(a -> a.getTransactions().stream())
            .filter(t -> t.getState().equals(State.CANCELED))
            .mapToLong(Transaction::getSum)
            .sum();
    }

    private static State convertStringToState(String state) {
        switch (state) {
            case "c": return State.CANCELED;
            case "f": return State.FINISHED;
            case "p": return State.PROCESSING;
            default: throw new IllegalArgumentException("Unknown account state");
        }
    }
}
