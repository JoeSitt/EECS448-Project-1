package scheduler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ui.start();
		
//		List<String> posRes = new ArrayList<String>();
//		posRes.add("Good");
//		posRes.add("Dandy");
//		
//		String response = getResponse("How are you?: ", posRes, System.in);
//		
//		System.out.println(response);
	}
	
	public static ByteArrayInputStream getStream(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}
	
	public static String getResponse(String question, List<String> possibleResponses, InputStream in) {
		Scanner scan = new Scanner(in);
		String response = "";
		
		while (true) {
			System.out.println(question);
			response = scan.nextLine();
			for (String possibleResponse : possibleResponses) {
				if (response.equals(possibleResponse)) {
					return response;
				}
			}
		}
	}
}
