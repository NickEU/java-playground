package tf.nick.hyperskill.patterns.decorator.coffee;

class InstantCoffee extends Coffee {
    InstantCoffee() {
        description = "Instant Coffee";
    }

    @Override
    double cost() {
        return 1.0;
    }
}
