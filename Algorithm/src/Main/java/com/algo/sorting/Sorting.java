package com.algo.sorting;

import com.algo.Output;

public class Sorting {

    public static void mergeSort(int[] a, int size) {
        int[] b = new int[size];
        int low = 0;
        int high = size - 1;
        mergeSort(a, b, low, high);
    }
    private static void copyBtoA(int a[],int b[],int begin,int end) {
        for (int i = begin ;i <= end; i++ ) {
            b[i] = a[i];
        }
    }
    private static void heapify(int[] a,int begin, int size) {
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

    public static void heapSort(int[] a, int size) {
        for (int i = 0; i<size; i++){
            heapify(a,i,size);
        }
    }
    public static void quickSort(int[] a, int size){
       quickSort(a,0,size-1,size);
    }
    private static void quickSort(int[] a,int beg, int end, int size){
        if (beg >= end){
            return;
        }
        int pivotPos =  putPivotElement(a,beg,end,size);
        quickSort(a,beg,pivotPos-1,size);
        quickSort(a,pivotPos+1,end,size);
    }
    private static int putPivotElement(int[] a,int begin,int end, int size){
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
            exchange(a,left,right,size);
        }
        exchange(a,pivotPos,right,size);
        pivotPos = right;
        return pivotPos;
    }
    private static void mergeSort(int[] a, int[] b, int l, int h) {
        //System.out.println("mergeSort ( " + l + " " + h +")");
        if (l == h) {
            return;
        }
        int mid = (l + h) / 2;
        mergeSort(a, b, l, mid);
        mergeSort(a, b, mid + 1, h);
        merge(a, b, l, mid, mid + 1, h);

    }

    private static void merge(int[] a, int[] b, int l0, int h0, int l1, int h1) {
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

    public static void bubbleSort(int[] a, int size) {
        for (int i = 0; i < size; i++) {
            int num_exchange = 0;
            System.out.println("number of exchange is : " + num_exchange + "for i = " + i);
            for (int j = 0; j < size - 1; j++) {
                if (a[j] > a[j + 1]) {
                    exchange(a, j, j + 1, size);
                    num_exchange++;
                }//Eif
            }//EOL2
            if (num_exchange == 0) {
                break;
            }
        }//EOL1

    }//EOM

    public static void insertionSort(int[] a, int size) {
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

    private static boolean exchange(int[] a, int id1, int id2, int size) {
        //if invaid input return false
        System.out.println("exchanging " + id1 + "and" + id2);
        int tmp = a[id1];
        a[id1] = a[id2];
        a[id2] = tmp;
        System.out.println("Array after Exchange is : ");
        Output.printElements(a, size);
        return true;
    }//EOM
}//EOC
