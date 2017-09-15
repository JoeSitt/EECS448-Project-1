package scheduler;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Time implements Comparable<Time> {
	
	public LocalTime time;
	public List<String> attendees;
	
	public static boolean isTimeStringValid(String timeString) {
		
		try {
			LocalTime.parse(timeString);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public Time(String timeString) {
		time = parseTime(timeString);
		attendees = new ArrayList<String>();
	}
	
	public List<String> getAttendees() {
		return this.attendees;
	}
	
	public void addAttendee(String attendee) {
		attendees.add(attendee);
	}
	
//	public Time(int hour, int minute) {
//		this.hour = hour;
//		this.minute = minute;
//	}
//	
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
	
	public String getTimeOnly(boolean isMil) {
		String outStr = "";
		int hour = time.getHour();
		int minute = time.getMinute();
		
		if (!isMil) {
			outStr += hour % 12;
		} else {
			outStr += hour;
		}
		
		outStr += ":";
		if (minute < 10) {
			outStr += "0";
		}
		
		outStr += minute;
		
		if (!isMil) {
			
			if (hour >= 12) {
				outStr += "PM";
			} else {
				outStr += "AM";
			}
			
		}
		
		
		return outStr;
	}
	
	public String getSummary(boolean isMil) {
		String outStr = this.getTimeOnly(isMil);
		
		outStr += " ";
		
		for (String attendee : attendees) {
			outStr += attendee;
			outStr += " ";
		}
		
		return outStr;
	}

	public int compareTo(Time o) {
		if (o.time == null || this.time == null) {
			return -1;
		}
		
		return this.time.compareTo(o.time);
	}
}
