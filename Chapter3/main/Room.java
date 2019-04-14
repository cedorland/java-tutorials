package Chapter3.main;

import java.util.ArrayList;

// Here, we're importing some of the other object files we're creating and using for the game.
// Note that their path is specified using their packages.
import Chapter3.npc.Monster;
import Chapter3.items.Item;

/** This will be our 'room' object. It will represent a room in our game,
	and will contain certain monsters, items, or other interactables,
 	and it will have its own description so that the user will know where they are. */

public class Room {

	// First, let's give it some fields.
	
	// Every room will need a monster list, and since we want to be able to sort through it quickly
	// to remove monsters or let it have no monsters in it (among other reasons),
	// we'll use an ArrayList for this.
	
	// We'll use the generic 'Monster' object for this, and talk about why this is important in a bit.
	// Note that we can't make this 'static', because we want each instance of the 'Room' class
	// to have its own specific monster list.
	
	// We're also going to initialize it here so we don't accidentally get any null pointer exceptions
	// (which occur when you try to access a variable that hasn't been initialized
	// or otherwise doesn't exist).
	public ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	// We'll also need an item list for each room.
	public ArrayList<Item> itemList = new ArrayList<Item>();
	
	// Here's the string that will serve as this room's printable description:
	public String descr = "";
	
	// We'll make a boolean to let us know if a room is locked or unlocked, in case we want to add keys to unlock rooms.
	public boolean locked = false;
	
	// And here's our basic constructor:
	public Room(){
		
		// Since this will be the constructor which creates a standard room,
		// let's give it no monsters or items and a simple description:
		this.descr = "A nondescript room.";
		
		// Note the syntax we used there: the 'this' keyword is used to reference whatever object the
		// 'this' syntax is used inside of. Here, it's not actually necessary, but we're using it 
		// to specify that we want to set the value of the description string for
		// THIS specific instance of a room that's being created when this constructor is called.
	}
	
	
	// Let's create a more detailed constructor in case we want to initialize all of the values of
	// a new room at once:
	public Room(ArrayList<Monster> monsterList, ArrayList<Item> itemList, String descr){
		
		// Note that the values that are getting passed into this constructor have
		// the same names as the Room object's field variables.
		// In this case, we DO need to use the 'this' keyword to specify
		// whether we're talking about the variables that are getting passed in or this 
		// specific Room object's field variables.
		this.monsterList = monsterList;
		this.itemList = itemList;
		this.descr = descr;
	}
	
	// Now, what if we want to check a room's monsterList or itemList to see if it contains
	// a specific item or monster?
	// Let's create some easy-to-use methods for that!
	// We'll want to return a boolean (true or false value) to let the user know whether
	// this room contains the given item or monster, so we'll need to make
	// our return type 'boolean'. Since we want to be able to call this method from another file,
	// we'll need to use the 'public' keyword. Finally, we'll want to take in a String
	// to check against!
	
	public boolean containsItem(String item){
		
		// First, let's save some time and processing power by returning 'false' if the room
		// doesn't have any items in it at all.
		// Note that there are no curly brackets after the if statement!
		// In Java, if the code block that would follow an if-statement, else-statement,
		// for-loop or while-loop contains only a single line of code,
		// you don't need to put brackets around it.
		if(this.itemList.isEmpty())
			return false;
		
		// Next, let's run through each item in this room's itemlist:
		for(Item i : itemList){
			
			// For each item, we'll look at the name of the item, convert it to lower case,
			// and check if its name contains a substring that matches
			// the input String.
			if ( i.name.toLowerCase().contains( item.toLowerCase() ) ){
				// If so, we'll return true.
				return true;
			}
		}
		// If none of the items' names contain the input string, we'll return false.
		return false;
	}
	
