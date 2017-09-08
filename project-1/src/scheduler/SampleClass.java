/**
 * Sample class demonstrating its ability to have its contents read and
 * written to file.
 * 
 * The class that keeps track of state of the session could be modeled
 * after this.
 * 
 * @author Carter Maxcy
 */

package scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;


public class SampleClass implements Serializable {

	// Sample data member that a class could contain
	private List<String> sampleMember;
	
	// Serializable requires this member variable be included
	private static final long serialVersionUID = 1L;
	
	SampleClass(List<String> sampleMember) {
		this.sampleMember = sampleMember;
	}

	public List<String> getMember() {
		return sampleMember;
	}

	/*
	 * Writes Class instance to supplied file
	 */
	public void write(String fileName) {
		try {
			FileOutputStream f = new FileOutputStream(new File(fileName));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(this);
			
			// close file writing objects
			o.close();
			f.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Reads and constructs instance from file
	 */
	public static SampleClass read(String fileName) {
		
		try {
			FileInputStream fi = new FileInputStream(new File(fileName));
			ObjectInputStream oi = new ObjectInputStream(fi);

			SampleClass pr1 = (SampleClass) oi.readObject();

			// close file reading objects
			oi.close();
			fi.close();
			
			return pr1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}


