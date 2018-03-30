package pr1.uebung01;

import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readString;

public class HelloWorld {
	
	public static void main(String[] args) {
		
		println("Hello Friend , what's your Name? ");
		String firstName;
		firstName = readString();
		println("Bad to meet you " + firstName + ".");
		
	}

}
