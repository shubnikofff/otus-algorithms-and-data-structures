package ru.otus;

import ru.otus.bst.AVLTree;
import ru.otus.bst.BinarySearchTree;
import ru.otus.bst.Treap;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Benchmark {

	private static final int NUMBER_OF_KEYS = 1_000_000;

	public static void main(String[] args) {
		final int[] keys = new Random().ints(NUMBER_OF_KEYS).toArray();
		final int[] sortedKeys = IntStream.of(keys).sorted().toArray();

		System.out.println("\nRun on Binary search tree with random keys...\n" + run(new BinarySearchTree(), keys));

		try {
			System.out.println("\nRun on Binary search tree with sorted keys...\n" + run(new BinarySearchTree(), sortedKeys));
		} catch (StackOverflowError e) {
			System.out.println(e.toString());
		}

		System.out.println("\nRun on AVL tree with random keys...\n" + run(new AVLTree(), keys));
		System.out.println("\nRun on AVL tree with sorted keys...\n" + run(new AVLTree(), sortedKeys));

		System.out.println("\nRun on Treap tree with random keys...\n" + run(new Treap(), keys));
		System.out.println("\nRun on Treap tree with sorted keys...\n" + run(new Treap(), sortedKeys));
	}

	private static Results run(BinarySearchTree tree, int[] keys) {
		final Results results = new Results();

		Instant startTime = Instant.now();
		Arrays.stream(keys).forEach(tree::insert);
		results.insertTime = Duration.between(startTime, Instant.now());

		startTime = Instant.now();
		Arrays.stream(keys).filter(n -> n % 10 == 0).forEach(tree::search);
		results.searchTime = Duration.between(startTime, Instant.now());

		startTime = Instant.now();
		Arrays.stream(keys).filter(n -> n % 10 == 0).forEach(tree::remove);
		results.removeTime = Duration.between(startTime, Instant.now());

		return results;
	}

	private static class Results {
		private Duration insertTime;
		private Duration searchTime;
		private Duration removeTime;

		@Override
		public String toString() {
			return String.format(
					"Insert: %dms\nSearch: %dms\nRemove: %dms\n",
					insertTime.toMillis(),
					searchTime.toMillis(),
					removeTime.toMillis()
			);
		}
	}
}
