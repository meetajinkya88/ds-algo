import java.util.Scanner;


public class ZigzagArray
{

	public static void main(String[] args) 
	{
		Scanner scanIn = null;
		try
		{
			System.out.println("Enter Sequence length : ");	     
			scanIn = new Scanner(System.in);
			int n  = scanIn.nextInt();

			System.out.println("Enter array elemnts one by one " );

			Integer [] array = new Integer [n];
			for(int i=0 ; i< n ; i++)
			{
				System.out.println("Enter array elemnt " + (i+1) + " :" );

				scanIn = new Scanner(System.in);				
				array[i] = scanIn.nextInt();;

			}
			
			System.out.println("Entered array is : " );
			printArray(array);

			array = convertTOZigZagArray(array);
			
			System.out.println("Final Zig Zag array is: " );
			printArray(array);

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(scanIn != null)
				scanIn.close();            
		}

	}

	protected static Integer[] convertTOZigZagArray(Integer[] array) 
	{
		int j = 0;
		int temp = 0;
		for(int i = 0 ; i< array.length ; i++)
		{
			j = i+1;
			if(i % 2 == 0 && j < array.length)
			{
				if(array[i] > array[j])
				{
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				
			}
			if(i % 2 == 1 && j < array.length)
			{
				if(array[i] < array[j])
				{
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				
			}
		}
		return array;
	}

	protected static void printArray(Integer[] array) 
	{
		String arrayString = "";
		arrayString += "{ ";
		for(int i=0;i<array.length;i++)
		{
			if(i!= (array.length-1))
				arrayString += array[i] + " , ";
			else
				arrayString += array[i];
		}
		arrayString += " } ";

		System.out.println(arrayString);
		
	}

}
