package EscapingReferncesConceptSolotionByIterable;

public class Customer {
	
	private String name;

	public Customer(String name) {
		this.name = name;
	}
	
	//copy constructor
	public Customer(Customer oldCustomername) {
		this.name = oldCustomername.name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	
		public String toString() {
		return name;
	}
	
}
