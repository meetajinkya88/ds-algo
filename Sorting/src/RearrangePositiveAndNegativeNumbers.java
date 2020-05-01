import java.util.ArrayList;


public class RearrangePositiveAndNegativeNumbers 
{
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(45);
		list.add(-23);
		list.add(89);
		list.add(-2);
		
		System.out.println("Before Sort : " );		
		for(int i=0 ; i< list.size() ; i++)
		System.out.print(list.get(i)+ " ," );
		reArrange(list);
		System.out.println("\n After Sort : " );
		for(int i=0 ; i< list.size() ; i++)
			System.out.print(list.get(i)+ " ," );
	}
	private static void reArrange(ArrayList<Integer> list)
	{
		for(int i=0 ; i< list.size() ; i++)
		{
			System.out.print("\n Pass "+ i + " : ");
			for(int j=(i-1) ; j >= 0; j--)
			{
				if( list.get(i) < 0 && list.get(j) > 0)
					swap(list, i , j);
	
				
				
				
				
			}
			for(int j=0 ; j< list.size() ; j++)
			System.out.print(list.get(j)+ " ," );
		}
		
	}

	protected static void swap(ArrayList<Integer> list, int i, int j) 
	{
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
		
		
	}

}

