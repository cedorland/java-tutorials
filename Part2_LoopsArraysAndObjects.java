package Chapter1;

/*
 Here, we'll take a look at while loops, followed by a look at for loops.
 After that, we'll take a look at arrays and using them to store stuff.
 Finally, we'll take a look at creating an object to store data, and using it to keep track of stuff.
 */

public class Part2_LoopsArraysAndObjects {
	
	public static void main(String[] args){
		
		/** SECTION 1 : LOOPS */
		
		int a = 1;
		
		// This is a while loop. When this line of code is reached, the computer checks if the statement inside
		// the round braces is true. If it is, the computer will run the code inside the while loop's code block.
		// When it reaches the end of the while loop's code block, it goes back and checks the while loop's conditional statement again.
		// If the statement is still true, it will execute the code block inside the while loop again.
		// It will keep doing this, looping through the while loop's code block, until the loop's conditional statement
		// is no longer true. What do you think will be output by this code?
		while(a < 10){
			System.out.println(a);
			a++;
		}
		
		// This is a for loop. It's a lot like a while loop, but it's got built-in start and end points.
		// The for loop gets an 'incrementor variable', a conditional statement, and an incrementation statement.
		// The following code does the exact same thing as the while loop above:
		for ( int y = 1; y < 10; y++ ){
			System.out.println(y);
		}
		// Breaking down that for-loop statement:
		// "int y = 1;"
		//		- This for-loop's incrementor variable is y, and it's initially set to 1. 
		// "y < 10;"
		//		- The for-loop will act the same as if you had said "while( y < 10 )"
		// "y++"
		//		- Every time the computer reaches the end of the for-loop's code block, it will add one to y before
		//			checking if the conditional statement, "y < 10", is still true.
		// 
		// You can actually use the for loop just like a while loop by leaving the incrementor variable declaration 
		// and incrementation statement blank:
		// for( ; x < 10; ) is functionally identical to while( x < 10 ).
		
		// Notice that we said "while x is LESS THAN 10". This means that when x reaches 10, the while loop won't execute,
		// and so the number 10 never gets printed to the console.
		// If, instead, we had said while(x <= 10), i.e. "while x is LESS THAN OR EQUAL TO 10", the number 10 WOULD get printed.
		
		// Anyway, have some fun and try answering this challenge question!
		// Remember that a for-loop checks its conditional statement before running each loop,
		// and only increments its incrementor at the end of the code block.
		
		/**
		    		◊========================================◊
		 			∏		 CHALLENGE QUESTION 1.2.1		 ∏
		   			‡========================================‡
		 			∏  Without running the code, what would  ∏
		 			∏									     ∏
		 			∏	  for(int z = 0; z <= 10; z++){	     ∏
					∏		  z+=3;						     ∏
		 			∏		  System.out.println(z);		 ∏
		 			∏	  } 								 ∏
		 			∏									     ∏
		 			∏  print to the console?				 ∏
		 			◊========================================◊
		 **/
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		
		
		/** SECTION 2 : ARRAYS */
		
		/* An array is a collection containing multiple instances of an object or data type, all lined up like books on a shelf.
		 * Arrays are used to conveniently store and access a bunch of the same type of information, like the temperatures
		 * for each day of a week or the names of all the people in a club, etc.
		 * 
		 * When you create an array, you have to give it a name, tell the computer what data type it's going to store,
		 * and tell the computer how many spaces it will contain for holding objects.
		 * The syntax for instantiation looks like this:
		 * 
		 * float temperatures[];
		 * 
		 * This is similar to saying,
		 * "This array stores floats, and it's called temperatures." 
		 * The square brackets indicate that this is an array of floats instead of a single float.
		 * 
		 * When instantiating an array, you can either initialize it with a set of values, like this:
		 * 
		 * float temperatures[] = {55.3, 60.9, 68.4, 77.2, 67.1, 59.5, 61.8};
		 * 
		 * which tells the computer that this array has exactly 7 values, and these are those values
		 * 
		 * OR you can leave the spaces blank so you can add values later:
		 * 
		 * float temperatures[] = new float[7];
		 * 
		 * This is similar to saying,
		 * "This array stores floats, it's called temperatures, and it will have seven spaces." 
		 * 
		 * Accessing arrays is pretty straightforward: when you want to grab the data from a single space in the array,
		 * you treat it like any other variable, but you add square brackets to the end
		 * with the index number of the space you want to access, like this:
		 * 
		 * float x = temperatures[5];
		 * 
		 * That will grab the value at index 5 of temperatures and copy that value into x.
		 * The first space in an array has index 0. This is because all of the values in the array are stored
		 * right next to each other in memory, and the way that the compiler accesses their values is by
		 * navigating to the beginning of the array, and then moving over by one space in the array for each number 
		 * inside the square brackets. When you tell it to move over 0 spaces, it will read from the beginning of the array,
		 * and when you tell it to move over 5 spaces, it will start at the beginning of the array, then move over 5 spaces
		 * and land on the sixth value stored in the array.
		 * 
		 * The means that for
		 * 
		 * float temperatures[] = {55.3, 60.9, 68.4, 77.2, 67.1, 59.5, 61.8};
		 * float x = temperatures[5];
		 * 
		 * the value of x will be 59.5.
		 * I always just count from 0 to make sense of this, and instead of saying 'the first index in the array' for the first value,
		 * I say 'the zeroth index in the array' for the first value stored in memory.
		 * You'll get used to it, and it's actually really useful when you start for-loops at zero and use the less-than symbol, '<',
		 * instead of starting at 1 and using the less-than-or-equal-to symbol, '<='.
		 * 
		 * Let's mess around with arrays a little bit.
		 * 
		 * */
		
		// Here, we'll create an array of floating point numbers for the temperatures:
		float temperatures[] = new float[7];
		
		// And we'll use a for-loop to populate it, with the temperature rising steadily throughout the week:
		for(int index = 0; index < 7; index++){
			// Here, we're accessing each index of the array using our incrementor, 'index', as index goes from 0 to 6.
			// We're setting the value of each day to 55.0 plus 2.73 times the current value of index.
			// This means that Monday will start off at 55.0 degrees, and each day after that will increase by 2.73 degrees.
			temperatures[index] = 55.0f + (2.73f * index);
		}
		
		// So we just set the indices of the array. Next, let's print out the values to the screen:
		for(int index = 0; index < 7; index++){
			System.out.println(temperatures[index]);
		}
		
		// Those are the basics of arrays. It's also possible to create multi-dimensional arrays:
		// you do so by making an array of arrays! Let's look at syntax for those:
		String[][] chessBoard = new String[8][8];
		
		// We've just created an 8x8 array that holds Strings. Accessing the array is similar:
		// We'll put one for loop inside another for loop to move through each space.
		// This for loop moves through the x-values of the board
		for(int x = 0; x < 8; x++){
			// And for each x-value of the board, this loop moves through each y-value of the board!
			for(int y = 0; y < 8; y++){
				// Here, we're saying "If (x+y) is an even number, make the space black. If it's odd, make the space white."
				if((x+y)%2==0){ 
					chessBoard[x][y] = "black";
				} else {
					chessBoard[x][y] = "white";
				}
				
			}
		}
		
		// Now, if you want to print from it, access it the same way:
		for(int x = 0; x < 8; x++){
			
			// Let's make a blank String so we can fill it later:
			String toPrint = "";
			
			for(int y = 0; y < 8; y++){
				// Now, if the space we're on is black, add '#' to the String.
				// If it's white, add 'O' to the String.
				// Because Strings aren't numbers, we can't just use the == operator to check if two Strings
				// are the same. Instead, we call a method in the String class called 'equals'.
				if(chessBoard[x][y].equals("white")){
					toPrint += "O ";
				} else if(chessBoard[x][y].equals("black")){
					toPrint += "# ";
				}
				// That 'else if' statement above is like saying else and then putting an if-statement inside of the 'else' code block.
				// It says, "If this first thing is true, do this stuff, but if not, check if this other thing is true and do this stuff."
			}
			// Now that we've gone through all of the spaces in this row (x) of the array,
			// print out our String!
			System.out.println(toPrint);
		}
		
		// One last note, because it will come in handy for the challenge question:
		// 'casting' is used to convert one data type directly to another data type.
		// It tells the computer that even though the data stored in that particular spot in memory
		// has one data type, you want to read it as though it's another data type.
		// This is useful in a number of situations, but you probably won't use it much
		// for a few years. The syntax looks like this:
		
		// 		int roundedToAnInteger = (int) Math.round(12.52);
		
		// This basically says that no matter what data type the Math.round() method returns,
		// we're going to read its location in memory as though it were an int
		// and we'll copy that value that we read to the memory location where the value of
		// 'roundedToAnInteger' is stored. You can get some crazy results trying to
		// cast Strings as integers or floats, because you'll basically be grabbing
		// a chunk of data ffrom the String that will fit the amount of data an int
		// contains, and then shoving all of those zeroes and ones into the memory location
		// of the int. 
		// Now, have some fun with the challenge question!
		
		/**		
		  		◊========================================◊
		 		∏		 CHALLENGE QUESTION 1.2.2		 ∏
		 		‡========================================‡
		    	∏  Given that 'Math.PI' gives you the    ∏
		   		∏  value of pi, the method 				 ∏
		   		∏  Math.pow(base, power) is used		 ∏
		   		∏  for exponentiation, and the method	 ∏
		   		∏  Math.floor(number) is used to round   ∏
		   		∏  down, can you write a loop that		 ∏
		   		∏  stores the first 8 digits of pi		 ∏
		   		∏  in an array?						     ∏
		    	◊========================================◊
		 **/

		
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		
		
		/** PART 3 : OBJECTS */
		
		/* Java is what's known as an object-oriented programming language, so it's safe to assume that this section
		 * is PRETTY FUCKING INTEGRAL to what makes Java both useful and fun.
		 * There's not a whole lot you can do with just the stuff you've learned before, except some basic math and a bit of printing.
		 * 
		 * Now we're going to tackle the idea of objects.
		 * 
		 * We learned earlier that a String is a kind of object. This is true, but it's actually more like the primitive data types
		 * than any other Object in Java. I realize that that sentence can be read in two ways, but I mean it both ways.
		 * 
		 * An object is like an array in that it can store multiple pieces of data, but unlike arrays, and object can store
		 * -Different types of data
		 * -As many different things as you want, and in no particular order
		 * -Other objects of different types, and most impotantly,
		 * -ITS OWN FUNCTIONS AND METHODS!
		 * 
		 * Objects are the basis of what makes Java fun, and so we'll just jump right in.
		 * The 'class' syntax we use at the beginning of every file doesn't just tell the computer "Hey, a file starts here."
		 * It actually says, "what follows is a new kind of Object."
		 * The 'main' method is used in runnable files to tell the computer where to start and what to do when executing
		 * that file. It's not necessary to have a 'main' method in your object, and in fact, most objects (read: virtually all objects)
		 * don't have a 'main' method. Instead, they have what are called 'constructors' - methods that create a new object
		 * the same way that a new variable is created when you're working with the primitive data types.
		 * 
		 * Check it all out below.
		 * (Note that you'd normally define an object in its own file, but for the purposes of this guide, I'm making one here.)
		 */
	}

