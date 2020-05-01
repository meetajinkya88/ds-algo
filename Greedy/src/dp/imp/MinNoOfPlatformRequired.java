package dp.imp;

import java.util.Arrays;

/**
 * 
 * @author ajinkyab
 *
 *
Minimum Number of Platforms Required for a Railway/Bus Station

Given arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop

Examples:

Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
        dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
There are at-most three trains at a time (time between 11:00 to 11:20)

https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class MinNoOfPlatformRequired 
{

	public static void main(String[] args) 
	{
		//e.g 1
		int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		int n = arr.length; 
		System.out.println("Minimum Number of Platforms Required = "
				+ findPlatform(arr, dep, n) + "\n\n"); 

		// e.g 2
		int arr1[] = {900, 940, 950, 1000, 1100, 1800}; 
		int dep1[] = {910, 2100, 1120, 2012, 1900, 2000}; 
		n = arr1.length; 
		System.out.println(" Minimum Number of Platforms Required = "
				+ findPlatform(arr1, dep1, n)); 

	}


	private static String findPlatform(int[] arr, int[] dep, int n)
	{
		int platformCount = 1 ;
		int count = 1;
		int j = 0;
		Arrays.sort(arr);
		Arrays.sort(dep);
		//	arr.forEach(v->System.out.print(v + " ,"));
		//	dep.forEach(v->System.out.print(v + " ,"));

		System.out.print("\n Arrival Sorted Array is \n");

		for(int i = 0; i <n ; i++)
			System.out.print(arr[i] + ",");

		System.out.print("\n\n Departure Sorted Array is \n");

		for(int i = 0; i <n ; i++)
			System.out.print(dep[i] + ",");

		System.out.print("\n\n");

		//	int arr[] = {900, 940,  950, 1100, 1500, 1800}; 
		//  int dep[] = {910,1120, 1130, 1200, 1900, 2000};
		int i = 0;
		while (i < n && j < n) 
		{ 
			// If next event in sorted order is arrival,  
			// increment count of platforms needed 
			if (arr[i] <= dep[j]) 
			{ 
				platformCount++; 
				i++; 

				// Update result if needed  
				if (platformCount > count)  
					count = platformCount; 
			} 

			// Else decrement count of platforms needed 
			else
			{ 
				platformCount--; 
				j++; 
			} 
		} 

		return platformCount + "";
	}

}
