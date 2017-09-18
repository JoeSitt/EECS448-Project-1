package scheduler;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
//import java.util.Arrays;
//import java.util.List;


//import javax.print.DocFlavor.STRING;

public class ui {

	public static String saveFile = "save.txt";
	public static Manager daBoss = Manager.makeManager(saveFile);
	public static int timeview=0;
/**
 * input: none
 * output: none
 * modifies: console window, name slot, time slot
 * takes User input and starts the program, also makes the User choose a name and a time veiwing format. 
 */
	public static void start(){
	System.out.println("Welcome to the \"Best program(its a working title)\"");
	System.out.println("please input your name");//Supports any name they want even no name
	Scanner myscan= new Scanner(System.in);
	String name=myscan.nextLine();
	System.out.println("your name is "+name);
	System.out.println("Would you rather have a time be displayed in a 24hr format or a 12hr format");
	System.out.println("type \"12\" for 12hr format and \"24\" for 24hr format ");
	//boolean badinput=true;
	String input;
	String twelve= new String("12");
	//String twenty4= new String("24");
	User me=new User(name);
	input=myscan.nextLine();
	String[] goodAnswer= {"12","24"};
	while(!inputcheck(goodAnswer,input)) {
		if(!(inputcheck(goodAnswer,input))) {
			System.out.println("Your input was not valid. please try again.");
			System.out.println("Would you rather have a time be displayed in a 24hr format or a 12hr format");
			System.out.println("type \"12\" for 12hr format and \"24\" for 24hr format ");
			input=myscan.nextLine();
			System.out.println("input recieved.");
		}
			else if(input.equals(twelve)){
				timeview=12;
//			//badinput=false;
		}else {
			timeview=24;
//			//badinput=false;
		}
	}
	if(input.equals(twelve)){
		timeview=12;
		//badinput=false;
	}else {
		timeview=24;
		//badinput=false;
	}

	clean();
	System.out.println(timeview);
	User(me);
	myscan.close();
}

	/**
	 * input: none
	 * output: none
	 * modifies: console window
	 * clears the console window by adding new lines 100 times. //have yet to find away of clearing the console anyother way...
	 */
	public static void clean() {
		for(int i=0;i!=101;i++) {
			System.out.println();
		}

	}
	
	/**
	 * input: a list of good inputs as strings and a string of the Users input
	 * output: a bool of if the Users input matched any of the acceptable answers
	 * modifies: none
	 * 
	 */
	public static boolean inputcheck(String[] goodinputs,String input) {
		boolean recievedGin=false;
		for(int i =0;!recievedGin&&i<goodinputs.length;i++) {
			if(input.equals(goodinputs[i])) {
				recievedGin=true;
			}
		}
		return recievedGin;
	}
	
	/**
	 * input:User info
	 * output:none
	 * modifies: screen
	 * shows menu and acts off of User input to goto view event screens. currently not finished.
	 */
	public static void User(User me) {
		Scanner myscan= new Scanner(System.in);
		String[] ginput={"Esc","esc","ESC","Create","create","CREATE","quit","Quit","QUIT"};
		ArrayList<String> ginputs=new ArrayList<String>();
		//ginputs.add(0,test[0]);
		ArrayList<String> sginputs=ginputs;
		int leave=0;
		String input="";
		while(!(input.equals("Quit")||input.equals("QUIT")||input.equals("quit"))) {
		clean();
		myscan= new Scanner(System.in);
		System.out.println("============================================================================================\r\n" + 
				"Input the index number of the event you want to view or input a code of what you want to do\r\n" + 
				"Return to options (code: \"esc\")\r\n" + 
				"Create an event (code: \"create\")\r\n" +
				"exit the program (code: \"quit\")\r\n"+
				"============================================================================================\r\n" + 
				"");
		//System.out.println("here should be where all of the events are shown. but that hasent been set up yet.");
		currentEvents(daBoss.getEvents());
		//System.out.println("currentevents complete");
		ginputs= sginputs;
		
		   //idea for code
		  int i=0;
		  //System.out.println(daBoss.getEvents().size()+"is the size");

			//String[] ginput= ginputs.toArray(test);
		  //System.out.println("updated ginputs");
		  i=0;
		  String[] ginpute=new String[daBoss.getEvents().size()+ginput.length];
		  ginpute=arrayfix(ginput,daBoss.getEvents().size()+ginput.length);
		  while(i<(daBoss.getEvents()).size()){//events would be an array of events
			  	ginpute[i+9]=(i+"");
			  	//System.out.println("frog");
			  	//System.out.println(ginputs[i+6]);
			  	i++;
			  }
		  i=0;
		 /* while(i<ginpute.length) {
			  System.out.println(ginpute[i]);
			  i++;
		  }*/ //used for debug
		//System.out.println("backhere");
		input=myscan.nextLine();
		
		while(!inputcheck(ginpute,input)) {
			System.out.println("Im sorry that input wasnt understood. Please try again.");
			input=myscan.nextLine();
		}
		if(input.equals("esc")||input.equals("Esc")||input.equals("ESC")) {
			//takes them to the options menu.
			me=options(me,myscan);
			input="";
		}
		else if(input.equals("Create")||input.equals("CREATE")||input.equals("create")) {
			//goes to the admin mode of creating an event
			clean();
			admin(me,myscan);
			//System.out.println("here");
			input="";
			//System.out.println("this mode currently isnt active. press enter to continue");
			//myscan.nextLine();//just a buffer will not be in final
		}else if(input.equals("quit")||input.equals("Quit")||input.equals("QUIT")) {
			
		}else {
			//System.out.println("made it here");
			int eventnum=Integer.parseInt(input);
			System.out.println("you have selected event #"+eventnum);
			//System.out.println("this mode currently isnt active. press enter to continue");
			Event temp=eventViewer(me,daBoss.getEvents().get(eventnum),myscan);
			daBoss.deleteEvent(temp.getName());
			daBoss.addEvent(temp);
			//myscan.nextLine();//just a buffer will not be in final
			//goes to event viewer.
		}
		//User(me);
		}
		daBoss.write();
		//System.out.println("scan closed");
		myscan.close();
	}
	
	
	
