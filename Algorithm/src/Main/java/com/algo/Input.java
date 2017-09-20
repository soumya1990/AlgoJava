package com.algo;
import java.util.Scanner;
public class Input{
  
 public static int consoleArrayInput(int[] a){
  System.out.println("Enter the length of array max is:  "+ a.length );
  Scanner sc = new Scanner(System.in);
  int size = sc.nextInt();
  for (int i = 0;i<size;i++) {
    System.out.println("Enter Element "+ (i+1) +":");
    a[i] = sc.nextInt();
 }//EOL
 return size;
 }//EOM
}//EOC
