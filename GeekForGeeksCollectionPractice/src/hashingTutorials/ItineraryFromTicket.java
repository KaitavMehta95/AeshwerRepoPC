package hashingTutorials;

import java.util.HashMap;
import java.util.Map;

/*Given a list of tickets, find itinerary in order using the given list. Good Questionss
 * Input:
"Chennai" -> "Banglore"
"Bombay" -> "Delhi"
"Goa"    -> "Chennai"
"Delhi"  -> "Goa"
Output: 
Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
 * 
 */

public class ItineraryFromTicket {
	
	static void  printResult(HashMap< String,String> map)
	{ 
		HashMap<String, String> reverseMap = new HashMap<String, String>();
		// To fill reverse map, iterate through the given map	
		for(Map.Entry<String, String> m :map.entrySet())
		{
			reverseMap.put(m.getValue(),m.getKey());
		}
		
		// Find the starting point of itinerary
		String start = null;
		for(Map.Entry<String, String> m :map.entrySet())
		{
			if (!reverseMap.containsKey(m.getKey()))
            {
                 start = m.getKey();
                 break;
            }
		}
		
		// If we could not find a starting point, then something wrong
        // with input
        if (start == null)
        {
           System.out.println("Invalid Input");
           return;
        }
 
        // Once we have starting point, we simple need to go next, next
        // of next using given hash map
        
        String to = map.get(start);
        while (to != null)
        {
        	System.out.print(start +  "->" + to + ", ");
        	 start = to;
             to = map.get(to);
        }
		
	}
	
	public static void main(String[] args){
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Chennai", "Banglore");
		map.put("Bombay", "Delhi");
		map.put("Goa", "Chennai");
		map.put("Delhi", "Goa");
		
		printResult(map);
		
	}

}
