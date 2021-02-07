package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

	private HashTable<Integer, String> hashTable;

	@BeforeEach
	void setUp() {
		hashTable = new HashTable<>(3);
	}

	@Test
	@DisplayName("Method size should return correct number of items")
	void size() {
		hashTable.put(1, "1");
		hashTable.put(3, "3");
		hashTable.put(5, "5");
		hashTable.put(3, "6");

		assertEquals(3, hashTable.size());
	}

	@Test
	@DisplayName("Put with new item")
	void put_new() {
		final int key = 12;
		final String value = "Value";

		assertNull(hashTable.get(key));
		assertEquals(0, hashTable.size());

		hashTable.put(key, value);
		assertEquals(value, hashTable.get(key));
		assertEquals(1, hashTable.size());
	}

	@Test
	@DisplayName("Put with existing item")
	void put_existing() {
		final int key = 12;
		final String value = "Value";
		final String newValue = "New value";

		hashTable.put(key, value);
		assertEquals(value, hashTable.get(key));
		assertEquals(1, hashTable.size());

		hashTable.put(key, newValue);
		assertEquals(newValue, hashTable.get(key));
		assertEquals(1, hashTable.size());
	}

	@Test
	void get() {
	}
}
