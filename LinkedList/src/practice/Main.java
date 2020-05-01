package practice;

public class Main {

	public static <T> void main(String[] args)
	{
		LinkedList<T> list = new LinkedList<T>();
		list.add((T) new Integer(1));
		list.add((T) new Integer(2));
		
		list.printAllNodes();
		
		System.out.println("\n2 Contains: " + list.contains(new Integer(2)));
		System.out.println("\n3 Contains: " + list.contains(new Integer(3)));
		
		list.add((T) new Integer(3));
		list.add((T) new Integer(4));

		System.out.println("\n3 Contains: " + list.contains(new Integer(3)));
		list.printAllNodes();

		list.remove(new Integer(4));
		list.remove(new Integer(3));
		list.remove(new Integer(1));

		System.out.println("\n Removing 2");

		list.printAllNodes();


	}

}
