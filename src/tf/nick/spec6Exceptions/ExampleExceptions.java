package tf.nick.spec6Exceptions;

import java.util.Scanner;

public class ExampleExceptions {
  private static Scanner sc;
  private static final int ID_LOWER_BOUND = 0;
  private static final int ID_UPPER_BOUND = 300;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    Integer userId = null;
    while (userId == null) {
      try {
        userId = readIdFromUser();
      } catch (MyException e) {
        System.out.println(e.getMsg());
        System.out.println("You entered: " + e.getID() + " instead!");
      }
    }
    System.out.printf("Welcome, User Nr.%d", userId);
  }

  private static Integer readIdFromUser() throws MyException {
    String errorMsg =
        String.format("\nId should be a number between %d and %d", ID_LOWER_BOUND, ID_UPPER_BOUND);
    System.out.print("\nEnter id: ");
    String userInput = sc.nextLine();
    try {
      int id = Integer.parseInt(userInput);
      if (id < 0 || id > 300) {
        throw new MyException(errorMsg, id);
      }
      return id;
    } catch (NumberFormatException ex) {
      System.out.println(errorMsg);
    }
    return null;
  }
}
