package LearnGuiceCalculatorModify2;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class CalculatorModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(ICalculator.class).annotatedWith(Names.named("Real")).to(Calculator.class);
		//bind(ICalculator.class).to(Calculator.class).in(Singleton.class);
		// bind(ICalculator.class).to(Calculator.class).in(Scopes.SINGLETON);
		//By default singleton
		//bind(ICalculator.class).toInstance(new Calculator());

		bind(ICalculator.class).annotatedWith(Names.named("Fake")).to(FakeCalculator.class);
		
	}

}
