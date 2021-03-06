package hashingTutorials;

import java.util.HashMap;
import java.util.Map;

/*Given an integer n. Print first n elements of Recamanís sequence.
 * Input : n = 6  Output : 0, 1, 3, 6, 2, 7  // First term of the sequence is always 0
 * http://mathworld.wolfram.com/RecamansSequence.html
 * NOTE: let a(n) denote the (n+1)-th term. (0 being already there).
 * 	a(0) = 0,
	if n > 0 and the number is not 
   	already included in the sequence,
     a(n) = a(n - 1) - n 
	else 
     a(n) = a(n-1) + n. 
 */

public class RecamansSequence {
	static void recaman(int n){
		HashMap<Integer,Integer> map  = new  HashMap<Integer, Integer>();
		// First term of the sequence is always 0
		map.put(0, 0);
		int temp = 1;
		n--;
		int val=0;
		while(n-- > 0){
			val = map.get(temp-1) - temp;
			if((val < 0) || map.containsValue(val)){
				val = map.get(temp-1) + temp;
			}
			map.put(temp, val);
			temp++;
		}
		
		for(Map.Entry<Integer,Integer> m : map.entrySet()){
			System.out.print(m.getValue() + " ");
		}
		
	}
	
	public static void main(String[] args) {
	    int n = 17;
	    recaman(n);
	}

}
