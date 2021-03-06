/*
 * Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same 
 * relative order, but not necessarily contiguous. For example, �abc�, �abg�, �bdf�, �aeg�, ��acefg�, .. etc are subsequences of �abcdefg�.
 *  So a string of length n has 2^n different possible subsequences.
 *  
 *  Watch Tushar Roys Video  for logic understanding	
 *  
 *  Examples:
	LCS for input Sequences �ABCDGH� and �AEDFHR� is �ADH� of length 3.
	LCS for input Sequences �AGGTAB� and �GXTXAYB� is �GTAB� of length 4.
 */
package DynamicProgrammingPractise;

public class LongestCommonSubSequence {
	
	// Simple Recursive Approach
	/* public int lcs(char str1[],char str2[],int len1, int len2){
	        
	        if(len1 == str1.length || len2 == str2.length){
	            return 0;
	        }
	        if(str1[len1] == str2[len2]){
	            return 1 + lcs(str1,str2,len1+1,len2+1);
	        }
	        else{
	            return Math.max(lcs(str1,str2,len1+1,len2),lcs(str1,str2,len1,len2+1));
	        }
	    }*/
	 
	public static int lcsDynamic(char str1[],char str2[],int len1 ,int len2){
		int temp[][] = new int[len1 + 1][len2 + 1];
        int max = 0;
        for(int i=1; i < len1+1; i++){
            for(int j=1; j < len2+1; j++){
                if(str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
        return max;
	}		
	  public static void main(String[] args) {
		  
		  	String str1 = "AGGTABZ";
	        String str2 = "GXTXAYBZ";
	        int len1 = str1.length();
	        int len2 = str2.length();
	        int result = lcsDynamic(str1.toCharArray(), str2.toCharArray(),len1,len2);
	        System.out.print(result);
	  }
}
