package ArraysProblems;
/*
 * Fixed Point in an array is an index i such that arr[i] is equal to i. Note that integers in array can be negative.
 * http://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
 */

public class FindFixedPointInArray {

    static int binarySearch(int arr[], int low, int high)
    {
        if(high >= low)
        {   
            int mid = (low + high)/2;  
            if(mid == arr[mid])
                return mid;
            if(mid > arr[mid])
                return binarySearch(arr, (mid + 1), high);
            else
                return binarySearch(arr, low, (mid -1));
        }
       
       // Return -1 if there is no Fixed Point 
        return -1;
    }
    
    //main function
    public static void main(String args[])
    {
        int arr[] = {-10, -1, 0, 3 , 10, 11, 30, 50, 100};
        int n = arr.length;
        System.out.println("Fixed Point is "+ binarySearch(arr,0, n-1));        
    } 
}