	// Let's do the same thing, but for monsters:
	public boolean containsMonster(String monster){
		
		// The body of this method was just copied and pasted from the above method,
		// and all reference to items or the itemList have been replaced with
		// references to monsters and the monsterList.
		if(this.monsterList.isEmpty()) return false;
		
		// Because the body of the if-statement below is only one line of code,
		// we don't need to bracket it.
		// Similarly, the entire body of the for-loop is the if-statement, so we don't
		// need to bracket it either!
		// Note that it's better to bracket everything just to be safe.
		// This is how I'd write this piece of code in my own work, just for aesthetics.
		for (Monster m : monsterList)
			if (m.name.toLowerCase().contains(monster.toLowerCase()))
				return true;
		
		return false;
	}
	
	// Now we want a quick way to find and return the first specific instance of an item
	// in a room (in case the room has two potions, for example).
	// It will have to be public again, this time returning the Item itself,
	// and we'll want to be able to pass in a String.
	public Item instanceOfItem(String item){
		// We'll do the same thing here as before to save processing power,
		// but instead of automatically returning false,
		// we'll return 'null'. We won't ever want this to happen,
		// because we'll get a null pointer error if we try to use
		// the result of this method like a regular item if it returns null,
		// so we'll have to remember to call the 'containsItem' method
		// before we use this method.
		if(this.itemList.isEmpty()) return null;
		
		// Now if we find a match, we'll return the first instance of this item.
		for(Item i : itemList)
			if(i.name.toLowerCase().contains(item.toLowerCase()))
				return i;
		
		// And in case there aren't any items matching the string, we'll return null again.
		return null;
		
	}
	
	// For this method, we're going to do the same thing as in the last method, but for Monsters.
	public Monster instanceOfMonster(String monster){
		if(this.monsterList.isEmpty()) return null;
		for(Monster m : monsterList)
			if(m.name.toLowerCase().contains(monster.toLowerCase()))
				return m;
		return null;
	}
	
	// We're also going to make a convenient method that we'll use to print out the room's description.
	// This way, when we're in a Room named currentRoom, we can call currentRoom.print() to print the description,
	// as well as a description of the monsters and/or items in the room.
	public void print(){
		System.out.println(this.descr);
		// We'll make some simple methods to print out the objects/monsters in a room.
		this.printMonsters();
		this.printItems();
	}
	
	// This method will print a string describing the monsters in the room, if any.
	public void printMonsters(){
		// If the monsterList is empty, we'll print nothing.
		// Otherwise, we'll do everything in this if-statement's code block.
		if(!this.monsterList.isEmpty()){
			
			// If there's only one monster, we'll print one kind of statement.
			if(this.monsterList.size() == 1){
				System.out.println("There's " + this.monsterList.get(0).name + " in the room!");
			}
			// Otherwise, we'll print a list of the monsters in the room.
			else{
				
				// We'll add the monster names to this String and then print it.
				String toPrint = "";
				
				// For each monster in the room
				for(int index = 0; index < monsterList.size(); index++){
					
					// If we haven't hit the last monster in the list yet (think about the indices of the .size() method)
					if((index-1) < monsterList.size()){
						// Add this to the String.
						toPrint += monsterList.get(index).name + ", ";
					}
					else{
						// If this is the last monster in the list, add this to the string.
						toPrint += "and " + monsterList.get(index).name + " ";
					}
				}
				// Notice that if there are only two monsters in the room, this will still print a comma in between them.
				// Can you add a single line of code that fixes this issue before printing?
				
				// Print the String.
				System.out.println(toPrint);
			}
			
		}
	}
	
	// Now we'll do the same thing for the items in the room.
	/** Challenge: take a shot at rewriting these methods so that they print better Strings, like "There are six potions in the room". **/
	public void printItems(){

		if(!this.monsterList.isEmpty()){
			if(this.monsterList.size() == 1){
				System.out.println("There's " + this.monsterList.get(0).name + " in the room!");
			}
			else {
				String toPrint = "";
				
				for(int index = 0; index < monsterList.size(); index++){
					
					if((index-1) < monsterList.size()){
						toPrint += monsterList.get(index).name + ", ";
					}
					else{
						toPrint += "and " + monsterList.get(index).name + " ";
					}
				}
				System.out.println(toPrint);
			}
		}
	}
	
	/* That's it for the 'Room' class. Jump back to the Chapter3.main.Map java file and keep reading. */
	
}
