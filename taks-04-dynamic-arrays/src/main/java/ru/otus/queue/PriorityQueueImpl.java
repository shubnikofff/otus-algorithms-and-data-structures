package ru.otus.queue;

import ru.otus.array.DynamicArray;
import ru.otus.array.FactorArray;

public class PriorityQueueImpl<T> implements PriorityQueue<T> {

	private final DynamicArray<PriorityQueueItem<T>> array = new FactorArray<>();

	@Override
	public void enqueue(int priority, T item) {
		int insertIndex = 0;

		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getPriority() < priority) {
				insertIndex = i;
				break;
			}
		}

		array.add(new PriorityQueueItem<>(item, priority), insertIndex);
	}

	@Override
	public T dequeue() {
		return array.remove(array.size() - 1).getItem();
	}

	@Override
	public int size() {
		return array.size();
	}
}
