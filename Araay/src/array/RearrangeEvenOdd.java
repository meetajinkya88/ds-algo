package array;

import java.util.Arrays;
import java.util.Scanner;

import array.util.RandomArray;

/*
 * 
Rearrange array such that even positioned are greater than odd

Given an array A of n elements, sort the array according to the following relations :
A[i] >= A[i-1] , if i is even.
A[i] <= A[i-1] , if i is odd.
Print the resultant array.

Examples :

Input : A[] = {1, 2, 2, 1}
Output :  1 2 1 2
Explanation : 
For 1st element, 1  1, i = 2 is even.
3rd element, 1  1, i = 4 is even.

Input : A[] = {1, 3, 2}
Output : 1 3 2
Explanation : 
Here, the array is also sorted as per the conditions. 
1  1 and 2 < 3.

Solution:
Observe that array consists of [n/2] even positioned elements.
 If we assign largest [n/2] elements to the even positions and rest of the elements to the odd positions,
  our problem is solved. Because element at odd position will always be less than the element at 
  even position as it is maximum element and vice versa. Sort the array and assign the first [n/2] elements 
  at even positions.
 */
public class RearrangeEvenOdd
{

	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getArray(size, 1, 100);

		System.out.println("Generated Array is:");
		RandomArray.printArray(a);
		
		reArrangeEvenOdd(a);
		
		System.out.println("Rearranged Array is:");
		RandomArray.printArray(a);
	
		scan.close();

	}

	private static void reArrangeEvenOdd(int[] a)
	{
		Arrays.sort(a);
		System.out.println("Sorted Array is:");
		RandomArray.printArray(a);
	
		int j = a.length -1 ;
		int i = 0;
		while(i<j)
		{
			if(i % 2 ==1)
			{
				RandomArray.shift(a,i,j);
			}
			i++;
		}
		
	}

}
