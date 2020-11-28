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
		assertEquals(100, factorArray.get(0));
		assertEquals(200, factorArray.get(1));

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
