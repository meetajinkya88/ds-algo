import java.util.Scanner;

import array.util.RandomArray;

/**
 * Find an efficient algorithm to get maximum subset sum for a given array of n
 * integers Note: sub array should not contain consecutive nos
 * 
 * @author ajinkyab
 * 
 */
public class CalculateMaxSum
{

	public static void main(String[] args)
	{
		int quit = 1;
		do
		{

			int[] array = getArray();
			printArray(array);

			System.out.println("\n \tMax Subarray sum is: " + maxSubArraySum(array));
			
			System.out.println("\n \t Type 0 to quit");
			quit = new Scanner(System.in).nextInt();

		} while (quit != 0);
	}

	private static int maxSubArraySum(int[] array)
	{
		int[] mem = new int[array.length];

		mem[0] = array[0];
		mem[1] = Math.max(array[0], array[1]);
		for (int i = 2; i < array.length; i++)
		{
			mem[i] = Math.max((mem[i - 2] + array[i]), mem[i - 1]);
		}

		int max = mem[0];
		for (int i = 1; i < mem.length; i++)
		{
			if (mem[i] > max)
				max = mem[i];
		}
		System.out.println("\n \t Final mem val are: \n");
		for (int i = 0; i < mem.length; i++)
		{
			System.out.print( mem[i]+ ",");

		}
		return max;
	}

	private static void printArray(int[] array)
	{
		System.out.println("Input Array is : \n");
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ",");
		}

	}

	private static int[] getArray()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of Elements : ");
		int size = scan.nextInt();

		System.out.println("Enter Min Range : ");
		int minRange = scan.nextInt();

		System.out.println("Enter Max Range : ");
		int maxRange = scan.nextInt();

		System.out.println("Enter Max. Range : ");

		return RandomArray.getArray(size, minRange, maxRange);
	}

}
