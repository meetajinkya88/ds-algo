package array;

import java.util.Scanner;

import array.util.RandomArray;

/*
 * 
Minimum swaps required to bring all elements less than or equal to k together

Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all 
the numbers less than or equal to k together.

Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
Output: 1

Explanation: 
To bring elements 2, 1, 3 together, swap 
element '5' with '3' such that final array
will be-
arr[] = {2, 1, 3, 6, 5}

Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
Output: 2


Solution: This is a special case of quick sort where we need to decide the pivot (in above example is 5) and move all the
 elements lesser than pivot towards left.
 */
public class MinSwapRequired
{

	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getArray(size, 1, 100);

		System.out.println("Generated Array is:");
		RandomArray.printArray(a);
	
		System.out.println("Enter the no:");
		int k = scan.nextInt();
	
		scan.close();
			System.out.println(" Min Swap Required is: " + getMinSwapRequired(a,k));
	}

	private static int getMinSwapRequired(int[] a, int k) throws Exception
	{
		int i = 0 ; 
		int j = a.length -1;
		int p = getPivot(a,k);
		int count = 0;
		if(p == -1)
		{
			throw new Exception("K not found");
		}
		else
			System.out.println(" i : " + i + ",j:" + j + ",p:"+ p);
		while(i < j)
		{
			if(a[i] <= a[p])
				i++;
			else if(a[j] >= a[p])
				j--;
			else if (a[i] > a[p] && a[j] < a[p])
			{
				swap(a,i,j);
				i++;
				j--;
				count ++;
			}
		}
		if(a[i] > a[p])
		{
			swap(a,i,p);
			count ++;
		}
		return count;
	}
	private static int getPivot(int[] a, int k)
	{
		for(int i = 0 ; i < a.length ; i++)
			if(a[i] ==k)
				return i;
		return -1;
	}

	private static void swap(int[] a, int j, int k)
	{
		if(a != null && a.length > 0)
		{
			if(j < a.length && k < a.length)
			{
				int temp = a[j];
				a[j]=a[k];
				a[k] = temp;
			}
			else
				System.out.println("Index Out of bound");
		}
	}
}
