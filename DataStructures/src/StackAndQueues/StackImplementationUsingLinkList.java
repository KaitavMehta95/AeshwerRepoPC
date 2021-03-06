package StackAndQueues;

import LinkListProblems.LinkListInsertionsAndDeletions.Node;

public class StackImplementationUsingLinkList {

	private Node top;
	private int size=0;
	class Node{
		
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
  			this.next = null;
		}
	}
	
	boolean isEmpty()
	{
		if(top == null){
		//System.out.println("EMPTY STACK");
		return true ;
		}
		return false;
	}
	
	void push(int x)
	{
		Node new_Node = new Node(x);
		new_Node.next =top;
		top = new_Node;
		size++;
		
	}
	
	int pop()
    {
		if(isEmpty())
		{
			System.out.println("Stack Underflow");
			return 0;	
		}
		else
		{
			int x = top.data;
			top = top.next;
			size--;
			return x;
		}
    }
	
	void peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack Empty");
			return;	
		}
		else
		{
			int x = top .data;
			System.out.println("The top of stack as ::" + x);
		}
		
	}
	
	void print()
	{
		Node tnode = top;
		while(tnode != null)
		{
			System.out.print( tnode.data +" ");
			tnode= tnode.next;
		}
		System.out.println();
	}
	
	
	static void reverse()
	{
		
	}
	
	public static void main(String[] args) {
		
		StackImplementationUsingLinkList s = new StackImplementationUsingLinkList();
		
		s.isEmpty();
		s.push(10);
        s.push(20);
        s.peek();
        s.push(30);
        s.push(40);
        s.print();
        System.out.println(s.pop() + " Popped from stack");
        s.push(50);
        s.print();
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.pop() + " Popped from stack");
        s.isEmpty();

	}

}
