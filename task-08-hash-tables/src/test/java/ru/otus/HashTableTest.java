package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

	private HashTable<Integer, String> hashTable;

	@BeforeEach
	void setUp() {
		hashTable = new HashTable<>();
	}

	@Test
	void size() {
	}

	@Test
	void put() {
		hashTable.put(25, "Dog");
		hashTable.put(27, "Cat");
		hashTable.put(27, "Fox");
		hashTable.put(25, "After Dog");
		hashTable.put(25, "After Fox");
		hashTable.put(25, "First of entries");
	}

	@Test
	void get() {
	}
}
