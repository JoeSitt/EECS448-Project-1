package scheduler;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Time implements Comparable<Time> {
	
	public LocalTime time;
	public List<String> attendeeList;
	
	public Time(String timeString) {
		time = parseTime(timeString);
		attendeeList = new ArrayList<String>();
	}
	
	public static LocalTime parseTime(String timeString) {
		
		LocalTime time;
		
		// verify that time string is correctly formatted
		try {
			time = LocalTime.parse(timeString);
		} catch (Exception e) {
			return null;
		}
		
		// verify that time is at a 30 min-mark
		if (time.getMinute() != 0 && time.getMinute() != 30) {
			return null;
		}
		
		return time;
	}
	
	/*
	 * 
	 * https://stackoverflow.com/questions/14133600/java-cannot-cast-to-comparable-when-using-treemap
	 * 
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Time o) {
		return this.time.compareTo(o.time);
	}
}
