package com.algo.sorting;

import com.algo.io.Output;

public class BubbleSort {
    
	private  boolean exchange(int[] a, int id1, int id2, int size) {
        //if invalid input return false
        System.out.println("exchanging " + id1 + "and" + id2);
        int tmp = a[id1];
        a[id1] = a[id2];
        a[id2] = tmp;
        System.out.println("Array after Exchange is : ");
        Output.printElements(a, size);
        return true;
    }//EOM
	
	
    public  void bubbleSort(int[] a, int size) {
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
  
}
