package tf.nick.hyperskill.patterns.decorator.coffee;

class Sugar extends Decorator {
    private final Coffee coffee;

    public Sugar(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    double cost() {
        return .02 + coffee.cost();
    }
}
