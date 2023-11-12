package LeetCode75.Trie;

import javax.swing.text.StyledEditorKit;

// https://leetcode.com/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=leetcode-75
public class _208_Implement_Trie_Prefix_Tree {

}

class Trie {

    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(node.children[index] == null) {
                node.children[index] = new Trie();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {

        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie pointer = this;

        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(pointer.children[index] == null) {
                return null;
            }

            pointer = pointer.children[index];
        }

        return pointer;
    }
}
