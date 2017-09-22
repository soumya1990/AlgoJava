package com.algo.io;

/**
 * Created by soumya on 03/09/17.
 */

public class DynamicProgramming {


    public static int findOptimalBST() {
        int[][] optimum = new int[10][10];
        int num_Node = 5;
        int[] q = new int[]{0,1,2,3,4,5};
        int[] p = new int[]{1,2,3,4,5};
        int[][] w = new int[6][6];
        initialize(optimum,p,q,w,num_Node);
        return optimumBST(1,num_Node,optimum,w);
    }

    private static void initialize(int[][] optimum,int[] p, int[] q, int[][] w ,int num_Node) {
        for (int i = 1; i<= num_Node+1; i++) {
            optimum[i][i-1] = q[i-1];
        }
        //initializa w
    }

    private static int optimumBST (int start,int end ,int[][] optimum,int[][] w){
        for (int l = 1;l< end; l++) {
            for (int i = start; i<=end-l+1;i++) {
                int j = i+l-1;
                System.out.println(i+","+j);
                int minCost =  Integer.MAX_VALUE;
                for (int k =start;k <= end;k++) {
                 int cost = optimum[i][k-1] + optimum[k+1][j]+ w[i][j];
                  if (cost<minCost) {
                      optimum[i][j] = minCost;
                  }
                }
            }
        }
        return optimum[start][end];
    }
}
