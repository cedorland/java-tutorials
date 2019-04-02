/**
 * @author Ciaran Eli Dorland
 * 
 * Part of a series of Java tutorials.
 * Intended for use with Eclipse or your favorite Java IDE.
 */

package Chapter2;

import java.util.Scanner;

public class Part2_ReadingUserInput {

	public static void main(String[] args){
		
		// This section is going to be pretty short. We're just going to learn how to
		// read user input from the console and store it in memory.
		
		// We're going to be using the Scanner class from the Java standard libraries.
		// Let's create a new instance of a Scanner object:
		
		Scanner sc = new Scanner(System.in);
		
		// You'll noticed that we passed it 'System.in' as a variable. This is the computer's standard input stream,
		// and a scanner reads wahtever input stream you give it, so we're gonna use System.in to read from the console.
		
		// Next, let's print something to the console:
		
		System.out.println(" Hello, I'm an echo machine. \n Type something in, and I'll echo it back! \n");
		
		// Now that we've printed some instructions (quick aside, note the '\n' in the middle of the string -
		// you'll see when this prints that there's a line separator there), let's wait for the user to
		// enter some text:
		
		String theNextThingThisMotherfuckerSaysToMe = sc.nextLine();
		
		// Since no text has been entered in the console yet, this makes the scanner wait until the user
		// types something in and hits enter, then it grabs everything the entered before hitting the enter key,
		// and saves it to our String.
		// Let's follow through, and echo what they said to the screen:
		
		System.out.println(theNextThingThisMotherfuckerSaysToMe);
		
		
		// That's it! Pretty easy, huh?
		// You can also take in user input and parse it for information - let's take a quick look at grabbing numbers:
		
		// Print some instructions:
		System.out.println("Enter a number and I'll multiply it by 5! \n");
		
		// And wait for input:
		String someNumberString = sc.nextLine();
		
		// Now, let's parse a number from that String using a convenient method in the Integer class:
		int num = Integer.parseInt(someNumberString);
		
		// Multiply it by 5 and print it!
		num *= 5;
		System.out.println("x 5 = "+num);
		
		// Don't forget to close the scanner before the program ends!
		sc.close();
		
	}
	
}
