package scheduler;
import java.util.Scanner;
//import java.util.Arrays;
//import java.util.List;


//import javax.print.DocFlavor.STRING;

public class ui {

/*
 * input: none
 * output: none
 * modifies: console window, name slot, time slot
 * takes user input and starts the program, also makes the user choose a name and a time veiwing format. 
 */
	public static void start(){
	System.out.println("Welcome to the \"Best program(its a working title)\"");
	System.out.println("please input your name");//Supports any name they want even no name
	Scanner myscan= new Scanner(System.in);
	//String username="";//should replace with actual user name from somewhere else...;//just did.-JS
	user me=new user();
	me.uname=myscan.nextLine();
	System.out.println("your name is "+me.uname);
	System.out.println("Would you rather have a time be displayed in a 24hr format or a 12hr format");
	System.out.println("type \"12\" for 12hr format and \"24\" for 24hr format ");
	//boolean badinput=true;
	String input;
	String twelve= new String("12");
	//String twenty4= new String("24");
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
				me.timeview=12;
//			//badinput=false;
		}else {
			me.timeview=24;
//			//badinput=false;
		}
	}
	if(input.equals(twelve)){
		me.timeview=12;
		//badinput=false;
	}else {
		me.timeview=24;
		//badinput=false;
	}

	clean();
	System.out.println(me.timeview);
	user(me);
	myscan.close();
}

	/*
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
	
	/*
	 * input: a list of good inputs as strings and a string of the users input
	 * output: a bool of if the users input matched any of the acceptable answers
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
	
	/*
	 * input:user info
	 * output:none
	 * modifies: screen
	 * shows menu and acts off of user input to goto view event screens. currently not finished.
	 */
	public static void user(user me) {
		Scanner myscan= new Scanner(System.in);
		String[] ginputs= {"Esc","esc","ESC","Create","create","CREATE",""+1};
		String[] sginputs=ginputs;
		int leave=0;
		String input;
		while(leave==0) {//currently set up to infinite loop
		clean();
		myscan= new Scanner(System.in);
		System.out.println("============================================================================================\r\n" + 
				"Input the index number of the event you want to view or input a code of what you want to do\r\n" + 
				"Return to options (code: “esc”)\r\n" + 
				"Create an event (code: “create”)\r\n" + 
				"============================================================================================\r\n" + 
				"");
		System.out.println("here should be where all of the events are shown. but that hasent been set up yet.");
		ginputs= sginputs;
		/*
		 *  //idea for code
		 * int i=0;
		 * while(i<events.length){//events would be an array of events
		 * 	ginputs[i+5]=""+i;
		 * }
		 */
		input=myscan.nextLine();
		while(!inputcheck(ginputs,input)) {
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
			System.out.println("this mode currently isnt active. press enter to continue");
			myscan.nextLine();//just a buffer will not be in final
		}else {
			int eventnum=Integer.parseInt(input);
			System.out.println("you have selected event #"+eventnum);
			//goes to event viewer.
		}
		//user(me);
		}
		myscan.close();
	}
	
	/*
	 * input: takes in user info, and the scanner
	 * output: none
	 * modifies: console, and user class.
	 * takes the user to the options menu and alows them to either change their name or the time settings
	 */
	public static user options(user me, Scanner myscan) {
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
				"Return to where you were (code: “esc”)\r\n" + 
				"Change your name (code: “name”) Your current name is:"+me.uname+"\r\n" + 
				"Change the time settings (code: time) Your current time setting is:"+me.timeview+"hr \r\n"+
				"============================================================================================\r\n" + 
				"";
		System.out.println(menuoptions);
		input=myscan.nextLine();
		if(input.equals("Name")||input.equals("NAME")||input.equals("name")) {
			System.out.println("what would you like your new name to be?");
			me.uname=myscan.nextLine();
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
					me.timeview=12;
					//badinput=false;
				}else {
					me.timeview=24;
					//badinput=false;
				}
			}
		}else {
			i=1;//will be changed if user leaves but will not make a difference at that point
		}
	}
		
		return me;
		//myscan.close();
	}

}