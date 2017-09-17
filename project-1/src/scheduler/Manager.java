package scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * Used to store a set of events. Instances can be read and written to file.
 * 
 * References:
 * https://stackoverflow.com/questions/447898/what-is-object-serialization
 */
public class Manager implements Serializable {
	
	private TreeSet<Event> events;
	
	// Required for serialization
	private static final long serialVersionUID = 1L;
	
	/**
	 * @return List of events.
	 */
	public List<Event> getEvents() {
		return new ArrayList<Event>(events);
	}
	
	public Manager() {
		events = new TreeSet<Event>();
	}
	
	/**
	 * Add event to event set. Event must have unique name.
	 * 
	 * @param event New event to be added.
	 * @return True only if the event was successfully added.
	 */
	public boolean addEvent(Event event) {
		if (events.contains(event)) {
			return false;
		}
		events.add(event);
		return true;
	}
	
//	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		Manager mrM = new Manager();
//		Event event = new Event(new Date(), "Johhny");
//		User user = new User("John");
//		Time time = Time.makeTime(9, true);
//		user.addTime(time);
//		event.addUser(user);
//		mrM.addEvent(event);
//		
//		mrM.write("SampleClass-test.txt");
//		
//		Manager newOne = Manager.read("SampleClass-test.txt");
//		
//		System.out.println(newOne.getEvents().get(0).getName());
//	}
//	
//	/*
//	 * Writes instance to supplied file
//	 */
//	public void write(String fileName) throws IOException {
//		FileOutputStream f = new FileOutputStream(new File(fileName));
//		ObjectOutputStream o = new ObjectOutputStream(f);
//		
//		o.writeObject(this);
//		
//		// close file writing objects
//		o.close();
//		f.close();
//	}
//	
//	/*
//	 * Reads and constructs instance from file
//	 */
//	public static Manager read(String fileName) throws IOException, ClassNotFoundException {
//		FileInputStream fi = new FileInputStream(new File(fileName));
//		ObjectInputStream oi = new ObjectInputStream(fi);
//
//		Manager pr1 = (Manager) oi.readObject();
//
//		// close file reading objects
//		oi.close();
//		fi.close();
//		
//		return pr1;
//	}
}
