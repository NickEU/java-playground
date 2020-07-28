package tf.nick.hypertrash.collections.greedyLoadBalancer;

import java.util.LinkedList;

class Queue {
    private final java.util.Queue<Task> tasks = new LinkedList<>();
    private int loadIndicator = 0;
    private static int ids = 0;
    private final int id = ids++;

    void addTask(Task task) {
        loadIndicator += task.getLoadFactor();
        getTasks().add(task);
    }

    java.util.Queue<Task> getTasks() {
        return tasks;
    }

    int getId() {
        return id;
    }

    int getLoadIndicator() {
        return loadIndicator;
    }
}
