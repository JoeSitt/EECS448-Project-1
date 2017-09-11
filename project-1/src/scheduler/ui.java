package scheduler;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;


import javax.print.DocFlavor.STRING;

public class ui {

/*
 * input: none
 * output: none
 * modifies: console window, name slot, time slot
 * takes user input and starts the program, also makes the user choose a name and a time veiwing format. 
 */
	public static void start(){
	System.out.println("Welcome to the \"Best program(its a working title)\"");
	System.out.println("please input your name");
	Scanner myscan= new Scanner(System.in);
	//String username="";//should replace with actual user name from somewhere else...;
	user me=new user();
	me.uname=myscan.next();
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
		input=myscan.nextLine();
		System.out.println("input recieved.");
		
		if(!(inputcheck(goodAnswer,input))) {
			System.out.println("Your input was not valid. please try again.");
			System.out.println("Would you rather have a time be displayed in a 24hr format or a 12hr format");
			System.out.println("type \"12\" for 12hr format and \"24\" for 24hr format ");
		}else if(input.equals(twelve)){
			me.timeview=12;
			//badinput=false;
		}else {
			me.timeview=24;
			//badinput=false;
		}
	}
	clean();
	user();
	myscan.close();
}

	/*
	 * input: none
	 * output: none
	 * modifies: console window
	 * clears the console window by adding new lines 100 times.
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
	 * input:none
	 * output:none
	 * modifies: screen
	 * shows menu and acts off of user input to goto view event screens. currently not finished.
	 */
	public static void user() {
		System.out.println("=============================================================================\r\n" + 
				"Input the index number of the event you want to view or input a code of what you want to do\r\n" + 
				"Return to options (code: “esc”)\r\n" + 
				"Create an event (code: “create”)\r\n" + 
				"=============================================================================\r\n" + 
				"");
	}

}
