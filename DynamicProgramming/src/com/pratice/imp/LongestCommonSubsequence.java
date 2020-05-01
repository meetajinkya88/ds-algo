package com.pratice.imp;

/**
 * 
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * https://www.youtube.com/watch?v=sSno9rV8Rhg
 * Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * @author ajinkyab
 *
 */
public class LongestCommonSubsequence
{


	public static void main(String[] args)
	{
		char[] a = {'a','b','c','d','g','h'};
		char[] b = {'a','e','d','f','h','r'};
		
		
		System.out.println("LCS Recursive: " + lcsRecursive(a,b,0,0));
		
		System.out.println("LCS Recursive with Memoization: " + lcsRecursiveWithMomoization(a,b));

		System.out.println("LCS Using DP: " + lcsUsingDP(a,b));

	}

	private static int lcsUsingDP(char[] a, char[] b)
	{
		Integer [] [] lcs = new Integer [a.length+1][b.length+1];
		
		for(int i = 0 ; i <= a.length ; i++)
			for(int j = 0 ; j <= b.length ; j++)
				lcs[i][j] = 0;

		for(int i = 1 ; i <= a.length ; i++)
		{
			for(int j = 1 ; j <= b.length ; j++)
			{
				if(a[i-1] == b[j-1])
					lcs[i][j] = 1+ lcs[i-1][j-1];
				else
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		return lcs[a.length][b.length];
	}

	private static int lcsRecursiveWithMomoization(char[] a, char[] b) 
	{
		Integer [] [] memoz = new Integer [a.length][b.length];
		
		for(int i = 0 ; i < a.length ; i++)
			for(int j = 0 ; j < b.length ; j++)
				memoz[i][j] = -1;
		
		
		
		return lcsRecursive(a,b,0,0,memoz);
	}

	private static int lcsRecursive(char[] a, char[] b, int i, int j, Integer[][] memoz)
	{
		if(a.length ==0 || b.length ==0)
			return 0;
		
		if(a.length <= i || b.length <= j)
			return 0;
		
		if(memoz[i][j] > 0)
			return memoz[i][j];
		
		if(a[i] == b[j])
		{
			if(memoz[i][j] == -1)
				memoz[i][j]  = 1;
			else
				memoz[i][j] ++;
			
			return 1 + lcsRecursive(a, b, i+1, j+1);
		}
		return Math.max(lcsRecursive(a, b, i, j+1) , lcsRecursive(a, b, i+1, j));
	}

	private static int lcsRecursive(char[] a, char[] b, int i, int j) 
	{
		if(a.length ==0 || b.length ==0)
			return 0;
		
		if(a.length <= i || b.length <= j)
			return 0;
		
		if(a[i] == b[j])
			return 1 + lcsRecursive(a, b, i+1, j+1);
		
		return Math.max(lcsRecursive(a, b, i, j+1) , lcsRecursive(a, b, i+1, j));
	}

}
