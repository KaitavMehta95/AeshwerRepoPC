package hashingTutorials;

import java.util.*;

public class SliddingWindowMan {

	static void printKMax(int[] arr ,int len, int k){
		int max =0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0 ; i < len ; i++)
		{ 
			list.add(arr[i]);
			if(list.size() == k )
			{
				Iterator<Integer> itr = list.iterator();
				while(itr.hasNext())
				{   
					max = Math.max(max, itr.next());   
				} 
				System.out.print(max + " ");
				list.remove(0);
			}
		}
	}
		
//	
	
	public static void main(String[] args) {
		//int arr[] = {12, 1, 78, 90, 57, 89, 56}; // output :78 90 90 90 89
		int arr[] = {12, 1, 78, 90, 97, 89, 106}; // output :78 90 90 90 89
	    int len = arr.length;
	    int k = 3;
	    printKMax(arr, len, k);
	}
}
