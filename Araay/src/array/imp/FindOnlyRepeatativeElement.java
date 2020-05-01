package array.imp;

/*
 * 
 * 
Find the only repetitive element between 1 to n-1

We are given an array arr[] of size n. Numbers are from 1 to (n-1) in random order.
 The array has only one repetitive element. We need to find the repetitive element.

Examples :

Input  : a[] = {1, 3, 2, 3, 4}
Output : 3

Input  : a[] = {1, 5, 1, 2, 3, 4}
Output : 1


https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/

Method 1(Use XOR): The idea is based on the fact that x ^ x = 0 and x ^ y = y ^ x.
1) Compute XOR of elements from 1 to n-1.
2) Compute XOR of array elements.
3) XOR of above two would be our result.

Method2: Method 2 (Using Sum Formula): We know sum of first n-1 natural numbers is (n – 1)*n/2.
 We compute sum of array elements and subtract natural number sum from it to find the only missing element.
 
 Method 5 : Using indexing.
1. Iterate through the array.
2. For every index visit a[index], 
if it is positive change the sign of element at a[index] index, else print the element.
 */
public class FindOnlyRepeatativeElement
{

    static int findRepeating(int arr[], int n) 
    { 
      
        // res is going to store value of 
        // 1 ^ 2 ^ 3 .. ^ (n-1) ^ arr[0] ^  
        // arr[1] ^ .... arr[n-1] 
        int res = 0; 
        for (int i = 0; i < n - 1; i++) 
            res = res ^ (i + 1) ^ arr[i]; 
        res = res ^ arr[n - 1]; 
              
        return res; 
    } 
      
    // Driver code 
    public static void main(String[] args) 
    {  
        int arr[] = { 9, 8, 2, 6, 1, 8, 5, 3, 4, 7 }; 
        int n = arr.length; 
        System.out.println(findRepeating(arr, n)); 
    } 

}
