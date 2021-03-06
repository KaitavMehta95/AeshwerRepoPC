/*  Bottom Up::
 *  The tabulated program for a given problem builds a table in bottom up fashion and returns the last entry from table. 
 *  For example, for the same Fibonacci number, we first calculate fib(0) then fib(1) then fib(2) then fib(3) and so on.
 *   So literally, we are building the solutions of subproblems bottom-up.
 *   
 *   NOTE::::: Both Tabulated and Memoized store the solutions of subproblems. In Memoized version, table is filled on demand while in Tabulated version, 
 *   starting from the first entry, all entries are filled one by one.
 *   Unlike the Tabulated version, all entries of the lookup table are not necessarily filled in Memoized version. 
 */
package DynamicProgrammingPractise;
 
public class FabonacciTabulationMethod {
	
	 public static int fib(int n)
	  {
	    int f[] = new int[n+1];
	    f[0] = 0;
	    f[1] = 1;
	    for (int i = 2; i <= n; i++)
	          f[i] = f[i-1] + f[i-2];
	    return f[n];
	  }
	 
	public static void main(String[] args){
    int n = 9;
    System.out.println(n + "th "+ "Fibonacci number is" + " " + fib(n));
	}
}