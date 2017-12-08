package algo;

import java.util.Scanner;

public class SudokuSolver
{

	public static void main(String[] args)
	{
		int[][] in = null;
		// in = createSudokuPuzzle();
		in = createStaticSudokuPuzzle();
		System.out.println("Given sudoku puzzle  :");
		printPuzzle(in);
		System.out.println("\nSolved Solutions of sudoku puzzle  :");
		sudokuSolver(in);

	}

	private static int[][] createStaticSudokuPuzzle()
	{
		int[][] in = new int[9][9];
		in[0][1]=2;
		in[0][5]=4;
		in[0][6]=3;
		in[1][0]=9;
		in[1][4]=2;
		in[1][8]=8;
		in[2][3]=6;
		in[2][5]=9;
		in[2][7]=5;
		in[3][8]=1;
		in[4][1]=7;
		in[4][2]=2;
		in[4][3]=5;
		in[4][5]=3;
		in[4][6]=6;
		in[4][7]=8;
		in[5][0]=6;
		in[6][1]=8;
		in[6][3]=2;
		in[6][5]=5;
		in[7][0]=1;
		in[7][4]=9;
		in[7][8]=3;
		in[8][2]=9;
		in[8][3]=8;
		in[8][7]=6;
		return in;
	}

	private static int[][] createSudokuPuzzle()
	{
		int[][] in = new int[9][9];

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total no of input digits : ");
		int n = scan.nextInt();
		for (int i = 0; i < n; i++)
		{
			scan = new Scanner(System.in);
			System.out.println("Enter the row index: ");
			int r = scan.nextInt();

			scan = new Scanner(System.in);
			System.out.println("Enter the column index: ");
			int c = scan.nextInt();

			scan = new Scanner(System.in);
			System.out.println("Enter the input digit: ");
			int d = scan.nextInt();

			in[r - 1][c - 1] = d;

		}
		return in;
	}

	private static void printPuzzle(int[][] in)
	{
		if (in != null)
		{
			for (int i = 0; i < 9; i++)
			{
				System.out.println();
				for (int j = 0; j < 9; j++)
				{
					System.out.print(in[i][j] + " ");
				}
			}
		}
	}

	private static void sudokuSolver(int[][] in)
	{
		if (in == null)
			in = new int[9][9];

		auxSolver(0, 0, in);

	}

	private static void auxSolver(int r, int c, int[][] in)
	{
		if (r == 9)
		{
			printPuzzle(in);
			System.out.print("\n\n");

			return;
		}
		if (in[r][c] != 0)
		{
			int nr = (c == 8 ? r + 1 : r);
			int nc = (c + 1) % 9;
			auxSolver(nr, nc, in);
		} else
		{
			for (int d = 1; d <= 9; d++)
			{
				if (isvalidDigit(r, c, d, in))
				{
					in[r][c] = d;
					int nr = (c == 8 ? r + 1 : r);
					int nc = (c + 1) % 9;
					auxSolver(nr, nc, in);
				}
				in[r][c] = 0;
			}

		}
	}

	private static boolean isvalidDigit(int r, int c, int d, int[][] in)
	{
		for (int i = 0; i < 9; i++)
		{
			if (in[r][i] == d)
				return false;
			if (in[i][c] == d)
				return false;
		}
		int gridStartRow = (r / 3) * 3;
		int gridStartCol = (c / 3) * 3;

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (in[gridStartRow + i][gridStartCol + j] == d)
					return false;
			}
		}

		return true;
	}

}
