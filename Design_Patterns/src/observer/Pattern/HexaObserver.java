package observer.Pattern;

import java.util.Observable;
import java.util.Observer;


public class HexaObserver implements Observer ,Displays {
	
	Observable observble;
	private int state;
	
	
	HexaObserver(Observable observable)
	{
		this.observble= observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Subject) {
			Subject newSubject = (Subject)o;
			this.state = newSubject.getState();
			display();
		}
		
	}

	@Override
	public void display() {
		System.out.println("Changes state for Hexa is "+ state );		
	}

}
