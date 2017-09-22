package com.algo.sorting;

import com.algo.io.Input;
import com.algo.io.Output;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by soumya on 22/09/17.
 */


public class SortingTest {

    static int  MAX_LENGTH = 100;
    @Test
    public  void testBubbleSort(){
        int a[] = {3,2,5,6,1};
        new BubbleSort().bubbleSort(a, a.length);
        Assert.assertArrayEquals("BubbleSort failed",new int[]{1,2,3,5,6},a);
    }

    @Test
    public void testInsertionSort() {
        int a[] = {3,2,5,6,1};
        new InsertionSort().insertionSort(a, a.length);
        Assert.assertArrayEquals("BubbleSort failed",new int[]{1,2,3,5,6},a);
    }

    @Test
    public  void testMergeSort(){
        int a[] = {3,2,5,6,1};
        new MergeSort().mergeSort(a, a.length);
        Assert.assertArrayEquals("mergeSort failed",new int[]{1,2,3,5,6},a);
    }

    @Test
    public  void testQuickSort(){
        int a[] = {3,2,5,6,1};
        new QuickSort().quickSort(a, a.length);
        Assert.assertArrayEquals("quickSort Failed",new int[]{1,2,3,5,6},a);
    }

    @Test
    public void  testHeapSort(){
        int a[] = {3,2,5,6,1};
        new HeapSort().heapSort(a, a.length);
        Assert.assertArrayEquals("quickSort Failed",new int[]{1,2,3,5,6},a);
    }

}
