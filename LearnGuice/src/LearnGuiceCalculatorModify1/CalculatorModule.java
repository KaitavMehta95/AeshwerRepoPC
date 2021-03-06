package LearnGuiceCalculatorModify1;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;

public class CalculatorModule extends AbstractModule{

	@Override
	protected void configure() {
		//bind(ICalculator.class).to(Calculator.class);
		//bind(ICalculator.class).to(Calculator.class).in(Singleton.class);
		// bind(ICalculator.class).to(Calculator.class).in(Scopes.SINGLETON);
		//By default singleton
		bind(ICalculator.class).toInstance(new Calculator());
		
	}

}
