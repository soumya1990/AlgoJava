package com.algo.trie;

/**
 * Created by soumya on 14/09/17.
 */

public class Dictionary {
    class Node {
        boolean isEndofWord = false;
        Node[] nodes = new Node[26];
    }
    Node root = new Node();
    public void insertWord(String word) {
        char[] letters = word.toCharArray();
        Node currNode =  root;
        for (int i=0;i<letters.length;i++) {
            Node nextNode = currNode.nodes[i];
            if(nextNode == null) {
                nextNode = new Node();
                currNode.nodes[i] = nextNode;
            }
            currNode = nextNode;
        }
        currNode.isEndofWord = true;
    }


}
