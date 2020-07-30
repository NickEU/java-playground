package tf.nick.hypertrash.collections.map.multiset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class HashMultiset<E> implements Multiset<E> {
    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        map.put(elem, getMultiplicity(elem) + 1);
    }

    @Override
    public void remove(E elem) {
        int multiplicity = getMultiplicity(elem);
        if (multiplicity > 1) {
            map.put(elem, multiplicity - 1);
        } else {
            map.remove(elem);
        }
    }

    @Override
    public void union(Multiset<E> other) {
        other.toSet().forEach(
                k -> map.put(k, Math.max(this.getMultiplicity(k), other.getMultiplicity(k))));
    }

    @Override
    public void intersect(Multiset<E> other) {
        Map<E, Integer> result = new HashMap<>();
        Set<E> otherKeys = other.toSet();
        otherKeys.retainAll(this.toSet());
        otherKeys.forEach(
                k -> result.put(k, Math.min(other.getMultiplicity(k), this.getMultiplicity(k))));
        map = result;
    }

    @Override
    public int getMultiplicity(E elem) {
        return map.getOrDefault(elem, 0);
    }

    @Override
    public boolean contains(E elem) {
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        return map.size();
    }

    @Override
    public int size() {
        return map.values().stream().mapToInt(i -> i).sum();
    }

    @Override
    public Set<E> toSet() {
        // Creating a new HashSet<> object helps us avoid ConcurrentModificationException.
        // It is thrown when we try to iterate over elements of Map and modify them at the same time
        return new HashSet<>(map.keySet());
    }
}
