package tf.nick.specStatic;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int age;

    private static List<Person> people = new ArrayList<>();


    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Person create(String name, int age) {
        Person p = new Person(name, age);
        people.add(p);
        return p;
    }

    public static void showAll() {
        for (Person p : people) {
            System.out.println(p);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Age: " + this.age;
    }
}
