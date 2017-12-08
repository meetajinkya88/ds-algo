package algo;

import java.util.Scanner;

/**
 * 
 *  Maximal Sum without Consecutive Numbers
 *  
Given an array of n positive numbers, write an efficient function to select a subset of the
numbers with maximal sum and such that no two consecutive numbers are selected. Your
function should return the maximal sum only. What are the time and space complexities
of your solution?

 * @author ajinkyab
 *
 */
public class MaximalSumWithoutConsecutiveNos
{

	public static void main(String[] args)
	{
		int array[] = getArray();
		System.out.println("Maximal sum is : " + getMaximalSum(array));

	}

	protected static int getMaximalSum(int[] array)
	{
		int maxSum = 0;
		int sum = 0;
		for(int i = 0 ; i <array.length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				if(i==j )
					continue;
				
				if(maxSum < array[j])
					maxSum = array[j];
				
				if( Math.abs(i - j) == 1)
					continue;
				
				sum = array[i] + array[j];
				if(maxSum < sum)
					maxSum = sum;
			}
		}
		return maxSum;
	}

	protected static int[] getArray()
	{
		System.out.println("Enter Size of array : ");
		Scanner scanSize = new Scanner(System.in);
		int n = scanSize.nextInt();
		
		int array[] = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			System.out.println("Enter array[" + i + "]:");
			array[i] = new Scanner(System.in).nextInt();
		}
		
		System.out.println("Entered array is: ");
		for(int i = 0 ; i < n ; i++)
		{
			System.out.println(array[i]+ "\t");
		}	
		return array;
	}

}
