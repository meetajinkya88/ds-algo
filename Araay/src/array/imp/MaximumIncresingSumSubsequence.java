package array.imp;

import java.util.Scanner;

import array.util.RandomArray;

/**
 * https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence 
 * of the given array such that the integers in the subsequence are sorted in increasing order.
 *  For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
 *   if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) 
 *   and if the input array is {10, 5, 4, 3}, then output should be 10
 * 
 * 
 * @author ajinkyab
 *
 */
public class MaximumIncresingSumSubsequence
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getArray(size, 6, 100);

		System.out.println("Array is:" );
		RandomArray.printArray(a);
		System.out.println("Max Incresing Sum subsequence in Array is: " + maxSumIS(a));
		scan.close();

	}

	static int maxSumIS(int arr[]) 
    { 
        int i, j, max = 0; 
        int msis[] = new int[arr.length]; 
  
        /* Initialize msis values  
           for all indexes */
        for (i = 0; i < arr.length; i++) 
            msis[i] = arr[i]; 
  
        /* Compute maximum sum values 
           in bottom up manner */
        for (i = 1; i < arr.length; i++) 
            for (j = 0; j < i; j++) 
                if (arr[i] > arr[j] && 
                    msis[i] < msis[j] + arr[i]) 
                    msis[i] = msis[j] + arr[i]; 
  
        /* Pick maximum of all 
           msis values */
        for (i = 0; i < arr.length; i++) 
            if (max < msis[i]) 
                max = msis[i]; 
  
        return max; 
    }
}
