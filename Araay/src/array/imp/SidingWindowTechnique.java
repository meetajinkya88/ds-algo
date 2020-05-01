package array.imp;

import java.util.Scanner;

import array.util.RandomArray;

/**
 * https://www.geeksforgeeks.org/window-sliding-technique/
 * @author ajinkyab
 *  
 *   This technique shows how a nested for loop in few problems can be converted to single for loop 
 *   and hence reducing the time complexity.

Let’s start with a problem for illustration where we can apply this technique –

Given an array of integers of size ‘n’.
Our aim is to calculate the maximum sum of ‘k’ 
consecutive elements in the array.

Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23}
of size 4.

Input  : arr[] = {2, 3}
         k = 3
Output : Invalid
There is no subarray of size 3 as size of whole
array is 2.


 Window Sliding Technique

The technique can be best understood with the window pane in bus, consider a window of length n and the pane which is fixed in it of length k. Consider, initially the pane is at extreme left i.e., at 0 units from the left. Now, co-relate the window with array arr[] of size n and plane with current_sum of size k elements. Now, if we apply force on the window such that it moves a unit distance ahead. The pane will cover next k consecutive elements.

Consider an array arr[] = {5, 2, -1, 0, 3} and value of k = 3 and n = 5

Applying sliding window technique :

    We compute the sum of first k elements out of n terms using a linear loop and store the sum in variable window_sum.
    Then we will graze linearly over the array till it reaches the end and simultaneously keep track of maximum sum.
    To get the current sum of block of k elements just subtract the first element from the previous block and add the last element of the current block .

 */
public class SidingWindowTechnique
{

	public SidingWindowTechnique()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Size of Array:");
		int size = scan.nextInt();
		System.out.println("Enter k :");
		int k = scan.nextInt();
		int[] a = RandomArray.getMixedArray(size, -50, 50);

	//	int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Initial Array is:");
		RandomArray.printArray(a);

		System.out.println("Max Sum of k ints by Sliding window technique : " + geMaxSumForkLength(a,k));
		 scan.close();
	}

	private static int geMaxSumForkLength(int[] a, int k)
	{
		int start = 0, end = 0;
		int windowSum = 0;
		int maxSum = -999;
		
		if(a.length < k)
			return 0;
		
		start = 0 ;
		end = k -1 ;
		
		for(int i = 0 ; i < k ; i++)
			windowSum += a[i];

		while(end < a.length)
		{
			windowSum = calculateWindowSum(a,start,end,windowSum);
			if(maxSum < windowSum)
				maxSum = windowSum;
			start ++;
			end ++; 
		}
		
		return maxSum;
		
	}

	private static int calculateWindowSum(int[] a, int start, int end, int windowSum)
	{
		if(start > 0)
		{
			windowSum = windowSum - a[start -1];
			windowSum = windowSum + a[end];	
		}
		return windowSum;
	}

}
