/*The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all 
 * elements of the subsequence are sorted in increasing order. 
 * 
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */

package DynamicProgrammingPractise;

public class LongestIncreasingSubsequence {
	
	public int longestSubsequenceWithActualSolution(int arr[]){
        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        // fill the temporary array with 1 as each place in array will be minimum 1 LIS
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(T[j] + 1 > T[i]){
                        T[i] = T[j] + 1;
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }
            }
        }
        
        //find the index of max number in T 
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }
        
        //lets print the actual solution (Tough)
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();
 
        return T[maxIndex];
    }
	

	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int result = lis.longestSubsequenceWithActualSolution(arr);
        System.out.println("Max lenghth is : "+ result);
	}

}
