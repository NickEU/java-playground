package tf.nick.hypertrash.collections.greedyLoadBalancer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class LoadBalancer {
    private static final Comparator<Queue> COMPARE_BY_LOAD_THEN_ID =
            Comparator.comparingInt(Queue::getLoadIndicator)
                    .thenComparingInt(Queue::getId);
    private final List<Queue> queues = new ArrayList<>();

    LoadBalancer(int queueCount) {
        for (int i = 0; i < queueCount; i++) {
            addQueue(new Queue());
        }
    }

    private void addQueue(Queue toAdd) {
        getQueues().add(toAdd);
    }

    private List<Queue> getQueues() {
        return queues;
    }

    void addTask(Task task) {
        getQueues().stream()
                .min(COMPARE_BY_LOAD_THEN_ID).orElseThrow()
                .addTask(task);
    }

    String getStatus() {
        StringBuilder result = new StringBuilder();
        getQueues().forEach(q -> {
            q.getTasks()
                    .forEach(t -> result.append(t.getId()).append(" "));
            result.append("\n");
        });
        return result.toString();
    }
}
