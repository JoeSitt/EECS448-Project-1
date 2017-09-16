/**
 * This class implements time for each guests at the event.
 * @author Amrit Thapa
 * @version 1.0
 */
public class Time 
{
	/**
	 * stores if there is 30 minutes or not. true indicates 30 minutes. false indicates 0 minute.
	 */
	public boolean[] timeSlots;
	/**
	 * //stores the military time.
	 */
	public int[] timeSlot; 
	/**
	 * //tracks how many times a user has added times to timeSlots and timeSlot array.
	 */
	public int pickednum = 0; 
	
	/**
	 * This constructs a Time with a specified militaryHours, and halfHour.
	 * @param militaryHours Represents military time. 0-23
	 * @param halfHour Represents 30 minutes.
	 */
	private Time(int militaryHours, boolean halfHour)
	{
		timeSlots = new boolean[24];
		timeSlot = new int[24];
		timeSlot[pickednum] = militaryHours;
		timeSlots[pickednum] = halfHour;
		pickednum++;
	}
	
	/**
	 * This function is used to access the constructor.
	 * @param militaryHours Represents military time. 0-23
	 * @param halfHour Represents 30 minutes.
	 * @return returns the Time class. returns null if the militaryHour is invalid.
	 */
	public static Time getTime(int militaryHours, boolean halfHour) 
	{
		if (militaryHours < 0 || militaryHours > 23) 
		{
			return null; 
		}
		return new Time(militaryHours, halfHour);
	}
	
	/**
	 * 
	 * @return returns array where all the military time is stored.
	 */
	public int[] getMilitaryTimeSlots()
	{
		return timeSlot;
	}
	
	/**
	 * 
	 * @return returns array where all the halfHour time is stored.
	 */
	public boolean[] gethalfHourTimeSlots()
	{
		return timeSlots;
	}
	
	/**
	 * prints all the times a guest has picked in 12 hours mode.
	 */
	public void tellTime()
	{
		String ampm = "";
		for (int i = 0; i < pickednum; i++)
		{
			if (timeSlot[i] == 0)
			{
				System.out.print(12 + ":");
				ampm = "a.m.";
			}
			else if (timeSlot[i] < 12 && timeSlot[i] >  0)
			{
				System.out.print(timeSlot[i] + ":");
				ampm = "a.m.";
			}
			else if (timeSlot[i] == 12)
			{
				System.out.print(timeSlot[i] + ":");
				ampm = "p.m.";
			}
			else if (timeSlot[i] > 12)
			{
				System.out.print((timeSlot[i]-12) + ":");
				ampm = "p.m.";
			}
			if (timeSlots[i] == true)
			{
				System.out.print("30" + " " + ampm + '\n');
			}
			else if (timeSlots[i] == false)
			{
				System.out.print("00" + " " + ampm + '\n');
			}
		}
		
	}
	
	/**
	 * adds time to the timeSlots and timeSlot arrays.
	 * @param militaryHours Represents military time. 0-23
	 * @param halfHour Represents 30 minutes.
	 * @return returns false if military time is invalid. returns true is the time is added.
	 */
	public boolean addTime(int militaryHours, boolean halfHour)
	{
		if (militaryHours < 0 || militaryHours > 23) 
		{
			return false;
		}
		else 
		{
			timeSlot[pickednum] = militaryHours;
			timeSlots[pickednum] = halfHour;
			pickednum++;
			return true;
		}
	}
	
	/**
	 * Main method of this application.
	 * @param args array of string arguments.
	 */
	public static void main(String[] args) 
	{
		//Example.
		/*Time t = Time.getTime(1, true);
		boolean check = t.addTime(0, false);
		t.addTime(23, true);
		System.out.println(check);
		t.tellTime();*/
	}

}
