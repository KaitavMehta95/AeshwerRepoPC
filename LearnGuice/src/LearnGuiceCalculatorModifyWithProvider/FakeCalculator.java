package LearnGuiceCalculatorModifyWithProvider;

public class FakeCalculator implements ICalculator {

	@Override
	public int add(int a, int b) {
		return 0;
	}

	@Override
	public int sub(int a, int b) {
		return 0;
	}

	@Override
	public int mul(int a, int b) {
		return 0;
	}

}