	/**
	 * input: takes in User info, and the scanner
	 * output: none
	 * modifies: console, and User class.
	 * takes the User to the options menu and alows them to either change their name or the time settings
	 */
	public static User options(User me, Scanner myscan) {
		String input="";
		int i=0;//0 for good input//1 for bad input
		//String[] ginputs= {"Esc","esc","ESC","Name","name","NAME","Time","time","TIME"};//left it here just to let us know what the current options are.
		while(/*!inputcheck(ginputs,input)&&*/!(input.equals("Esc")||input.equals("esc")||input.equals("ESC"))) {
		clean();
		if(i==1) {
			System.out.println("that input wasnt recognised");
		}
		String menuoptions="============================================================================================\r\n" + 
				"Input a code of what you want to do\r\n" + 
				"Return to where you were (code: \"esc\")\r\n" + 
				"Change your user (code: \"name\") Your current name is:"+me.getName()+"\r\n" + 
				"Change the time settings (code: \"time\") Your current time setting is:"+timeview+"hr \r\n"+
				"============================================================================================\r\n" + 
				"";
		System.out.println(menuoptions);
		input=myscan.nextLine();
		if(input.equals("Name")||input.equals("NAME")||input.equals("name")) {
			System.out.println("what would you like your new name to be?");
			String name;
			name=myscan.nextLine();
			//me.setName(name);
			User temp=new User(name);
			me=temp;
			i=0;
		}else if(input.equals("Time")||input.equals("TIME")||input.equals("time")) {
			i=0;
			String[] goodAnswer= {"12","24"};
			System.out.println("Would you rather have a time be displayed in a 24hr format or a 12hr format");
			System.out.println("type \"12\" for 12hr format and \"24\" for 24hr format ");
			while(!inputcheck(goodAnswer,input)) {
				input=myscan.nextLine();
				//System.out.println("input recieved.");
				
				if(!(inputcheck(goodAnswer,input))) {
					System.out.println("Your input was not valid. please try again.");
					System.out.println("Would you rather have a time be displayed in a 24hr format or a 12hr format");
					System.out.println("type \"12\" for 12hr format and \"24\" for 24hr format ");
				}else if(input.equals("12")){
					timeview=12;
					//badinput=false;
				}else {
					timeview=24;
					//badinput=false;
				}
			}
		}else {
			i=1;//will be changed if User leaves but will not make a difference at that point
		}
	}
		
		return me;
		//myscan.close();
	}
	
	/**
	 * input: list of events
	 * output: none
	 * modifies: terminal 
	 */
	public static void currentEvents(List<Event> events) {
		if(events.size()==0) {
			System.out.println("No events to display");
		}else {
			Event temp;
			System.out.println("index:");
			for(int i=0;i<events.size();i++) {
				temp=events.get(i);
				System.out.println(i+"       "+temp.getName()+" on "+temp.getDateString());
			}
		}
	}
	
