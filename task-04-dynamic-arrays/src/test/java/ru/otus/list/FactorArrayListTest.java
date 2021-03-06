package ru.otus.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorArrayListTest {

	private List<Integer> list;

	@BeforeEach
	void setUp() {
		list = new FactorArrayList<>();
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
	void remove() {
		assertEquals(300, list.remove(2));
		assertEquals(4, list.size());
	}

	@Test
	void size() {
		assertEquals(5, list.size());
	}
}
