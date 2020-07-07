package tf.nick.grokkingAlgo.bfsExample;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Person {
    private final List<Person> neighbours = new LinkedList<>();
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public List<Person> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Person person) {
        neighbours.add(person);
    }

    public void addNeighbours(Collection<Person> people) {
        neighbours.addAll(people);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "nr of connections=" + neighbours.size() +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
