package ru.otus;

public class HashTable<K, V> {

	private static final int INITIAL_CAPACITY = 10;

	private static final float LOAD_FACTOR = 0.5f;

	private int size = 0;

	private Entry<K, V>[] entries = new Entry[INITIAL_CAPACITY];

	public int size() {
		return size;
	}

	public V put(K key, V value) {
		final int entryIndex = getNearestEmptyIndex(key);
		entries[entryIndex] = new Entry<>(key, value);

		size++;
		// TODO rehash

		return value;
	}

	public V get(K key) {
		final int keyHash = key.hashCode();

		return entries[keyHash].value;
	}

	private int hash(K key) {
		return key.hashCode() % entries.length;
	}

	private int getNearestEmptyIndex(K key) {
		final int entriesLength = entries.length;
		int index = hash(key);

		while (entries[index] != null) {
			index++;
			if (index == entriesLength) {
				index = 0;
			}
		}

		return index;
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
