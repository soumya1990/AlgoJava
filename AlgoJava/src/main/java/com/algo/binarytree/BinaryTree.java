package com.algo.binarytree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by soumya on 01/09/17.
 */

public class BinaryTree {
    static class TreeNode implements Comparable<TreeNode> {
        private int value;
        private char name;
        private int frequency;
        private TreeNode left;
        private TreeNode right;

        TreeNode(char name) {
            this.frequency = 0;
            this.name = name;
        }

        TreeNode(int value) {
            this('a');
            this.value = value;
            this.left = null;
            this.right = null;
        }


        void rightNode(TreeNode right) {
            this.right = right;
        }

        void leftNode(TreeNode left) {
            this.left = left;
        }

        void print() {
            System.out.print(value + " ");
        }

        @Override
        public int compareTo(TreeNode that) {
            if (this.frequency > that.frequency) {
                return 1;
            } else if (this.frequency == that.frequency) {
                return 0;
            } else {
                return -1;
            }
        }


    }

    private static int findparentIndex(int[] tree, int i, int size) {
        int parentIndex = (i + 1) / 2 - 1;
        return parentIndex;
    }

    public static void iterativeVisit() {
        TreeNode root = createBinaryTree();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.add(root);
        while (!treeNodeStack.isEmpty()) {
            TreeNode current = treeNodeStack.pop();
            current.print();
            TreeNode cLeft = current.left;
            TreeNode cRight = current.right;
            if (cLeft != null) {
                treeNodeStack.push(cLeft);
            }
            if (cRight != null) {
                treeNodeStack.push(cRight);
            }
        }

    }

