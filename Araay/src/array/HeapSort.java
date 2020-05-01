package array;

import java.util.Scanner;

import array.util.RandomArray;

public class HeapSort
{

	public static void main(String[] args)
	{
	//	Scanner scan = new Scanner(System.in);
	//	System.out.println("Size of Array:");
	//	int size = scan.nextInt();
//		int[] a = RandomArray.getArray(size, 6, 100);
		int a[] = {7,9,3,1,14,19,13};
		System.out.println("Initial Array is:");
		RandomArray.printArray(a);

		heapSort(a);
	//	scan.close();
		System.out.println("Sorted Array is:");
		RandomArray.printArray(a);
	}

	private static void heapSort(int[] a)
	{
		for(int i = 0 ; i < a.length ; i++)
		{
			sort(a,a.length - i);
		}
	}

	private static void sort(int[] a, int size)
	{
		System.out.println("Size: " + size);
		getMaxHeap(a,0,size);
		System.out.println("Array After MAx Heap is:");
		RandomArray.printArray(a);
		RandomArray.swap(a, 0, size-1);
		System.out.println("Intermidiete Array state:");
		RandomArray.printArray(a);
	
	}

	private static void getMaxHeap(int[] a, int i,int size)
	{
		if(i > size)
			return;
	

		//System.out.println("Get Max Heap i: "+ i + " , size: " + size);

		getMaxHeap(a,i+1,size);
		
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
