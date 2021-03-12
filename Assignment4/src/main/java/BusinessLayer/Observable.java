package BusinessLayer;

import java.util.ArrayList;

public interface Observable<T>{
	
	public void notifyObservers();
	public void removeObserver(T o);
	public void registerObserver(T o);
	
}
