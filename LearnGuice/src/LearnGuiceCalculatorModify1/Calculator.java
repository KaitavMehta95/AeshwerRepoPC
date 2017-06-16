package LearnGuiceCalculatorModify1;

import com.google.inject.Singleton;

//@Singleton
public class Calculator implements ICalculator{
	
	@Override
	public int add(int a ,int b)
	{
		return (a+b);
	}

	@Override
	public int sub(int a ,int b)
	{
		return (a-b);
	}

	@Override
	public int mul(int a ,int b)
	{
		return (a*b);
	}

}
