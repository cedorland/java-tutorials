/*
 Here, we'll take a look at the basic parts of a Java file,
 the primitive data types, some basic work with Strings,
 the mathematical and comparative operators, and
 the basics of using methods in your code.
 */


// This is a package declaration. It's not super important right now --
// it's only really important when you want to use part of this code
// from another piece of code that's in a different package. We'll
// go over scope to cover that.
package Chapter1;

// This is a comment. By putting the double slash in front of some words,
// the compiler (which converts this code into computer language) ignores
// the rest of that line of code.

/* This is a multi-line comment.
   The compiler will ignore all the words between
   the slash-asterisk combination marks. */

// This is a class declaration. A class is a single program file. We've given it the name 'BasicJavaPart1', and if
// we want to run it from another program, we'll use that name, Driver, to do so. The word 'public' is
// syntax denoting the *scope* of the class - public means that this class can be accessed from any other file.
// We'll take a look at that later.
public class Part1_BasicJavaSyntax {

	// These are a few of the primitive data types. They're the fundamental building blocks of Java programming.
	
	// 'int' denotes an integer - it can be positive or negative,
	// but can only be a whole number, like 5, -12, 27004, etc.
	// Note that the names can be pretty much whatever you want them to be, but you can't give two
	// variables the same name. Below, the variables are 'instantiated', which means, for example,
	// you're telling the computer that you're going to be using a variable named 'x', it's going to be an integer,
	// and to save some space for that integer in memory. It doesn't have a value yet.
	// Note that the statement ends with a semicolon; this is true of all statements in Java.
	int x;
	
	// This is a float, which is a 'floating point number'. This means it holds a decimal place.
	// Floats can have values like 1.220445, 167.25, -312.14, etc.
	float y;
	
	// This is a char, or character. It's used to store single text characters, like '0', 'L', 'a', '$', etc.
	// We'll save it as an exclamation point. Giving a variable its first value like this is called 'initializing' it.
	// Note that the exclamation point is held between two single-quotes - this is how characters are written.
	char myCharacter = '!';
	
	// This is a boolean. It takes up a single bit in memory, so it can only have two values: true or false.
	// We'll set it to true for now.
	boolean trueOrFalse = true;
	
	// This is a variable which isn't a primitive data type. It's a String, and it holds a string of characters.
	// The String is an object, which means it's defined not by the computer like primitive data types are,
	// but instead, it's defined by another piece of code that someone wrote. It has its own class file.
	// You can create your own objects in the same way and use them in your code. Note that all of the
	// primitive data types are lower case, while String is always capitalized. Also note that the primitive
	// data types show up purple when you type them in, while String doesn't. This is because it isn't
	// standard Java syntax. String is probably the most commonly used object.
	// Note that its value is held between double-quotes. This is how you store Strings.
	String myString = "Hello, world";
	
	//Now that we've instantiated some variables, i.e. told the computer we're going to be using an instance of
	// this data type with this name (e.g. String myString), let's manipulate them.
	
	/** This piece of code is called a method, and it acts like a function in math - these are
	 * the fundamental building blocks of code. You give it a scope (public),
	 * a return type (in this case 'float', which means it will return a floating-point number),
	 * a name that you'll use to call it, which usually describes what it does ('DivideByTwo' in this case),
	 * and then you throw some round brackets on there. If you want to be able to pass input variables
	 * into the method, you state them between these round brackets. Here, we're only taking in one variable,
	 * so we write 'float toDivide', which tells us the data type of the input variable and the name we'll use
	 * for it inside the method.
	 * We have to add the word 'static' so that we can access it from the main method later on. I'll define
	 * what this means in a second.
	 *  */
	public static float divideByTwo(float toDivide){
		//Inside the method, we perform some operation on the input variables, and then return a value.
		//We'll look how this gets used in a second.
		
		// Here, 'float inputDividedByTwo' is declaring a new variable of type 'float' and with the name 'inputDividedByTwo'.
		// The equals sign means we're assigning the following value to this new float.
		// The value we're giving it is our input variable 'toDivide', which we took in at the top of the method,
		// divided by two.
		float inputDividedByTwo = toDivide / 2;
		
		// This is a return statement. It ends the method, returning the value that follows it.
		// Whatever piece of code called the method will be given this value when the method returns, or finishes.
		return inputDividedByTwo;
	}
	
