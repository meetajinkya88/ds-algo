package array;

import array.util.RandomArray;

/*
 * 
Reorder an array according to given indexes

Given two integer arrays of same size, “arr[]” and “index[]”, reorder elements in “arr[]” according to given index array. It is not allowed to given array arr’s length.

Example:

Input:  arr[]   = [10, 11, 12];
        index[] = [1, 0, 2];
Output: arr[]   = [11, 10, 12]
        index[] = [0,  1,  2] 

Input:  arr[]   = [50, 40, 70, 60, 90]
        index[] = [3,  0,  4,  1,  2]
Output: arr[]   = [40, 60, 90, 50, 70]
        index[] = [0,  1,  2,  3,   4] 

 */
public class ReOrderBasedOnIndex
{

	public static void main(String[] args)
	{

		int a[] = {50, 40, 70, 60, 90};
		int index[] = {3,  0,  4,  1,  2};
		reOrder(a,index);
		System.out.println("Final array is:");
		RandomArray.printArray(a);
		
	}

	private static void reOrder(int[] a, int[] index)
	{
		Integer temp[] = new Integer[a.length];
		for(int i = 0 ; i <index.length ; i++ )
		{
			temp[index[i]] = a[i];
		}
		for(int i =0 ; i< a.length ; i++)
		{
			a[i] = temp[i];
		}
		
	}

}