	// This tells the computer that we're about to define the properties of this new Object that will be called "Car".
	public class Car {
		
		// We'll make sure that every Car object has its own make, model, color, year, fuel economy rating, and price value.
		// They'll start out blank for each new car, and they can be defined later.
		public String make = "";
		public String model = "";
		public String color = "";
		public int year;
		public int mpg;
		public float value;
		
		// This is a basic constructor. It takes in no variables and will serve as the standard, basic car.
		// This is what you call to create a new instance of Car, if you don't feel like specifying any values yet.
		// We'll make it my car, because I'm the one writing this and I can't be bothered to look up the stats of other cars.
		public Car(){
			make = "Honda";
			model = "Civic";
			color = "Gold";
			year = 2003;
			mpg = 30;
			value = 3000.00f;
		}
		
		// Note that you don't have to give all of the variable values in every constructor, but it's handy to avoid errors.
		// If you tried to use the value of your car's mpg to find out how much gas it takes to drive a certain distance,
		// and you hadn't actually given mpg a value yet, you would get an error and the program would crash.
		
		// Now we'll make another constructor, so you can input a make, model, and year.
		
		public Car(String myMake, String myModel, int myYear){
			make = myMake;
			model = myModel;
			year = myYear;
			// We're going to just set these to some standard values, because they weren't specified.
			color = "Black";
			mpg = 22;
			value = 500.00f;
		}
		
