package array;

import java.util.Random;
import java.util.Scanner;

import array.util.RandomArray;

public class QuickSort
{
	private static int loop = 0;
	public static void main(String[] args)
	{
		//int a[] = {1,2,3,4,5,6};

		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getArray(size, 6, 100);

		scan.close();
		System.out.println("Original Array is:");
		RandomArray.printArray(a);


		quickSort2(a,0,a.length -1,loop);
		System.out.println("Final Array is:");
		RandomArray.printArray(a);

	}

	private static void quickSort(int[] a)
	{

		for(int i =0 ; i < a.length ; i++)
		{

			int pivot =  (a.length)/2  ;

			int j=0; 
			int k = a.length -1;

			System.out.println("Pivot index is:" + pivot);

			System.out.println("Pivot Element is:" + a[pivot]);
			while(j<k)
			{
				if(a[j]>a[pivot] && a[k] < a[pivot])
				{
					swap(a,j,k);
					j++;
					k--;
					continue;
				}
				if(a[j]<a[pivot])
					j++;
				if(a[k]>a[pivot])
					k--;
			}
			swap(a,j,pivot);

			//			System.out.println("Loop :"  + (i+1));
			//			RandomArray.printArray(a);
		}
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

	private static void quickSort2(int []a,  int start, int end , int loop)
	{

		if(start >= end)
			return;

		int pivot = partition(a,start,end);
		quickSort2(a, start, pivot - 1, loop);
		quickSort2(a, pivot + 1,end, loop);


	}
	private static int partition(int[] a, int start, int end)
	{

		int i = start;
		int j = end -1;
		int p = end;
		System.out.println("i: " + i + " , j:" + j + ", p: " + p);

		while(i <= j)
		{
			if(a[i] <= a[p])
				i++;
			else if(a[j] >= a[p])
				j--;
			else if( a[i] > a[p] && a[j] < a[p])
			{
				RandomArray.swap(a, i, j);
				i++;
				j--;
			}
		}
		RandomArray.swap(a, i, p);
		System.out.println("Intermidiete Array state:");
		RandomArray.printArray(a);
		return i;
	}

	private static void quickSort(int []a,  int start, int end , int loop)
	{


		System.out.println("start:" + start + " , end: " + end);
		if(start == end)
			return;



		int p = end;
		int i = start;
		int j = end -1;
		while(i<j)
		{
			if(a[i] <= a[p])
				i++;
			else if(a[j] >= a[p])
				j--;
			else if(a[i] > a[p] && a[j] < a[p])
			{
				swap(a,i,j);
				i++;
				j--;

			}
		}
		if(a[i] > a[p])
			swap(a,i,p);
		//		if(a[j] < a[p])
		//			swap(a,j,p);
		//		
		//		loop++;
		//		System.out.println("Pass:" + loop);
		//		RandomArray.printArray(a);
		//System.out.println("i:" + i + " , p:" + p);

		if(p == i+1)
			return;

		if(i > 0)
			quickSort(a,start,i-1,loop);

		if(i < a.length -1)
			quickSort(a,i+1,end,loop);


	}

}
