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
 */
public class Manager implements Serializable {
	
	private TreeSet<Event> events;
	private String fileName;
	
	// Required for serialization
	private static final long serialVersionUID = 1L;
	
	public static boolean deleteFile(String fileName) {
		return new File(fileName).delete();
	}
	
	/**
	 * Retrieve stored events.
	 * 
	 * @return List of events.
	 */
	public List<Event> getEvents() {
		return new ArrayList<Event>(events);
	}
	
	/**
	 * Remove event by name.
	 * 
	 * @param eventName The name of the event to be removed.
	 * @return True only if Event was successfully deleted.
	 */
	public boolean deleteEvent(String eventName) {
		Event key = Event.makeEvent(new Date(), eventName);
		if (!events.contains(key)) {
			return false;
		}
		events.remove(key);
		return true;
	}
	
	/**
	 * Sets up Manager. If no manager has been written to the location 
	 * passed, a brand new manager is created. Else Manager is read from file contents.
	 * 
	 * @param fileName Desired location to have Manager's characteristics stored.
	 * @return Constructed Manager
	 */
	public static Manager makeManager(String fileName) {
		
		if (doesFileExist(fileName)) {
			try {
				return read(fileName);
			} catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("ERROR: could not read manager file");
				return null;
			}
		}
		
		return new Manager(fileName);
	}
	
	/**
	 * Private constructor creates a new Manager from scratch
	 * 
	 * @param fileName Location to store instance characteristics.
	 */
	private Manager(String fileName) {
		this.fileName = fileName;
		this.events = new TreeSet<Event>();
	};
	
	/**
	 * Determines whether or not a file exists.
	 * 
	 * @param fileName
	 * @return Whether or not a file exists.
	 */
	public static boolean doesFileExist(String fileName) {
		File f = new File(fileName);
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
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
	

	/**
	 * Write class instance contents to file.
	 * 
	 * @return True only if file was written correctly
	 */
	public boolean write() {
		try {
			FileOutputStream f = new FileOutputStream(new File(fileName));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(this);
			
			// close file writing objects
			o.close();
			f.close();
		} catch(IOException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Factory Constructor reads Manager from file.
	 * 
	 * @param fileName File in which Manager is to be read from.
	 * @return Constructed Manager only if file was read correctly. Else null.
	 */
	public static Manager read(String fileName) {
		Manager pr1;
		
		try {
			FileInputStream fi = new FileInputStream(new File(fileName));
			ObjectInputStream oi = new ObjectInputStream(fi);

			pr1 = (Manager) oi.readObject();

			// close file reading objects
			oi.close();
			fi.close();
		} catch(Exception e) {
			return null;
		}
		
		return pr1;
	}
}
