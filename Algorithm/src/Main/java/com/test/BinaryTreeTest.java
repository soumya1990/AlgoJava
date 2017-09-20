package com.test;

import com.algo.Input;
import com.algo.binarytree.BinaryTree;

/**
 * Created by soumya on 01/09/17.
 */

public class BinaryTreeTest {
    public static void testPrintRootToLeaf() {
        int[] a = new int[100];
        int size = Input.consoleArrayInput(a);
        BinaryTree.printRootToLeafComplete(a,size);
    }
    public static void testIterateTreeVisit() {
        BinaryTree.iterativeVisit();
    }
    public static void testprintPathtoLeafNode() {
        BinaryTree.printPathToLeafNode(null);
    }
    public static void testTreeInversionInPlace() {
        BinaryTree.binaryTreeInversionInPlace();
    }
    public static void testEncode() {
        BinaryTree.encode("theweather");
    }
    public static void testisHeightBalanced() {
        if (BinaryTree.IsHeightBalanced(null)){
         System.out.println("Height Balanced");
         return;
        }
        System.out.println("NOT Height Balanced");
    }
    public static void testPrintLeveOrderTraversal () {
        BinaryTree.printLevelOrderTraversal(null);
    }
    public static void testPrintDiagonalSum() {
        BinaryTree.printDiagonalSum(null);
    }
    public static void testConvertbinTreetoDl() {
        BinaryTree.convertbinTreetoDl(null);
    }
}
