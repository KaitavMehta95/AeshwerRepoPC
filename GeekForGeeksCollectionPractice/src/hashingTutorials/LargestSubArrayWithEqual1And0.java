package hashingTutorials;

import java.awt.SystemColor;
import java.util.HashMap;

import javax.print.DocFlavor.READER;
/*Given an array containing only 0s and 1s, find 
 * the largest subarray which contain equal no of 0s and 1s.
 *  Expected time complexity is O(n).
 	Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
	Output: 1 to 6 (Starting and Ending indexes of output subarray)
 */

public class LargestSubArrayWithEqual1And0 {
    // Returns largest subarray with equal number of 0s and 1s
    int maxLen(int arr[], int n) 
    {
    	HashMap< Integer,Integer> map =new HashMap<Integer, Integer>();
    	
    	//set zero's as -1
    	for(int i= 0; i<n;i++)
    	{
    		if(arr[i]== 0){arr[i] = -1;}
    	}
    	
    	int sum =0, maxLen =0;
    	
    	for(int i= 0; i<n;i++)
    	{
    		sum += arr[i];
    		if(sum == 0)
    		{
    			maxLen = i+1;
    		}  
    		
    		if(map.containsKey(sum))
    		{  maxLen = Math.max(maxLen, (i -map.get(sum))); 
    		}
    		else{ map.put(sum, i);}
    	}
    	
    	return maxLen;
    }
	public static void main(String[] args) {

		LargestSubArrayWithEqual1And0 sub = new LargestSubArrayWithEqual1And0();
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        int n = arr.length;
 
        System.out.println(sub.maxLen(arr, n));
    }
}
