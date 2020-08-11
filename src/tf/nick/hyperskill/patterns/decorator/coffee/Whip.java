package tf.nick.hyperskill.patterns.decorator.coffee;

class Whip extends Decorator {
    private final Coffee coffee;

    public Whip(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    String getDescription() {
        return coffee.getDescription() + ", Whip";
    }

    @Override
    double cost() {
        return .10 + coffee.cost();
    }
}
