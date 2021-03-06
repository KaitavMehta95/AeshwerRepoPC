package LearnGuiceCalculator;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CalculatorClient {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new CalculatorModule());
		Calculator calculator = injector.getInstance(Calculator.class);
		System.out.println("ADD " + calculator.add(100, 200));
		System.out.println("SUB " + calculator.sub(700, 200));
		System.out.println("MUL " + calculator.mul(10, 20));
	}
}
