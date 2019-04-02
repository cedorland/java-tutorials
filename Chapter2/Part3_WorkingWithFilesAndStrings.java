package Chapter2;

// These are all of the imported classes we'll be using later on in this section.
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Part3_WorkingWithFilesAndStrings {
	
	/* 	
		In this section, we'll cover how to work with basic text files (.txt extension).
		Saving and loading data is important in programming - it allows you to, for example, save and load
		a player's current progress through the game you're making, keep track of a patient's medical history
		through your Java GUI, etc.
		
		We'll also be learning some of the more useful String methods, such as grabbing only a select group
		of characters, checking if a String contains a certain word or phrase, or splitting one long String into
		several smaller Strings based on a 'delimiter' - for example, splitting a paragraph into individual
		sentences using a period character ('.') as a delimiter.
		
		This section will also introduce the basic idea of 'scope', and why it's both useful and important.
	*/
	
	/**	 SECTION 1 : FILES  **/
	
	// First, we'll declare a few global variables.
	// The word global means that they'll be visible throughout the rest of this program,
	// in any methods we make. This is useful for keeping track of events between methods.
	// Global variables are defined within the class file but outside of any methods,
	// and by convention (and to make it easy to find them) are usually declared at the top of the file.
	// The keyword 'public', as I said before, when put before a variable's declaration (as below), 
	// allows any other program to view and manipulate that variable, be it from another class file
	// in the same package or from a completely different project.
	// This is the scope of the variable's visibility - you'll learn a few more keywords that
	// control the scope of a variable's visibility later. For now, we're not concerned with access to these
	// variables so we'll make them public.
	// We'll also make them static so there can only be one of each of them. I'll explain that keyword
	// a bit later when we get into Object extension and inheritance.
	public static String lastUserInput = "";
	public static Scanner sc = new Scanner(System.in);
	
	// The keyword 'final' used below indicates that this variable cannot ever be altered by the program
	// after it has been created - it's used for constant values, especially when you don't want to 
	// accidentally change a variable's value later on. This variable will serve as the filepath to
	// whatever folder you want to save/load data from. The easiest way to do this is probably
	// to go to your desktop, create a new folder, then right click it, and click either "Copy Path(s)" (Windows/Linux)
	// and paste the result here as a String, or right click on your folder and click
	// "Get Info" (Mac OS), find the line that begins with 'Where:' and copy the rest of the line after the colon,
	// and paste the result here. Make sure that the String ends with either a slash or a backslash,
	// depending on what direction the slashes in the rest of the filepath follow.
	public static final String PATH = "Replace these words with your folder's filepath";
	
	/*
	 * Note: the creation of your path can also be done on most operating systems by using this convenient method:
	 * 
	 * >	System.getProperty("user.home");
	 * 
	 * This method returns a string representing the filepath of the user's home folder.
	 * On most systems, you can get the desktop's filepath by using
	 * 
	 * >	String path = System.getProperty("user.home") + "/Desktop";
	 * 
	 * Pointing to your folder from there is as easy as saying
	 * 
	 * >	path += "/myFolderName";
	 * 
	 */
	
	// Now, we'll create the main method. Note the extra 'throws IOException' - this is
	// used for error handling. It basically tells the computer that it might encounter
	// an i/o (input/output) error at some point while it's running this method, and to handle
	// that error properly. Writing to and reading from files, you'll encounter errors
	// if you try to read a file that doesn't exist or write to a file that's read-only.
	// We'll go over error handling in a bit more depth at a later point.
	public static void main(String[] args) throws IOException {
		
		// First, we're going to print some instructions to the console.
		System.out.println("Enter a sentence, and I'll write it to the file for you!");
		
		// Next, we're going to use a Scanner to read the next line from the console.
		lastUserInput = sc.nextLine();
		
		// Cool - we've waited for input, then collected a String of text.
		// Next, we have to write it to a file. You can replace this with whatever you want,
		// but it can't have any spaces, periods, slashes, or anything like that in it.
		String fileName = "myFile";
		
		// Let's create a FileWriter. This will try to open up a file with the specified name and location.
		// If no file exists, it will create the file. Note that I've added '.txt' to the end of the file.
		// This makes it a .txt (text) file.
		FileWriter fw = new FileWriter( PATH + fileName + ".txt" );
		
		// Now, we'll use the .write(String) method from the FileWriter class to write some text
		// to the file. Note that if the file already had text in it, this will delete the contents of
		// the file before it writes anything. If you wanted to add text to a file without clearing it first,
		// you would use the .append(String) method, which simply adds text to the end of a file.
		fw.write(lastUserInput);
		
		// This closes the FileWriter, which saves the file and prevents it from being written to again
		// until you reopen it.
		fw.close();
		
		// Now, we'll read from the file and print it back to the console. First, let's print something
		// to the console to let the user know what we're doing:
		System.out.println("Here's what the file says:");
		
		// Now, we'll create a new FileReader object and feed it our file's full path:
		// (note that this will cause an error if no file with the specified name and path exists!)
		FileReader fr = new FileReader( PATH + fileName + ".txt" );
		
		// Now, a FileReader is a pretty low-level tool for reading from a file, but we're
		// using it because it'll give you a bit more to think about and touch back on casting
		// and loops.
		// The FileReader's .read() method can only read a single character at a time, and it returns those
		// characters in ASCII format, which is the same binary code that your keyboard uses.
		// That means you'll get an integer that represents a character - this is where casting comes in handy.
		// Since the computer uses ASCII as its standard storage method for characters, casting those
		// integer values to character values will give you readable characters.
		// Let's take a look at how to do this:
		
		// First, we'll need to create a String to receive the text from the file.
		// Let's make it blank.
		String fileText = "";
		
		// Next, we'll have to use a loop to read all of the characters in order and add them to the String.
		// The FileReader's .read() method always returns the integer value -1 at the end of the file,
		// so we'll use that to figure out when we've hit the end of the file.
		// I've moved the solution to this a bit further down the page so that, if you're so inclined,
		// you can try your hand at coding this next part yourself.
		// Hints: Use a while loop, and check whether you've hit the end of the file yet every loop!
		
		
		
		
		
		
		
		
		
		/* ~ Scroll down to see solution ~ */
		
		
		
		
		
		
		
		
		
		/* ~ Scroll down to see solution ~ */
		
		
		
		
		
		
		
		
		
		/* ~ Scroll down to see solution ~ */
		
		
		
		
		
		
		
		
		
		// Here's an in-depth look at how I tackled this:
		
		// First, we know we're going to use a while loop. We want to loop *while* there's still more text
		// in the file, i.e. the .read() method hasn't returned a value of -1 yet.
		// Since we need to check the value at the start of every loop, and since we can't check the value
		// without collecting the next character, we're going to have to do both at the same time, all
		// inside the conditional statement of the while loop. Since we can't cast the result of the .read()
		// method to a character before we've checked what its integer value is, we'll have to collect each 
		// character as an integer and cast it later. That means we need an int we can access
		// from inside the loop:
		int character = 0;
		
		// And here's that condition statement. We're collecting the read result in our integer,
		// then making sure it's NOT equal to -1 before allowing the loop's code block to execute.
		while(   ( character = fr.read() ) != -1   ) {
			
			// Now, all we have to do is cast the ASCII code we got to a character, and add it to the
			// end of our fileText String! It was important to cast here, because if we just
			// added the value of character to the end of the String, we'd have a bunch of numbers
			// as our String.
			fileText += (char) character;
			
		}
		
		// Now that we've got the String, let's print it to the console:
		System.out.println(fileText);
		
		// And finally, let's close our FileReader:
		fr.close();
		
		// For now, that's it for files. We'll come back to this later to look at some
		// methods for formatting different types of data so they're easy to retrieve.
		
		
		
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		
		
		
		/**  SECTION 2 : STRINGS  **/
		
		/*
			Now, we're going to take a look at some string rules and learn some useful methods.
			We're going to go over:
				- Pulling substrings from larger strings
				- Chopping strings up based on delimiters
				- Manipulating strings to make them easier to use
			
			Let's dive right in.
			
			First off, substrings. The String.substring() method is going to take us back to 
			the idea of an array, and we'll be using the same numbering system. This will also
			give you a look at how the computer actually stores and understands strings.
			
			The computer understands Strings like they're arrays of characters.
			There's really not a whole lot of difference, if you think about it,
			between these two snippets of code:
			
				char[] helloWorld = { 'H', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd', '!' };
				
				String helloWorld = "Hello, world!";
				
			...other than the fact that Strings are generally way more convenient than character arrays.
			This is how the computer stores and manipulates Strings in memory - the String class really
			only exists to make your life easier. 
			If you wanted to copy only a specific part of that String, and you had it stored in a character
			array, how would you do it?
			Consider the following:
			
				char[] helloWorld = { 'H', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd', '!' };
					 // Array index:  [0]  [1]  [2]  [3]  [4]  [5]  [6]  [7]  [8]  [9]  [10] [11] [12]
				
				char[] world = new char[5];
				world[0] = helloWorld[7];	// 'w'
				world[1] = helloWorld[8];	// 'o'
				world[2] = helloWorld[9];	// 'r'
				world[3] = helloWorld[10];	// 'l'
				world[4] = helloWorld[11];	// 'd'
			
			You've just successfully copied over a substring!
			That's exactly what the substring() method does.
			In reality, the substring() method takes in one or two integer values, and looks a lot like this:
			
			public String substring( int begin, int end ) {
				
				String toReturn = "";
				
				for( int index = begin; index < end; index++ ) {
					
					toReturn += originalString.charAt( index );
					
				}
				
				return toReturn;
				
			}
			
			If you look at that for-loop, you'll notice that it grabs each character
			starting with the first index you give it and ending on the last.
			It does add the character AT the beginning index, but it stops just short of
			the character AT the ending index in the String.
			
			Here's an example:
		*/
		
		String helloWorld = "Hello, world!";
		String world = helloWorld.substring(7,12);
		
		/*		
			Since it grabs the first index but stops short of the second index you give it,
			in this example, our String 'world' will contain the characters at indices
			7, 8, 9, 10, and 11, which is exactly what we want.
			
			A good way to remember this is that you give it the index of the first character you want to grab,
			and then add the number of characters you want it to have - n this case, we want a substring that
			starts on index 7 and is 5 characters long, so we use .substring(7, 12) because 7 + 5 = 12.
			
			That's the substring method.
			
			Next, we'll take a quick look at some methods that are pretty straightforward:
			
			
			1. The 'replace' method takes in two substrings, and replaces all instances of the first substring
				with the second substring, proceeding from left to right.
			
				>	String.replace( thisSubstring, withThisSubstring )
			
			Example:
		 */
		
		String howNow = "How now, brown cow?";
		howNow.replace("brown", "milk-producing");
		
		/*
			The String 'howNow' now reads "How now, milk-producing cow?"
			
			Note that this method can also be used to remove all instances of a given substring from
			the given String if you leave the second String blank:
			
		 */
		
		howNow.replace("o", "");
		
		/*
			That just removed all of the 'o' characters in the howNow String,
			so if we were to print it, we would see "Hw nw, milk-prducing cw?"
		
			That can be really useful.
			
			~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			Next one:
			
			2. The 'toUpperCase' and 'toLowerCase' methods do exactly what you think:
				they make all of the letters in a string either upper or lower case,
				depending on which one you use.
				
			Example:
		
		 */
		
		String input = "WhY yEs I wOuLd LoVe SoMe PiZzA, tHaNk YoU fOr AsKiNg!";
		
		/*
			
			If we received this as user input straight from the console, and we only cared whether they had said
			'yes' or 'no', we would probably want to get everything into lower case so we could check
			more easily:
			
		 */
		
		input = input.toLowerCase();
		
		/*
			
			Now, that String reads, "why yes, i would love some pizza, thank you for asking!"
			That brings us to our next method:
			
			~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			3. The 'contains' method checks a string to see if it contains a given substring,
				and returns true if it does, and false if it doesn't.
				
			This one has obvious merit. We could do something like this:
			
		 */
		
		if ( input.contains("yes") ){
			// They said yes, so give them their pizza.
		}
		else {
			// They didn't say yes, so give them something else.
		}
		
		/*
		 * 
			Of course, you would need to account for the fact that maybe they used another word
			like "sure", "okay", "you know it", "affirmative", etc.
			
			There are a bunch of other handy methods that the String class offers you,
			and if you're using Eclipse, you can actually just type in
			
				String.
			
			(or any other class file's name followed by just a period) and wait for the dialog box to pop up.
			If you scroll over a method, it will give you a brief description of what that method does.
			
			Let's take a look at one last String method:
			
			~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			4. The 'split' method
			
				To use this method, you just input a 'delimiter' character, e.g. a period.
				The method cuts your original String at every point where it finds your delimiter
				character, and then splits the String into a set of substrings at those points.
				It then returns these as an array.
				
				Here's the syntax:
				
				>	myStringArray = thisString.split( "delimiter" );
				
			And an example:
			
		 */
		
		String sentence = "Somebody once told me the world was gonna roll me; I ain't the sharpest tool in the shed.";
		String words[] = sentence.split(" ");
		
		/*
			I used the space bar as my delimiting character, so the string array named 'words' now contains
			all of the individual words in the string 'sentence', split at the spaces.
			If we were to print some of these words out, we'd see this:
			
				words[0] contains "Somebody"
				words[1] contains "once"
				
				words[9] contains "me;"
				
			Note that since we split on the spaces, none of the resulting strings contained spaces, but
			all of the other characters in the original string were retained.
			
			Let's take a look at another example:
				
		 */
		
		String tooManySemicolons = "I have too many semicolons here;; however, there's a reason for it.";
		String halves[] = tooManySemicolons.split(";");
		
		/*
			This example is just to show you fringe behavior.
			If we were to look at the length of our array, we would find that the
			string array 'halves' actually contains THREE strings.
			They are:
			
				halves[0] = "I have too many semicolons here"
				
				halves[1] = ""
				
				halves[2] = " however, there's a reason for it."
				
			Since there was nothing between those two semicolons, we got a string with nothing in it.
			
			~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			Here's a little something I forgot earlier:
			
			Remember when we were working with ArrayLists, and we used the ArrayList.size() method to
			find out how many elements the ArrayList contained?
			There are two other very useful methods that are just like this,
			one for Strings and one for any kind of array.
			
			The Array.length method applies to any kind of array, and returns the exact
			number of slots in that array:
			
		 */
		
		int arraySize = halves.length;
		// Remember that 'halves' is a String array. Length is just a public variable, AKA a 'field'.
		
		/*
			Strings have a very similar method (remember, they're just character arrays at heart!):
		 */
		
		int stringLength = halves[0].length();
		// Since halves is a String array, halves[0] is the first String in that array.
		// As you can see, String.length() is a method and not a field.
		
		/*
			That's pretty much it for this section.
			
			See below for your first project assignment.
			
			HINT: For better formatting, use '\t' to insert a TAB character.
			But really, don't worry about formatting too much right now.
			
		 */
		
	}
	
	/**
				◊==========================================◊
				∏				 PROJECT #1				   ∏
				∏~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~∏
				∏			    OrderUp.java			   ∏
	 			‡==========================================‡
    			∏  For your first project, write a program ∏
   				∏  called "TakeOut.java". Have it ask the  ∏
   				∏  user what they'd like to eat, and offer ∏
   				∏  them at least 5 different food items    ∏
   				∏  from a menu, with individual prices     ∏
   				∏  listed. After they've ordered, ask them ∏
   				∏  if they're still hungry. If they say    ∏
   				∏  yes, offer them the menu again. If they ∏
   				∏  say no, ask them what percentage tip    ∏
   				∏  they would like to leave, then print    ∏
   				∏  them a receipt with all food they ate   ∏
   				∏  listed next to its price, a subtotal,   ∏
   				∏  tax, tip, and full total.               ∏
   				∏  										   ∏
   				∏  See below for sample.				   ∏
    			◊==========================================◊
    			
    			NOTE: Make sure you round your price calculations to the nearest cent each time!
    			Remember that nobody is grading this - you don't have to do it, but you should!
    			Feel free to look back over the first two chapters as you work.
    			My solution to this project is in the solutions folder. Feel free to take a look at it,
    			but I strongly advise against looking at it without at least trying to write the program first.
    			If you want to be a programmer, you'll have to solve much tougher problems than this,
    			and probably with deadlines looming and your livelihood (salary) at stake!
    			
    			You'll need a bit of everything we've covered so far to complete this project.
    			
    **/
	/*	
	 		Sample input/output for project 1:
	 		
	 			Hello, welcome to The Food Place! We have food, and we're a place!
				What can I get for you?
				
				Menu:
				$  0.75	 - Single french fry
				$  6.25	 - Burger
				$ 98.50	 - Filet mignon
				$ 27.50	 - Lobster
				$  1.25	 - Mayonnaise
				
				> A single french fry
			
				Wonderful! Here's your single french fry!
				Can I get you anything else?
				
				> A burger
	
				Wonderful! Here's your burger!
				Can I get you anything else?	
				
				> Mayonnaise	
				
				Wonderful! Here's your mayonnaise!
				Can I get you anything else?
				
				> More mayonnaise
	
				Wonderful! Here's your mayonnaise!
				Can I get you anything else?
				
				> No
				
				All right! What percent tip would you like to leave?
				
				> 15
				
				Thank you very much! Here's your receipt:
				
				$0.75 - SINGLE FRENCH FRY
				$6.25 - BURGER
				$1.25 - MAYONNAISE
				$1.25 - MAYONNAISE
				
				SUBTOTAL:  $  9.50
				TAX:       $  0.57
				TIP:       $  1.51
				
				TOTAL:     $ 11.58	
	*/
	
}
