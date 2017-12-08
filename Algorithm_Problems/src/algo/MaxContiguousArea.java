package algo;

import java.util.Scanner;


/**
 * 
 * Maximum Contiguous Squared Area of Ones 
 * 
 *  Given an N*N array A of zeroes and ones, write an efficient function to find the size(or
 *  area) of the largest contiguous all-ones square.

 * @author ajinkyab
 *
 */
public class MaxContiguousArea
{

	public static void main(String[] args)
	{
		
		/*System.out.println("Enter Size of Matrix : ");
		Scanner scanSize = new Scanner(System.in);
		int n = scanSize.nextInt();
	
		//int matrix [] [] = getMatrix(n);
		*/
		int n = 4;
		int matrix [] [] = getHardcodedMatrix(n);
		printMatrix(matrix,n);
		
		System.out.println("Max Contiguos Area using DP " + getMaxContigousArea(matrix,n));
		
		
	}
	

	protected static int[][] getHardcodedMatrix(int n)
	{
	
		int matrix [][] = new int [n+1][n+1];
		matrix[1][1] = 1;
		matrix[1][2] = 0;
		matrix[1][3] = 1;
		matrix[1][4] = 0;
		matrix[2][1] = 1;
		matrix[2][2] = 1;
		matrix[2][3] = 1;
		matrix[2][4] = 0;
		matrix[3][1] = 0;
		matrix[3][2] = 0;
		matrix[3][3] = 0;
		matrix[3][4] = 1;
		matrix[4][1] = 1;
		matrix[4][2] = 1;
		matrix[4][3] = 1;
		matrix[4][4] = 1;
		
		return matrix;
	}

	protected static int getMaxContigousArea(int[][] matrix, int n)
	{
		int[][]  maxArea = new int [n+1] [n+1];
		
		getAuxMaxContiguousArea(matrix,n,maxArea);
		return getMaxArea(maxArea,n);
		
	}

	protected static void getAuxMaxContiguousArea(int[][] matrix, int n, int[][]  maxArea)
	{
		for(int i = 1 ; i<=n ; i++)
		{
			for(int j=1 ; j<=n ; j++)
			{
				if(matrix[i][j]==0)
					maxArea[i][j]=0;
				else if (j ==1)
					maxArea[i][j] = matrix[i][j] + maxArea[i-1][n];
				else
					maxArea[i][j] = matrix[i][j] + maxArea[i][j-1];
			}
		}
		
	}

	protected static int getMaxArea(int[][] maxArea,int n)
	{
		int max = 0;
		for(int i = 1 ; i<= n ; i++)
		{
			for(int j = 1 ; j<= n ; j++)
			{
			if(maxArea[i][j] > max)
				max = maxArea[i][j];
			}
		}
		return max;
	}

	protected static void printMatrix(int[][] matrix, int n)
	{
		for(int i = 1 ; i<=n ; i++)
		{
			System.out.println("\t");
			for(int j=1 ; j<=n ; j++)
			{
				System.out.print(matrix[i][j] + "\t");
	
			}
		}
		}

	protected static int[][] getMatrix(int n)
	{
			
		int matrix [] [] = new int [n+1][n+1];
		System.out.println("matrix.length:" +matrix.length);
		for(int i = 1 ; i<=n ; i++)
		{
			for(int j=1 ; j<=n ; j++)
			{
				System.out.println("Enter element of matrix ["+i+"]["+j+"] : ");
				Scanner scanSize = new Scanner(System.in);
				matrix[i][j] = scanSize.nextInt();
			}
		}
		return matrix;
		
	}

}
