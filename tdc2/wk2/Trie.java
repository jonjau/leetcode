package tdc2.wk2;

// https://leetcode.com/problems/implement-trie-prefix-tree/solution/
public class Trie {
    static class TrieNode {
        // R links to node children
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            int r = 26;
            links = new TrieNode[r];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * <p>
     * O(m) time, O(m) space, where m is the length of the key
     * (worst case space: newly inserted key does not share any prefix with existing keys)
     * </p>
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /**
     * search a prefix or whole key in trie and
     * returns the node where search ends
     * <p>
     * O(m) time, O(1) space
     * </p>
     */
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     * <p>
     * O(m) time, O(1) space
     * </p>
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie
     * that starts with the given prefix.
     * <p>
     * O(m) time, O(1) space
     * </p>
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
