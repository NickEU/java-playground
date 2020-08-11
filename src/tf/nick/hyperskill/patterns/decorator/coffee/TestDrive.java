package tf.nick.hyperskill.patterns.decorator.coffee;

import java.util.Locale;

class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        Coffee simpleEspresso = new Espresso();
        System.out.println(simpleEspresso.getDescription() + " $" + formatSum(simpleEspresso.cost()));

        Coffee espressoWithDecor = new Espresso();
        espressoWithDecor = new Milk(espressoWithDecor);
        espressoWithDecor = new Sugar(espressoWithDecor);
        System.out.println(espressoWithDecor.getDescription() + " $" + formatSum(espressoWithDecor.cost()));

        Coffee instantWithDecor = new InstantCoffee();
        instantWithDecor = new Whip(instantWithDecor);
        instantWithDecor = new Sugar(instantWithDecor);
        instantWithDecor = new Sugar(instantWithDecor);
        instantWithDecor = new Sugar(instantWithDecor);
        System.out.println(instantWithDecor.getDescription() + " $" + formatSum(instantWithDecor.cost()));

        System.out.println("I'm drinking my " + instantWithDecor.getDescription());
        Thread.sleep(1500);
        System.out.println("-I want to add some Whip to my coffee. And don't make a new one! Just add Whip");
        Thread.sleep(1500);
        System.out.println("-Okay! But the final price will change");
        Thread.sleep(1500);
        System.out.println("-I understand");

        instantWithDecor = new Whip(instantWithDecor);
        System.out.println(instantWithDecor.getDescription() + " $" + formatSum(instantWithDecor.cost()));
    }

    private static String formatSum(double sum) {
        return String.format(Locale.ROOT, "%.2f", sum);
    }
}

