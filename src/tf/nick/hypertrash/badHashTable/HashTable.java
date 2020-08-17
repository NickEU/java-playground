package tf.nick.hypertrash.badHashTable;

class HashTable<T> {
    private int size;
    private TableEntry[] table;

    public HashTable(int size) {
        this.size = size;
        table = new TableEntry[size];
    }

    public boolean put(int key, T value) {
        int id = findKey(key);
        if (id == -1) {
            rehash();
            id = findKey(key);
        }
        table[id] = new TableEntry<>(key, value);
        return true;
    }

    public T get(int key) {
        int id = findKey(key);

        if (id == -1 || table[id] == null) {
            return null;
        }

        return (T) table[id].getValue();
    }

    private int findKey(int key) {
        int hash = key % size;

        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % size;

            if (hash == key % size) {
                return -1;
            }
        }

        return hash;
    }

    private void rehash() {
        int scalingFactor = 2;
        size *= scalingFactor;
        var oldTable = table;
        table = new TableEntry[size];
        for (var entry : oldTable) {
            put(entry.getKey(), (T) entry.getValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder tableStringBuilder = new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                tableStringBuilder.append(i).append(": null");
            } else {
                tableStringBuilder.append(i)
                    .append(": key=").append(table[i].getKey())
                    .append(", value=").append(table[i].getValue());
            }

            if (i < table.length - 1) {
                tableStringBuilder.append("\n");
            }
        }

        return tableStringBuilder.toString();
    }
}
