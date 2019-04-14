package Chapter3.items;

// Here, we'll go a step further and say that each Potion is a Consumable!

public class Potion extends Consumable{

	// Our potions won't need any special fields, so we'll just have a constructor here.
	// Because we know it's a potion, we only need to take in whether it heals HP or mana, 
	// and by how much.
	public Potion(HealType healType, int healAmt){
		// Jump down and read everything after this constructor to see what's going on in the super() call here.
		super(getName(healType,healAmt),getDescr(healType,healAmt),healType, healAmt);
		
	}
	
	// We'll need some methods that generate its name and description based on the potion's heal type and amount.
	// Since we don't need to use them anywhere else and we don't want to get confused by seeing them when we're
	// working with potion object later on, we'll make their visibility *private*. They'll need to return a String,
	// and they need to take in the healType and healAmt variables. We'll also need this method to be static
	// so that it's the same for all instances.
	private static String getName(HealType healType, int healAmt){
		
		// Here, we'll name the potion based on its characteristics.
		String myName = "potion";
		
		// Add whether it's a health potion or a mana potion.
		if (healType == HealType.HP)
			myName = "health " + myName;
		
		else
			myName = "mana " + myName;

		// Give it a descriptive name based on how much it heals you.
		if (healAmt < 10)
			myName = "Weak " + myName;
		// Between 10 and 25 points = Regular
		else if (healAmt < 25)
			myName = "Regular " + myName;
		// Between 25 and 50 = Strong
		else if (healAmt < 50)
			myName = "Strong" + myName;
		// More than 50 points = Legendary
		else
			myName = "Legendary " + myName;
		
		// Then return it.
		return myName;
	}
	
	// We'll also need a description string generator.
	private static String getDescr(HealType healType, int healAmt){
		
		String descr = "Heals " + healAmt + " ";
		
		if(healType == HealType.HP)
			descr += "health.";
		else
			descr += "mana.";
		
		return descr;
	}
	
	// That's it for our potion. Jump to Chapter3.items.Sword to keep reading.
	
}
