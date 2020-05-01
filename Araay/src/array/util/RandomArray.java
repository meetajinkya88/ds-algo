package array.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomArray
{
	
	public  static int[] getArray(int size, int minRange, int maxRange)
	{
		int [] randArray = new int[size];
		Set<Integer> set = new HashSet<Integer>();
		Random rand = new Random();
		int i = 0;
		while(i < size)
		{
			int no = rand.nextInt(maxRange);
			if(no < minRange  || no > maxRange)
			continue;
     		else
			{
				if(!set.contains(no))
				{
					set.add(no);
					randArray[i++] = no;
				}
			}
			
			if( i == size)
				break;
		}
		return randArray;
		
	}
	public  static int[] getMixedArray(int size, int minRange, int maxRange)
	{
		int [] randArray = new int[size];
		Set<Integer> set = new HashSet<Integer>();
		Random rand = new Random();
		Random negativeRandom = new Random();
		int i = 0;
		while(i < size)
		{
			int no = rand.nextInt(maxRange);
			int negNo = negativeRandom.nextInt(3);
			if(negNo <= 0)
				no *=-1;
			
			if(no < minRange  || no > maxRange)
			continue;
     		else
			{
				if(!set.contains(no))
				{
					set.add(no);
					randArray[i++] = no;
				}
			}
			
			if( i == size)
				break;
		}
		return randArray;
		
	}
	
	public static void printArray(int [] arr)
	{
		StringBuffer buffer = new StringBuffer();
		for (int i=0 ; i <arr.length ; i++)
		{
			buffer.append(arr[i] + " , ");
		}
		
		buffer.deleteCharAt(buffer.length() -1);
		
		System.out.println(buffer.toString());
	}
	public static void printArray(Integer [] arr)
	{
		StringBuffer buffer = new StringBuffer();
		for (int i=0 ; i <arr.length ; i++)
		{
			buffer.append(arr[i] + " , ");
		}
		
		buffer.deleteCharAt(buffer.length() -1);
		
		System.out.println(buffer.toString());
	}
	
	public  static int[] getSotedArray(int size, int minRange, int maxRange)
	{
		int [] randomArray =  getArray(size,minRange,maxRange);
		 Arrays.sort(randomArray);
		 return randomArray;
		
	}

	public static void swap(int[] a, int j, int k)
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

	public static void shift(int[] a, int i, int j)
	{
		int temp = a[j];
		while(i < j)
		{
			a[j] = a[j-1];
			j--;			
		}
		a[i] = temp;
	}

}
