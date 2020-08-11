package tf.nick.hyperskill.patterns.decorator.coffee;

class Espresso extends Coffee {
    Espresso() {
        description = "Espresso";
    }

    @Override
    double cost() {
        return 1.99;
    }
}
