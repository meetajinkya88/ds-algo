package com.pratice.imp;

import java.util.Arrays;

/**
 * There are row of n houses. Each house can be painted with one of the following color:
 * Red, Blue, Green. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no to adjacent houses has same color.
 * What is the minimum cost?
 * 
 * e.g 
 * 
 *              Red  Blue  Green
 *      House 1  17   2      17
 *      House 2  16	  16      5    
 * 		House 3  14    3      9
 * 
 * 	Minimum cost = 10 ( h1 - Blue(2) + h2-Green (5) + h3- blue(3))
 * 
 * 
 * @author ajinkyab
 *
 */
public class ColorHouses 
{

	public final static int RED = 0;
	public final static int BLUE = 1;
	public final static int GREEN = 2;

	public static void main(String[] args) 
	{
		int [][] cost = {{17,2,17},{16,16,5},{14,3,9}};

		recursiveSolution(cost);

		// Top Down approach (Momoization)
		memoization(cost);

		//Bottom Up approach
		bottomUp(cost);
	}

	private static void bottomUp(int[][] cost) 
	{
		int [][] minCostArr = new int[cost.length][cost[0].length];
		for(int [] row :minCostArr )
			Arrays.fill(row, -1);

		for(int house = 0 ; house < cost.length ; house++)
		{
			if(house ==0)
			{
				minCostArr[house][RED] = cost[house][RED];
				minCostArr[house][BLUE] = cost[house][BLUE];
				minCostArr[house][GREEN] = cost[house][GREEN];
				continue;
			}
			minCostArr[house][RED] = cost[house][RED] + Math.min(minCostArr[house-1][BLUE],minCostArr[house-1][GREEN]);
			minCostArr[house][BLUE] = cost[house][BLUE] + Math.min(minCostArr[house-1][RED],minCostArr[house-1][GREEN]);
			minCostArr[house][GREEN] = cost[house][GREEN] + Math.min(minCostArr[house-1][BLUE],minCostArr[house-1][RED]);
		}
		
		System.out.println("Bottom Up,min cost: " + getMinCost(minCostArr));
	}

	private static int getMinCost(int[][] minCostArr)
	{
		int min = minCostArr[0][0];
	//	for(int i = 0; i < minCostArr.length ; i++)
			for(int j = 0 ; j< minCostArr[0].length ; j++)
			{
				if(min > minCostArr[minCostArr.length -1][j])
					min = minCostArr[minCostArr.length -1][j];
				System.out.println(minCostArr[minCostArr.length -1][j]);
			}
		
		return min;
	}

	private static void memoization(int[][] cost) 
	{
		int [][] cache = new int[cost.length][cost[0].length];
		for(int [] row :cache )
			Arrays.fill(row, -1);


		int rCost = minCost(cost,0,RED,cache);
		int bCost = minCost(cost,0,BLUE,cache);
		int gCost = minCost(cost,0,GREEN,cache);

		System.out.println("With Memoization, Min Cost:" + Math.min(rCost, Math.min(gCost, bCost)));

	}

	private static int minCost(int[][] cost, int house, int color, int[][] cache) 
	{
		if(house == cost.length)
			return 0;

		if(cache[house][color] != -1)
			return cache[house][color];

		switch(color)
		{
		case RED:
			int bCost = minCost(cost,house+1,BLUE);
			int gCost = minCost(cost,house+1,GREEN);
			cache[house][color]= cost[house][RED] + Math.min(bCost, gCost);
			return cache[house][color];
		case BLUE:
			int rCost = minCost(cost,house+1,RED);
			gCost = minCost(cost,house+1,GREEN);
			cache[house][color]= cost[house][BLUE] + Math.min(rCost, gCost);	
			return cache[house][color];

		case GREEN:
			bCost = minCost(cost,house+1,BLUE);
			rCost = minCost(cost,house+1,RED);
			cache[house][color]= cost[house][GREEN] + Math.min(bCost, rCost);	
			return cache[house][color];

		}
		return 0;
	}


	private static void recursiveSolution(int[][] cost) 
	{
		int rCost = minCost(cost,0,RED);
		int bCost = minCost(cost,0,BLUE);
		int gCost = minCost(cost,0,GREEN);

		System.out.println("Reursive Min Cost:" + Math.min(rCost, Math.min(gCost, bCost)));
	}

	private static int minCost(int[][] cost, int house, int color) 
	{
		if(house == cost.length)
			return 0;

		switch(color)
		{
		case RED:
			int bCost = minCost(cost,house+1,BLUE);
			int gCost = minCost(cost,house+1,GREEN);
			return cost[house][RED] + Math.min(bCost, gCost);	
		case BLUE:
			int rCost = minCost(cost,house+1,RED);
			gCost = minCost(cost,house+1,GREEN);
			return cost[house][BLUE] + Math.min(rCost, gCost);	
		case GREEN:
			bCost = minCost(cost,house+1,BLUE);
			rCost = minCost(cost,house+1,RED);
			return cost[house][GREEN] + Math.min(bCost, rCost);	
		}
		return 0;
	}
}
