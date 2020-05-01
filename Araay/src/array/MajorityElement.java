package array;

/**
 * https://www.geeksforgeeks.org/majority-element/
 * 
 * Write a function which takes an array and prints the majority element (if it exists), 
 * otherwise prints “No Majority Element”. A majority element in an array A[] of size n is an element 
 * that appears more than n/2 times (and hence there is at most one such element).
Examples :

Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
Output : 4 

Input : {3, 3, 4, 2, 4, 4, 2, 4}
Output : No Majority Element

 * @author ajinkyab
 *
 * Solution:
 * 
 *  1.  Initialize index and count of majority element
             maj_index = 0, count = 1
    2.  Loop for i = 1 to size – 1
       (a) If a[maj_index] == a[i]
             count++
       (b) Else
             count--;
       (c) If count == 0
             maj_index = i;
             count = 1
    3.  Return a[maj_index]
    
    
    Example :
Let the array be A[] = 2, 2, 3, 5, 2, 2, 6

    Initialize maj_index = 0, count = 1
    Next element is 2, which is same as a[maj_index] => count = 2
    Next element is 3, which is different from a[maj_index] => count = 1
    Next element is 5, which is different from a[maj_index] => count = 0
    Since count = 0, change candidate for majority element to 5 => maj_index = 3, count = 1
    Next element is 2, which is different from a[maj_index] => count = 0
    Since count = 0, change candidate for majority element to 2 => maj_index = 4
    Next element is 2, which is same as a[maj_index] => count = 2
    Next element is 6, which is different from a[maj_index] => count = 1
    Finally candidate for majority element is 2.

 */
public class MajorityElement
{

	/* Function to print Majority Element */
    void printMajority(int a[], int size)  
    { 
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size); 
  
        /* Print the candidate if it is Majority*/
        if (isMajority(a, size, cand)) 
            System.out.println(" " + cand + " "); 
        else 
            System.out.println("No Majority Element"); 
    } 
  
    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size)  
    { 
        int maj_index = 0, count = 1; 
        int i; 
        for (i = 1; i < size; i++)  
        { 
            if (a[maj_index] == a[i]) 
                count++; 
            else
                count--; 
            if (count == 0) 
            { 
                maj_index = i; 
                count = 1; 
            } 
        } 
        return a[maj_index]; 
    } 
  
    /* Function to check if the candidate occurs more 
       than n/2 times */
    boolean isMajority(int a[], int size, int cand)  
    { 
        int i, count = 0; 
        for (i = 0; i < size; i++)  
        { 
            if (a[i] == cand) 
                count++; 
        } 
        if (count > size / 2)  
            return true; 
        else
            return false; 
    } 
  
    /* Driver program to test the above functions */
    public static void main(String[] args)  
    { 
        MajorityElement majorelement = new MajorityElement(); 
        int a[] = new int[]{1, 3, 3, 1, 2,3,3}; 
        int size = a.length; 
        majorelement.printMajority(a, size); 
    } 
}
