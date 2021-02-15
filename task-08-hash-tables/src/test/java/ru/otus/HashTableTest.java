package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

	private HashTable<Integer, String> hashTable;

	@BeforeEach
	void setUp() {
		hashTable = new HashTable<>();
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
	@DisplayName("HashTable should be consistent after resizing")
	void resize() {
		hashTable = new HashTable<>(5);
		hashTable.put(10, "10");
		hashTable.put(20, "20");
		hashTable.put(30, "30");
		hashTable.put(40, "40");

		assertEquals("10", hashTable.get(10));
		assertEquals("20", hashTable.get(20));
		assertEquals("30", hashTable.get(30));
		assertEquals("40", hashTable.get(40));
	}

	@Test
	@DisplayName("Method put should add new item")
	void put_new() {
		assertNull(hashTable.get(1));
		hashTable.put(1, "1");
		assertEquals("1", hashTable.get(1));
	}

	@Test
	@DisplayName("Method put should update existing item")
	void put_existing() {
		hashTable.put(1, "1");
		hashTable.put(1, "2");

		assertEquals("2", hashTable.get(1));
	}

	@Test
	@DisplayName("Method put should return old value")
	void put_result() {
		assertNull(hashTable.put(2, "2"));
		assertEquals("2", hashTable.put(2, "3"));
	}

	@Test
	@DisplayName("Method get should return correct value")
	void get() {
		hashTable.put(-100, "100");

		assertEquals("100", hashTable.get(-100));
	}

	@Test
	@DisplayName("Method get should return null")
	void get_not_existing() {
		assertNull(hashTable.get(-100));
	}

	@Test
	@DisplayName("Method remove should delete item and return its  value")
	void remove() {
		hashTable.put(1, "1");
		hashTable.put(2, "2");
		hashTable.put(3, "3");

		assertEquals("2", hashTable.remove(2));
		assertNull(hashTable.get(2));
	}
}
