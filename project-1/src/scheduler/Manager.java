package scheduler;

import java.util.List;
import java.util.TreeSet;

/**
 * Keeps track of Events, allowing them to be added and summarized upon request.
 * 
 * @author cmaxcy
 *
 */

// TODO(cmaxcy):
// - Implement
// - Document
// - Test

public class Manager {
	
	public List<Event> eventList;
	
	public Manager() {
		
	}
	
	public boolean addEvent(Event e) {
		return false;  // TEMP
	}
	
	public static void main(String[] args) {
		TreeSet<Event> mySet = new TreeSet<Event>();
		Event myEvent = new Event("", "", "");
		mySet.add(myEvent);
		
		System.out.println(mySet.isEmpty());
	}

}
