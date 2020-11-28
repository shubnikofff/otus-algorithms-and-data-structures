package ru.otus.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorArrayTest {

	private VectorArray<Integer> vectorArray;

	@BeforeEach
	void setUp() {
		vectorArray = new VectorArray<>();
		vectorArray.add(100, 0);
		vectorArray.add(200, 1);
	}

	@Test
	void add() {
		assertEquals(100, vectorArray.get(0));
		assertEquals(200, vectorArray.get(1));

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> vectorArray.add(300, 100));
	}

	@Test
	void remove() {
		assertEquals(100, vectorArray.remove(0));
		assertEquals(1, vectorArray.size());
		assertEquals(200, vectorArray.get(0));
	}

	@Test
	void size() {
		assertEquals(2, vectorArray.size());
	}
}
