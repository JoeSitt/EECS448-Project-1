package scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Representation of a User. 
 * 
 * Includes their name and which half-hour time slots in the day are to be associated with them.
 */
public class User {
	
	private String name;
	private TreeSet<Time> timeSlots;
	
	/**
	 * User name specified and empty set of timeSlots created.
	 * 
	 * @param name Name of the user.
	 */
	public User(String name) {
		this.name = name;
		timeSlots = new TreeSet<Time>();
	}
	
	/**
	 * @return Name of user
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Add time to timeSlots. Time will not be added if it is already represented in the timeSlot.
	 * 
	 * @param nt New Time to be added.
	 * @return Whether or not time was successfully added.
	 */
	public boolean addTime(Time nt) {
		
		if (nt == null) {
			return false;
		}
		
		if (timeSlots.contains(nt)) {
			return false;
		}
		
		timeSlots.add(nt);
		return true;
	}
	
	/**
	 * Produce collection of times in timeSlot, each represented as a String.
	 * @param useMil Whether to represent time as military time (as opposed to civilian)
	 * @return List of time string representations.
	 */
	public List<String> getSlotTimeStrings(boolean useMil) {
		List<String> timeStrings = new ArrayList<String>();
		for (Time t : timeSlots) {
			timeStrings.add(t.getTimeString(useMil));
		}
		return timeStrings;
	}
}
