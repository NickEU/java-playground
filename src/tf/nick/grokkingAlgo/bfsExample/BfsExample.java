package tf.nick.grokkingAlgo.bfsExample;

import tf.nick.utility.Helpers;

public class BfsExample {
    public static void main(String[] args) {
        People people = new People();
        Person john = new Person("John", 19);
        Person tammy = new Person("Tammy", 25);
        Person leo = new Person("Leo", 23);
        Person graham = new Person("Graham", 18);
        Person heidi = new Person("Heidi", 20);
        john.addNeighbour(tammy);
        tammy.addNeighbours(Helpers.listOf(john, leo, graham));
        graham.addNeighbour(tammy);
        leo.addNeighbours(Helpers.listOf(tammy, heidi));
        people.setStartingNode(john);
        people.findPersonByName("Leo");
        people.findPersonByName("Nick");
        people.findPersonByName("Heidi");
    }

}
