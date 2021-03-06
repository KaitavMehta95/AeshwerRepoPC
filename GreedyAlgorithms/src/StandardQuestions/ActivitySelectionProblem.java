package StandardQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;

/*You are given n activities with their start and finish times. Select the maximum number of activities that can 
 * be performed by a single person, assuming that a person can only work on a single activity at a times
 * Example 2 : Consider the following 6 activities  sorted by by finish time.
     start[]  =  {1, 3, 0, 5, 8, 5};
     finish[] =  {2, 4, 6, 7, 9, 9};
A person can perform at most four activities. The maximum set of activities that can be executed is 
{0, 1, 3, 4} [ These are indexes in start[] and finish[] ]
activities are already sorted according to their finish time.	The greedy choice is to always pick the next activity
whose finish time is least among the remaining activities and the start time is more than or equal to the finish time of 
previously selected activity.
*/
public class ActivitySelectionProblem {
	
	public static void printMaxActivities(int start[], int finish[], int len)
    {
		int i=0, j;
	    System.out.print("Following activities are selected : \n");
	    // The first activity always gets selected
	    System.out.print(i+" ");
	    // Consider rest of the activities
	    for (j = 1; j < len; j++)
	    {
	         // If this activity has start time greater than or
	         // equal to the finish time of previously selected
	         // activity, then select it
	         if (start[j] >= finish[i])
	         {
	              System.out.print(j+" ");
	              i = j;
	          }
	     }
    }
	
	
	public static void main(String[] args) {
		int start[] =  {1, 3, 0, 5, 8, 5};
	    int finish[] =  {2, 4, 6, 7, 9, 9};
	    int len = start.length;
	    
	   /* HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i= 0; i< len ;i++ )
	    {
	    	map.put(finish[i],start[i]);
	    }
	    
	    for(Map.Entry<Integer,Integer> m : map.entrySet())
	    {
	    	System.out.println(m.getKey() + " " + m.getValue() + " ");
	    }*/
	    
	    printMaxActivities(start, finish, len);
	    }
	}


