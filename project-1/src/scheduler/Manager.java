package scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO(cmaxcy):
// - Perform a check upon initialization if file containing data has been written. If
//   so, load info from there. Else start fresh
public class Manager implements Serializable {
	
	private List<Event> events = new ArrayList<Event>();
	
	// Serializable requires this member variable be included
	private static final long serialVersionUID = 1L;
	
	public List<Event> getEvents() {
		return events;
	}
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	public static void main(String[] args) {
		Manager mrM = new Manager();
		Event event = new Event(new Date(), "Johhny");
		
		mrM.addEvent(event);
		
		mrM.write("SampleClass-test.txt");
		
		Manager newOne = Manager.read("SampleClass-test.txt");
		
		System.out.println(newOne.getEvents().get(0).getName());
	}
	
	/*
	 * Writes Class instance to supplied file
	 */
	public void write(String fileName) {
		try {
			FileOutputStream f = new FileOutputStream(new File(fileName));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(this);
			
			// close file writing objects
			o.close();
			f.close();
		} catch (Exception e) {
			System.out.println("ERROR");
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Reads and constructs instance from file
	 */
	public static Manager read(String fileName) {
		
		try {
			FileInputStream fi = new FileInputStream(new File(fileName));
			ObjectInputStream oi = new ObjectInputStream(fi);

			Manager pr1 = (Manager) oi.readObject();

			// close file reading objects
			oi.close();
			fi.close();
			
			return pr1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
