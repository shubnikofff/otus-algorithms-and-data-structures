package ru.otus.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueImplTest {

	private PriorityQueue<Integer> queue;

	@BeforeEach
	void setUp() {
		queue = new PriorityQueueImpl<>();
		queue.enqueue(2, 100);
		queue.enqueue(-1, 200);
		queue.enqueue(1, 300);
		queue.enqueue(3, 400);
		queue.enqueue(-2, 500);
	}

	@Test
	void enqueue() {
		queue.enqueue(2, 600);

		assertEquals(400, queue.dequeue());
		assertEquals(100, queue.dequeue());
		assertEquals(600, queue.dequeue());
	}

	@Test
	void dequeue() {
		assertEquals(400, queue.dequeue());
		assertEquals(100, queue.dequeue());
	}
}
