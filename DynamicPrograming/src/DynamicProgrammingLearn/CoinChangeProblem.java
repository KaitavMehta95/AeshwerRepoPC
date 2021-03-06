package DynamicProgrammingLearn;

import java.util.Arrays;

/*Given a value N, if we want to make change for N cents, and we have infinite supply of each
 *  of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn�t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
 * So output should be 4 with the minimum coins needed is 2 ie. {1,3}.
 * 
 * OPTIMUL SUBSTRUCTURE PROBLEM with recursion : C(p)= min for all i {C(p-vi)}+1
*/
public class CoinChangeProblem {
	
	// m is size of coins array (number of different coins)
	static int minCoins(int[] coins, int length, int value)
	{
	    // table[i] will be storing the minimum number of coins
	    // required for i value.  So table[V] will have result
		 int[] table = new int[value+1];
	 
	    // Base case (If given value V is 0)
	    table[0] = 0;
	 
	    // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
        
	    // Compute minimum coins required for all
	    // values from 1 to V
	    for (int i=1; i<=value; i++)
	    {
	        // Go through all coins smaller than i
	        for (int j=0; j<length; j++)
	          if (coins[j] <= i)
	          {
	              int sub_res = table[i-coins[j]];
	              if (sub_res != 0 && sub_res + 1 < table[i])
	                  table[i] = sub_res + 1;
	          }
	    }
	    return table[value];
	}
	
	public static void main(String[] args) {

		int coins[] =  {9, 6, 5, 1};
        int length = coins.length;
        int value = 4;
        System.out.println(minCoins(coins, length, value));
	}
}
