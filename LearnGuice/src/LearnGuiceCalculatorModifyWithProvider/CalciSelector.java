package LearnGuiceCalculatorModifyWithProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class CalciSelector implements Provider<ICalculator>{

	@Inject FakeCalculator fake;
	@Inject Calculator real;
	@Override
	public ICalculator get() {
		return fake;
	}

}
