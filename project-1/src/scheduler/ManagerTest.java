package scheduler;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class ManagerTest {

	/**
	 * Tests that event addition behaves correctly.
	 */
	@Test
	public void testAddEvent() {
		
		Event testEvent = Event.makeEvent(new Date(), "Test Event");
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
		m.addEvent(Event.makeEvent(new Date(), "Party"));
		assertTrue(m.deleteEvent("Party"));
		assertEquals(m.getEvents().size(), 0);
		
		// Test that the attempted delete of an event not in the manager is unsuccessful
		m = Manager.makeManager("");
		m.addEvent(Event.makeEvent(new Date(), "Party"));
		assertFalse(m.deleteEvent("Event name not in manager"));
		assertEquals(m.getEvents().size(), 1);
	}
	
	/**
	 * Test that manager can be read and written to file correctly.
	 */
	@Test
	public void testManagerFileIO() {
		String realFileName = "testing-Manager-file.txt";
		
		Manager testManager = Manager.makeManager(realFileName);
		
		Event testEvent = Event.makeEvent(Event.parseDateString("01/02/2017"), "");
		User testUser = new User("");
		Time t1 = Time.makeTime(0, true);
		testUser.addTime(t1);
		testEvent.addUser(testUser);
		testManager.addEvent(testEvent);
		
		// Test that file write was successful and that file now exists
		assertTrue(testManager.write());
		assertTrue(Manager.doesFileExist(realFileName));
		
		// Tests Manager instance can be recovered after being saved.
		Manager readManager = Manager.read(realFileName);
		assertNotNull(readManager);
		assertEquals(readManager.getEvents().get(0).getDateString(), "01/02/2017");
		
		Manager.deleteFile(realFileName);
	}
}
