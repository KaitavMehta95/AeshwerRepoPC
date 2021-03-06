package ArraysProblems;
/*
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
 * HARD LOGIC :: Dutch National Flag Algorithm, or 3-way Partitioning ,IMPORTANT
 */

public class Sort012Array {
	
	void sort(int[] arr, int len)
	{
		int lo = 0; //for zeros
		int mid = 0; // for ones
        int hi = len - 1; // for twos
        int temp=0; 
        while (mid <= hi)
        {
        	// put a check for ones i.e ones 
            switch (arr[mid])
            {
            case 0:
            {  // swap value with zeros pointer
                temp   =  arr[lo];
                arr[lo]  = arr[mid];
                arr[mid] = temp;
                lo++;
                mid++;
                break;
            }
            case 1: // easy case when we see one pointer point to one
                mid++;
                break;
            case 2:
            {    // swap value with twos pointer
                temp = arr[mid];
                arr[mid] = arr[hi];
                arr[hi] = temp;
                hi--;
                break;
            }
            }
        }
	}
	
	 public static void main(String[] args) {
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		Sort012Array obj = new Sort012Array();
		obj.sort(arr,arr.length);
		
		 System.out.print("Array after sorting is ");
	        for (int i  = 0; i < arr.length; i++)
	            System.out.print(arr[i] + " ");
	}
}
