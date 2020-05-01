import java.util.Scanner;


public class RotateMatrixElements
{

	public static void main(String[] args)
	{
		RotateMatrixElements r = new RotateMatrixElements();
		System.out.println("Please Enter Matrix size (n x n ) : ");		
		Scanner scanIn = new Scanner(System.in);
		int n  = scanIn.nextInt();

		Integer [][] matrix = new Integer [n][n];

		for(int i=0 ; i< n ; i++)
		{
			for(int j=0;j<n ; j++)
			{
				System.out.println("Enter array elemnt ["  +i+ "]["+j+"]:" );

				scanIn = new Scanner(System.in);				
				matrix[i][j] = scanIn.nextInt();
			}
		}

		r.printMatrix(matrix,n);
		matrix = r.rotateMatrix(matrix,n);
		r.printMatrix(matrix,n);
	}

	protected Integer[][] rotateMatrix(Integer[][] matrix, int n)
	{
		int temp1 , temp2 = 0;
		
		temp1 = matrix[0][0];
		for(int j=1;j<n;j++)
		{
			temp2 = matrix[0][j];
			matrix[0][j] = temp1;
			temp1 = temp2;

		}

		for(int i = 1;i<n;i++)
		{
			temp2 = matrix[i][n-1];
			matrix[i][n-1] = temp1;
			temp1 = temp2;
		}
		for(int j = n-2 ; j>= 0 ; j--)
		{
			temp2 = matrix[n-1][j];
			matrix[n-1][j] = temp1; 
			temp1 = temp2;
		}	

		for(int i = n-2 ; i>= 0 ; i--)
		{
			temp2 = matrix[i][0];
			matrix[i][0] = temp1; 
			temp1 = temp2;
		}	

		return matrix;
	}

	protected void printMatrix(Integer[][] matrix, int n)
	{
		StringBuffer buffer = new StringBuffer();
		for(int i=0 ; i<n ; i++)
		{
			buffer.append("\n   ");
			for(int j=0 ; j<n ; j++)
			{
				buffer.append(matrix[i][j]);
				buffer.append("   ");
			}

		}
		System.out.println(buffer.toString());
	}

}
