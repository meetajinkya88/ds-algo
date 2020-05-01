package array.imp;

import java.util.HashMap;
import java.util.Scanner;

import array.util.RandomArray;

/**
 * 
 * 
 * @author ajinkyab

 */
public class SubArrayWithSum
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
	//	System.out.println("Size of Array:");
	//	int size = scan.nextInt();
		//		int[] a = RandomArray.getMixedArray(size, -15, 15);
		int []a = {1,4,20,3,15,5};

		System.out.println("Array is:" );
		RandomArray.printArray(a);
		System.out.println("Enter Sum: ");
		int sum = scan.nextInt();

		// works only for +ve integers
		subArrayWithSum(a,sum);

		// works for both +ve and -ve integers
		subArraySum2(a,a.length,sum);

		scan.close();

	}

	/**
	 * 
	 * https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
	 * @param a
	 * @param sum
	 */
	public static void subArraySum2(int[] arr, int n, int sum) { 
        //cur_sum to keep track of cummulative sum till that point 
        int cur_sum = 0; 
        int start = 0; 
        int end = -1; 
        HashMap<Integer, Integer> hashMap = new HashMap<>(); 
  
        for (int i = 0; i < n; i++) { 
            cur_sum = cur_sum + arr[i]; 
            //check whether cur_sum - sum = 0, if 0 it means 
            //the sub array is starting from index 0- so stop 
            if (cur_sum - sum == 0) { 
                start = 0; 
                end = i; 
                break; 
            } 
            //if hashMap already has the value, means we already  
            // have subarray with the sum - so stop 
            if (hashMap.containsKey(cur_sum - sum)) { 
                start = hashMap.get(cur_sum - sum) + 1; 
                end = i; 
                break; 
            } 
            //if value is not present then add to hashmap 
            hashMap.put(cur_sum, i); 
  
        } 
        // if end is -1 : means we have reached end without the sum 
        if (end == -1) { 
            System.out.println("No subarray with given sum exists"); 
        } else { 
            System.out.println("Sum found between indexes " 
                            + start + " to " + end); 
        } 
  
    } 

	/**
	 * https://www.geeksforgeeks.org/find-subarray-with-given-sum/
	 *  * 
Find subarray with given sum 

Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

Examples :

    Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
    Ouptut: Sum found between indexes 2 and 4

    Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
    Ouptut: Sum found between indexes 1 and 4

    Input: arr[] = {1, 4}, sum = 0
    Output: No subarray found
	 */
	private static void subArrayWithSum(int[] a, int sum)
	{
		int currSum = 0 ;
		int start =0 ;
		for(int i = 0 ; i < a.length ; i++)
		{
			currSum += a[i];
			while(currSum > sum)
				currSum -= a[start++];

			if(currSum == sum)
				System.out.println("Sum " + sum + " with Start Index: " + start + " End Index :" + i);
		}
	}

}
