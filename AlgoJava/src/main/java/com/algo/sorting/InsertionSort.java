package com.algo.sorting;

/**
 * Created by soumya on 22/09/17.
 */

public class InsertionSort {

    public  void insertionSort(int[] a, int size) {
        for (int i = 1; i < size; i++) {
            int j = 0;
            while (j < i && a[j] < a[i]) {
                j++;
            }//EOL2
            int element = a[i];
            System.out.println("Moving element in pos" + i + " to " + j);
            for (int k = i; k > j; k--) {
                a[k] = a[k - 1];
            }//EOL3
            a[j] = element;
        }//EOL1

    }//EOM
}
