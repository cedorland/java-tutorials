package Chapter3.items;

// This will be the basic item class. We'll use it to define the properties shared by every item,
// then we'll jump into a discussion on inheritance.

public class Item {

	// Every item will have a name String so that we can print it out.
	public String name;
	
	// Each item will also be of a specific type. Here, we'll use what's called an enumerator.
	// An enumerator is kind of a like a set of labels you can choose between.
	// Here's the syntax:
	public enum Type {
		// We've created this enum called 'Type', and now we'll assign the different 'Type' values that each item will be able to have.
		CONSUMABLE, EQUIPPABLE, KEY;
		
		// We'll have CONSUMABLE items, like potions or food, EQUIPPABLE items like armor, and KEY items that you can't get rid of.
		// Now, we can give each item its own Type value, then we can check that value to see whether they're CONSUMABLE, EQUIPPABLE, or KEY items.
		// We could have used an integer and just remembered that, for example, the value of the integer 'type' is 0 for key items, 1 for equippable items,
		// and 2 for consumable items, but then we would have to translate back and forth between the integer and its meaning a bunch of times.
		// We could also have saved booleans like isEquippable, isConsumable, isKeyItem, etc., but then we would have had to run checks on all three
		// of those booleans. This makes it simpler - we can just check their type without having to translate (because enum values are
		// always plain text), and we know that if their Type is 'Type.CONSUMABLE', they aren't a key item or a equippable.
	}
	
	// Here, we'll make sure that every Item has its own Type variable, called 'type':
	public Type type;
	
	// Finally, every item will have its own description:
	public String descr;
	
	// Now we'll create the constructor.
	// We don't want a basic constructor (without passing in any variables) because we want every item to be fully defined,
	// so we'll just make a full constructor (which takes in all of the item's variable values when that Item is created).
	public Item(String name, Type type, String descr){
		this.name = name;
		this.type = type;
		this.descr = descr;
	}
	
	// Now we'll look at inheritance - jump on over to the Chapter3.items.Consumable java file and keep reading.
	
}
