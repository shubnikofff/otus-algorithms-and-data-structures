package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrieTest {

	private Trie trie;

	@BeforeEach
	void setUp() {
		trie = Trie.builder()
				.withPattern("a")
				.withPattern("ab")
				.withPattern("bc")
				.withPattern("bca")
				.withPattern("c")
				.withPattern("caa")
				.withPattern("cabc")
				.build();
	}

	@Test
	void search() {
		final List<String> expected = new List<>();
		expected.add("a");
		expected.add("ab");
		expected.add("bc");
		expected.add("c");
		expected.add("bca");
		expected.add("a");
		expected.add("ab");
		expected.add("cabc");
		expected.add("bc");
		expected.add("c");
		expected.add("bca");
		expected.add("a");
		expected.add("caa");
		expected.add("a");
		expected.add("ab");
		expected.add("bc");
		expected.add("c");
		expected.add("bca");
		expected.add("a");
		expected.add("ab");
		expected.add("cabc");
		expected.add("bc");
		expected.add("c");
		expected.add("bca");
		expected.add("a");
		expected.add("caa");
		expected.add("a");

		assertEquals(expected, trie.search("abcabcaabcabcaa"));
	}
}
