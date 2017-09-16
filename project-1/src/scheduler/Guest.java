
public class Guest {
		public Time guesttimeslot;//stores available time for each guest
		public String guestname = "Write the guest name."; //stores name of the guest
	
		
		public void initializetimeslot(int militaryHour, boolean halfHour)
		{
		guesttimeslot = Time.getTime(militaryHour, halfHour);
		}
		
		public void guestname()
		{
			System.out.println(guestname);
		}
		
		public static void main(String[] args) {
			
		}
}
