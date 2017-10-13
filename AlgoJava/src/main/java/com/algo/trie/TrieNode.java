package com.algo.trie;


import lombok.Data;
import lombok.Getter;

public @Data
class TrieNode {

    @Getter private boolean endOfWord;
    @Getter private TrieNode[] alphabets;
    TrieNode() {
        endOfWord = false;
        alphabets = new TrieNode[26];
    }

}
