package array;

import java.util.Scanner;

import array.util.RandomArray;

/**
 * 
 * @author ajinkyab
 *
 */

/*
Block swap algorithm for array rotation

Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.

Input :  arr[] = [1, 2, 3, 4, 5, 6, 7]
         d = 2
Output : arr[] = [3, 4, 5, 6, 7, 1, 2] 

Algorithm:
rotate(arr[], d, n)
  reverse(arr[], 1, d) ;
  reverse(arr[], d + 1, n);
  reverse(arr[], 1, n);
 */
public class BlockSwap
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		System.out.println("Block size:");
		int d = scan.nextInt();
		int[] a = RandomArray.getArray(size, 6, 100);

		System.out.println("Before:" );
		RandomArray.printArray(a);
		
		swapblock(a,d);

		System.out.println("After:" );
		RandomArray.printArray(a);

	}

	public static void swapblock(int[] a, int d)
	{
		reverse(a,0,d);
		reverse(a,d+1,a.length-1);
		reverse(a,0,a.length-1);
	}

	private static void reverse(int[] a, int i, int d)
	{
		if(a.length < 0)
			return;
		int temp=0;

		while(i < d)
		{
			temp = a[i];
			a[i] = a[d];
			a[d] = temp;
			
			i++;
			d--;
		}
	}

}
