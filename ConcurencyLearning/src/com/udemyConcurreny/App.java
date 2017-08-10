package com.udemyConcurreny;


class runner1 implements Runnable
{
	public void run(){
	for(int i=0;i<10;i++){System.out.println("Runner1");}
		}
}

class runner2 implements Runnable
{
	public void run(){
	for(int i=0;i<10;i++){System.out.println("Runner2");}
	}
}



public class App {	
	public static void main(String[] args) {

		Thread t1  = new Thread(new runner1());
		Thread t2  = new Thread(new runner2());
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Finished");
	}

}
