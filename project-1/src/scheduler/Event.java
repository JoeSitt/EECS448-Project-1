package scheduler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class Event {
	
	private Date date;
	private String name;
	private List<Attendee> attendees;
	
	public Event(Date date, String name) {
		this.date = date;
		this.name = name;
		this.attendees = new ArrayList<Attendee>();
	}
	
	/*
	 * Returns the stored date, formatted as requested.
	 */
	// TODO(cmaxcy):
	// - Test
	// - Consider checking if date format passed is valid
	public String getDateString(String dateFormat) {
		return formatDate(this.date, dateFormat);
	}
	
	/*
	 * Returns date string representation according to format.
	 */
	public static String formatDate(Date date, String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(date);
	}
	
	/*
	 * Returns whether or not the date string passed is valid.
	 * A date string is considered valid if it follows the passed format and exists.
	 */
	// TODO(cmaxcy): test
	public static boolean isDateStringValid(String dateString, String dateFormat) {
		
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		format.setLenient(false);
		
		// Attempt parsing of dateString
		try {
			format.parse(dateString);
		} catch(Exception e) {
			return false;
		}
		
		// date string must be valid
		return true;
	}
	
	/*
	 * Parse date from string. String is expected to follow passed date format.
	 * Method will return null if format is not followed.
	 */
	// TODO(cmaxcy): test
	public static Date parseDate(String dateString, String dateFormat) {
		
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		format.setLenient(false);
		Date date;
		
		// Attempt parsing of dateString
		try {
			date = format.parse(dateString);
		} catch(Exception e) {
			return null;
		}
		
		// date string must be valid
		return date;
	}
	
	public ArrayList<Attendee> getAttendees() {
		return new ArrayList<Attendee>(attendees);
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getName() {
		return this.name;
	}	
}
