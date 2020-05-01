package array;

import array.util.RandomArray;

/*
 * Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.

    Incremental operations:Choose 1 element from the array and increment its value by 1.
    Doubling operation: Double the values of all the elements of array.

We are given desired array target[] containing n elements. Compute and return the smallest possible number of the operations needed to change the array from all zeros to desired array.

Sample test cases:

Input: target[] = {2, 3}
Output: 4
To get the target array from {0, 0}, we 
first increment both elements by 1 (2 
operations), then double the array (1 
operation). Finally increment second
element (1 more operation)

Input: target[] = {2, 1}
Output: 3
One of the optimal solution is to apply the 
incremental operation 2 times to first and 
once on second element.

Input: target[] = {16, 16, 16}
Output: 7
The output solution looks as follows. First 
apply an incremental operation to each element. 
Then apply the doubling operation four times. 
Total number of operations is 3+4 = 7

Solution:

One important thing to note is that the task is to count the number of steps to get the given target array (not to convert zero array to target array).

The idea is to follow reverse steps, i.e. to convert target to array of zeros. Below are steps.

Take the target array first. 

Initialize result as 0. 

If all are even, divide all elements by 2 
and increment result by 1. 

Find all odd elements, make them even by 
reducing them by 1. and for every reduction,
increment result by 1.

Finally, we get all zeros in target array.

https://www.geeksforgeeks.org/count-minimum-steps-get-given-desired-array/
 */
public class CountMinStepsToGetDesiredArray
{

	public static void main(String[] args)
	{
		int a[]= {16,16,16};
		
		System.out.println("Minimum steps required are: " + getCountMinSteps(a));
	}

	private static int getCountMinSteps(int[] a)
	{
		int steps = 0;
		int sum = 0;
		while(true)
		{
			
			sum = 0;
			for(int i = 0 ; i < a.length ; i++)
			{
				if(a[i] % 2 ==1)
				{
					a[i] = a[i] - 1;
					steps ++;
					//System.out.println("incrementing steps with a:" );
					//RandomArray.printArray(a);
				}				
			}
			
			for(int i = 0 ; i < a.length ; i++)
				sum += a[i];
			
			if(sum == 0)
				break;
				
			for(int i = 0 ;i < a.length ; i++)
				a[i] = a[i]/2;
		
			steps ++;
			//System.out.println("incrementing steps with a:" );
			//RandomArray.printArray(a);

		}
		return steps;
	}

}
