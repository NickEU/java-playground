package tf.nick.grokkingAlgo.bfsExample;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

class People {
    private Deque<Person> queue;
    private HashSet<Person> visited;
    private Person startingNode;

    void setStartingNode(Person john) {
        startingNode = john;
    }

    private void prepareForTraversal() {
        queue = new LinkedList<>();
        visited = new HashSet<>();
        queue.add(startingNode);
    }

    void findPersonByName(String name) {
        if (startingNode == null) {
            System.out.println("Set starting node before searching the graph");
            return;
        }

        System.out.println("Searching for someone named " + name);
        prepareForTraversal();

        while (queue.peek() != null) {
            Person nextPerson = queue.poll();
            System.out.println(nextPerson);
            if (nextPerson.getName().equals(name)) {
                System.out.println("Found the culprit!");
                System.out.println(nextPerson + "\n");
                return;
            }
            if (!visited.contains(nextPerson)) {
                nextPerson.getNeighbours()
                        .forEach(p -> {
                            if (!visited.contains(p)) queue.add(p);
                        });
                visited.add(nextPerson);
            }
        }

        System.out.println("Was unable to find someone named " + name);
    }
}
