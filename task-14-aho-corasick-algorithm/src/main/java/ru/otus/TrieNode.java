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

    public void addChild(String key, int keyPosition) {
        if (keyPosition == key.length()) {
            return;
        }

        final char[] keyChars = key.toCharArray();

    }
}
