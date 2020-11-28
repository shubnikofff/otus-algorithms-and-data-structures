package ru.otus.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleArrayTest {

	private SingleArray<Integer> singleArray;

	@BeforeEach
	void setUp() {
		singleArray = new SingleArray<>();
		singleArray.add(100, 0);
		singleArray.add(200, 1);
	}

	@Test
	void add() {
		assertEquals(100, singleArray.get(0));
		assertEquals(200, singleArray.get(1));

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> singleArray.add(300, 100));
	}

	@Test
	void remove() {
		assertEquals(100, singleArray.remove(0));
		assertEquals(1, singleArray.size());
		assertEquals(200, singleArray.get(0));
	}

	@Test
	void size() {
		assertEquals(2, singleArray.size());
	}
}
