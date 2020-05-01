import array.util.RandomArray;


public class MergeSort 
{

	public static void main(String[] args)
	{
		int  [] arr = RandomArray.getArray(20, -10,85 );

	
		System.out.println("Unsorted Array : \n");
		RandomArray.printArray(arr);

		mergeSort(arr);
		
		System.out.println("Sorted Array : \n");
		RandomArray.printArray(arr);


	}

	private static void mergeSort(int[] arr)
	{
		if(arr.length <=1) return;
		
		
		int mid = arr.length /2;
		
		int [] leftArray = getSubArray(arr,0,mid -1);
		int [] rightArray = getSubArray(arr,mid,arr.length -1);
		

		mergeSort(leftArray);
		mergeSort(rightArray);
		
		merge(arr,leftArray,rightArray);
			
	}
	private static int[] getSubArray(int[] arr, int start, int end) 
	{
		int subArr[] = new int[end - start + 1];
		int i = 0;
		while(start <= end)
			subArr[i++] = arr[start ++];
		
		return subArr;
	}


	private static void merge(int[] arr, int[] leftArray, int[] rightArray) 
	{
		int i= 0 , j = 0 , k = 0;
		while (i< leftArray.length && j < rightArray.length)
		{
			if(leftArray[i] <= rightArray[j])
			{
				arr[k] = leftArray[i];
				i++;
			}
			else 
			{
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		while(i< leftArray.length)
			arr[k++] = leftArray[i++];
		
		while( j< rightArray.length)
			arr[k++] = rightArray[j++];
	}







	

}
