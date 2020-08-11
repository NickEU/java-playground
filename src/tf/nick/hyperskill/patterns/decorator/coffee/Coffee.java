package tf.nick.hyperskill.patterns.decorator.coffee;

abstract class Coffee {
    String description;
    String getDescription() {
        return description;
    }
    abstract double cost();
}
