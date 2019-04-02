/**
 * @author Ciaran Eli Dorland
 * 
 * Part of a series of Java tutorials.
 * Intended for use with Eclipse or your favorite Java IDE.
 */

package Chapter3;

public class Part1_TheSwitchStatement {
	/*	
		This is gonna be a really quick section.
		All we're going to cover here is the switch statement.
	*/
	
	/**		SECTION 1 : THE SWITCH STATEMENT	**/
	
	// I've gotta make a main method just so I can write out an example.
	public static void main(String[] args){
		
		/*
			Switch statements are pretty straightforward.
			They're basically shorthand for a bunch of if-else statements in a row.
			Every switch statement switches on a single variable or equation.
			You can switch on integers, longs, characters, Strings, and booleans (and boolean expressions),
			but not on floats or doubles (not sure if we've talked about doubles yet - 
			they're just like floats, except they can be a lot bigger, just like 
			longs can hold larger values than integers).
			
			I usually switch on integers and Strings.
			Although you can technically switch on booleans and boolean expressions,
			it's a bit pointless. You'll see why in a second.
			
			Say we have a method called myFunction() that performs an operation
			and returns an integer based on the success of that operation.
			myFunction() returns 0 if the operation worked, 1 if it failed because of human error,
			2 if it failed because of a machine error, or 3 if it failed due to an unknown error.
			We could do something like this to handle the errors:
			
				int result = myFunction();
				
				if (result == 0){
					System.out.println("Success!");
				}
				else if (result == 1) {
					System.out.println("Error code 1: PEBKAC. Please recalibrate wetware.");
				}
				else if (result == 2) {
					System.out.println("Error code 2: Machine error. Please recalibrate sensors.");
				}
				else {
					System.out.println("An unknown error occurred. Please try again in a few minutes.");
				}
			
			but that's pretty inefficient. It's also not sexy.
			
			You know what's sexy?
			
			Switch statements.
			
			A switch statement can be used in a situation like this to 'switch' on the value of the int result,
			printing out something different for each case.
			
			Let's take a look at the syntax:
			
		 */
		
		int variable = (int) Math.round(Math.random() * 3);

		switch (variable) {

		case 0:
			System.out.println("Success!");
			break;

		case 1:
			System.out.println("Error code 1: PEBKAC. Please recalibrate wetware.");
			break;

		case 2:
			System.out.println("Error code 2: Machine error. Please recalibrate sensors.");
			break;

		default:
			System.out.println("An unknown error occurred. Please try again in a few minutes.");
			break;

		}
		
		/*
			Okay, that's your first look at it. Let's break that down:
			
			
				int variable = (int) Math.round(Math.random()*3);
				
			This line here just gives us a random int between 0 and 3, inclusive.
			
			
			
				switch	(variable) {
				
			Here, we're telling the computer that we want to switch on the value of our integer, 'variable'.
		
			
			
				case 0: System.out.println("Success!");
				
			A case statement is the equivalent of saying "If the variable is equal to this, do this thing."
			Here, we're saying "If the value of the integer 'variable' that we're switching on is
			equal to 0, print out a message that says "Success!".
				
				
				
				break;
				
			This right here is a break statement. We know this exits loops. It also exits switch statements.
			Without this break statement, the computer would actually move onto the next case and 
			execute the code there as well. We'll take a look at that in a second.
			
			
			
				default: System.out.println("An unknown error occurred. Please try again in a few minutes.");
			
			This is the default case statement. It activates if the value of your variable isn't covered by the 
			other case statements. You don't need a default case, but it's good practice to use one unless
			you specifically want to ignore a large range of possible values for your variable and not respond
			to them at all.
			
			So wait, what happens if we leave out break statements?
			Let's take a look.
			
			Say we have a String that represents a friend telling us what color his new car is.
			We want to respond positively if it's a color that we like, and negatively if it's a color we don't like.
			This is really straightforward to do with a switch statement:
			
		 */
		
		String color = "orange";
		int coolnessPoints = 0;

		switch (color) {
		
		case "orange":
			coolnessPoints += 4;
		case "purple":
			coolnessPoints += 3;
		case "green":
			coolnessPoints += 3;
			System.out.println("Respect. " + coolnessPoints + " coolness points.");
			break;

		case "yellow":
			coolnessPoints-=2;
		case "brown":
			coolnessPoints--;
			System.out.println("Yuck! " + coolnessPoints + " coolness points.");
			break;

		case "black":
			coolnessPoints++;
		case "red":
			coolnessPoints++;
			System.out.println("Classic. " + coolnessPoints + " coolness points.");
			break;
		default:
			System.out.println("Hm.");
		}
		
		/*
			Try changing the color on this and running the program. You should quickly see that,
			when you don't include break statements between cases, the cases that don't include break statements
			will just propagate on downward.
			This means that for the above code, having an orange car earns you 10 coolness points,
			having a yellow car earns you -3 coolness points, etc.
			
			That's basically it. Switch statements are awesome and useful and I'm pretty mad that it took me
			a little over 5 years to find out about them.
			
			Go on and head into Chapter 3, Part 2: Objects and Inheritance.
		 */
		
	}
	
}
