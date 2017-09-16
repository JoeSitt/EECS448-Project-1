/**
 * Testing other classes.
 * @author Amrit Thapa
 * @version 1.0
 */
public class Main 
{
	/**
	 * Main method of this application.
	 * @param args array of string arguments.
	 */
	public static void main(String[] args) 
	{
		//Example
		Event test0 = new Event("Fir Firework's", "Hawk");		
		test0.attend[0].initializetimeslot(1, true);
		boolean check = test0.attend[0].guesttimeslot.addTime(0, false);
		test0.attend[0].guesttimeslot.addTime(23, true);
			
		test0.printnames();
		test0.attend[0].guestname();
		test0.attend[0].guesttimeslot.tellTime();
		
		test0.attend[1].initializetimeslot(14, true);
		test0.attend[1].guesttimeslot.addTime(17, false);
		test0.attend[1].guesttimeslot.addTime(8, true);
		test0.attend[1].guestname = "Ary Nal";
		test0.attend[1].guestname();
		test0.attend[1].guesttimeslot.tellTime();

	}

}
