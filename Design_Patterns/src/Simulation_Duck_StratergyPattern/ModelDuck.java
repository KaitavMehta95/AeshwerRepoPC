package Simulation_Duck_StratergyPattern;

public class ModelDuck extends Duck {
	
	ModelDuck()
	{
		flyBehaviour = new NoFly() ;
		quackBehaviour = new Quack();	
	}
	
	@Override
	void display() {
		System.out.println("I AM A MODEL DUCKKY");

	}
	

}
