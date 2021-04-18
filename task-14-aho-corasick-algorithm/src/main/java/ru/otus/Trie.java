package ru.otus;

/**
 * Consider only lower case letters a..z
 */
public class Trie {

    private final TrieNode root;

    private Trie() {
        root = new TrieNode(null, false);
    }

    public static TrieBuilder builder() {
        return new TrieBuilder();
    }

    private static class TrieBuilder {

        private final Trie trie = new Trie();

        public TrieBuilder withPattern(String pattern) {
            trie.root.addChild(pattern);
            return this;
        }

        public Trie build() {
            return trie;
        }
    }
}
