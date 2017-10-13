package com.algo.binarysearchtree;

import com.algo.datastructures.Node;
import com.algo.interfaces.DynamicSetOperations;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DictionaryBST implements DynamicSetOperations {
    @Getter
    private NodeBST root;

    @Override
    public boolean insert(int key, Object value) {
        NodeBST newNode = new NodeBST();
        newNode.setKey(key);
        newNode.setVal((String) value);
        root = insert(root, newNode);
        return true;
    }

    private NodeBST insert(NodeBST root, NodeBST node) {
        if (root == null) {
            return node;
        }
        if (root.getKey() <= node.getKey()) {
            root.setRight(insert(root.getRight(), node));
        } else {
            root.setLeft(insert(root.getLeft(), node));
        }
        return root;
    }

    public void inOrderTraverse(NodeBST root, @NotNull List<Integer> keyList) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.getLeft(), keyList);
        keyList.add(root.getKey());
        inOrderTraverse(root.getRight(), keyList);


    }

    @Override
    public Object search(int key) {
        NodeBST curr_Node = root;
        while (curr_Node != null) {
            if (curr_Node.getKey() < key) {
                curr_Node = curr_Node.getRight();
            } else if (curr_Node.getKey() > key) {
                curr_Node = curr_Node.getLeft();
            } else {
                return curr_Node.getVal();
            }
        }
        return "NOT FOUND";
    }

    @Override
    public boolean remove(int key) {
        return false;
    }

    @Override
    public int maximum() {
        NodeBST curr_node = root;
        int maxKey = Integer.MIN_VALUE;
        while (curr_node != null) {
            maxKey = curr_node.getKey();
            curr_node = curr_node.getRight();
        }
        return maxKey;
    }

    @Override
    public int minimum() {
        NodeBST curr_node = root;
        int minKey = Integer.MAX_VALUE;
        while (curr_node != null) {
            minKey = curr_node.getKey();
            curr_node = curr_node.getLeft();
        }
        return minKey;
    }

    @Override
    public int successor(int key) {
        NodeBST curr_Node = root;
        int ceil = Integer.MIN_VALUE;
        while (curr_Node != null) {
            if (curr_Node.getKey() > key) {
                ceil = curr_Node.getKey();
                curr_Node = curr_Node.getLeft();
            } else {
                curr_Node = curr_Node.getRight();
            }
        }
        return ceil;
    }

    @Override
    public int predecessor(int key) {
        return 0;
    }
}
