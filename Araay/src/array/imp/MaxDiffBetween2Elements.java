package array.imp;

import java.util.Scanner;

import array.util.RandomArray;

/**
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 * @author ajinkyab
 * 
 *  
Maximum difference between two elements such that larger element appears after the smaller number

Given an array arr[] of integers, find out the maximum difference between any two elements
 such that larger element appears after the smaller number.

Examples :

Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.

 */
public class MaxDiffBetween2Elements
{

	public MaxDiffBetween2Elements()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getArray(size, 6, 50);

		System.out.println("Array is:" );
		RandomArray.printArray(a);
		System.out.println("Max Difference between two Elements using method1 is: " + getMaxDiffBetween2Elements(a));
		System.out.println("Max Difference between two Elements using method2 is: " + getMaxDiffBetween2Elements2(a));

		scan.close();

	}

/**
 * First find the difference between the adjacent elements of the array and store all differences
 *  in an auxiliary array diff[] of size n-1. Now this problems turns into finding the maximum sum 
 *  subarray of this difference array.
 * @param a
 * @return
 */
	private static int getMaxDiffBetween2Elements2(int[] a)
	{
		if(a == null || a.length <=0)
			return 0;
		
		if(a.length == 1)
			return a[0];
		
		int[] temp = new int [a.length -1];
		
		for(int i = 0 ; i < a.length -1 ; i++)
			temp[i] = a[i + 1] - a[i];
		
		return	findMaxContigeousSubArraySum(temp);
		
	}

	private static int findMaxContigeousSubArraySum(int[] temp)
	{
		int maxSum = 0 ;
		int sum = 0;
		
		for(int i = 0 ; i <temp.length;i++)
		{
			sum += temp[i];
			
			if(sum < 0)
				sum = 0;
			
			if(maxSum < sum)
				maxSum = sum;
		}
		return maxSum;
	}

	/**
	 * In this method, instead of taking difference of the picked element with every other element, we take the difference with the minimum element found so far. So we need to keep track of 2 things:
1) Maximum difference found so far (max_diff).
2) Minimum number visited so far (min_element).


	 * @param a
	 * @return
	 */
	private static int getMaxDiffBetween2Elements(int[] a)
	{
		if(a == null || a.length <=0)
			return 0;
		if(a.length == 1)
			return a[0];
		int maxDiff = a[1] - a[0];
		int minElement = a[0];
		
		for(int i = 1; i< a.length ; i++)
		{
			if(a[i] - minElement > maxDiff)
				maxDiff = a[i] - minElement;
			
			if(a[i] < minElement)
				minElement = a[i];
		}
		return maxDiff;
	}

}
