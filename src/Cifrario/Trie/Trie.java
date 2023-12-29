package Cifrario.Trie;

public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            current = current.getChildren().computeIfAbsent(ch, k -> new TrieNode());
        }

        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            current = current.getChildren().get(ch);

            if (current == null) {
                return false;
            }
        }

        return current.isEndOfWord();
    }
}

