package com.algo.sorting;

/**
 * Created by soumya on 22/09/17.
 */

public class MergeSort {

    public  void mergeSort(int[] a, int size) {
        int[] b = new int[size];
        int low = 0;
        int high = size - 1;
        mergeSort(a, b, low, high);
    }

    private  void copyBtoA(int a[],int b[],int begin,int end) {
        for (int i = begin ;i <= end; i++ ) {
            b[i] = a[i];
        }
    }

    private  void mergeSort(int[] a, int[] b, int l, int h) {
        //System.out.println("mergeSort ( " + l + " " + h +")");
        if (l == h) {
            return;
        }
        int mid = (l + h) / 2;
        mergeSort(a, b, l, mid);
        mergeSort(a, b, mid + 1, h);
        merge(a, b, l, mid, mid + 1, h);

    }

    private  void merge(int[] a, int[] b, int l0, int h0, int l1, int h1) {
        //System.out.println("merge( "+l0 +"," + h0 + ","+l1 +","+h1 +")");
        int index = l0;
        int i = l0;
        int j = l1;
        while (i<= h0 && j<=h1) {
            if (a[i] >= a[j]) {
                System.out.println("3 putting element in "+ j + "in position "+ index);
                b[index] = a[j];
                index++;
                j++;
            } else if (a[i] < a[j]) {
                System.out.println("4 putting element in "+ i + "in position "+ index);
                b[index] = a[i];
                i++;
                index++;
            }else {
                System.out.println("in loop i = "+ i+ " j = "+j);
                break;
            }
        }
        if (i > h0) {
            for (int k = j; k <= h1; k++) {
                System.out.println(" 1 putting element in "+ k + "in position "+ index);
                b[index] = a[k];
                index++;
            }
        }
        else if (j > h1) {
            for (int k = i; k <= h0; k++) {
                System.out.println("2 putting element in "+ k + "in position "+ index);
                b[index] = a[k];
                index++;
            }
        }
        copyBtoA(b,a,l0,h1);
        // System.out.println("Array B after merge");
        //  Output.printElements(b,size);
        // System.out.println("Array A after merge");
        // Output.printElements(a,size);

    }
}
