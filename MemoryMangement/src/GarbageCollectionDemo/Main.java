package GarbageCollectionDemo;

public class Main {
	
	public static void main(String[] args) 
	{
		Runtime runtime = Runtime.getRuntime();

		long availableBytes = runtime.freeMemory();
		System.out.println("Available memory: " + availableBytes / 1024 + "k");

		// let's create a ton of garbage....
		Customer c;
		for (int i=0; i<100; i++)
		{
			c = new Customer("John");	
		}
		
		availableBytes = runtime.freeMemory();
		System.out.println("Available memory: " + availableBytes / 1024 + "k");
		
		System.gc(); // this is just a suggestion ...don't actually enforce garbage collection
		
		availableBytes = runtime.freeMemory();
		System.out.println("Available memory: " + availableBytes / 1024 + "k");
	}

	
}
