package tf.nick.grokkingAlgo.bfsExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        People people = new People();
        Person john = new Person("John", 19);
        Person tammy = new Person("Tammy", 25);
        Person leo = new Person("Leo", 23);
        Person graham = new Person("Graham", 18);
        Person heidi = new Person("Heidi", 20);
        john.addNeighbour(tammy);
        tammy.addNeighbours(listOf(john, leo, graham));
        graham.addNeighbour(tammy);
        leo.addNeighbours(listOf(tammy, heidi));
        people.setStartingNode(john);
        people.findPersonByName("Leo");
        people.findPersonByName("Nick");
        people.findPersonByName("Heidi");
    }

    @SafeVarargs
    public static <T> List<T> listOf(T... objects) {
        return new ArrayList<>(Arrays.asList(objects));
    }

}
