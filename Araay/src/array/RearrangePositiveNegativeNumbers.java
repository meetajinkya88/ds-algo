package array;

import array.util.RandomArray;

/*
 * 
 * https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 * 
 * An array contains both positive and negative numbers in random order. Rearrange the array elements 
 * so that positive and negative numbers are placed alternatively. Number of positive and negative numbers 
 * need not be equal. If there are more positive numbers they appear at the end of the array.
 *  If there are more negative numbers, they too appear in the end of the array.

For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
 then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
 */
public class RearrangePositiveNegativeNumbers
{

	public static void main(String[] args)
	{
		int a[] = {-1, 2, -3, 4, 5, 6, -7, 8,-5,56,74,-1,-2,-48,-12,69,32,-36,-11,-44,15,-122,-10,-16};

		
		reArrange(a);
		
		RandomArray.printArray(a);
	}

	private static void reArrange(int[] a)
	{
		boolean isOldElementPositive = isPositive(a[0]);
		for(int i = 1 ; i <= a.length -1; )
		{
			System.out.println("Current Element is: " + a[i]);
			boolean isCurrentElementPositive = isPositive(a[i]);
			if(!isOldElementPositive && isCurrentElementPositive)
				i++;
			else  if(isOldElementPositive && !isCurrentElementPositive)
				i++;
			else
			{
				swap(a,i);
				i++;
				isCurrentElementPositive = !isCurrentElementPositive;
			}
			isOldElementPositive = isCurrentElementPositive;

		}
	}

	private static void swap(int[] a, int i)
	{
		//System.out.println("Swap Element is: " + a[i]);

		if(a[i] > 0)
		{
			for(int j = i+1 ; j<=a.length -1;j++)
			{
				System.out.println("Evalating Element to be swapped is: " + a[j]);
				
				if(a[j] < 0)
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					
					System.out.println("Intermidiate array is:");
					RandomArray.printArray(a);
				
					return;
				}
			}
		}
		else if( a[i] < 0)
		{
			for(int j = i+1 ; j<=a.length -1;j++)
			{
				System.out.println("Evalating Element to be swapped is: " + a[j]);

				if(a[j] > 0)
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					
					System.out.println("Intermidiate array is:");
					RandomArray.printArray(a);
					return;
				}
			}
		}
	}

	private static boolean isPositive(int i)
	{
		return i > 0;
	}

}
