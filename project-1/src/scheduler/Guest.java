/**
 * This class implements informations for a Guest at the event.
 * @author Amrit Thapa
 * @version 1.0
 */
public class Guest 
{
		/**
		 * stores available time for each guest.
		 */
		public Time guesttimeslot;
		/**
		 * stores name of the guest.
		 */
		public String guestname = "Write the guest name.";
	
		/**
		 * initializes the variable guesttimeslot. 
		 * @param militaryHour Represents military time. 0-23
		 * @param halfHour Represents 30 minutes.
		 */
		public void initializetimeslot(int militaryHour, boolean halfHour)
		{
			guesttimeslot = Time.getTime(militaryHour, halfHour);
		}
		
		/**
		 * prints the name of the guest.
		 */
		public void guestname()
		{
			System.out.println(guestname);
		}
		
}
