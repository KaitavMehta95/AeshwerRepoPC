package EscapingReferncesConceptSolotionByIterable;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));
				
		for (Customer next : records)   // iterate only on arrays or instance of a n iterator
				{
					System.out.println(next);
				}

		// oops there is one more issue... the iterator has a remove method and we can still empty/ modify the list

		Customer john = records.getCustomerByName("John");
		System.out.println(john.getName());
		john.setName("Derik");
		System.out.println(john.getName()); // client changes here but it is done on a copy ... ?? confusion is created for him...sol is Interface
		
		// original list remains the same
		for (Customer next : records)   // iterate only on arrays or instance of a n iterator
		{
			System.out.println(next);
		}
		
	}
}
