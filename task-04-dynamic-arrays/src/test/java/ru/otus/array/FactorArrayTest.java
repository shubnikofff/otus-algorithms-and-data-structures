package ru.otus.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorArrayTest {

	private FactorArray<Integer> factorArray;

	@BeforeEach
	void setUp() {
		factorArray = new FactorArray<>();
		factorArray.add(100, 0);
		factorArray.add(200, 1);
	}

	@Test
	void add() {
		factorArray.add(300, 1);
		assertEquals(100, factorArray.get(0));
		assertEquals(300, factorArray.get(1));
		assertEquals(200, factorArray.get(2));
		assertEquals(3, factorArray.size());

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> factorArray.add(300, 100));
	}

	@Test
	void remove() {
		assertEquals(100, factorArray.remove(0));
		assertEquals(1, factorArray.size());
		assertEquals(200, factorArray.get(0));
	}

	@Test
	void size() {
		assertEquals(2, factorArray.size());
	}
}
