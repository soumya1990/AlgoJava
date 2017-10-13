package com.algo.trie;

/**
 * Created by soumya on 14/09/17.
 */

public class Dictionary {

    TrieNode root = new TrieNode();

    public void insertWord(String word) {
        char[] letters = word.toCharArray();
        TrieNode currNode =  root;
        for (int i=0;i<letters.length;i++) {
            TrieNode nextNode = currNode.getAlphabets()[i];
            if(nextNode == null) {
                nextNode = new TrieNode();
                currNode.getAlphabets()[i] = nextNode;
            }
            currNode = nextNode;
        }
        currNode.setEndOfWord(true);
    }

    public boolean findWord(){
     return true;
    }

}
