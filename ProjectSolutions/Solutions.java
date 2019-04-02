/**
 * @author Ciaran Eli Dorland
 * 
 * Part of a series of Java tutorials.
 * Intended for use with Eclipse or your favorite Java IDE.
 */

package Solutions;

public class Solutions {

	public static void Chapter1(){
		
		/** Part 2 - Loops, Arrays, and Objects */
		
			/** Section 1 - Loops */
		
		
			/* 
			 	The code 
			 	
			 		for(int z = 0; z <= 10; z++){	
						z+=3;		
		 				System.out.println(z);
		 			} 
		 			
		 		does the following:
		 		
		 			>	for(int z = 0; z <= 10; z++){}
		 		
		 			This for-loop starts at zero, and doesn't loop if z > 10 at the beginning of a new loop.
		 			At the end of the loop's code block, z gets incremented by 1.
		 			
					>		z+=3;
					
					At the beginning of the loop, we're adding 3 to the value of z.
					
					> 		System.out.println(z);
					
					Then, we're printing the value of z.
					
					Let's write out what happens:
					
						z = 0
						Loop starts.
							z = z+3 = 3
							3 gets printed to the console.
						Loop ends. z is incremented by 1: z = z+1 = 4.
						
						z = 4
						Loop starts.
							z = z+3 = 7
							7 gets printed to the console.
						Loop ends. z is incremented by 1: z = z+1 = 8.
						
						z = 8
						Loop starts.
							z = z+3 = 11
							11 gets printed to the console.
						Loop ends. z is incremented by 1. z = z+1 = 12.
						
						z = 12
						Loop doesn't start, as z is now greater than 10.
						
					This means that this loop will print 
					
					>	3
					>	7
					>	11
					
					to the console.
			 
			 */
			
		
		  /*****************************/
		
		
		
			/** Section 2 - Arrays */
		
			/*
			 	Here's the question:
			 	
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
			 	
			 	So we want to store the first 8 digits of pi in an array.
			 	
			 	First, let's make the array - an integer array with 8 spaces:
			 	
			 		int digitsOfPi[] = new int[8];
			 	
			 	Next, let's figure out how to populate it.
			 	A for-loop will probably be easiest:
			 	
			 		for(int digit = 0; digit < 8; digit++){}
			 		
			 	That looks good. Now, let's figure out a way to grab just a single decimal digit from pi.
			 	Say we want to grab just the digit in the hundreds place.
			 	If we want to make it an integer, first thing we should do is to multiply pi by 100 to move the
			 	number in the hundredths place into the ones place:
			 	
			 		pi*100 = 314.159265358979
			 	
			 	Now, we can use the Math.floor() method to cut off the deciaml place.
			 	
			 		Math.floor(pi*100) = 314
			 	
			 	Okay, but now how do we get rid of the 310 that comes before the 4?
			 	Simple - we use the remainder operator!
			 	If we find the remainder of this number when it's divided by 10, we will get the total value of everything less than 10,
			 	because we're working in a decimal (base-10) system: 314 / 10 = 31 with a remainder of 4.
			 	
			 		314 % 10 = 4
			 		
			 	So now we have 
			 		
			 		third digit = Math.floor(pi*100) % 10
			 		
			 	but if we want to make this work as part of a loop,
			 	we'll need to find a way to write this so it works for each index of the array.
			 	Well, if we want the first digit, we can just use Math.floor(pi), right?
			 	And if we want the second, we can use Math.floor(pi*10) % 10 right?
			 	
			 	Well, that means that this should work:
			 	
			 		nth digit = Math.floor(pi * (10^n)) % 10
			 	
			 	where the first digit is the 'zeroth', the next digit is the 'first', etc.
			 	But wait, that's not proper Java notation - carats don't work like that in java,
			 	and if I just write 10^n, I'll get errors!
			 	
			 	No worries. That's what the Math.pow() method if for.
			 	We want a base of 10 and a power of n, so let's use
			 	
			 		Math.pow(10,n)
			 	
			 	to replace 10^n.
			 	Now, n is actually just the index of our for-loop AND our array, so here's the final answer:
			 	
			 		int digitsOfPi[] = new int[8];
			 		
			 		for(int n = 0; n < 8; n++){
			 			
			 			digitsOfPi[n] = (int) Math.floor( Math.PI * Math.pow(10, n) ) % 10;
			 			
			 		}
			 		
			 	That's it!
			 	Note that since the Math.floor() function returns a data type of long, we need to cast it to an int.
			 	If you don't know what that means, go back to the section and keep reading.
			 	
			 */
		
		  /*****************************/
		
		
	}
	
	public static void Chapter2(){
		
		/** Part 1 - ArrayLists and Sorting */
		
		/*
		 	Here's my solution to the ArrayList sorting problem:
		 	
		 	
		 	- Create a new ArrayList to place the sorted values into.
		 	
		 		ArrayList<Integer> orderedList = new ArrayList<Integer>();
		 	
		 	
		 	- Create a for-loop that iterates through all of the integers in the intList.
		 	
				for(int i : intList){
				
				
			-Inside that for-loop, make sure that the new list isn't empty. If it is, just pop the first integer in there and move on.
			
					if(orderedList.isEmpty()){
						orderedList.add(i);
					}
					else{
					
					
			-Make a boolean flag that you can toggle to and check later to see if something was successfully added.
			
						boolean added = false;
						
						
			-Run another for loop inside the first for loop: for each int in the original intList, check every int in the new, ordered list.
			
						for(int j = 0; j < orderedList.size(); j++){
						
			
			- If the integer we're looking at in the intList is less than or equal to the integer we're looking at in our ordered list,
			 
							if(i <= orderedList.get(j)){
							
							
			- Add the int i, from our intList, to the index j in the orderedList.
			
									orderedList.add(j,i);
									
									
			- Let the system know we've added something.
			
									added = true;
									
									
			- Break: this syntax tells the for-loop to exit when it's reached this line.
									break;
							}
						}
						
						
			- If nothing got added, that means that our int i from the intList must be greater than anything in the orderedList,
			  so we'll add it to the end of the orderedList.
			  
						if(!added){
							orderedList.add(i);
						}
					}
				} 
				
			- That's it. Here's the full code, so you can look back over it as a whole:
			
			
			
					ArrayList<Integer> orderedList = new ArrayList<Integer>();
			
					for(int i : intList){
			
						if(orderedList.isEmpty()){
							orderedList.add(i);
						}
						else{
							boolean added = false;
						
							for(int j = 0; j < orderedList.size(); j++){
						
								if(i <= orderedList.get(j)){
									orderedList.add(j,i);
									added = true;
									break;
								}
							
							}
							if(!added){
								orderedList.add(i);
							}
						}
				
					}
			
			
			
			- Then, all that's left to do is print out the new orderedList!
		 */
		
		/*****************************/
		
		
	}
	
}
