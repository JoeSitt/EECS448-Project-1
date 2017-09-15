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
// - Perform a check upon initialization if file containing data has been written. If
//   so, load info from there. Else star fresh
public class Manager {
	
	private ArrayList<Event> events = new ArrayList<Event>();
	
	public ArrayList<Event> getEvents() {
		return events;
	}
	
	public void addEvent(Event event) {
		events.add(event);
	}
}
