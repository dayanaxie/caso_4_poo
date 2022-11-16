package patronObserver;

import java.util.ArrayList;

public interface Observable {
	public void addObserver(Observer pObservable);
	
	public void removeObserver(Observer pObservable);
	
	public void notifyObservers(int pValue);

}
