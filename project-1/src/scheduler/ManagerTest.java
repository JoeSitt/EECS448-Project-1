package scheduler;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class ManagerTest {

//	@Test
//	public void testGetEvents() {
//		fail("Not yet implemented");
//	}

	/**
	 * Tests that event addition behaves correctly.
	 */
	@Test
	public void testAddEvent() {
		
		Event testEvent = new Event(new Date(), "Test Event");
		Manager testManager = new Manager();
		
		// Test that new event is successfully added
		assertTrue(testManager.addEvent(testEvent));
		
		// Test that duplicate event is NOT successfully added
		assertFalse(testManager.addEvent(testEvent));
	}

}