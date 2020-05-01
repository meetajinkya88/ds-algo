import array.util.RandomArray;


public class HeapSort 
{

	public static void main(String[] args)
	{
		int [] arr = RandomArray.getArray(9, 5, 50);

		System.out.println("Array Before sorting:");
		RandomArray.printArray(arr);
		arr =heapSort(arr);
		
		System.out.println("Array After sorting:");
		RandomArray.printArray(arr);
	
	}

	private static int[] heapSort(int[] arr)
	{
		for(int i = arr.length -1  ; i>0  ; i--)
		{	
			arr=computeMaxHeap(arr, i);
			arr=swap(arr,0,i);
		}
		return arr;
	}

	private static int[] computeMaxHeap(int[] arr, int i) 
	{
		 arr= maxHeapify(arr,0,i);
		 System.out.println("Computed Max heap array : ");
		 RandomArray.printArray(arr);
		 return arr;
	}

	private static int[] maxHeapify(int[] arr, int i, int max) 
	{
		if(2*i+1 > max  && 2*i+2 > max)
			return arr;
		
		if(2*i+1 <= max)
			arr=maxHeapify(arr,2*i+1,max );
		
		if(2*i+2 <= max)
			arr=maxHeapify(arr,2*i+2,max );
		
		if((2*i+1 <= max) && arr[i] < arr[2*i+1])
			arr=swap(arr,i,2*i+1);
		if((2*i+2 <= max) && arr[i] < arr[2*i+2])
			arr=swap(arr,i,2*i+2);
	
		return arr;
	}

	private static int[] swap(int[] arr, int index1, int index2) 
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		
		return arr;
	}

}
