package array.imp;



import java.util.Scanner;

import array.util.RandomArray;

/*
 * 
Largest Sum Contiguous Subarray

Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.

kadane-algorithm

Input : arr = {-2, -3, 4, -1, -2, 1, 5, -3}, 
output : 7

Solution:

Kadane’s Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far

https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class MaxSum
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getMixedArray(size, -50, 50);

	//	int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Initial Array is:");
		RandomArray.printArray(a);

		 geMaxSum(a);
		 scan.close();
	}

	private static void geMaxSum(int[] a)
	{
		int sum = 0;
		int maxSum =0;
		int s = 0;
		int startIndex = -1, endIndex = -1;
		for(int i = 0 ; i < a.length ; i++)
		{			
			sum += a[i];		
			if(sum < 0 )
			{
				sum = 0;
				s = i+1;
			}
			if(maxSum < sum) 
			{
				maxSum = sum;
				startIndex = s;
				endIndex = i;
			}
		}
		
		System.out.println("Max Sum is : " + maxSum);
		System.out.println("Start Index is : " + startIndex);
		System.out.println("End Index is : " + endIndex);

	}

}
