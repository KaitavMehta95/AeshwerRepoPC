package ArraysProblems;

import java.util.Arrays;

/*
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 */
public class PythagorasTripletInArray {
	
    static boolean isTriplet(int arr[], int n)
    {
    	int l,r;
    	 // Square array elements
        for (int i=0; i<n; i++)
            arr[i] = arr[i]*arr[i];
  
        // Sort array elements
        Arrays.sort(arr);
    	
     // Now fix one element one by one and find the other two
        // elements
    	for (int i = n-1; i >= 2; i--)	
        {            
        	l = 0; // index of the first element in the remaining elements
            r = i - 1; // index of the last element
            while (l < r) 
            {
                if (arr[i] == arr[l] + arr[r] ) 
                {
                	return true;
                } 
                
                // Else either move 'l' or 'r'
                if (arr[l] + arr[r] < arr[i])
                   l++;
                else
                   r--;
            }
        }
        return false;
   }	
	
	public static void main(String[] args)
    {
        int arr[] = {3, 1, 4, 6, 5};
        int arr_size = arr.length;
        if (isTriplet(arr,arr_size)==true)
           System.out.println("Yes");
        else
           System.out.println("No");        
    }
}