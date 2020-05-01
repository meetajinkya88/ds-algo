import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LookAndSaySquence 
{

	public static void main(String[] args) 
	{
		Scanner scanIn = null;
		try
		{
			System.out.println("Enter Sequence length : ");	     
			scanIn = new Scanner(System.in);
			int n  = scanIn.nextInt();

			System.out.println("No of values printed in sequence is " + n);

			String [] array = getSequence(n);

			printSequence(array,n);
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

	protected static void printSequence(String[] array, int n) 
	{
		for(int i = 1 ; i<= n ; i++)
			System.out.println(array[i]);	  

	}

	protected static String[] getSequence(int n)
	{
		String[] array = new String[100];
		array[1] = "1";
		for(int i= 2 ; i<= n ; i++)
		{
			if(array[i - 1].length() == 1 )
			{
				array[i] = array[i-1] + (i -1);
			}

			array[i] = returnNextString(array[i-1]);
		}

		return array;
	}

	protected static String returnNextString(String string) 
	{
		String tempString = "";
		String [] chars = string.split("(?!^)");
		List <Integer> temp = new ArrayList<Integer>();

		for(int i = 1 ; i <= string.length() ; i++)
		{
			String a = chars[i-1];
			if(temp.size() <=0)
			{
				temp.add(Integer.parseInt(a));
			}
			else if(temp.contains(Integer.parseInt(a)))
			{
				temp.add(Integer.parseInt(a));

			}
			else
			{
				tempString = tempString + temp.size() + temp.get(0);
				temp.clear();
				temp.add(Integer.parseInt(a));
			}

		}
		if(chars.length == temp.size())
			return temp.size() + "" + temp.get(0);
		else
			return tempString + temp.size() + "" + temp.get(0);
	}

}
