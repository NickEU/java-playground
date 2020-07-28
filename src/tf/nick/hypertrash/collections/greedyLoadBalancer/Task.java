package tf.nick.hypertrash.collections.greedyLoadBalancer;

class Task {
    private final int id;
    private final int loadFactor;

    Task(int id, int loadFactor) {
        this.id = id;
        this.loadFactor = loadFactor;
    }

    int getId() {
        return id;
    }

    int getLoadFactor() {
        return loadFactor;
    }
}
