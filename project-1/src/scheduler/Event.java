package scheduler;

import java.util.Calendar;
import java.util.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Encapsulates an Event.
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
	public String time;
	public String date;
	public String name;
	
	public Event(String time, String date, String name) {
		this.time = time;
		this.date = date;
		this.name = name;
	}
	
	public String getEventSummary() {
		return "Time: " + time + "\n" + "Date: " + date + "\n" + "Name: " + name + "\n"; 
	}
	
	public static void main(String[] args) throws ParseException {
		DateFormat timeFormatter = new SimpleDateFormat("h:mm a");
		DateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		
		Date myDate = dateFormatter.parse("01/03/1996");
		Date myTime = timeFormatter.parse("8:30 PM");
		
		System.out.println(myDate.toString());
		System.out.println(myTime.toString());
	}
}
