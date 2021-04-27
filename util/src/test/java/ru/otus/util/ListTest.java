package ru.otus.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

	private List<Integer> list;

	@BeforeEach
	void setUp() {
		list = new List<>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
	}

	@Test
	void add() {
		list.add(600);
		assertEquals(6, list.size());
		assertEquals(600, list.get(list.size() - 1));
	}

	@Test
	void get() {
		assertEquals(300, list.get(2));
	}

	@Test
	void set() {
		final Integer result = list.set(1, 300);

		assertEquals(200, result);
		assertEquals(300,  list.get(1));

		assertThrows(IndexOutOfBoundsException.class, () -> list.set(100, 100));
	}

	@Test
	void remove() {
		assertEquals(300, list.remove(2));
		assertEquals(4, list.size());
	}

	@Test
	void size() {
		assertEquals(5, list.size());
	}

	@Test
	void toArray() {
		final Integer[] expectedResult = {100, 200, 300, 400, 500};
		assertArrayEquals(expectedResult, list.toArray());
	}
}
