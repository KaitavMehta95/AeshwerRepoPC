/*  1) Construct a sum matrix S[R][C] for the given M[R][C].
     a)	Copy first row and first columns as it is from M[][] to S[][]
     b)	For other entries, use following expressions to construct S[][]
         If M[i][j] is 1 then
            S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
         Else If M[i][j] is 0
            S[i][j] = 0
     2) Find the maximum entry in S[R][C]
     3) Using the value and coordinates of maximum entry in S[i], print sub-matrix of M[][]
 */
package DynamicProgrammingLearn;

import java.util.Arrays;

//Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

public class MaxSizeSubSquareWithAll1 {
	
	static void printMaxSubSquare(Integer[][] arr, int len)
	{
		// copy first row and first column
		Integer[][] s = new Integer[len][len];
		for(int i= 0;i< len ;i++)
		{ s[0][i] = arr[0][i];
		  s[i][0] = arr[i][0];
		}
		
		//construct other entries
		for(int i= 1;i< len ;i++)
		{ for(int j= 1;j< len ;j++)
			{ 
				if(arr[i][j]==1)
				{
					s[i][j]= Math.min(Math.min(s[i][j-1], s[i-1][j]), s[i-1][j-1]) + 1;
				}
				else
				{
					s[i][j]=0;					
				}
			}
		}
		
		//Max entry in s[][]
		int max = s[0][0],max_i=0,max_j=0;
		for(int i= 0;i< len ;i++)
		{ for(int j= 0;j< len ;j++)
			{ 
			   if(max < s[i][j])
			   {
				   max = s[i][j];
				   max_i=i; 
				   max_j=j;
 			   }
			}
		
		}
		// Using value of above co-ordinate print the submatrix
		for(int i= max_i; i > (max_i - max); i--)
		{ for(int j= max_j; j > (max_j - max); j--)
			{ System.out.print( arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		  Integer M[][] ={{0, 1, 1, 0, 1}, 
				      	  {1, 1, 0, 1, 0}, 
		                  {0, 1, 1, 1, 0},
		                  {1, 1, 1, 1, 0},
		                  {1, 1, 1, 1, 1}};
		                
		  printMaxSubSquare(M,5);
	}
}
