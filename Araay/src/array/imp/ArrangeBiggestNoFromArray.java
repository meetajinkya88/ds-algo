package array.imp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import array.util.RandomArray;

/**
 * https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 * @author ajinkyab
 *
 * Given an array of numbers, arrange them in a way that yields the largest value. 
 * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives 
 * the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, 
 * then the arrangement 998764543431 gives the largest value.
 * 
 *  Solution: The idea is to use any comparison based sorting algorithm. In the used sorting algorithm, 
 *  instead of using the default comparison, write a comparison function myCompare() and use it to sort numbers. 
 *  Given two numbers X and Y, how should myCompare() decide which number to put first – we compare two numbers XY
 *   (Y appended at the end of X) and YX (X appended at the end of Y). If XY is larger, 
 *   then X should come before Y in output, else Y should come before. For example, let X and Y be 542 and 60. 
 *   To compare X and Y, we compare 54260 and 60542. Since 60542 is greater than 54260, we put Y first.
 */
public class ArrangeBiggestNoFromArray
{

	public ArrangeBiggestNoFromArray()
	{
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Size of Array:");
		int size = scan.nextInt();
		int[] a = RandomArray.getArray(size, 1, 5000);

		Integer [] arr = IntStream.of( a ).boxed().toArray( Integer[]::new );

		System.out.println("Array is:" );
		RandomArray.printArray(arr);
		System.out.println("Biggest no Arrangement: " );
		arrangeBiggestNo(arr);
		RandomArray.printArray(arr);

		scan.close();
	}

	private static void arrangeBiggestNo(Integer[] a)
	{
		List<Integer> list = Arrays.asList(a);
		Collections.sort(list,new Comparator<Integer>()
		{
			
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return (o1.toString()+o2.toString()).compareTo(o2.toString()+o1.toString())>0 ? -1:1;
			}
		});
	}

}
