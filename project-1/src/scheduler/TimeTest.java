package scheduler;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	@Test
	public void testIsTimeStringValid() {
		
		// Military time inputs
		assertTrue(Time.isTimeStringValid("1:30", true));
		assertFalse(Time.isTimeStringValid("111:30", true));
		
		// Civilian time inputs
		assertTrue(Time.isTimeStringValid("1:30PM", false));
		assertFalse(Time.isTimeStringValid("1:30PAM", false));
	}

	@Test
	public void testAddTimeString() {
//		fail("Not yet implemented");
	}

	@Test
	public void testGetTimeStrings() {
//		fail("Not yet implemented");
	}

	@Test
	public void testTimeToString() {
//		fail("Not yet implemented");
	}

}
