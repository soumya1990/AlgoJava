package com.codechef;

import java.util.Scanner;

public class CodeChef {

    public static void moverArray() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
            int N = sc.nextInt();
            int d = sc.nextInt();
            long result = 0;
            int a[] = new int[N];
            long totalSum =0;
            for (int j = 0; j<N;j++){
               a[j] = sc.nextInt();
                totalSum+= a[j];
            }
            if (totalSum % N != 0){
                result = -1;
               // System.out.println(result);

            } else {
                for (int j = 0; j < d; j++) {
                    long sum = 0;
                    int count = 0;
                    for (int k = j; k < N; k += d) {
                        // System.out.print(a[k] + ",");
                        sum += a[k];
                        count++;
                    }
                    if (sum % count != 0) {
                        result = -1;
                        break;
                    } else {
                        int carry = 0;
                        for (int k = j; k < N; k += d) {
                            long val = sum / count;
                            //System.out.println("individual value is "+val);
                            if (carry + a[k] > val) {
                                result += (carry + a[k]) - val;
                            } else {
                                result += val - (carry + a[k]);
                            }
                            carry += a[k] - val;
                            //System.out.println("carry is  "+carry +"result is "+result);


                        }
                    }
                    // System.out.println();
                }
            }
            System.out.println(result);
        }
    }

    public static void testRainbowArray(){
        Scanner sc =  new Scanner(System.in);
        int T =  sc.nextInt();
        for (int i = 0; i < T ; i++) {
            int a[] =  new int[8];
            int N = sc. nextInt();
            int exp_element1 = 1;
            int exp_element2 = 1;
            boolean printNo = false;
            boolean increasing = true;
            for (int j = 0; j< N; j++) {
                int element = sc.nextInt();
                if (element == exp_element1 || element == exp_element2){
                    if (element == 7) {
                        increasing =  false;
                    }
                    if (!increasing) {
                        exp_element1 = element;
                        if (element == 1) {
                            exp_element2 = element;
                        } else {
                            exp_element2 = element - 1;
                        }
                        a[element]--;
                    } else {
                        exp_element1 = element;
                        exp_element2 = element+1;
                        a[element]++;
                    }
                } else {
                    printNo = true;
                }
            }

            if (printNo) {
                System.out.println("no");
            } else {
                boolean printYes = true;
                for (int k =0; k<7;k++){
                    if (a[k] == 0){

                    }else {
                        printYes =  false;
                    }
                }
                if (printYes){
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
    public static void main(String[] args){
     //testRainbowArray();
        moverArray();
    }
}