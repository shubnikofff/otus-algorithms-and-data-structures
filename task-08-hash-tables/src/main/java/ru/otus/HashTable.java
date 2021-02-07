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
		final int startIndex = findIndex(key);
		int deletedEntryIndex = -1;

		for (int index = startIndex; index != startIndex - 1; index++) {
			if (entries[index] == null) {
				if (deletedEntryIndex == -1) {
					entries[index] = new Entry<>(key, value);
					if (++size > entries.length * LOAD_FACTOR) {
						resize();
					}
				} else {
					entries[deletedEntryIndex] = new Entry<>(key, value);
				}

				return null;
			}

			if (entries[index].key == key) {
				final V previousValue = entries[index].value;
				entries[index] = new Entry<>(key, value);
				return previousValue;
			}

			if (entries[index].isDeleted && deletedEntryIndex == -1) {
				deletedEntryIndex = index;
			}

			index = index == entriesLength - 1 ? 0 : index + 1;
		}

		return null;
	}

	public V get(Object key) {
		final int entriesLength = entries.length;
		final int startIndex = findIndex(key);
		int deletedEntryIndex = -1;

		for (int index = startIndex; index != startIndex - 1; index++) {
			if (entries[index] == null) {
				return null;
			}

			if (entries[index].key == key && !entries[index].isDeleted) {
				final Entry<K, V> foundEntry = entries[index];

				if (deletedEntryIndex != -1) {
					entries[index] = entries[deletedEntryIndex];
					entries[deletedEntryIndex] = foundEntry;
				}

				return foundEntry.value;
			}

			if (entries[index].isDeleted && deletedEntryIndex == -1) {
				deletedEntryIndex = index;
			}

			index = index == entriesLength - 1 ? 0 : index + 1;
		}

		return null;
	}

	public V remove(Object key) {
		final int entriesLength = entries.length;
		final int startIndex = findIndex(key);

		for (int index = startIndex; index != startIndex - 1; index++) {
			if (entries[index] == null) {
				return null;
			}

			if (entries[index].key == key) {
				entries[index].isDeleted = true;
				return entries[index].value;
			}

			index = index == entriesLength - 1 ? 0 : index + 1;
		}

		return null;
	}

	private static int findIndex(Object key, Object[] entries) {
		return Math.abs(key.hashCode()) % entries.length;
	}

	private int findIndex(Object key) {
		return findIndex(key, entries);
	}

	private void resize() {
		final int newCapacity = Math.min(entries.length * 2, MAXIMUM_CAPACITY);
		final Entry<K, V>[] newEntries = new Entry[newCapacity];

		for (Entry<K, V> entry : entries) {
			if (entry != null) {
				final int index = findIndex(entry.key, newEntries);
				newEntries[index] = entry;
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
