package com.algo.binarysearchtree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DictionaryBSTTest {
    @Test
    public void insertTest() {
        DictionaryBST dictionary = new DictionaryBST();
        dictionary.insert(15,"");
        dictionary.insert(6,"");
        dictionary.insert(18,"");
        dictionary.insert(3,"");
        dictionary.insert(7,"");
        dictionary.insert(17,"");
        dictionary.insert(20,"");
        dictionary.insert(2,"");
        dictionary.insert(4,"");
        dictionary.insert(13,"");
        dictionary.insert(9,"");
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(2);
        expectedOutput.add(3);
        expectedOutput.add(4);
        expectedOutput.add(6);
        expectedOutput.add(7);
        expectedOutput.add(9);
        expectedOutput.add(13);
        expectedOutput.add(15);
        expectedOutput.add(17);
        expectedOutput.add(18);
        expectedOutput.add(20);
        dictionary.inOrderTraverse(dictionary.getRoot(),output);
        Assert.assertArrayEquals(output.toArray(), expectedOutput.toArray());
    }

    @Test
    public  void searchTest() {
        DictionaryBST dictionary = new DictionaryBST();
        dictionary.insert(3,"THREE");
        dictionary.insert(4,"FOUR");
        dictionary.insert(5,"FIVE");
        Assert.assertEquals("FAIL 3","THREE",dictionary.search(3).toString());
        Assert.assertEquals("FAIL 4","FOUR",dictionary.search(4).toString());
        Assert.assertEquals("FAIL 5","FIVE",dictionary.search(5).toString());
    }
    @Test
    public void ceilingTest(){
        DictionaryBST dictionary = new DictionaryBST();
        dictionary.insert(15,"");
        dictionary.insert(6,"");
        dictionary.insert(18,"");
        dictionary.insert(3,"");
        dictionary.insert(7,"");
        dictionary.insert(17,"");
        dictionary.insert(20,"");
        dictionary.insert(2,"");
        dictionary.insert(4,"");
        dictionary.insert(13,"");
        dictionary.insert(9,"");
        Assert.assertEquals(dictionary.successor(15),17);
        Assert.assertEquals(dictionary.successor(20),Integer.MIN_VALUE);
        Assert.assertEquals(dictionary.successor(4),6);
        Assert.assertEquals(dictionary.successor(9),13);
        Assert.assertEquals(dictionary.successor(13),15);
        Assert.assertEquals(dictionary.successor(5),6);
        Assert.assertEquals(dictionary.successor(-1),2);

    }

    @Test
    public void maxminTest(){
        DictionaryBST dictionary = new DictionaryBST();
        dictionary.insert(15,"");
        dictionary.insert(6,"");
        dictionary.insert(18,"");
        dictionary.insert(3,"");
        dictionary.insert(7,"");
        dictionary.insert(17,"");
        dictionary.insert(20,"");
        dictionary.insert(2,"");
        dictionary.insert(4,"");
        dictionary.insert(13,"");
        dictionary.insert(9,"");
        Assert.assertEquals(dictionary.maximum(),20);
        Assert.assertEquals(dictionary.minimum(),2);
    }
}
