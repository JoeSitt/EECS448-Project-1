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
	public String getDateString(String dateFormat) {
		return formatDate(this.date, dateFormat);
	}
	
	/*
	 * Returns whether or not dateFormat is a use-able representation of a date
	 * 
	 * WARNING: Set of allowed dates is extensive.
	 * Consult http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
	 */
	public static boolean isDateFormatValid(String dateFormat) {
		try {
			new SimpleDateFormat(dateFormat);
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * Returns date string representation according to format.
	 * If invalid format passed, string indicating this is returned.
	 * If null date passed, string indicating this is returned.
	 */
	public static String formatDate(Date date, String dateFormat) {
		
		if (date == null) {
			return "ERROR: null date passed";
		}
		
		if (!isDateFormatValid(dateFormat)) {
			return "ERROR: invalid date format";
		}
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(date);
	}
	
	/*
	 * Returns whether or not the date string passed is valid.
	 * A date string is considered valid if it follows the passed format and exists.
	 * Date format string is assumed to be valid (have already passed an
	 * isDateFormatValid(...) check).
	 * 
	 * NOTE: Because of the specificity of the method, a check is not performed on the
	 * dateFormat string. If this had been done, and false had been returned, it would 
	 * give a misleading result.
	 */
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
	public static Date parseDate(String dateString, String dateFormat) {
		
		if (!isDateFormatValid(dateFormat)) {
			return null;
		}
		
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
	
	public static void main(String[] args) {
		
		// Generate date for testing
		Date date = new Date();
		
		System.out.println(date);
		System.out.println();
		
		String goodFormat1 = "MM/dd/yyyy";
		String goodFormat2 = "MM-dd-yyyy";
		
		String badFormat1 = "b";
		String badFormat2 = "nb//a/a/b";
		
		// Check formats
		System.out.println(Event.isDateFormatValid(goodFormat1));
		System.out.println(Event.isDateFormatValid(goodFormat2));
		System.out.println(Event.isDateFormatValid(badFormat1));
		System.out.println(Event.isDateFormatValid(badFormat2));
		System.out.println();
		
		// Represent date using good formats
		System.out.println("Good date formattings:");
		System.out.println(Event.formatDate(date, goodFormat1));
		System.out.println(Event.formatDate(date, goodFormat2));
		System.out.println();
		
		// Attempt to represent dates using bad formats
		System.out.println("Invalid date formattings:");
		System.out.println(Event.formatDate(date, badFormat1));
		System.out.println(Event.formatDate(date, badFormat2));
		System.out.println();
		
		// Perform date parsing
		String dateString1 = "09/15/2017";
		Date parsedDate1 = Event.parseDate(dateString1, goodFormat1);
		System.out.println(Event.formatDate(parsedDate1, goodFormat1));
		System.out.println(Event.formatDate(date, goodFormat1));
		System.out.println();
		
		String dateString2 = "09-15-2017";
		Date parsedDate2 = Event.parseDate(dateString2, goodFormat2);
		System.out.println(Event.formatDate(parsedDate2, goodFormat2));
		System.out.println(Event.formatDate(date, goodFormat2));
		System.out.println();
		
		String dateString3 = "asd";
		Date parsedDate3 = Event.parseDate(dateString3, goodFormat1);
		System.out.println(Event.formatDate(parsedDate3, goodFormat1));
		System.out.println(Event.formatDate(date, goodFormat1));
		System.out.println();
		
		String dateString4 = "";
		Date parsedDate4 = Event.parseDate(dateString4, goodFormat2);
		System.out.println(Event.formatDate(parsedDate4, goodFormat2));
		System.out.println(Event.formatDate(date, goodFormat2));
		System.out.println();
	}
}
