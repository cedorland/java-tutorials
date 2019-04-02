package Solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderUpSolution {

	// Make our menu
	public static String fry = "Single french fry";
	public static String burger = "Burger";
	public static String filet = "Filet mignon";
	public static String lobby = "Lobster";
	public static String mayo = "Mayonnaise";
	
	
	// Turn it into an array so it's easier to use
	public static String menuItems[] = { fry, burger, filet, lobby, mayo };
	
	
	// Make our prices
	public static float fryPrice = 0.75f;
	public static float burgerPrice = 6.25f;
	public static float lobbyPrice = 27.50f;
	public static float filetPrice = 98.50f;
	public static float mayoPrice = 1.25f;
	
	
	// And make them an array as well, in the same order so we can use the same index for the item's name and price.
	public static float menuPrices[] = { fryPrice, burgerPrice, filetPrice, lobbyPrice, mayoPrice };
	
	
	// Here's a boolean so we can keep track of whether they want to order more.
	public static boolean doneOrdering = false;
	
	// Here's a constant we can use for sales tax. It's currently set to the Maryland sales tax amount.
	public static final float SALES_TAX = 0.06f;
	
	
	/**  A scanner to read user input.  */
	public static Scanner sc = new Scanner(System.in);
	
	
	/**  This method calculates sales tax for a given subtotal (Using Maryland sales tax).  */
	public static float getTaxOn(float subtotal){
		return (SALES_TAX * subtotal);
	}
	
	
	/**  This method calculates a tip based on a given tip percentage and after-tax subtotal.  */
	public static float calculateTip(float tipPercentage, float subtotalAfterTax){
		return ( (tipPercentage / 100.0f) * subtotalAfterTax);
	}
	
	// And finally, let's make an ArrayList to keep track of what they've eaten.
	public static ArrayList<String> foodsEaten = new ArrayList<String>();
	
	public static void main(String[] args){
		
		System.out.println("Hello, welcome to The Food Place! We have food, and we're a place!");
		System.out.println("What can I get for you?");
		System.out.println("\nMenu:");
		// Let's loop through the menu options:
		for(int i = 0; i < menuPrices.length; i++){
			// Print out each option's price and name.
			// Note that just printing the prices as-is is totally fine.
			// I wrote a method for formatting, but it wasn't asked of you and I wouldn't expect you to do it.
			System.out.println("$" + formatPrice(menuPrices[i]) + "\t" + " - " + menuItems[i]);
		}
		
		// I'm just printing a newline character here to make everything look a bit nicer.
		System.out.println();
		
		// Loop as long as they're not done ordering yet.
		while(!doneOrdering){
			
			// Grab user input
			String input = sc.nextLine();
			
			// Make it lower case so it's easier to check
			input = input.toLowerCase();
			
			// I'm just printing a newline character here to make everything look a bit nicer.
			System.out.println();
			
			// Check for each menu item, in order. If found, add that item at index 0 of the ArrayList.
			if(input.contains("fry")){
				
				foodsEaten.add(0,menuItems[0]);
				
			}else if(input.contains("burger")){
				
				foodsEaten.add(0,menuItems[1]);
				
			}else if(input.contains("filet")){
				
				foodsEaten.add(0,menuItems[2]);
				
			}else if(input.contains("lobst")){
				
				foodsEaten.add(0,menuItems[3]);
				
			}else if(input.contains("mayo")){
				
				foodsEaten.add(0,menuItems[4]);
				
			}else{
				// If they don't order something on the menu, end their order.
				doneOrdering = true;
				// Exit the loop immediately. 'continue' would also work here, because we just toggled 'doneOrdering'.
				break;
			}
			
			// Now that they've ordered something, let's print them a little message.
			System.out.println("Wonderful! Here's your " + foodsEaten.get(0).toLowerCase() + "!");
			System.out.println("Can I get you anything else?\n");
			
		}
		
		// Ask how much of a tip they want to leave
		System.out.println("\nAll right! What percent tip would you like to leave?\n");
		
		// Grab the input and parse a float from it at the same time.
		float tipPercent = Float.parseFloat(sc.nextLine());
		
		// Thank them for their patronage.
		System.out.println("\nThank you very much! Here's your receipt:\n");
		
		// Now that they've finished ordering, we'll have to calculate everything.
		float subtotal = 0;
		
		// Let's run through all the foods on the list.
		for (int i = 0; i < foodsEaten.size(); i++){
			
			// For each food item on the list, let's check it against the menu items to see which one it is.
			for (int index = 0; index < menuItems.length; index++){
				
				// If it's this food, print out the name of the food and the price.
				// Note the index I'm using for the foodsEaten.get() method: I'm reading from the end of the list to the front,
				// because the items on the list are ordered starting with the most recent!
				// Of course, you don't have to do it this way. It's always up to the programmer. Or their boss.
				if ( foodsEaten.get( foodsEaten.size() - (i+1) ).equals(menuItems[index]) ){
					
					System.out.println("$" + menuPrices[index] + " - " + menuItems[index].toUpperCase());
					
					// Add the price of this food item to the subtotal
					subtotal += menuPrices[index];
					
					// Exit the inner for-loop because we found the right food (note: this isn't necessary, but it's good practice.)
					break;
					
				}
				
			}
		}
		
		// Calculate tax
		float tax = getTaxOn(subtotal);
		
		// Calculate tip
		float tip = calculateTip(tipPercent, subtotal+tax );
		
		// Calculate total
		float total = subtotal + tax + tip;
		
		// Note that just printing the subtotal as-is is totally fine. I wrote a method for formatting, but it wasn't
		// asked of you and I wouldn't expect you to do it.
		System.out.println("\nSUBTOTAL:  $" + formatPrice(subtotal));
		System.out.println("TAX:       $" + formatPrice(tax));
		System.out.println("TIP:       $" + formatPrice(tip));
		System.out.println("\nTOTAL:     $" + formatPrice(total));
		
		// That's it!
		
	}
	
	/** This method takes in a float and returns a String which represents a properly formatted price. */
	public static String formatPrice(float price){
		
		// Round the price off to the nearest cent
		int cost = (int) Math.round(price * 100.0);
		
		// Grab just the cents
		int cents = cost % 100;
		
		// Grab just the whole dollar amount
		int dollars = (cost - cents) / 100;
		
		// Make it a String
		String toReturn = "" + cents; 
		
		// Make sure it has two 'cents' places.
		while (toReturn.length() < 2){
			toReturn = "0" + toReturn;
		}
		
		// Add the dollar amount and a decimal place onto it
		toReturn = dollars + "." + toReturn;
		
		// Add some spaces in front of it to accommodate up to $999.99 in the bill.
		while (toReturn.length() < 6){
			toReturn = " " + toReturn;
		}
		
		// Aaaaaaaaaand we're done.
		return toReturn;
	}
	
	
}
