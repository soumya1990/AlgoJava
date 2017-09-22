package com.algo.sorting;

import com.algo.io.Output;

/**
 * Created by soumya on 22/09/17.
 */

public class HeapSort {
    private  boolean exchange(int[] a, int id1, int id2, int size) {
        //if invaid input return false
        System.out.println("exchanging " + id1 + "and" + id2);
        int tmp = a[id1];
        a[id1] = a[id2];
        a[id2] = tmp;
        System.out.println("Array after Exchange is : ");
        Output.printElements(a, size);
        return true;
    }//EOM

    private  void heapify(int[] a,int begin, int size) {
        System.out.println(" root begins at " + begin);
        int length = size - begin;

        for (int i = length/2-1+begin; i>=begin; i--){
            int ex = i;
            int left =  2*i + 1 -begin;
            int right = left + 1;
            if (left < size) {
                if (a[left] < a[ex]) {
                    ex = left;
                }
            }
            if (right < size) {
                if (a[right] < a[ex]) {
                    ex = right;
                }
            }
            exchange(a,i,ex,size);

        }
    }

    public  void heapSort(int[] a, int size) {
        for (int i = 0; i<size; i++){
            heapify(a,i,size);
        }
    }
}
