package tf.nick.hyperskill.patterns.decorator.coffee;

class Milk extends Decorator {
    private final Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    double cost() {
        return .13 + coffee.cost();
    }
}