	/** This is the main method. It gets run when you run the program. It's recognized by the compiler and must always
	 * be named 'main' (all lower case), have a scope of 'public' (so that it can be run from outside of this file), and
	 * it always needs to be 'static' - this keyword means that there's only one of it on the computer at any given time.
	 * We'll look into that later.
	 * Its return type is 'void' - this means that it doesn't return any values at all.
	 * It takes in a variable: a String array named 'args'. This isn't important right now - we'll come back to
	 * what an array is, how you use it, and why the main method has to take in a String array a bit later. */
	public static void main(String[] args){
		// The main method is where the actual program happens. Everything in the main method gets run when you run the program.
		
		// First, let's set up some variables.
		boolean iAmProgramming = true;
		String toPrint = "I ";
		
		// This is called an 'if statement'. *If* what's inside the round brackets is true, then all of the code
		// inside the squiggly brackets gets executed. Otherwise, it all gets skipped.
		if(iAmProgramming){
			// Here, we're taking the String toPrint and adding on a few extra letters.
			// Note that we're assigning a value to toPrint which includes the old value of toPrint.
			// Although you can't do this in math, it's totally fine in programming.
			// We're saying "Give the variable named 'toPrint' the following value:
			// whatever the old value of 'toPrint' was, followed by the String 'am'."
			toPrint = toPrint + "am";
		}
		
		// Here's an integer named 'number'. We'll give it a value of zero.
		int number = 0;
		
		// Here's another if statement. Here, we're comparing the value of 'number' to another value:
		// While the single-equals sign is the 'assignment' operator (i.e., it says "give that variable this value"),
		// a double-equals sign checks whether two things are equal and returns a boolean.
		// I call it the 'check-equals' sign. If the two things are equal, it gives the value 'true'; otherwise, it gives 'false'.
		// That means that this section of code only executes if the integer 'number' has the value 0.
		if( number == 0 ){
			
			// This is the 'plus-equals' operator. This line of code is equivalent to the statement
			// toPrint = toPrint + " programming.";
			// The plus-equals operator says "add whatever comes next to this variable's value". For example,
			// if we were to say 'number += 5', number would get 5 added onto it, as if we had said 'number = number + 5'.
			// Here, we're saying 'Add the String " programming" onto the end of toPrint's value'.
			toPrint += " programming";
		}
		// This is an 'else' statement. It can come directly after the end of an if-statement's code block, and
		// it only executes if the if-statement's code block doesn't get executed. Together, the if- and else-statements form
		// an 'if-else statement', and they work as though you're telling the computer
		// "if this is true, do this first thing, but otherwise, do this other thing instead."
		else {
			toPrint += " not programming";
		}
		
		/* Here are all of the operators:
		  
		 =	: Assignment operator. Sets the variable on the left equal to what's on the right.
		 	  'x = 5' is a valid statement, while '5 = x' is not.
		 	  
		 ==	: Check-equals operator. Checks whether two values are exactly equal to each other, returning either 'true' or 'false'.
		 
		 *	: Multiplication operator. This one's straightforward. It multiplies two things.
		 		Example:
		 			int x = 5 * 4;
		 		The value of x is now 20.
		 			int x = 5;
		 			int y = 6;
		 			int z = y * x;
		 		The value of z is now 30.
		 		
		 /	: Division operator. Works just like the multiplication operator, but is used for division.
		   		Example:
		  			int x = 50 / 10;
		 		The value of x is now 5.
		 		
		 +	: Addition operator. Works just like the multiplication operator, but is used for addition.
		    	Example:
		  			int x = 5 + 3;
		 		The value of x is now 8.
		 		
		 -	: Subtraction operator. Works just like the multiplication operator, but is used for subtraction.
		    	Example:
		  			int x = 7 - 4;
		 		The value of x is now 3.
		 
		 +=	: Plus-equals operator. Adds the value on the right to whatever was on the left.
		 	  	Example: 
		 	  		int x = 5;
		 	  		x += 4;
		 	  	The value of 'x' is now 9.
		 	  
		 -=	: Minus-equals operator. Subtracts the value on the right from whatever was on the left.
		 	  	Example: 
		 	  		int x = 5;
		 	  		x -= 4;
		 	  	The value of 'x' is now 1.
		 	  	
		 *=	: Times-equals operator. Multiplies whatever's on the left by whatever's on the right.
		 	  	Example: 
		 	  		int x = 5;
		 	  		x *= 4;
		 	  	The value of 'x' is now 20.
		 	  	
		 /=	: Slash-equals operator. Divides whatever's on the left by whatever's on the right.
		 	  	Example: 
		 	  		int x = 10;
		 	  		x /= 2;
		 	  	The value of 'x' is now 10.
		 	  	
		 !	: Inversion operator. This flips a boolean value to the opposite value.
		 		Example:
		 			boolean myBool = false;
		 			if( !myBool ) { Do a thing }
		 			When checking '!myBool', the value reads as the opposite of whatever the value of 'myBool' is.
		 			In this case, since myBool is false, !myBool is true.
		 			
		 !=	: Inverted check-equals operator. This works like a combination of the ! and == operators.
		 		It inverts whatever's on the right, then applies the == operation.
		 		Examples: 
		 			The statement
		 				oneBoolean != anotherBoolean
		 			is equivalent to the statement
		 				oneBoolean == !anotherBoolean
		 			and whereas the statement
		 				x == 5
		 			returns true only if the value of x is 5, and false whenever x doesn't equal 5, the statement
		 				x != 5
		 			returns false only if the value of x equals 5, and true whenever x isn't equal to 5.
		 
		 ++	: Increment operator. Adds one to a value.
		 		Example: 
		 			int x = 5;
		 			x++;
		 		The value of x is now 6.
		 		It's important to note that you can use this operator within other statements:
		 			If you were to say 
		 				if( x++ == 6 )
		 			then that if-statement would check if x was equal to 6, and then it would add one to the value of x.
		 			If you were to put the double-plus before the x instead of after it, like so:
		 				if( ++x == 6 )
		 			then the computer would add one to the value of x and then check if x equals 6.
		 			Let's check it out again real quick:
		 			
		 			int x = 5;
		 			
		 			if( x++ == 6 ) { Do a thing; }
		 			
		 			Here, the if-statement checks if x is equal to six, then adds one to it. This if-statement wouldn't execute,
		 			as it says "Does 5 equal 6?", then it adds one to x. The value of x at the end of that code is 6.
		 			How about this way:
		 			
		 			int x = 5;
		 			
		 			if( ++x == 6 ) { Do a thing; }
		 			
		 			Here, the value of x gets incremented by 1: x now equals six. Then, the if-statement checks if x equals 6,
		 			so in this case, the code block following the if-statement does get executed.
		 			
		 --	: Decrement operator. Acts just like the ++ operator, but instead of adding 1, it subtracts 1.
		 		Note:
		 			The before/after behavior of the ++ and -- operators make them act like this:
		 				if( x++ == 6 )
		 			is the same as 
		 				if( x == 6 ){ x += 1; Do a thing; }
		 				else { x += 1; }
		 			while
		 				if( ++x == 6 )
		 			is the same as 
		 				x += 1;
		 				if( x == 6 ) { Do a thing; }
		 				
		 <	: Less-than operator. It's like the == operator, but it returns true if one thing is strictly less than another thing and false otherwise.
		 		Example:
		 			int x = 6;
		 			if( x < 7 ){ This code would execute because x is 6, which is less than 7. }
		 			
		 			int x = 6;
		 			if( x < 6 ){ This code would *not* execute, because x is 6, which isn't less than 6. }
		 
		 >	: Greater-than operator. It's like the less-than operator, but for greater-than.
		 		Example:
		 			int x = 6;
		 			if( x > 5 ){ This code would execute because x is 6, which is greater than 5. }
		 			
		 			int x = 6;
		 			if( x > 12 ){ This code would *not* execute, because x is 6, which isn't greater than 12. }
		 
		 <=	: Less-than-or-equal-to operator. It's like the less-than operator, but it also returns true if the two things are equal.
		 		Example:
		 			int x = 6;
		 			
		 			if( x < 6 ){ This code would NOT execute, because x is 6, which is NOT less than 6. }
		 			
		 			if( x <= 6 ){ This code WOULD execute, because x is 6, which IS less than or equal to 6. }
		 			
		 >=	: Greater-than-or-equal-to operator. It's like the greater-than operator, but it also returns true if the two things are equal.
		 		Example:
		 			int x = 10;
		 			
		 			if( x > 10 ){ This code would NOT execute, because 10 is NOT greater than 10. }
		 			
		 			if( x >= 10 ){ This code WOULD execute, because x is equal to 10. }
		 			
		 %	: Remainder operator. This is one of the most important things to understand about math in Java.
		 		When you divide one integer by another integer, the result is always an integer.
		 		What happens if you divide 5 by 2, though? It can't return 2.5, as that isn't an integer!
		 		Integer division always rounds down - this means that 5 / 2 = 2 in java, even though 5.0 / 2.0 = 2.5.
		 		Although at first this might seem dumb, it can be extremely useful.
		 		The remainder operator returns the remainder of such a division: 5 / 2 = 2, with a remainder of 1.
		 		It's used like any of the other arithmetic operators, and you can only use it on integers:
		 		5 % 2 = 1.
		 		12 % 7 = 5, as there's only one complete 7 in 12, so 12 - 7 = 5 is the remainder.
		 		This is also called the modulus operator, and it's really useful: for example,
		 		if you had a counter going from 1 to 100, and you wanted to do something special every time your counter
		 		landed on a multiple of three, you could use ( counter % 3 == 0 ) to check, as the remainder would
		 		only be zero if counter was a multiple of three!
		  */
		
		// Now, we're going to use that method we made before - the one called 'divideByTwo'.
		// First, we need to make a floating-point number. We have to add a lower case 'f' to the end of the value
		// so that the computer knows that it's a float.
		float myNumber = 10.0f;
		
		// Next, we're going to call our method.
		// Here, we're saying that we want to set the value of 'myNumber' to whatever gets returned by our method,
		// and we're also passing in the current value of myNumber to the method divideByTwo.
		// When this line of code is reached, the computer jumps to the part of the code where we defined what 
		// divideByTwo does, and starts executing that code. If you don't remember exactly what's going on here,
		// jump back up to line number 69.
		myNumber = divideByTwo(myNumber);
		
		// At this point, the value of myNumber should be 5.0.
		// It's important to note that operations using floats aren't perfectly accurate,
		// so its value could be 5.000000000001 or 4.9999999998 or something.
		// This means that you can't use the == operator to check if two floats are equal, as one could be
		// 5.000000000001 and the other could be 4.99999999998 even though you performed the same
		// operations on them. If you want to compare floats, you have to decide how accurately you want to
		// compare them, then round them to that decimal place before checking if they're even.
		// Let's say we want to check if our method worked, but we only care about whether it's accurate to the first
		// 5 decimal places, or 5.00000:
		
		// First, we'll make a new number and try to make it the same:
		float secondNumber = 10.0f / 2;
		
		// Next, we'll multiply it by 100,000 and round it to a while number.
		// The words 'Math.round' mean we're calling a method named 'round' in another class file named 'Math'.
		// This is part of Java's standard library of functions.
		// We're going to pass in the value that we want to round, and accept the value that the method returns
		// into our new integer named 'roundedSecondNum'.
		int roundedSecondNum = Math.round(secondNumber*100000);
		
		// Let's repeat this for the first number:
		int roundedFirstNum = Math.round(myNumber*100000);
		
		// Now, if we check if they're equal, we're seeing if the first 5 decimal places match!
		if( roundedFirstNum == roundedSecondNum ){
			// Let's add a period onto the end of this String for good measure.
			toPrint += ".";
		}
		
		// Next, we're going to print our String to the system's output console.
		// Here, we're calling the method printString, and passing it a variable, the String we named 'toPrint'.
		// This method is defined below. Note that this method has a return type of 'void', so we don't need
		// to collect any information from it like we did with the other methods.
		printString(toPrint);
		
		// This is the end of our 'main' method. Since the main method has the return type 'void', we don't need a return statement.
		// The whole program will end when it reaches the next curly brace, which marks the end of the 'main' method's
		// code block.
		
	}
	
	/** This method is public, so it can be seen from outside of this file, it's static, so it can be accessed from other
	 * static methods like the 'main' method, and its return type, the type of data it returns, is 'void'. This
	 * means that it doesn't need a return statement - it ends as soon as its last line of code is reached. */
	public static void printString(String myString){
		// Here, we're calling the method 'println' from the Java standard libraries. This method
		// prints the string you give it to the system's standard output console.
		System.out.println(myString);
	}
	
}
