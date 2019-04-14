package Chapter3.items;

// Since every Consumable will be a kind of Item, we're going to make the Consumable object 'extend' the Item class.
// We do this by using the 'extends' keyword in the class declaration as shown:

public class Consumable extends Item {

	// This means that every Consumable is a kind of Item, and so every Consumable object has all of the properties that an Item object has,
	// but we can add some extra properties that are specific to Consumable objects.
	// For example, not all items are consumable, but all consumables can either heal your health or mana points.
	// Let's give consumables an enum which lets you know which type they'll heal:
	public enum HealType{
		HP, MANA, NONE;
	}
	
	// And give each Consumable a healType variable:
	public HealType healType;
	
	// We'll also need them to have a heal-amount, so let's create that:
	public int healAmt = 0;
	
	// This will be used for consumable ammunition.
	public String die = "1d1";
	
	// We'll also need to make sure that when a Consumable object is created, since it's also an Item,
	// all of its Item-standard properties are defined.
	// This is accomplished using the super() keyword.
	// For now, when a Consumable object is created, you'd think from just this file that all we need to take in are its healType and healAmount.
	// We actually should also take in its name and description Strings, because it's technically an Item as well.
	/** Creates a new Consumable Item.
	 * @param name : The item's name.
	 * @param descr : The item's description.
	 * @param healType : The type (health or mana) that this item heals.
	 * @param healAmt : The amount of health that this item heals. */
	public Consumable(String name, String descr, HealType healType, int healAmt){
		// The 'super' keyword goes on the first line of every constructor.
		// What it's doing here is that when a Consumable object is created, this line is calling its 'superconstructor',
		// which is the constructor of whatever object type this class is 'extending'. In this case, since we're extending the 'Item' class,
		// the superconstructor is the main constructor of the Item object, so we need to feed it the values that an Item would normally take in.
		// We'll pass along the name and description for this consumable item, and since it's consumable,
		// we'll set its Type variable to 'Type.CONSUMABLE'.
		super(name, Type.CONSUMABLE, descr);
		
		// After we've called the superconstructor, we can set all of the Consumable-specific values:
		this.healType = healType;
		this.healAmt = healAmt;
		
		// Now, even though we didn't specify that every Consumable has a name and description in the Consumable file,
		// every 'Consumable' object that we create will be an Item with a type value of CONSUMABLE because we made it extend the Item type.
		// We say that the Consumable object *inherits* the name, description, and type variables from the Item class.
	}
	
	/** Creates a new Consumable ammunition Item.
	 * @param name : The item's name.
	 * @param descr : The item's description.
	 * @param healType : The type (health or mana) that this item heals.
	 * @param dmgDie : The die used to calculate damage. */
	public Consumable(String name, String descr, HealType healType, String dmgDie){
		super(name, Type.CONSUMABLE, descr);
		
		this.healType = healType;
		this.die = dmgDie;
	}
	
	// Now jump on over to the Chapter3.items.Equippable java file to keep reading.
	
}
