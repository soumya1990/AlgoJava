package com.test;

import com.algo.Input;
import com.algo.Output;
import com.algo.sorting.Sorting;

/**
 * Created by soumya on 11/08/17.
 */

public class SortingTest {

    static int  MAX_LENGTH = 100;
    public static void testquickSort(){
        int a[] = new int[MAX_LENGTH];
        int size = Input.consoleArrayInput(a);
        System.out.println("Input array to be sorted is ");
        Output.printElements(a,size);
        Sorting.quickSort(a,size);
        System.out.println("Sorted output array is ");
        Output.printElements(a,size);
    }

}
