package scheduler;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public class ManagerTest {

	/**
	 * Tests that event addition behaves correctly.
	 */
	@Test
	public void testAddEvent() {
		
		Event testEvent = new Event(new Date(), "Test Event");
		Manager testManager = Manager.makeManager("");
		
		// Test that new event is successfully added
		assertTrue(testManager.addEvent(testEvent));
		
		// Test that duplicate event is NOT successfully added
		assertFalse(testManager.addEvent(testEvent));
	}
	
	/**
	 * Tests that checking if a file exists is done correctly.
	 */
	@Test
	public void testDoesFileExist() {
		String realFileName = "SampleClass-test.txt";
		String fakeFileName = "Not-A-File.txt";
		assertTrue(Manager.doesFileExist(realFileName));
		assertFalse(Manager.doesFileExist(fakeFileName));
	}
	
	/**
	 * Tests behavior involving the attempted delete of an event.
	 */
	@Test
	public void testDeleteEvent() {
		
		// Test an event can be correctly deleted
		Manager m = Manager.makeManager("");
		m.addEvent(new Event(null, "Party"));
		assertTrue(m.deleteEvent("Party"));
		assertEquals(m.getEvents().size(), 0);
		
		// Test that the attempted delete of an event not in the manager is unsuccessful
		m = Manager.makeManager("");
		m.addEvent(new Event(null, "Party"));
		assertFalse(m.deleteEvent("Event name not in manager"));
		assertEquals(m.getEvents().size(), 1);
	}
	
//	@Test
//	public void testManagerFileWriting() throws IOException {
//		String realFileName = "new.txt";
//		Manager testManager = Manager.makeManager(realFileName);
//		
//		Event testEvent = new Event(Event.parseDateString("01/02/2017"), "Myvent");
//		User testUser = new User("Larry");
//		Time t1 = Time.makeTime(0, true);
//		
//		testUser.addTime(t1);
//		testEvent.addUser(testUser);
//		System.out.println(testManager.addEvent(testEvent));
//		
//		testManager.write();
//		
//		Manager newManager = Manager.makeManager(realFileName);
//		assertEquals(newManager.getEvents().get(0).getUsers().get(0).getSlotTimeStrings(true).get(0), "00:00");
//	}

}
