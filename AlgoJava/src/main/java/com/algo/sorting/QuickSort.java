package com.algo.sorting;

import com.algo.io.Output;

/**
 * Created by soumya on 22/09/17.
 */


public class QuickSort {
    private boolean exchange(int[] a, int id1, int id2, int size) {
        //if invaid input return false
        System.out.println("exchanging " + id1 + "and" + id2);
        int tmp = a[id1];
        a[id1] = a[id2];
        a[id2] = tmp;
        System.out.println("Array after Exchange is : ");
        Output.printElements(a, size);
        return true;
    }//EOM

    public void quickSort(int[] a, int size) {
        quickSort(a, 0, size - 1, size);
    }

    private void quickSort(int[] a, int beg, int end, int size) {
        if (beg >= end) {
            return;
        }
        int pivotPos = putPivotElement(a, beg, end, size);
        quickSort(a, beg, pivotPos - 1, size);
        quickSort(a, pivotPos + 1, end, size);
    }

    private int putPivotElement(int[] a, int begin, int end, int size) {
        int pivotPos = begin;
        int left = begin + 1;
        int right = end;
        while (true) {
            while (a[left] <= a[pivotPos] && left < size) {
                left++;
            }

            while (a[right] > a[pivotPos] && left < size) {
                right--;
            }
            if (right <= left) {
                break;
            }
            exchange(a, left, right, size);
        }
        exchange(a, pivotPos, right, size);
        pivotPos = right;
        return pivotPos;
    }
}
