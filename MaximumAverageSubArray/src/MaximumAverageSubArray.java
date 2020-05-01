import java.util.Scanner;


public class MaximumAverageSubArray 
{

	public static void main(String[] args)
	{
		Scanner scanIn = null;
		try
		{
			System.out.println("Enter Max array length : ");	     
			scanIn = new Scanner(System.in);
			int n  = scanIn.nextInt();

			Integer [] array = new Integer [n];
			for(int i=0 ; i< n ; i++)
			{
				System.out.println("Enter array elemnt " + (i+1) + " :" );

				scanIn = new Scanner(System.in);				
				array[i] = scanIn.nextInt();;

			}
		 /*
			Integer [] array = new Integer [6];
			array[0]=1;
			array[1]=12;
			array[2]=-5;
			array[3]=-6;
			array[4]=50;
			array[5]=3;
			System.out.println("Entered array is : " );
			*/
			printArray(array,0,0);

			int k = 0;
			do
			{
				System.out.println("Entered size of subArray (Enter 0 for exit) : " );
				scanIn = new Scanner(System.in);
				k  = scanIn.nextInt();

				int index = getMaximumAvgSubArray(array,k);

				printArray(array,index ,k);


			}while(k == 0);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	protected static int getMaximumAvgSubArray(Integer[] array, int k)
	{
		Integer [] subArraySum = new Integer [array.length];
		int sum = 0;
		System.out.println("SubArraySum size :"  + subArraySum.length);

		for(int i=0 ; i<= (array.length - k ) ; i++)
		{	

			//System.out.println("i :"  + i);

			sum = 0;			
			for(int j=i ; j< (i + k) ; j++)
			{
				//System.out.println("j :"  + j);

				sum = sum+ array[j];
			}
			subArraySum[i] = sum;
			System.out.println("SubArraySum["  + i + "] :"  + subArraySum[i]);

		}


		int index = 0;
		sum= subArraySum [0];
		for(int i=0 ; i<= (array.length - k ) ; i++)
		{
			System.out.println("i :"  + i);

			if(subArraySum[i] > sum)
			{
				System.out.println("SubArraySum["  + i + "] :"  + subArraySum[i]);

				sum = subArraySum[i];
				index = i;
			}
		}

		return index;
	}

	protected static void printArray(Integer[] array , int index , int k) 
	{
		String arrayString = "";
		arrayString += "{ ";
		if(k == 0 )
			k = array.length;
		else
			k = index + k;
		for(int i= index ;i< k ;i++)
		{
			if(i!= (k -1))
				arrayString += array[i] + " , ";
			else
				arrayString += array[i];
		}
		arrayString += " } ";

		System.out.println(arrayString);

	}

}
