package tf.nick.hypertrash.reflection.modifiers;

import java.util.Arrays;

public class Playground {
    public static void main(String[] args) {
        FieldGetter o = new FieldGetter();
        var publicFields = o.getPublicFields(new Dog());
        var privateFields = o.getPrivateFields(new Dog());
        System.out.println(Arrays.toString(publicFields));
        System.out.println(privateFields);
    }

    static class Dog {
        public String name = "Fido";
        public String owner = "Jack";
        private int weight = 25;
        private int height = 2;
        private int age = 0;
    }
}


