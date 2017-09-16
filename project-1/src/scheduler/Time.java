
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Time 
{
	public boolean[] timeSlots; //stores if there is 30 minutes or not. true indicates 30 minutes. false indicates 0 minute.
	public int[] timeSlot; //stores the military time.
	public int pickednum = 0; //tracks how many times a user has added times to timeSlots and timeSlot array.
	
	private Time(int militaryHours, boolean halfHour)
	{
		timeSlots = new boolean[24];
		timeSlot = new int[24];
		timeSlot[pickednum] = militaryHours;
		timeSlots[pickednum] = halfHour;
		pickednum++;
	}
	
	public static Time getTime(int militaryHours, boolean halfHour) 
	{
		if (militaryHours < 0 || militaryHours > 23) 
		{
			return null; // returns null if the militaryHour is invalid.
		}
		return new Time(militaryHours, halfHour);
	}

	public int[] getMilitaryTimeSlots() //returns array where all the military time is stored.
	{
		return timeSlot;
	}
	
	public void tellTime() //returns all the times in 12 hours mode.
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
	
	public boolean[] gethalfHourTimeSlots() //returns array where all the halfHour time is stored.
	{
		return timeSlots;
	}
	
	public boolean addTime(int militaryHours, boolean halfHour) //adds time to the arrays.
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
