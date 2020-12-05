package ru.otus.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixArrayTest {

	private MatrixArray<Integer> matrixArray;

	@BeforeEach
	void setUp() {
		matrixArray = new MatrixArray<>();
		matrixArray.add(100, 0);
		matrixArray.add(200, 1);
		matrixArray.add(300, 2);
		matrixArray.add(400, 3);
	}

	@Test
	void add() {
		matrixArray.add(300, 1);
		assertEquals(100, matrixArray.get(0));
		assertEquals(300, matrixArray.get(1));
		assertEquals(200, matrixArray.get(2));
		assertEquals(5, matrixArray.size());
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrixArray.add(300, 100));
	}

	@Test
	void remove() {
		assertEquals(100, matrixArray.remove(0));
		assertEquals(3, matrixArray.size());
		assertEquals(200, matrixArray.get(0));
	}

	@Test
	void size() {
		assertEquals(4, matrixArray.size());
	}
}
