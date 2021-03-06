/*
 * Given two strings str1 and str2 and below operations that can performed on str1. 
 * Find minimum number of edits (operations) required to convert �str1� into �str2�.  (INser ,Remove, Replace)
 */
package DynamicProgrammingPractise;

public class StringConvertion {
	
	static int min(int x,int y,int z)
    {
        if (x < y && x <z) return x;
        if (y < x && y < z) return y;
        else return z;
    }
	
	static int editDistDP(char[] str1, char[] str2, int m, int n)
    {
        // Create a table to store results of subproblems
        int dp[][] = new int[m+1][n+1];
        
        // filling first row and column 
        for(int i=0; i < dp[0].length; i++){
            dp[0][i] = i;}
        
        for(int j=0; j < dp.length; j++){
            dp[j][0] = j;
        }
        
      
        // Fill d[][] in bottom up manner
        for (int i=1; i<=m; i++)
        {
            for (int j=1; j<=n; j++)
            {
                // If last characters are same, ignore last char
                // and recur for remaining string
                 if (str1[i-1] == str2[j-1])
                    dp[i][j] = dp[i-1][j-1];
      
                // If last character are different, consider all
                // possibilities and find minimum
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                                       dp[i-1][j],  // Remove
                                       dp[i-1][j-1]); // Replace
            }
        }
  
        return dp[m][n];
    }

	public static void main(String[] args) {
		
		String str1 = "sunday";
        String str2 = "saturday";
        System.out.println( editDistDP( str1.toCharArray() , str2.toCharArray() , str1.length(), str2.length()) );
	}
}
