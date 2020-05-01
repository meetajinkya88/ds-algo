import array.util.RandomArray;


public class QuickSort
{
	public static void main(String[] args)
	{
		int  [] arr = RandomArray.getArray(10, -10,85 );

		System.out.println("Unsorted Array : \n");
		RandomArray.printArray(arr);

		quicksort(arr,0,arr.length-1);
		System.out.println("Sorted Array : \n");
		RandomArray.printArray(arr);
	}
	private static void quicksort(int[] arr, int start, int end) 
	{
		if(start >= end)
			return;
		
		int pivot = partition(arr,start,end);
		quicksort(arr, start, pivot -1);
		quicksort(arr, pivot + 1, end);
	}
	private static int partition(int[] arr, int start, int end)
	{
		int pivot = end;
		int i = 0;
		int j = end -1;	
		while( i <= j)
		{
			if(arr[i] > arr[pivot] && arr[j] < arr[pivot])
			{
				swap(arr,i,j);
				i++;
				j--;
			}
			if(arr[i] < arr[pivot])
				i++;
			if(arr[j] > arr[pivot])
				j--;						
		}	
		swap(arr,i,pivot);			
		
		return i;
	}
	private static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
