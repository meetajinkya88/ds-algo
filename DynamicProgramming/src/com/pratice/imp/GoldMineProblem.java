package com.pratice.imp;

import java.util.Arrays;

/**
 * 
 * https://www.geeksforgeeks.org/gold-mine-problem/
 * @author ajinkyab
 *
Gold Mine Problem

Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer 
which is the amount of gold in tons. Initially the miner is at first column but can be at any row.
 He can move only (right->,right up /,right down\) that is from a given cell, 
 the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right.
  Find out maximum amount of gold he can collect.

Examples:

Input : mat[][] = {{1, 3, 3},
                   {2, 1, 4},
                  {0, 6, 4}};
Output : 12 
{(1,0)->(2,1)->(2,2)}

Input: mat[][] = { {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}};
Output : 16
(2,0) -> (1,1) -> (1,2) -> (0,3) OR
(2,0) -> (3,1) -> (2,2) -> (2,3)

Input : mat[][] = {{10, 33, 13, 15},
                  {22, 21, 04, 1},
                  {5, 0, 2, 3},
                  {0, 6, 14, 2}};
Output : 83

 */
public class GoldMineProblem {


	public static void main(String[] args)
	{
		Integer[][] goldMine = { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
		
		System.out.println("Max Amount of Gold can be collected: " + maxAmountGold(goldMine,4,4));
	}

	private static int maxAmountGold(Integer[][] goldMine,int m , int n) 
	{
		int [][] temp = new int[m][n];
		
		for(int [] tempRow: temp)
		Arrays.fill(tempRow, 0);
		
		for(int col = n-1 ; col >=0 ; col--)
		{
			for(int row = 0 ; row < m ; row ++)
			{
				int right = (col == n-1) ? 0 : temp[row][col + 1];
				int rightUp = (row == 0 || col == n-1)? 0 : temp[row -1][col +1];
				int rightDown = (row ==m -1 || col == n-1) ? 0 : temp[row +1][col +1];
				
				int sum = goldMine[row][col] + Math.max(right, Math.max(rightUp, rightDown));
			
				if(col == 0)
					System.out.println("Right: " + right + " , rightUp:" + rightUp + " , rightDown:"+ rightDown);
				System.out.println("Sum: " + sum);
				
				
				temp[row][col] = sum;
			}
		}
		
		int maxSum = 0;
		for(int row = 0 ; row < m-1 ; row ++)
		{
			if(temp[row][0] > maxSum)
				maxSum = temp[row][0];
		}
		return maxSum;
	}

}
