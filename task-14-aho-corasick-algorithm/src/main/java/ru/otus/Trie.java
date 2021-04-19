package ru.otus;

import ru.otus.util.List;

import java.util.function.Consumer;

/**
 * Consider only lower case letters a..z
 */
public class Trie {

	private final TrieNode root;

	private Trie() {
		root = new TrieNode(null, false);
	}

	public List<String> search(String text) {
		final List<String> result = new List<>();
		return result;
	}

	private TrieNode findNode(String key) {
		TrieNode node = root;
		for (char keyChar : key.toCharArray()) {
			node = node.getChild(keyChar);

			if (node == null) {
				return null;
			}
		}

		return node;
	}

	private void walkTrie(TrieNode node, Consumer<TrieNode> visitor) {
		for (TrieNode child : node.getChildren()) {
			if (child != null) {
				visitor.accept(child);
				walkTrie(child, visitor);
			}
		}
	}

	private void setSuffixLink(TrieNode node) {
		final String nodeKey = node.getKey();

		for (int suffixIdx = 1; suffixIdx < nodeKey.length(); suffixIdx++) {
			final TrieNode suffixLink = findNode(nodeKey.substring(suffixIdx));
			if (suffixLink != null) {
				node.setSuffixLink(suffixLink);
				return;
			}
		}

		node.setSuffixLink(root);
	}

	private void setFinalLink(TrieNode node) {
		TrieNode finalLink = node.getSuffixLink();

		while (finalLink != root) {
			if (finalLink.isTerminal()) {
				node.setFinalLink(finalLink);
				return;
			}

			finalLink = finalLink.getSuffixLink();
		}
	}

	public static TrieBuilder builder() {
		return new TrieBuilder();
	}

	public static class TrieBuilder {

		private final Trie trie = new Trie();

		public TrieBuilder withPattern(String pattern) {
			trie.root.addChild(pattern);
			return this;
		}

		public Trie build() {
			trie.walkTrie(trie.root, trie::setSuffixLink);
			trie.walkTrie(trie.root, trie::setFinalLink);
			return trie;
		}
	}
}
