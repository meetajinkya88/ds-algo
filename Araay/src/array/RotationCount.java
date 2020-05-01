package array;

import java.util.Scanner;

import array.util.RandomArray;

/*
 * 
Find the Rotation Count in Rotated Sorted array

Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.

Examples:

Input : arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation : Initial array must be {2, 3,
6, 12, 15, 18}. We get the given array after 
rotating the initial array twice.

Input : arr[] = {7, 9, 11, 12, 5}
Output: 4

Input: arr[] = {7, 9, 11, 12, 15};
Output: 0

 */
public class RotationCount
{

	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		System.out.println("Block Size:");
		int b = scan.nextInt();

		int[] a = RandomArray.getSotedArray(size, 8, 100);
		System.out.println("Before:" );
		System.out.println("Sorted Array:");
		RandomArray.printArray(a);
		//int []a = {4,5,6,1,2};
		rotateArray(b, a);
		RandomArray.printArray(a);
		System.out.println("Rotation Count: " + getRotationCount(a));

		scan.close();
	}
	private static int getRotationCount(int[] a)
	{
		if(a.length <= 0)
			return 0;

		int mid = a.length /2;

		return getRotationCount(a,0,a.length);

	}
	private static int getRotationCount(int[] a, int start,int end)
	{
		int mid = 0;
		
		mid = (start + end) /2;
		
		if(start == end)
			return 0;
		
		if(start == mid && end == mid)
			return 0;
		
		if(a.length> mid+1 &&  a[mid] > a[mid +1])
			return mid+1;
		
		int index = getRotationCount(a,start, mid);
		
		if(index <= 0)
			return getRotationCount(a,mid + 1, end);
		else
			 return index;
	}
	public static void rotateArray(int blockSize,int [] arr)
	{
		BlockSwap.swapblock(arr, blockSize);
	}
}
