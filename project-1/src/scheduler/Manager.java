package scheduler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	
	private TreeSet<Event> events;
	private String dateFormat = "MM/dd/yyyy";
	
	/*
	 * https://stackoverflow.com/questions/10817037/java-convert-treeset-to-list
	 */
	public List<Event> getEvents() {
		return new ArrayList<Event> (events);
	}
	
	/*
	 * Parse date from string. In the case in which a non-existent or un-parsable date is passed, null is returned.
	 * 
	 * https://stackoverflow.com/questions/226910/how-to-sanity-check-a-date-in-java
	 * 
	 */
	// TODO(cmaxcy): Test
	public Date parseDate(String dateString) {
		DateFormat df = new SimpleDateFormat(dateFormat);
		Date date;
		
		// Ensure date is formatted correctly
		try {
			date = df.parse(dateString);
		} catch(ParseException e) {
			return null;
		}
		
		Calendar dateChecker = Calendar.getInstance();
		dateChecker.setLenient(false);
		dateChecker.setTime(date);
		
		// Ensure date exists
		try {
			dateChecker.getTime();
		} catch(Exception e) {
			return null;
		}
		
		// Checks passed
		return date;
	}
	
	public static void main(String[] args) {
//		TreeSet<Event> mySet = new TreeSet<Event>();
//		Event myEvent = new Event("", "", "");
//		mySet.add(myEvent);
//		
//		System.out.println(mySet.isEmpty());
	}

}