package com.algo.divideandconquer;

import com.algo.io.Input;

/**
 * Created by soumya on 17/08/17.
 */

public class MaximumSumSubset {
      static int[] arr = new int[100];


    private static int max(int a,int b){
        if (a>=b){
            return a;
        }
        return b;
    }

    public static void maxSubsetSum(){
        int size = Input.consoleArrayInput(arr);
        int start_index = -1;
        int end_index = -1;
        int max_sum_so_far = 0;
        int sum_from_max_end = 0;
        for (int i=0;i<size;i++) {
             if (arr[i]>=arr[i]+sum_from_max_end){
                 if (arr[i] > max_sum_so_far){
                     max_sum_so_far = arr[i];
                     sum_from_max_end = max_sum_so_far;
                     start_index = i;
                     end_index = i;
                 }
             }else {
                 if (arr[i]+sum_from_max_end>max_sum_so_far) {
                     max_sum_so_far = arr[i]+sum_from_max_end;
                     end_index = i;
                 }
                 sum_from_max_end+=arr[i];
             }


            System.out.println("i = "+i);
            System.out.println("max_sum_so_far = "+max_sum_so_far);
            System.out.println("sum_from_max_end till here= "+sum_from_max_end);
        }
        System.out.println("max Sum = "+max_sum_so_far);
        System.out.println("start Index = "+start_index +":"+"end Index ="+end_index);
       // Output.printElements(arr,size);
    }

}
