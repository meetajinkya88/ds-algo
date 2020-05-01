package array;

import java.util.Scanner;

import array.util.RandomArray;

/*
 * 
Find the minimum distance between two numbers

Given an unsorted array arr[] and two numbers x and y, find the minimum distance 
between x and y in arr[]. The array might also contain duplicates.
 You may assume that both x and y are different and present in arr[].

Examples:
Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.

Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.

Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.

Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.
 */
public class FindMinDistance
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int arr[] = {2, 5, 3, 5, 4, 4, 2, 3};
		int x = 3;
		int y = 2;
		System.out.println("Array is:" );
		RandomArray.printArray(arr);
		System.out.println("Minimum distance between 2 and 3 is: " + findMinDistance(arr,x,y));
		scan.close();

	}

	private static int findMinDistance(int[] a, int x, int y)
	{
		int distance = 0;
		int minDistance = 9999;

		int element = 0;
		int elementToFind = 0;
		for(int i = 0 ;i<a.length ; i++)
		{
			if(a[i] == x && element <=0 && elementToFind <=0)
			{
				element = a[i];
				elementToFind = y;
			}
			if(a[i] == y && element <=0 && elementToFind <=0)
			{
				element = a[i];
				elementToFind = x;
			}
			
			if(element == a[i])
			{
				distance =0;
			}
		
			if(elementToFind > 0 && elementToFind == a[i])
			{
				
				if(minDistance > distance)
					minDistance = distance;
				element = 0;
				elementToFind = 0;
				distance = 0;

			}
			if(element > 0 && elementToFind > 0)
				distance ++;
		
				
		}
		return minDistance;
	}

}
