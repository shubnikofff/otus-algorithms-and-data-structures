package ru.otus.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListWrapperTest {

	private ArrayListWrapper<Integer> arrayListWrapper;

	@BeforeEach
	void setUp() {
		arrayListWrapper = new ArrayListWrapper<>();
		arrayListWrapper.add(100, 0);
		arrayListWrapper.add(200, 1);
	}

	@Test
	void add() {
		assertEquals(100, arrayListWrapper.get(0));
		assertEquals(200, arrayListWrapper.get(1));

		assertThrows(IndexOutOfBoundsException.class, () -> arrayListWrapper.add(300, 100));
	}

	@Test
	void remove() {
		assertEquals(100, arrayListWrapper.remove(0));
		assertEquals(1, arrayListWrapper.size());
		assertEquals(200, arrayListWrapper.get(0));
	}

	@Test
	void size() {
		assertEquals(2, arrayListWrapper.size());
	}
}