		// Now we'll make a third constructor, so you can input all information about your car.
		
		public Car(String myMake, String myModel, String myColor, int myYear, int myMpg, float myValue){
			make = myMake;
			model = myModel;
			color = myColor;
			year = myYear;
			mpg = myMpg;
			value = myValue;
		}
		
		// Cool! Now we can create a car and choose one of those three ways to specify its initial values.
		// But what if the price goes down later?
		// It's always useful to create methods to get and set the values for your object.
		// They're called getters and setters, respectively (no shit).
		// They should be public, so you can access them from anywhere,
		// and they should either return void (if they're used to set a value) or the data type of whatever variable they're used to get.
		// Here are all of your getters and setters for the values that our car holds:
		
		// Setters:
		public void setMake(String newMake){
			make = newMake;
		}
		
		public void setModel(String newModel){
			model = newModel;
		}
		
		public void setColor(String newColor){
			color = newColor;
		}
		
		public void setMpg(int newMpg){
			mpg = newMpg;
		}
		
		public void setYear(int newYear){
			year = newYear;
		}
		
		public void setValue(float newValue){
			value = newValue;
		}
		
		
		// Getters:
		public String getMake(){
			return make;
		}
		
		public String getModel(){
			return model;
		}
		
		public String getColor(){
			return color;
		}
		
		public int getMpg(){
			return mpg;
		}
		
		public int getYear(){
			return year;
		}
		
		public float getValue(){
			return value;
		}
		
		// You can also give the car object its own methods, like this one that calculates how much money it will cost to drive
		// a given distance in this car for a given gas price:
		
		public float getGasCostForTrip(float numberOfMiles, float gasCostPerGallon){
			return ((numberOfMiles / mpg) * gasCostPerGallon);
		}	
		
		// Anyway, that's a little bit about objects. We'll do some more work with them in Chapter 3.
		// Move on to the file 'Part1_ArrayListsAndSorting.java' in the Chapter2 package.
	}
	
}