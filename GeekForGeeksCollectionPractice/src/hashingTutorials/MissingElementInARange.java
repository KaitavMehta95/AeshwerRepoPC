package hashingTutorials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/*  Given an array arr[0..n-1] of distinct elements and a range [low, high],
 *  find all numbers that are in range, but not in array.
 *  The missing elements should be printed in sorted order. 
 * 	Input: arr[] = {10, 12, 11, 15}, 
       low = 10, hight = 15
	Output: 13, 14
 */

public class MissingElementInARange {
	
	static void printMissing(Integer arr[], int n, int low, int high){
		Set<Integer> set = new HashSet<Integer>();
		Collections.addAll(set, arr);
		
		// Traverse throught the range an print all missing elements
				for (int x=low; x<=high; x++)
					if (!set.contains(x))
						System.out.print(x+", ");
	}
	
	
	public static void main(String[] args) {
		   Integer arr[] = {1, 3, 5, 4};
		   int n = arr.length;
		   int low = 1, high = 10;
		   printMissing(arr, n, low, high);
	}

}