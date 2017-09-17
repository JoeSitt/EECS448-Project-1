package scheduler;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	/**
	 * Verify that time string is correctly formed.
	 */
	@Test
	public void testGetTimeString() {
		Time t = Time.makeTime(0, true);
		assertEquals(t.getTimeString(true), "00:00");
		assertEquals(t.getTimeString(false), "12:00AM");
	}

	/**
	 * Verify that time can be made from valid inputs, and
	 * not made from invalid ones.
	 */
	@Test
	public void testMakeTime() {
		
		// Verify that proper time
		assertNotNull(Time.makeTime(12, true));
		
		// Verify improper times
		assertNull(Time.makeTime(-1, true));
		assertNull(Time.makeTime(24, true));
		assertNull(Time.makeTime(-1, false));
		assertNull(Time.makeTime(24, false));
	}

	/**
	 * Verify that military time and civilian times can be correctly verified,
	 * and invalid inputs to both can be detected.
	 */
	@Test
	public void testIsTimeStringValid() {
		// Test valid inputs
		assertTrue(Time.isTimeStringValid("00:00", true));
		assertTrue(Time.isTimeStringValid("12:00AM", false));
		
		// Test obviously bad inputs
		assertFalse(Time.isTimeStringValid("asd", true));
		assertFalse(Time.isTimeStringValid("asd", false));
		assertFalse(Time.isTimeStringValid("", true));
		assertFalse(Time.isTimeStringValid("", false));
		
		// Test odd cases
		assertFalse(Time.isTimeStringValid("13:30AM", false));
	}

	/**
	 * Tests that time strings can be read and correctly interpreted.
	 * Relies on testGetTimeString() to be correct.
	 */
	@Test
	public void testParseTime() {
		assertNull(Time.parseTime("asda", true));
		assertNull(Time.parseTime("asda", false));
		
		Time t = Time.parseTime("10:30", true);
		assertNotNull(t);
		assertEquals(t.getTimeString(true), "10:30");
		assertEquals(t.getTimeString(false), "10:30AM");
		
		t = Time.parseTime("10:30AM", false);
		assertNotNull(t);
		assertEquals(t.getTimeString(true), "10:30");
		assertEquals(t.getTimeString(false), "10:30AM");
	}

	/**
	 * Verifies that .compareTo(...) works correctly for time.
	 */
	@Test
	public void testCompareTo() {
		Time lowTime = Time.makeTime(0, true);
		Time highTime = Time.makeTime(23, false);
		
		assertEquals(lowTime.compareTo(highTime), -1);
		assertEquals(highTime.compareTo(lowTime), 1);
		
		Time equalTime1 = Time.makeTime(12, true);
		Time equalTime2 = Time.makeTime(12, true);
		
		assertEquals(equalTime1.compareTo(equalTime1), 0);
		assertEquals(equalTime2.compareTo(equalTime2), 0);
		assertEquals(equalTime1.compareTo(equalTime2), 0);
		assertEquals(equalTime1.compareTo(equalTime2), 0);
	}

}