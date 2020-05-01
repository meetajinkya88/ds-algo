import java.util.ArrayList;


public class InsertionSort 
{

	public static void main(String[] args)
	{
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(45);
		list.add(23);
		list.add(89);
		list.add(2);
		
		System.out.println("Before Sort : " );		
		for(int i=0 ; i< list.size() ; i++)
		System.out.print(list.get(i)+ " ," );
		sort(list);
		System.out.println("\n After Sort : " );
		for(int i=0 ; i< list.size() ; i++)
			System.out.print(list.get(i)+ " ," );
	}
	private static void sort(ArrayList<Integer> list)
	{
		for(int i=0 ; i< list.size() ; i++)
		{
			for(int j=0 ; j<= i; j++)
			{
				if(list.get(i) < list.get(j))
					swap(list, i , j);
				
			}
		}
		
	}

	protected static void swap(ArrayList<Integer> list, int i, int j) 
	{
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
		
		
	}

}
