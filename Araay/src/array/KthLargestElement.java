package array;

import java.util.Scanner;

import array.util.RandomArray;

/*
 * 
K’th Smallest/Largest Element in Unsorted Array | Set 1

Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that ll array elements are distinct.

Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 4
Output: 10

Solution: We are using special case of heap sort to get the max heap at k the index . 
We are also implemented it using partial quicksort where if pivot index is inline with k then return
 */
public class KthLargestElement
{

	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getArray(size, 6, 100);

		System.out.println("Initial Array is:");
		RandomArray.printArray(a);

		System.out.println("Enter Kth no:");
		int k = scan.nextInt();

		System.out.println("kth Largets using heap= " + kthLargestUsingHeap(a,k));
		System.out.println("kth Largets using quick sort= " + kthLargestUsingQuickSort(a,k));

		scan.close();
	}

	private static int kthLargestUsingQuickSort(int[] a, int k)
	{
		quickSort(a,0,a.length -1 , k);
		return a[a.length - k];
	}

	private static void quickSort(int[] a, int start, int end, int k)
	{
		if(start >= end)
			return;
		
		int p = partition(a,start,end);
		
		if(p == a.length - k)
			return;
		
		quickSort(a,start, p -1,k);
		quickSort(a,p+1,end,k);
	}

	private static int partition(int[] a, int start, int end)
	{
		int i = start;
		int j = end - 1;
		int p = end;
		while(i<=j)
		{
			if(a[i] <= a[p])
				i++;
			else if(a[j] >= a[p])
				j--;
			else if(a[i] > a[p] && a[j] < a[p])
			{
				RandomArray.swap(a, i, j);
				i++;
				j--;
			}
		}
		RandomArray.swap(a, i, p);
		return i;
	}

	private static int kthLargestUsingHeap(int[] a, int k)
	{
		for(int i = 0 ; i < k ; i++)
		{
			heapSort(a,0,a.length - i);
		}
		return a[a.length - k];
	}

	private static void heapSort(int[] a, int i, int size)
	{
		maxHeap(a,0,size);
		RandomArray.swap(a, 0, size -1 );

	}

	private static void maxHeap(int[] a, int i , int size)
	{
		if( i > size)
			return;
		maxHeap(a,i+1,size);

		if(2*i + 1 < size && a[i] < a[2*i+1])
		{
			System.out.println("Swapping " + a[i] + "with " + a[2*1+1]);
			RandomArray.swap(a, i, 2*i+1);
		}
		if(2*i + 2 < size && a[i] < a[2*i+2])
		{
			System.out.println("Swapping " + a[i] + "with " + a[2*1+2]);
			RandomArray.swap(a, i, 2*i+2);		
		}
	}

}
