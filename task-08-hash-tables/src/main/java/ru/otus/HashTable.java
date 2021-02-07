package ru.otus;

public class HashTable<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    private static final float LOAD_FACTOR = 0.5f;

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private int size;

    private Entry<K, V>[] entries;

    public HashTable(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }

        entries = new Entry[initialCapacity];
        size = 0;
    }

    public HashTable() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        final int entriesLength = entries.length;
        final int startIndex = getIndex(key);

        for (int index = startIndex; index != startIndex - 1; index++) {
            if (entries[index] == null) {
                entries[index] = new Entry<>(key, value);
                if (++size > entries.length * LOAD_FACTOR) {
                    resize();
                }
                return null;
            }

            if (entries[index].key == key) {
                final V previousValue = entries[index].value;
                entries[index] = new Entry<>(key, value);
                return previousValue;
            }

            index = index == entriesLength - 1 ? 0 : index + 1;
        }

        return null;
    }

    public V get(Object key) {
        final int entriesLength = entries.length;
        final int startIndex = getIndex(key);

        for (int index = startIndex; index != startIndex - 1; index++) {
            if (entries[index] == null) {
                return null;
            }

            if (entries[index].key == key) {
                return entries[index].value;
            }

            index = index == entriesLength - 1 ? 0 : index + 1;
        }

        return null;
    }

    public V remove(Object key) {
        return null;
    }

    private int getIndex(Object key) {
        return key.hashCode() % entries.length;
    }

    private void resize() {
        final int newCapacity = Math.min(entries.length * 2, MAXIMUM_CAPACITY);
        final Entry<K, V>[] newEntries = new Entry[newCapacity];

        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                newEntries[entry.key.hashCode() % newCapacity] = entry;
            }
        }

        entries = newEntries;
    }

    private static class Entry<K, V> {

        private final K key;

        private final V value;

        private boolean isDeleted;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            isDeleted = false;
        }
    }
}
