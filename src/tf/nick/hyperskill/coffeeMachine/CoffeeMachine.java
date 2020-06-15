package tf.nick.hyperskill.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
  enum State {
    ACTION_SELECT,
    COFFEE_SELECT,
    REFILL_MATS,
    TURNED_OFF,
  }

  enum FillProcessStep {
    WATER,
    MILK,
    BEANS,
    CUPS,
  }

  private State state;
  private FillProcessStep fillStep;
  private int waterLeft = 400;
  private int milkLeft = 540;
  private int beansLeft = 120;
  private int cupsLeft = 9;
  private int moneyBalance = 550;

  public State getState() {
    return state;
  }

  public boolean isOperational() {
    return getState() != State.TURNED_OFF;
  }

  public void setState(State state) {
    this.state = state;
  }

  public FillProcessStep getFillStep() {
    return fillStep;
  }

  public void setFillStep(FillProcessStep fillStep) {
    this.fillStep = fillStep;
  }

  public CoffeeMachine() {
    goBackToMainMenu();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    CoffeeMachine machine = new CoffeeMachine();
    while (sc.hasNextLine() && machine.isOperational()) {
      String userInput = sc.nextLine();
      machine.inputCommand(userInput);
    }
  }

  public void inputCommand(String action) {
    switch (this.getState()) {
      case TURNED_OFF:
        System.out.println("A machine that has been turned off cannot accept commands");
        break;
      case ACTION_SELECT:
        processMainMenuAction(action);
        break;
      case COFFEE_SELECT:
        processCoffeeSelectMenuAction(action);
        break;
      case REFILL_MATS:
        processRefillMenuAction(action);
        break;
      default:
        System.out.println("Error inside inputCommand()!");
    }
  }

  private void processMainMenuAction(String userAction) {
    if (userAction == null) {
      System.out.println("Write action (buy, fill, take, remaining, exit):");
      return;
    }
    switch (userAction) {
      case "buy":
        setState(State.COFFEE_SELECT);
        System.out.println(
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        break;
      case "fill":
        setState(State.REFILL_MATS);
        setFillStep(FillProcessStep.WATER);
        refillRawMatsAnnounce();
        break;
      case "take":
        giveMoney();
        goBackToMainMenu();
        break;
      case "remaining":
        printStatus();
        goBackToMainMenu();
        break;
      case "exit":
        setState(State.TURNED_OFF);
        break;
      default:
        System.out.println("Error inside processMainMenuAction()!");
    }
    System.out.println();
  }

  private void giveMoney() {
    System.out.println("I gave you $" + moneyBalance + "\n");
    moneyBalance = 0;
  }

  private void refillRawMatsAnnounce() {
    switch (getFillStep()) {
      case WATER:
        System.out.println("Write how many ml of water do you want to add:");
        break;
      case MILK:
        System.out.println("Write how many ml of milk do you want to add:");
        break;
      case BEANS:
        System.out.println("Write how many grams of coffee beans do you want to add:");
        break;
      case CUPS:
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        break;
      default:
        System.out.println("Error inside refillRawMatsAnnounce()");
    }
  }

  private void processRefillMenuAction(String userAction) {
    int userAmount = Integer.parseInt(userAction);

    switch (getFillStep()) {
      case WATER:
        waterLeft += userAmount;
        setFillStep(FillProcessStep.MILK);
        refillRawMatsAnnounce();
        break;
      case MILK:
        milkLeft += userAmount;
        setFillStep(FillProcessStep.BEANS);
        refillRawMatsAnnounce();
        break;
      case BEANS:
        beansLeft += userAmount;
        setFillStep(FillProcessStep.CUPS);
        refillRawMatsAnnounce();
        break;
      case CUPS:
        cupsLeft += userAmount;
        goBackToMainMenu();
        break;
      default:
        System.out.println("Error inside processRefillMenuAction()");
    }
  }

  private void processCoffeeSelectMenuAction(String userAction) {
    boolean gotEnoughForCup;

    switch (userAction) {
      case "1":
        gotEnoughForCup = tryMakeCoffee(CoffeeType.ESPRESSO);
        break;
      case "2":
        gotEnoughForCup = tryMakeCoffee(CoffeeType.LATTE);
        break;
      case "3":
        gotEnoughForCup = tryMakeCoffee(CoffeeType.CAPPUCCINO);
        break;
      case "back":
        goBackToMainMenu();
        return;
      default:
        System.out.println("Error inside processCoffeeSelectMenuAction()!");
        return;
    }
    if (gotEnoughForCup) {
      System.out.println("I have enough resources, making you a coffee!");
    }

    goBackToMainMenu();
  }

  private boolean tryMakeCoffee(CoffeeType coffeeType) {
    if (waterLeft < coffeeType.getWaterReq()) {
      System.out.println("Sorry, not enough water!");
      return false;
    }
    if (milkLeft < coffeeType.getMilkReq()) {
      System.out.println("Sorry, not enough milk!");
      return false;
    }
    if (beansLeft < coffeeType.getBeansReq()) {
      System.out.println("Sorry, not enough beans!");
      return false;
    }
    if (cupsLeft < 1) {
      System.out.println("Sorry, not enough cups!");
      return false;
    }

    waterLeft -= coffeeType.getWaterReq();
    milkLeft -= coffeeType.getMilkReq();
    beansLeft -= coffeeType.getBeansReq();
    cupsLeft--;
    moneyBalance += coffeeType.getPrice();

    return true;
  }

  private void printStatus() {
    System.out.println("The coffee machine has:");
    System.out.println(waterLeft + " of water");
    System.out.println(milkLeft + " of milk");
    System.out.println(beansLeft + " of coffee beans");
    System.out.println(cupsLeft + " of disposable cups");
    System.out.println(moneyBalance + " of money\n");
  }

  private void goBackToMainMenu() {
    setState(State.ACTION_SELECT);
    setFillStep(null);
    processMainMenuAction(null);
  }
}
