package array.imp;

import java.util.Scanner;

import array.util.RandomArray;

/*
 * Divide the array into two parts and compare the maximums and minimums of the the two parts to get the maximum and the minimum of the the whole array.

int Max(array, array_size)
   if array_size = 1
      return element as max 
   else if arry_size = 2
      one comparison to determine max 
      return max
   else    (array_size  > 2 )
      recur for max  of left half
      recur for max  of right half
      one comparison determines true max of the two candidates
      return the  max

 */
public class MaxOfArrayUsingTournament
{

	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getArray(size, 6, 100);

		System.out.println("Array is:" );
		RandomArray.printArray(a);
		System.out.println("Max Element in Array is: " + getMaxElementUsingTournament(a,0,a.length-1));
		scan.close();
	}

	private static int getMaxElementUsingTournament(int[] a, int start , int end)
	{
		if(start == end)
			return a[start];

		if(end == (start + 1) )
		{
			if(a[start] > a[end])
				return a[start];
			else
				return a[end];
		}
		int mid = (start + end) / 2;

		int x=	getMaxElementUsingTournament(a,start , mid);
		int y =getMaxElementUsingTournament(a, mid+1, end);

		if(x > y)
			return x;
		else
			return y;


	}

}
