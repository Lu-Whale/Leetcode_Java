package LeetCode75.Trie;

import javax.management.loading.PrivateClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/search-suggestions-system/?envType=study-plan-v2&envId=leetcode-75
public class _1268_Search_Suggestions_System {

    private int[] child = new int[26];
    private boolean isEnd = false;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        return result;
    }


}

class TrieNode {
    private TrieNode[] child;
    private boolean isEnd;
    private char c;

    public TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
        c = ' ';
    }

    public void insert(String words) {
        TrieNode pointer = this;

        for(int i = 0; i < words.length(); i++) {

            char c = words.charAt(i);
            int index = c - 'a';
            if(pointer.child[index] == null){
                pointer.child[index] = new TrieNode();
                pointer.child[index].c = c;
            }

            pointer = pointer.child[index];
        }

        pointer.isEnd = true;
    }

    public String search(String words) {
        TrieNode pointer = this;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            int index = c - 'a';

            if(pointer.child[index] == null) {
                return null;
            }
            stringBuilder.append(c);
            pointer = pointer.child[index];
        }

        return stringBuilder.toString();
    }
}

// Trie + DFS
class SearchSuggestionsSystem {
    private class TrieNode{
        boolean end = false;
        String str = null;
        int count = 0;
        TrieNode[] children = new TrieNode[26];
    }

    private class Trie{
        TrieNode root = new TrieNode();
        public void insert(String[] products){
            for(String str : products){
                insertWord(str);
            }
        }
        private void insertWord(String products){
            TrieNode node = root;
            for(char c : products.toCharArray()){
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            if(node.end != true){
                node.end = true;
                node.str = products;
            }
            node.count++;
        }
        public List<List<String>> searchWord(String word){
            List<List<String>> result = new ArrayList<>();
            for(int i = 1; i <= word.length(); i++){
                result.add(search(word.substring(0, i)));
            }
            return result;
        }
        private List<String> search(String pattern){
            List<String> result = new ArrayList<>();
            TrieNode node = root;
            for(char c : pattern.toCharArray()){
                if(node.children[c - 'a'] == null){
                    return result;
                }
                node = node.children[c - 'a'];
            }
            Solution(node, result);
            return result;
        }
        private void Solution(TrieNode root, List<String> result){
            if(root.end){
                for(int i = 0; i < root.count; i++){
                    result.add(root.str);
                    if(result.size() == 3){
                        return;
                    }
                }
            }
            for(TrieNode node : root.children){
                if(node != null){
                    Solution(node, result);
                }
                if(result.size() == 3){
                    return;
                }
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        trie.insert(products);
        return trie.searchWord(searchWord);
    }
}

// sort + Two Pointers
/**
 * First, sort the entire list of products in dictionary (lexicographical) order. Then iterate over all the
 * letters in the search word.
 *
 * At the same time, use two pointers to check through the entire list of products.
 * When the number of characters in a product is less than the number of letters iterated in the current search word,
 * or when the characters pointed by the left and right pointers do not match the current search word letter, move
 * the left and right pointers to the left and right, respectively.
 *
 * Collect results based on the current pointers. Use the condition j < l + 3 && j <= r to determine the collection
 * of results, with no more than 3 for each group.
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);

        int l = 0;
        int r = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != searchWord.charAt(i))) {
                ++l;
            }
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != searchWord.charAt(i))) {
                --r;
            }

            List<String> list = new ArrayList<>();
            for (int j = l; j < l + 3 && j <= r; j++) {
                list.add(products[j]);
            }
            res.add(list);
        }
        return res;
    }
}