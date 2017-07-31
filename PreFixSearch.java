/**
 * Created by yizhiw on 7/31/2017.
 * implement a prefix tree, support add and search. for any prefix string, return all the words
 * starting with that prefix. i.e:
 * fa - face,facemash, facetime, facebook
 * am - amazon,amazing, amaron
 */

import java.util.*;

public class PreFixSearch {
    class TrieNode {
        boolean isWord;
        TrieNode[]  children;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public PreFixSearch() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if ((word == null) || (word.length() == 0)) {
            return;
        }

        TrieNode traverse = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (traverse.children[ch - 'a'] == null) {
                traverse.children[ch - 'a'] = new TrieNode();
            }

            traverse = traverse.children[ch - 'a'];
        }

        traverse.isWord = true;
    }

    public void helper(TrieNode root, List<String> result, String word) {
        // return conditon
        if (root.isWord == true) {
            result.add(word);
        }

        String prev = word;
        // BFS to loop all the nodes on the same level
        for (int i = 0; i < 26; i++) {
            TrieNode node = root.children[i];

            if (node != null) {
                word += String.valueOf((char)(i + 'a'));
                //DFS, recursively go deeper to the trie tree
                helper(node, result, word);
                // reset the word string to earlier value
                word = prev;
            }
        }
    }

    public List<String> search(String prefix) {
        List<String> result = new LinkedList<String>();

        if ((prefix == null) || (prefix.length() == 0)) {
            return result;
        }

        TrieNode traverse = root;
        // start to search in the trie tree with the prefix
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (traverse.children[ch - 'a'] == null) {
                return result;
            } else {
                traverse = traverse.children[ch - 'a'];
            }
        }

        // BFS + DFS for the words starting with prefix
        helper(traverse, result, prefix);

        return result;
    }

    public static void main(String[] args) {
        String[] dict = {"face","facemash", "facetime", "facebook", "amazon", "amazing", "easy", "ah", "fusion"};

        PreFixSearch obj = new PreFixSearch();

        for (String str : dict) {
            obj.addWord(str);
        }

        List<String> result = obj.search("f");
        System.out.println(result);
    }
}