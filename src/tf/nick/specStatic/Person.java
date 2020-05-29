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

        // What happens when the constructor throws an exception?
        // Reference to this unfinished object gets stuck in the collection
        // and it never gets GC-ed
        // For ex. can happen in a constructor of one of the children of Person
        // people.add(this);
    }

    // A safer alternative
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
