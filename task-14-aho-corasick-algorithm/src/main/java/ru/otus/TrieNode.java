package ru.otus;

public class TrieNode {

	private static final int ALPHABET_LENGTH = 26;

	private final String key;

	private final TrieNode[] children;

	private final boolean isTerminal;

	private TrieNode suffixLink;

	private TrieNode finalLink;

	public TrieNode(String key, boolean isTerminal) {
		this.key = key;
		this.isTerminal = isTerminal;
		children = new TrieNode[ALPHABET_LENGTH];
	}

	public void addChild(String key) {
		addChild(key, 0);
	}

	public TrieNode getChild(char key) {
		return children[charToChildIndex(key)];
	}

	private int charToChildIndex(char key) {
		return key - 'a';
	}

	private void addChild(String key, int keyPosition) {
		if (keyPosition == key.length()) {
			return;
		}

		final int childIdx = charToChildIndex(key.charAt(keyPosition));

		if (children[childIdx] == null) {
			final String nodeName = key.substring(0, keyPosition + 1);
			final boolean isTerminal = nodeName.equals(key);
			children[childIdx] = new TrieNode(nodeName, isTerminal);
		}

		children[childIdx].addChild(key, ++keyPosition);
	}

	public String getKey() {
		return key;
	}

	public boolean isTerminal() {
		return isTerminal;
	}

	public TrieNode[] getChildren() {
		return children;
	}

	public TrieNode getSuffixLink() {
		return suffixLink;
	}

	public void setSuffixLink(TrieNode suffixLink) {
		this.suffixLink = suffixLink;
	}

	public TrieNode getFinalLink() {
		return finalLink;
	}

	public void setFinalLink(TrieNode finalLink) {
		this.finalLink = finalLink;
	}

	@Override
	public String toString() {
		return key;
	}
}
