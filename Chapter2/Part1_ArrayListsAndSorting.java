/**
 * @author Ciaran Eli Dorland
 * 
 * Part of a series of Java tutorials.
 * Intended for use with Eclipse or your favorite Java IDE.
 */

package Chapter2;

// This is an *import* statement. This line tells the computer that we're going to be using
// the ArrayList object throughout this file, so we don't have to constantly tell the
// computer where to go looking for the ArrayList file every time we do anything
// with an ArrayList.
import java.util.ArrayList;

public class Part1_ArrayListsAndSorting {

	// We'll make a main method so we can do some work.
	public static void main(String[] args){
		
		/** PART 1 : ARRAYLISTS */
		
		// In this section, we'll go over a standard java Object called an ArrayList that's really useful.
		// You know that arrays are useful when a specific amount of the same type of variable need to be ordered,
		// like when you know you'll be working with exactly twelve integers and it matters what order they're in.
		// This has its purpose, and it's good for a lot of things, but what if you're not sure
		// how many Cars you will have, and it doesn't matter what order they're in?
		// This is when the ArrayList Object comes in handy.
		// First off, to use ArrayLists, since they're not a String or primitive data type,	we need to import them from
		// the standard Java library so that we can access them throughout our file without having to constantly
		// tell the computer where to look for the ArrayList file every time we reference an ArrayList.
		// The first thing we're going to do here is make a new ArrayList.
		// Every ArrayList can only hold one type of object. To specify this, we have to tell the computer
		// what type of object our ArrayList will hold using triangular brackets when we first create the ArrayList.
		
		ArrayList<String> stringsList= new ArrayList<String>();
		
		// Note that, on the right side of the equals sign, we're making a new ArrayList of type String using the default constructor -
		// since we're creating an instance of an object, we have to add the parentheses (), even though we aren't passing it
		// any variables.
		
		// Now that we've created our String ArrayList, we can start populating it.
		// Let's make a few strings.
		String hello = "Hello";
		String comma = ", ";
		String world = "world";
		String exclamation = "!";
		
		// Now, we'll put those Strings into our ArrayList!
		// If we use the .add() method from the ArrayList class, we'll be adding a new String to the *end* of the ArrayList.
		stringsList.add(comma);
		
		// Our ArrayList now contains one element, which is our 'comma' string.
		// Let's put the 'world' String after it.
		// We can do this by just using the .add() method again,
		// as it always adds the given element to the end of the ArrayList.
		stringsList.add(world);
		
		// Our ArrayList now contains two elements, which are 'comma' and 'world'.
		// Let's put the 'hello' String at the beginning.
		// We can do this by just using the .add() method again,
		// but this time, we'll tell the computer where in the list we want to put our string
		// by specifying an index. Since index 0 is the beginning of the list, we'll use 0.
		stringsList.add(0, hello);
		
		// Awesome! Now, our list contains 'hello', 'comma', and 'world', in that order.
		// Let's go ahead and add on the exclamation point string:
		stringsList.add(exclamation);
		
		// Now we want to print out the strings in our list, in order.
		// We could just use a regular for loop to do this, and the .get(int index) method from the ArrayList class,
		// which returns the element at the specified index of the ArrayList (similar to how myArray[int index] works for arrays),
		// but we'll need to know exactly how many Strings are in our ArrayList to avoid errors. In this case,
		// we know that we have exactly 4 Strings stored in our ArrayList, so we'll use this method first.
		for( int index = 0; index < 4; index++){
			// Here, we'll use the System.out.print() method, which is a lot like System.out.println(),
			// but it doesn't hit the enter key after each time it prints.
			System.out.print(stringsList.get(index));
		}
		
		// Now, we just printed everything using the System.out.print() method, so if we want to print again,
		// we should probably hit the enter key so we can start on a new line. We can do this by
		// printing the computer's 'newline' character, which in most programming languages is specified by
		// the character '\n'. This means that the String "\n" represents the same new-line behavior as
		// when you hit the enter key. Let's print one of those:
		System.out.print("\n");
		
		// Now, if we didn't know how many Strings we had in our ArrayList, there's another method we can use to find out:
		// The ArrayList.size() method returns the number of elements in the ArrayList, just like array.length did for arrays.
		// Let's use that in our for-loop's comparison statement:
		for(int index = 0; index < stringsList.size(); index++){
			// See it there? 'index < stringsList.size()'. That way, we can grab the size without knowing
			// how many elements are in the array, and use it in our for-loop.
			// The downside to this is that it slows down processing speed - every time the for-loop finishes an iteration and
			// goes back to check if it should keep looping, it has to query the ArrayList for its size, and the ArrayList
			// has to go back and count how many elements it has. This is inefficient, so next we'll look at a better way to do this.
			System.out.print(stringsList.get(index));
		}
		// Again, we'll print a newline character.
		System.out.print("\n");
		
		
		// There's actually another type of for-loop we haven't looked at yet.
		// So far, we've only looked at for-loops that count up using an integer as an iterator.
		// The other type of for-loop looks like this:
		for(String s : stringsList){
			// This type of for-loop iterates through a 'collection' of the same data type - in this case, stringsList - so you can
			// use it with arrays and ArrayLists. Here, it basically says "For each String in the collection stringsList,
			// call that String s and run this block of code on it, then move on to the next String in the collection."
			// So this for-loop grabs the first String in the collection stringsList,
			// calls it 's', then executes the code block, plugging the value of the first String in the collection in
			// everywhere it sees the variable 's' in the code block. It then moves onto the next String in the collection,
			// calls that one 's' temporarily, executes the code block on that second String, and moves on, repeating the code block
			// for each String in the specified collection, in order.
			// This for-loop should, therefore, look at the first String, print it, then move onto the next one,
			// do the same for that String, etc. until it has done so for every element in the collection stringsList.
			System.out.print(s);
		}
		// Since the println method is really just the print method plus a "\n", if we don't
		// give it a string to print, it will act just like System.out.print("\n");
		// 		What I'm really saying there:
		//				The following two lines of code are equivalent:
		//						System.out.println();
		//						System.out.print("\n");
		//				and these next two lines are also equivalent to one another:
		//						System.out.print("Hello, world!\n");
		//						System.out.println("Hello, world!");
		System.out.println();
		
		// Anyway, now that you know how to add stuff to an ArrayList and read from an ArrayList,
		// let's take a look at a few more functions:
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		for(int i = 0; i < 20; i++){
			// Now we'll do some work with random numbers.
			// The Math.random() method returns a random float whose value is between 0.0000000000 and 0.99999999999.
			// If we want to fill this list with integers of random value, between 1 and 20,
			// we'll have to use the random() method, plus a little bit of ingenuity.
			// If Math.random() gives a number between 0 and 0.9999, then if we multiply it by 20, we should get a number between
			// 0.00000 and 19.9999999. If we round that number to the nearest integer, we should get
			// an integer between 0 and 20.
			// But we wanted our number to be between 1 and 20, not 0.000000 and 19.999999.
			// So instead, let's multiply our random nuber by 19, then round it and add 1.
			// That should give us a random number between 1 and 20.
			// Since the Math.round() function returns the data type 'long' (which is just an integer, but with more data allocated
			// so it can store larger integer values), we'll need to cast it to an int before we can add it to our list.
			int myRandom = (int) (1 + Math.round(19*Math.random()));
			
			// Add this number to the list, then let the code block of the for-loop end.
			intList.add(myRandom);
		}
		
		// Awesome. That should have added 20 random numbers to the list!
		// Let's print it, just to check:
		for(int i : intList){
			System.out.print(i+" ");
		}
		System.out.println();
		
		// Now, let's sort it from least to greatest.
		// This is going to be your first challenge question:
		// Take this list, and put it on order from least to greatest, then print it.
		// These might be important:
		
		// you can add something to a specific index in the list, right?
		intList.add(5,21);
		
		// Well, you can also remove something at a specific index:
		intList.remove(5);
		
		// Now, take a swing at this challenge question. It's a really difficult question,
		// so don't beat yourself up if you can't solve it. Even exploring the ideas for a bit before
		// reading the solution will help you develop your programming-oriented problem-solving skills.
		
		/**		
  				◊========================================◊
 				∏		  CHALLENGE QUESTION 2.1		 ∏
 				‡========================================‡
    			∏  Take the 'intList' ArrayList and sort ∏
   				∏  through it to create a new ArrayList, ∏
   				∏  named orderedList, where all of the	 ∏
   				∏  integers in intList are sorted from	 ∏
   				∏  least to greatest (starting with the  ∏
   				∏  lowest-value integer at index 0, the  ∏
   				∏  next-lowest at index 2, and so on).	 ∏
   				∏  										 ∏
   				∏  (Hint: the line 'break;' tells a for- ∏
   				∏  loop to exit and not finish looping.) ∏
    			◊========================================◊
		 **/
		
		/* WRITE YOUR CODE FOR THE CHALLENGE QUESTION BELOW. */
		
		
		
		
		
		
		
		
		
		
		
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		
		
		
		/** PART 2 : SORTING */
		
		/*	We now know how to use the basic functions of ArrayLists. You (hopefully) tackled the challenge question and came up
		 * 	with a way to sort an ArrayList of integers from least to greatest. There's actually a super simple
		 *  convenience method made to do this for you, and it's part of the standard Java libraries.
		 *  
		 *  That's the .sort() method in the Collections class.
		 *  The .sort() method will order an ArrayList of integers from least to greatest,
		 *  or put an ArrayList of Strings in alphabetical order.
		 *  The syntax is pretty simple:
		 *  
		 *  Say we have an ArrayList of integers named intList.
		 *  They're all out of order, and we want them in order.
		 *  
		 *  The syntax for the sorting method looks like this:
		 *  
		 *  Collections.sort( Collection c );
		 *  
		 *  so for our case, we would write
		 *  
		 *  Collections.sort( intList );
		 *  
		 *  Here, we're telling the computer to find the 'Collections' class file,
		 *  find the .sort() method within that file, and run that method on our collection, intList.
		 *  
		 *   The reason that this works for an ArrayList, even though the syntax for the .sort() method asks for a 'Collection',
		 *   is because of a property called inheritance. We'll get into that a little later, but for now, just know that
		 *   the ArrayList class is defined as an 'extension' of the Collection class, sort of like Collection is the genus and
		 *   ArrayList is a species in that genus. So the .sort() method works for anything in the 'Collection' genus, which
		 *   means you can throw an ArrayList at it and it will work, because the 'ArrayList' class "inherits" all the properties of
		 *   the 'Collection' class by 'extending' it. The word 'extend' is used here to mean 'further define and specify'.
		 *   
		 *   You can sort things any number of ways - you could write a method similar to the challenge question that
		 *   orders integers from highest to lowest, or put things in reverse alphabetical order, or order things by
		 *   color, or smell, or texture, or whatever, but you have to define the properties that you want to order them by,
		 *   and you have to write the algorithm for ordering them - you could assign each color a number, or write an algorithm that
		 *   parses color names and orders them by wavelength, or cast the Strings to integers and order them least to greatest that way.
		 *   It's all up to you and your program's needs, and writing sorting algorithms is an important skill in programming, albeit
		 *   less useful than learning how to structure your data well using objects and methods.
		 *   
		 *   That's really all I have left to say about sorting, so let's move on to Chapter 2, Part 2: Reading User Input.
		 *   
		 * */
		
		
	}
	
	
}
