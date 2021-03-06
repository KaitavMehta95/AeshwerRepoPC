package BasicConcept;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestEmployee {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Aeshwer", "Noida", 25);
		Employee employee2 = new Employee("Madhulika", "Banglore", 29);
		Employee employee3 = new Employee("Anamika", "Singapore", 31);
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		
		System.out.println("sorting by name...");  
		Collections.sort(list, new NameComparator());
		for(Employee st: list){  
			System.out.println(st.location+" "+st.name+" "+st.age);  
			} 
		
		System.out.println(); 
		System.out.println("sorting by location...");
		Collections.sort(list, new LocationComparator());
		for(Employee st: list){  
			System.out.println(st.location+" "+st.name+" "+st.age);  
			} 
		System.out.println();
		System.out.println("sorting by age...");  
		Collections.sort(list, new AgeComparator());
		for(Employee st: list){  
			System.out.println(st.location+" "+st.name+" "+st.age);  
			} 
		
		System.out.println();
		System.out.println("sorting by age...Using Comparable");  
		Collections.sort(list);
		for(Employee st: list){  
			System.out.println(st.location+" "+st.name+" "+st.age);  
			} 
		
		
	}
}
