package hashingTutorials;

/*Given an array of integers and a number k, write a function that returns true 
 * if given array can be divided into pairs such that sum of every pair is divisible by k.
 * Complexcity O(n)
 * Input: arr[] = {9, 7, 5, 3}, k = 6 Output: True (We can divide array into (9, 3) and (7, 5).)
 * Sum of both of these pairs is a multiple of 6.
 * Input: arr[] = {91, 74, 66, 48}, k = 10 Output: False
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComplexArrayProblem {
	
	boolean findPairs(Integer[] arr,int n, int k)
	{
		int sum = 0;
		
		if(n % 2 != 0 || n == 1 )
		{
			return false;
		}
		 
		for(int i = 0 ; i < n ; i++)
		{  sum = sum +arr[i] ;
		}
		
		int temp = ( (n/2)* k ); //logic part
		boolean value = (n%2 == 0) && (sum %temp) == 0  ? true : false;	
		return  value;	
	}
	
		public static void main(String[] args) throws IOException{
			
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a Array length");
			int n  = Integer.parseInt(read.readLine());
			int length  = n, i = 0;
			System.out.println("Enter Array now");
			Integer arr[] = new Integer[n];
			
			while (n-- > 0)
			{  
				arr[i] = Integer.parseInt(read.readLine());		
				i++;
			}
			System.out.println("Enter Divisor number");
			int divisor  = Integer.parseInt(read.readLine());
			
			System.out.println("You entered this Array");
			for(i = 0 ;i < length; i++ )
			{
				System.out.println(arr[i] + " ");
			}
			ComplexArrayProblem complexArrayProblem = new ComplexArrayProblem();
			if(complexArrayProblem.findPairs(arr,length,divisor) == true)
			{
				System.out.println("TRUE");
			}
			else{System.out.println("False");}
		}
}