	/**
	 * input string array and int with size larger than the stringarray
	 * output string array
	 */
	public static String[] arrayfix(String[] a,int size) {
		String[] b=new String[size];
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];
		}
		return b;
	}
	
	/**
	 * NOTE: When in 12 hour mode, entered strings of 4 or fewer characters will cause an array out of bounds exception.
	 * 
	 * @param me the user in question
	 * @param myEvent the event being viewed
	 * @param myscan a scanner for user inputs
	 * @return
	 */
	// TODO: Fix array out of bounds exception on 12 hour mode input
	public static Event eventViewer(User me, Event myEvent, Scanner myscan) {
		String input="";
		while(!input.equals("Esc")&&!input.equals("esc")&&!input.equals("ESC")&&!input.equals("Y")&&!input.equals("y")&&!input.equals("N")&&!input.equals("n")) {
		clean();
		for(int i=0; i<myEvent.getUsers().size();i++) {
			getUserSummary(myEvent.getUsers().get(i),timeview!=12);
		}
		System.out.println("\n\n Would you like to rsvp?(\"Y\" for yes and \"N\" for no)");
		input=myscan.nextLine();
		}
		if(input.equals("Y")||input.equals("y")) {
		User temp=me;
		while(!(input.equals("ESC")||input.equals("esc")||input.equals("Esc")||input.equals("Done")||input.equals("done")||input.equals("DONE"))) {
			ui.clean();
			String menuoptionstime="============================================================================================\r\n" + 
					"Input a code of what you want to do or follow the prompt to make an event\r\n" + 
					"Return to where you were and cancel this event (code: \"esc\")\r\n" + 
					"If you are finished entering times (code: \"Done\")\r\n" +
					"============================================================================================\r\n" + 
					"";
			System.out.println(menuoptionstime);
			if(timeview==12) {
				System.out.println("please input the time you want to have the event in format \"HH:MMaa\" with H=hour, M=min(can only be 00 or 30), and aa= Am or Pm");
				input=myscan.nextLine();
				if(input.equals("ESC")||input.equals("esc")||input.equals("Esc")||input.equals("Done")||input.equals("done")||input.equals("DONE"))
				{
					
				}else {
				if(input.length()<5) {
				char[] inputchar=input.toCharArray();
				if(inputchar[2]!=':') {
					inputchar[2]=':';
				}
				if(inputchar[4]!='0') {
					inputchar[4]='0';
				}
				//if()
				}
				if(Time.isTimeStringValid(input,false)) {
					me.addTime(Time.parseTime(input,false));
				}else {
					//if() {
					System.out.println("input not understood");	
					//}
				}
				}
			}else {
				System.out.println("please input the time you want to have the event in format \"HH:MM\" with H=hour and M=min(can only be 00 or 30)");
				input=myscan.nextLine();
				if(!(input.equals("ESC")||input.equals("esc")||input.equals("Esc")||input.equals("Done")||input.equals("done")||input.equals("DONE"))) {
				if(input.length()<5) {
				char[] inputchar=input.toCharArray();
				
				}
				if(Time.isTimeStringValid(input,true)) {
					me.addTime(Time.parseTime(input,true));
					System.out.println("Time added");
				}else {
					//if() {
					System.out.println("input not understood");	
					//}
				}
				}
			}
		}
		if(input.equals("ESC")||input.equals("esc")||input.equals("Esc")) {
			me=temp;
			return myEvent;
		}
		//time=input;
		myEvent.addUser(me);
		}
		return myEvent;
		
	}
	
	/**
	 * Prints description of user. Includes the user's name which time blocks they occupy.
	 * 
	 * @param user The user in question.
	 * @param useMil Whether or not to format using military time.
	 */
	public static void getUserSummary(User user, boolean useMil) {
		
		String outStr = user.getName();
		outStr += ": ";
		
		List<String> timeSlots = user.getSlotTimeStrings(useMil);
		
		for (int i = 0; i < timeSlots.size(); i++) {
			outStr += timeSlots.get(i);
			if (i != timeSlots.size() - 1) {
				outStr += ", ";
			}
		}
		
		System.out.println(outStr);
	}
	/**
	 * NOTE: When in 12 hour mode, entered strings of 4 or fewer characters will cause an array out of bounds exception.
	 * 
	 * input: me, myscan
	 * output: none or new event
	 * modifies:event string or none,terminal
	 * lets the User create events not finished
	 */
	// TODO: Fix array out of bounds exception on 12 hour mode input
	public static void admin(User me,Scanner myscan) {
		String menuoptions="============================================================================================\r\n" + 
				"Input a code of what you want to do or follow the prompt to make an event\r\n" + 
				"Return to where you were and cancel this event (code: \"esc\")\r\n" + 
				"============================================================================================\r\n" + 
				"";
		String menuoptionstime="============================================================================================\r\n" + 
				"Input a code of what you want to do or follow the prompt to make an event\r\n" + 
				"Return to where you were and cancel this event (code: \"esc\")\r\n" + 
				"If you are finished entering times (code: \"Done\")\r\n" +
				"============================================================================================\r\n" + 
				"";
		System.out.println(menuoptions);
		String[] gHRinputs= {"Esc","esc","ESC"};
		String[] g12inputs= {"Esc","esc","ESC","AM","am","Am","A.M.","a.m.","A.m.","PM","pm","Pm","P.M.","p.m.","P.m."};
		String[] gmininputs= {"Esc","esc","ESC","","0","00","30"};
		/*if (me.timeview==12) {

			for(int i=0;i<12;i++) {
				int x=i+1;
					gHRinputs[i+3]=""+x;
			}
		
		}else {
			for(int i=0;i<24;i++) {
				gHRinputs[i+3]=""+i;
			}
		}
*/
		String input="";
		System.out.println("Please input a name for your Event(Cannot be esc, ESC, or Esc)");
		input=myscan.nextLine();
		if(input.equals("ESC")||input.equals("esc")||input.equals("Esc")) {
			return;
		}
		String name =input;
		System.out.println("please input the date you would liked to schedual your event on.(MM/dd/yyyy)");
		String date;
		input= myscan.nextLine();
		if(input.equals("ESC")||input.equals("esc")||input.equals("Esc")) {
			return;
		}
		//TODO-check date here and loop if incorrect info or format(while letting the User know why they are a fool);
		while(!(Event.isDateStringValid(input)||input.equals("ESC")||input.equals("esc")||input.equals("Esc"))) {
			System.out.println("please input the date you would liked to schedual your event on.(MM/dd/yyyy)");
			input=myscan.nextLine();
		}
		if(input.equals("ESC")||input.equals("esc")||input.equals("Esc")) {
			return;
		}
		date=input;
		Date Date= Event.parseDateString(date);
		
		//TODO-this should allow for multiple inputs either separated by a comma or allow for time spans, eg. 11:00-15:00, 16:00-20:30
		//should also loop until correct input is received.
		
		//where i stopped-js
//		Event myEvent=new Event(Date,name);
		Event myEvent = Event.makeEvent(Date, name);
		
		//String time;//could also be a list of strings or list of ints
		/*boolean bsize=false;//bad size
		boolean b5=false;//
		boolean b0=false;//bad first character
		boolean b3=*/
		User temp=me;
		while(!(input.equals("ESC")||input.equals("esc")||input.equals("Esc")||input.equals("Done")||input.equals("done")||input.equals("DONE"))) {
			ui.clean();
			System.out.println(menuoptionstime);
			if(timeview==12) {
				System.out.println("please input the time you want to have the event in format \"HH:MMaa\" with H=hour, M=min(can only be 00 or 30), and aa= Am or Pm");
				input=myscan.nextLine();
				if(input.equals("ESC")||input.equals("esc")||input.equals("Esc")||input.equals("Done")||input.equals("done")||input.equals("DONE"))
				{
					
				}else {
				if(input.length()<5) {
				char[] inputchar=input.toCharArray();
				if(inputchar[2]!=':') {
					inputchar[2]=':';
				}
				if(inputchar[4]!='0') {
					inputchar[4]='0';
				}
				//if()
				}
				if(Time.isTimeStringValid(input,false)) {
					me.addTime(Time.parseTime(input,false));
				}else {
					//if() {
					System.out.println("input not understood");	
					//}
				}
				}
			}else {
				System.out.println("please input the time you want to have the event in format \"HH:MM\" with H=hour and M=min(can only be 00 or 30)");
				input=myscan.nextLine();
				if(!(input.equals("ESC")||input.equals("esc")||input.equals("Esc")||input.equals("Done")||input.equals("done")||input.equals("DONE"))) {
				if(input.length()<5) {
				char[] inputchar=input.toCharArray();
				
				}
				if(Time.isTimeStringValid(input,true)) {
					me.addTime(Time.parseTime(input,true));
					System.out.println("Time added");
				}else {
					//if() {
					System.out.println("input not understood");	
					//}
				}
				}
			}
		}
		if(input.equals("ESC")||input.equals("esc")||input.equals("Esc")) {
			me=temp;
			return;
		}
		//time=input;
		myEvent.addUser(me);
		daBoss.addEvent(myEvent);
		me=temp;
	}

}
