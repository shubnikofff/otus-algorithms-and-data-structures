package ru.otus;

public class TrieNode {

	private static final int ALPHABET_LENGTH = 26;

	private final String key;

	private final TrieNode[] children;

	private final boolean isTerminal;

	public TrieNode(String key, boolean isTerminal) {
		this.key = key;
		this.isTerminal = isTerminal;
		children = new TrieNode[ALPHABET_LENGTH];
	}

	public void addChild(String key) {
		addChild(key, 0);
	}

	private void addChild(String key, int keyPosition) {
		if (keyPosition == key.length()) {
			return;
		}

		final int childIdx = key.charAt(keyPosition) - 'a';

		if (children[childIdx] == null) {
			final String nodeName = key.substring(0, keyPosition + 1);
			final boolean isTerminal = nodeName.equals(key);
			children[childIdx] = new TrieNode(nodeName, isTerminal);
		}

		children[childIdx].addChild(key, ++keyPosition);
	}
}
