package Chapter3.items;

import Chapter3.npc.Monster.AtkType;

// Again, we'll have Equippable items extend the Item object.
public class Equippable extends Item {

	// Each equippable item will offer a base attack or defense value.
	public int val = 0;
	public String atkDie = "1d4";
	
	// We'll use the attack types as a sort of rock-paper-scissors system.
	// Each equippable needs a value for that:
	public AtkType type;
	
	// And finally, each one needs an equip area. 
	// We'll have body (suit of armor), primary (sword), secondary/off-hand (shield), special (amulets, rings, etc.), and head.
	public enum Area{
		BODY, HEAD, PRIMARY, SECONDARY, SPECIAL;
	}
	
	// And a value for each Equippable.
	public Area area;
	
	// We'll need to take in all of the Equippable-specific variables and the Strings for name and description from the Item class.
	/** Creates a new Equippable Item.
	 * @param name : The name of the item.
	 * @param descr : A short description of the item.
	 * @param val : The base attack/defense buff of this item.
	 * @param etype : The type (melee, ranged, magic) of the item. */
	public Equippable(String name, String descr, int val, AtkType type, Area area){
		
		super(name, Type.EQUIPPABLE, descr);
		
		this.val = val;
		this.type = type;
		this.area = area;
	}
	
	/** Creates a new Equippable Item.
	 * @param name : The name of the item.
	 * @param descr : A short description of the item.
	 * @param val : The base attack/defense buff of this item.
	 * @param etype : The type (melee, ranged, magic) of the item. */
	public Equippable(String name, String descr, String die, AtkType type, Area area){
		
		super(name, Type.EQUIPPABLE, descr);
		
		this.atkDie = die;
		this.type = type;
		this.area = area;
	}
	
	// And that's our basic equippable item. Jump on over to the Chapter3.items.Potion java file to keep reading.
	
	// This is used to roll an attack using this weapon.
	public int rollAtk(){
		int toReturn = 0;
		String[] nums = this.atkDie.split("d");
		int numDice = Integer.parseInt(nums[0]);
		int numSides = Integer.parseInt(nums[1]);
		for(int i = 0; i < numDice; i++){
			toReturn += (int)(Math.round(numSides - 1) + 1);
		}
		return toReturn;
	}
}
