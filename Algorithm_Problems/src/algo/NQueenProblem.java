package algo;

import java.util.Scanner;

/**
 * Give N queen of chase board of size n x n . We have to place N in each column
 * queens such that no two queen should attack on each other . Queen can
 * traverse vertical,horizontal and diagonally .
 * 
 * Find all possible combinations for such queens positions.
 * 
 * @author ajinkyab
 * 
 */
public class NQueenProblem
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Chase board size : ");
		int size = scan.nextInt();

		findNQueenCombination(0, new int[size]);
	}

	public static void findNQueenCombination(int depth, int[] out)
	{
		if (depth == out.length)
		{
			if (isValidPosition(depth, out))
			{
				for (int i = 0; i < out.length; ++i)
					System.out.print(out[i] + ",");
				System.out.println();
			}
			return;
		}
		for (int c = 0; c < out.length; ++c)
		{
			out[depth] = c;
			findNQueenCombination(depth + 1, out);
		}

	}

	private static boolean isValidPosition(int depth, int[] out)
	{
		for(int i=0 ; i< out.length ; i++)
		{
			
			for(int j= 0 ; j< out.length ; j++)
			{
				//System.out.println("")
				if(i==j)
				continue;
				
				//if(out[i] == j)
					//return false;
				if(out[i] == out[j])
					return false;
				if(Math.abs(out[i] - out[j]) == Math.abs(i-j))
					return false;
				
			}
		}
		return true;
	}

}
