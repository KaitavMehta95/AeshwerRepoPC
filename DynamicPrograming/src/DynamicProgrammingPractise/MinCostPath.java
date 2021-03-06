/*
 * 	http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
package DynamicProgrammingPractise;

import java.util.Arrays;

public class MinCostPath {

	private static int minCost(int[][] cost, int m, int n) {
		
		int[][] temp = new int[m+1][n+1];
		temp[0][0] = cost[0][0];
		
		// fill first row 
		for(int i= 1; i<=n; i++)
		{	
			temp[0][i] = cost[0][i] +temp[0][i-1]; 
		}

		//fill first Column
		for(int j= 1; j<= m; j++)
		{
			temp[j][0] = cost[j][0] +temp[j-1][0];
		}
		
		for(int i= 1; i<= m; i++)
		{
			for(int j= 1; j<= n; j++)
			{
				temp[i][j]= Math.min(temp[i-1][j], temp[i][j-1]) +cost[i][j]; 
			}
		}
		
		return temp[m][n];
		
	}
	
	public static void main(String[] args) {
		
        int cost[][] = {{1,2,3},{4,8,2},{1,5,3},{6,2,9}};
        int result = minCost(cost, 3, 2);
        System.out.println(result);
	}
}
