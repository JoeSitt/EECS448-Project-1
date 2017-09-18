package scheduler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Representation of a User. 
 * 
 * Includes their name and which half-hour time slots in the day are to be associated with them.
 */
public class User implements Comparable<User>, Serializable {
	public int timeview=0;
	private String name;
	private TreeSet<Time> timeSlots;
	
	// Required for serialization
	private static final long serialVersionUID = 1L;
	
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
	/*
	 * input string for a name
	 * output: none
	 * modifies name of user;
	 * is used to change name of user
	 */
	public void setname(String Name) {
		name=Name;
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
	
	/**
	 * @param otherUser The user to be compared to
	 * @returns Lexicographic comparison of users' names
	 */
	public int compareTo(User otherUser) {
		return this.name.compareTo(otherUser.name);
	}
}
