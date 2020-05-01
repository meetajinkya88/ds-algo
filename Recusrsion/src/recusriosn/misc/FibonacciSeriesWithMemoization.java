package recusriosn.misc;

import java.util.Scanner;


public class FibonacciSeriesWithMemoization
{

	/**
	 * find fibonaaci series number for kth index
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the kth index : ");
		int k = scan.nextInt();

		
		Integer[] mem = new Integer[k + 1];
		
		for(int i = 0 ; i< k +1 ; i++)
			mem[i] = 0;
		
		
			System.out.println("Fibonacci series  is :");

		mem = printFibonacciSeries(k, mem);
		
		
		for(int i = 1 ; i< k +1 ; i++)
			System.out.print(i + ",");

		System.out.println();
		
		for(int i = 1 ; i< mem.length ; i++)
			System.out.print(mem[i] + ",");
	
		System.out.println();

		System.out.println("Fibonacci series value at index " + k + " is : " + findFibonacciNo(k,mem));

	}

	private static int findFibonacciNo(int k, Integer[] mem) 
	{
		
		if(k <= 2)
		{
			mem[k] =1;
			return mem[k];
		}
		if(mem[k] != 0)
		 return mem[k];
		
		mem[k] = findFibonacciNo(k - 1 , mem) + findFibonacciNo( k - 2 , mem);
		
		return mem[k];
		
	}
	private static Integer[] printFibonacciSeries(int k, Integer[] mem) 
	{
		
		mem[k] = findFibonacciNo(k  , mem) ;
		
		return mem;
		
	}

}
