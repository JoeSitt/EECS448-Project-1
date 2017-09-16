
public class Event {

	public String eventname = "Write the event name."; //name of the event.
	public String creatorname = "Write the creator name."; //name of the creator.
	public Guest attend[] = new Guest[100]; //array of guest, limited to 100, //creator should be added to attend[0].
	public int attendes = 0; //number of attendes, //includes creator, will increment by 1 everytime someone is added.
	
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
	
	public void printnames()
	{
		System.out.println(creatorname + " " + eventname);
	}
	
	public static void main(String[] args) {
	
	}

}
