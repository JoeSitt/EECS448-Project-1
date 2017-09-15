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
public class Manager {
	
	private ArrayList<Event> events = new ArrayList<Event>();
	private String dateFormat = "MM/dd/yyyy";
	
	public ArrayList<Event> getEvents() {
		return events;
	}
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	public static void main(String[] args) {
//		Manager mrM = new Manager();
//		
//		Date date = mrM.parseDate("01/091/2017");
//		
//		Event event = new Event(date, "party");
//		
//		System.out.println(event.getDate());
//		
//		mrM.addEvent(event);
	}

}
