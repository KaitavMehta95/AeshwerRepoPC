package observer.Pattern;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Subject extends Observable{

	  private List<Observer> observers = new ArrayList<Observer>();
	  private int state;

	   public int getState() {
	      return state;
	   }

	   public void setState(int state) {
	      this.state = state;
	      stateChanged();
	   }
	   
	   public void stateChanged()
	   {	setChanged();
	        notifyObservers();
		   
	   }
 
}