    private static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        root.print();
        inOrderTraversal(root.right);
    }

    private static void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

    public static void binaryTreeInversionInPlace() {
        TreeNode root = createBinaryTree();
        inOrderTraversal(root);
        invertBinaryTree(root);
        System.out.println();
        inOrderTraversal(root);
    }

    public static void printPathToLeafNode(TreeNode root) {
        if (root == null) {
            root = createBinaryTree();
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.add(root);
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        while (!treeNodeStack.isEmpty()) {
            TreeNode current = treeNodeStack.pop();
            TreeNode cLeft = current.left;
            TreeNode cRight = current.right;
            if (cLeft != null) {
                parentMap.put(cLeft, current);
                treeNodeStack.push(cLeft);
            }
            if (cRight != null) {
                parentMap.put(cRight, current);
                treeNodeStack.push(cRight);
            }
            if (cLeft == null && cRight == null) {
                //Leaf Node
                printPath(current, parentMap);
            }
        }

    }

    public static boolean[] encode(String s) {
        return encodeHuffman(s);
    }

    private static boolean[] encodeHuffman(String s) {
        boolean[] decodedString = new boolean[100];
        HashMap<Character, TreeNode> nodeFreqMap = new HashMap<>();
        PriorityQueue<TreeNode> minFreqPQ = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            TreeNode n = nodeFreqMap.get(a);
            if (n == null) {
                n = new TreeNode(s.charAt(i));
                nodeFreqMap.put(a, n);
            } else {
                minFreqPQ.remove(n);
            }
            n.frequency++;
            System.out.println(a + ":" + n.name + "#" + n.frequency);
            minFreqPQ.add(n);
        }
        do {
            TreeNode node1 = null;
            TreeNode node2 = null;
            if (minFreqPQ.size() == 1) {
                node1 = minFreqPQ.remove();
                node2 = null;
            }
            if (minFreqPQ.size() > 1) {
                node1 = minFreqPQ.remove();
                node2 = minFreqPQ.remove();
            }

            TreeNode newNode = new TreeNode('%');
            if (node1 != null) {
                System.out.println(node1.name + "#" + node1.frequency);
                newNode.frequency += node1.frequency;
            }
            if (node2 != null) {
                System.out.println(node2.name + "#" + node2.frequency);
                newNode.frequency += node2.frequency;
            }
            newNode.value = newNode.frequency;
            newNode.left = node1;
            newNode.right = node2;
            minFreqPQ.add(newNode);
            System.out.println("adding Node " + newNode.name + "left = " + newNode.left.name +
                    " right " +
                    " " + newNode.right.name + " # " + newNode.frequency);
        } while (minFreqPQ.size() > 1);
        printLeavesHuffman(minFreqPQ.peek(), "");
        return decodedString;
    }

    private static void printLeavesHuffman(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(path + root.name);
            System.out.println();
            return;
        }
        //System.out.println(root.name +":"+ root.frequency);
        //System.out.print(path+","+root.name+","+root.frequency +"---");
        String newPath = new String(path);
        printLeavesHuffman(root.left, newPath + "0");
        printLeavesHuffman(root.right, newPath + "1");

    }

    private static void printPath(TreeNode leafNode, Map<TreeNode, TreeNode> parentMap) {
        TreeNode node = leafNode;
        System.out.println();
        do {
            node.print();
            node = parentMap.get(node);
        } while (node != null);

    }

    private static TreeNode createBinaryTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        node4.left = node9;
        //node4.right = node9;

        return node1;

    }

    private static int calculateHeight(TreeNode root, Map<TreeNode, Integer> nodeheightMap) {
        if (root == null) {
            nodeheightMap.put(root, 0);
            return 0;
        }
        int nodeHeight = Math.max(calculateHeight(root.left, nodeheightMap), calculateHeight(root
                .right, nodeheightMap)) + 1;
        nodeheightMap.put(root, nodeHeight);
        return nodeHeight;
    }

    private static boolean isHeightBalancedTree(TreeNode root, Map<TreeNode, Integer>
            nodeheightMap) {
        if (root == null) {
            return true;
        }
        int leftNodeHeight = 0;
        int rightNodeHeight = 0;
        if (root.left != null) {
            leftNodeHeight = nodeheightMap.get(root.left);
        }
        if (root.right != null) {
            rightNodeHeight = nodeheightMap.get(root.right);
        }
        if (Math.abs(leftNodeHeight - rightNodeHeight) <= 1) {

            return isHeightBalancedTree(root.left, nodeheightMap) && isHeightBalancedTree(root
                            .right,

                    nodeheightMap);
        }
        return false;
    }
    public static void printLevelOrderTraversal(TreeNode root) {
        if (root == null) {
            root=createBinaryTree();
        }
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("root = null");
            return;
        }
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        do {
            int levelNodeSize = levelQueue.size();
            for (int i = 0; i < levelNodeSize; i++) {
                TreeNode node = levelQueue.remove();
                node.print();
                if (node.right != null) {
                    levelQueue.add(node.right);
                }
                if (node.left != null) {
                    levelQueue.add(node.left);
                }
            }
            System.out.println();
        } while (!levelQueue.isEmpty());

    }

    public static boolean IsHeightBalanced(TreeNode rootNode) {
        if (rootNode == null) {
            rootNode = createBinaryTree();
        }
        HashMap<TreeNode, Integer> nodeHeightMap = new HashMap<>();
        calculateHeight(rootNode, nodeHeightMap);
        return isHeightBalancedTree(rootNode, nodeHeightMap);
    }

    public static void printRootToLeafComplete(int[] tree, int size) {
        for (int i = size / 2; i < size; i++) {
            int parent = i;
            ;
            System.out.println();
            System.out.print(tree[parent] + " ");
            do {
                parent = findparentIndex(tree, parent, size);
                System.out.print(tree[parent] + " ");
            } while (parent != 0);
        }

    }
    public static void convertbinTreetoDl(TreeNode root) {
        if (root == null ) {
            root = createBinaryTree();
        }
        inOrderTraversal(root);
        System.out.println();
        TreeNode linkedListNode = binTreetoDl(root,false);
        printNodes(linkedListNode);
        //inOrderTraversal(root);
    }
    private static void printNodes (TreeNode root) {
        if (root==null) {
            return;
        }
      while (root.left != null) {
          //System.out.print(root.value + " ");
          root = root.left;
      }
      while (root != null) {
          System.out.print(root.value + " ");
          root = root.right;
      }
    }
    private static boolean isLeafNode(TreeNode node) {
        if (node == null) {
            return false;
        }
        if(node.left==null && node.right==null) {
            return true;
        }
        return false;
    }
    private static TreeNode binTreetoDl(TreeNode root, boolean isLeftSubTree) {
        if(root==null) {
            return root;
        }
        if (isLeafNode(root)) return root;
        TreeNode retNode = root;
        TreeNode left = binTreetoDl(root.left,true);
        TreeNode right = binTreetoDl(root.right,false);
        if (left !=null) {
          //  System.out.print(left.value+":"+root.value);
            if (!isLeftSubTree) retNode = left;
            left.right = root;
            root.left = left;
        }
        if (right != null) {
          //  System.out.print(":"+right.value);
            if (isLeftSubTree) retNode = right;
            right.left = root;
            root.right = right;
        }
        //System.out.println();

       return retNode;
    }
    static int[] diagonalSum = new int[10];//TODO resizable array
    static int mDiaglevelMax = 0;
    public static void printDiagonalSum(TreeNode root) {
        if (root == null) {
            root = createBinaryTree();
        }
        getDiagonalSum(root,0);
        for (int i=0;i<=mDiaglevelMax;i++) {
            System.out.println(i+" : "+diagonalSum[i]);
        }
    }
    private static void  getDiagonalSum(TreeNode root,int diagLevel) {
        if (root==null) {
            return;
        }
        if (mDiaglevelMax<diagLevel) {
            mDiaglevelMax = diagLevel;
        }
        diagonalSum[diagLevel] += root.value;
        //System.out.println(diagLevel+":"+root.value);
        getDiagonalSum(root.left,diagLevel+1);
        getDiagonalSum(root.right,diagLevel);
    }
}
