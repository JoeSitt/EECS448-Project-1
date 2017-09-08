package scheduler;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		// Class instantiated with sample member variable
		List<String> testArr = Arrays.asList(new String[]{"A", "B", "C"});
		SampleClass s = new SampleClass(testArr);
		
		// Class instance written to file
		s.write("SampleClass-test.txt");
		
		// instance read from file and contents verified
		SampleClass j = SampleClass.read("SampleClass-test.txt");
		printList(j.getMember());
	}
	public static void printList(List<String> list) {
		for (String item : list) {
			System.out.println(item);
		}
	}
}
