package scheduler;

import java.util.Calendar;
import java.util.Date;
import java.util.TreeSet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Encapsulates an Event. Contains the name, date, and set of times in which the event will take place.
 * 
 * @author cmaxcy
 *
 */

// TODO(cmaxcy):
// - Consider using Data and Time classes
// - Document
// - Test

public class Event {
	
	// TODO(cmaxcy): make these private
	public Date date;
	public String name;
	
	public Event(Date date, String name) {
		this.date = date;
		this.name = name;
	}
	
	public TreeSet<Time> times;
}