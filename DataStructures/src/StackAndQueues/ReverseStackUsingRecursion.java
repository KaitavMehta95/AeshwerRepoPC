package StackAndQueues;
/*
 * Cant UNderstand
 */
import java.util.Stack;

public class ReverseStackUsingRecursion {
    public static void ReverseStackUsingRecursion(Stack<Integer> s)
    {
        if(s.size() == 0) return;
        int n = getLast(s);
        ReverseStackUsingRecursion(s);
        s.push(n);
    }
    public static int getLast(Stack<Integer> s)
    {
        int a = s.pop();
        if(s.size() == 0)
        {
            return a;
        }
        else
        {
            int k = getLast(s);
            s.push(a);
            return k;
        }
    }
	  public static void main(String[] args)
	    {
	        Stack <Integer> stack = new Stack <Integer> ();
	        stack.push(1);
	        stack.push(2);
	        stack.push(3);
	        stack.push(4);
	        ReverseStackUsingRecursion(stack);
	        while(stack.size() > 0)
	        {
	            System.out.println(stack.pop());
	        }
	    }
}
