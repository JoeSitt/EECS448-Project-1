/**
 * This class represents an Event where names, and guests are included.
 * @author Amrit Thapa
 * @version 1.0
 */
public class Event {
	
	/**
	 * name of the event.
	 */
	public String eventname = "Write the event name."; 
	/**
	 * name of the creator.
	 */
	public String creatorname = "Write the creator name."; 
	/**
	 * array of guest, limited to 100; can be increased.
	 */
	public Guest attend[] = new Guest[100]; 
	/**
	 * number of attendes, includes creator, will increment by 1 every time someone is added.
	 */
	public int attendes = 0;
	
	/**
	 * This constructs an Event with a specified event name, and creator name.
	 * adds creator to attend[0].
	 * @param eventname name of the event.
	 * @param creatorname name of the creator.
	 */
	public Event(String eventname, String creatorname) 
	{
		for (int i = 0; i < 100; i++)
		{
			attend[i] = new Guest();
		}
		this.eventname = eventname;
		this.creatorname = creatorname;
		attend[attendes].guestname = creatorname;
		attendes++;
	}	
	
	/**
	 * prints the name of the creator and the name of the event.
	 */
	public void printnames()
	{
		System.out.println(creatorname + " " + eventname);
	}

}
