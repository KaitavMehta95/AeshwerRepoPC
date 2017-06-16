package LearnGuiceCalculatorModifyWithProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CalculatorClient {

	public static void main(String[] args) {
		// Here a Calci selector is used for selecting the  implementation of the ICalculator Interface
		Injector injector = Guice.createInjector(new CalculatorModule());
		CalculatorService calculatorService  = injector.getInstance(CalculatorService.class); 
		System.out.println("ADD " + calculatorService.calculate(100, 200,"add"));
		System.out.println("SUB " + calculatorService.calculate(700, 200,"sub"));
		System.out.println("MUL " + calculatorService.calculate(10, 20,"mul"));
	}
}
