package array.imp;

import java.util.Scanner;

import array.util.RandomArray;

/*
 * Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.

Examples :

Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.

Solution:
In this method, instead of taking difference of the picked element with every other element, we take the difference with the minimum element found so far. So we need to keep track of 2 things:
1) Maximum difference found so far (max_diff).
2) Minimum number visited so far (min_element).
 */
public class MaxDiffBw2Elements
{

	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getArray(size, 6, 100);

		System.out.println("Array is:" );
		RandomArray.printArray(a);
		
		System.out.println("Max Difference:" + getMaxDiff(a));
		scan.close();

	}

	private static int getMaxDiff(int[] a)
	{
		if(a == null || a.length <=0)
			return 0;
		
		if(a.length == 1)
			return a[0];
		
		int minElement = a[0];
		int maxDiff = 0;
		
		for(int i = 1 ; i< a.length ; i++)
		{
			if(a[i] - minElement > maxDiff)
				maxDiff = a[i] - minElement;
			if(minElement > a[i])
				minElement = a[i];
		}
		return maxDiff;
	}

}
