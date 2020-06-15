package tf.nick.hyperskill.coffeeMachine;

public enum CoffeeType {
  ESPRESSO(250, 0, 16, 4),
  LATTE(350, 75, 20, 7),
  CAPPUCCINO(200, 100, 12, 6);

  private final int waterReq;
  private final int milkReq;
  private final int beansReq;
  private final int price;

  CoffeeType(int waterReq, int milkReq, int beansReq, int price) {
    this.waterReq = waterReq;
    this.milkReq = milkReq;
    this.beansReq = beansReq;
    this.price = price;
  }

  public int getWaterReq() {
    return waterReq;
  }

  public int getMilkReq() {
    return milkReq;
  }

  public int getBeansReq() {
    return beansReq;
  }

  public int getPrice() {
    return price;
  }
}
