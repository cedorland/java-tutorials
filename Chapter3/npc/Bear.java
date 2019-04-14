package Chapter3.npc;

import java.util.ArrayList;

// The asterisk here tells the computer to import every class in the specified package.
import Chapter3.items.*;

// Now we're going to make a Bear to extend the Monster class as a specific type of monster.
public class Bear extends Monster {

	// These are the standard 'bear' attributes. Notice that they're all final variables.
	public static final String NAME = "bear";
	public static final int HP = 25;
	public static final int XP = 50;
	public static final String[] DICE = {"1d6","1d4"};
	
	// This creates a bear.
	public Bear() {
		super(NAME, HP, AtkType.MAGIC, AtkType.MELEE, XP, DICE, randomizeLoot());
	}

	// Here, we're overriding the Monster.randomizeLoot() method to generate specific loot for bears!
	public static ArrayList<Item> randomizeLoot(){
		ArrayList<Item> toReturn = new ArrayList<Item>();
		
		// Each bear will drop between 1 and 3 honeycombs.
		int numHoneycombs = 1 + (int) Math.round(Math.random() * 2);
		if(numHoneycombs == 0) return toReturn;
		
		for(int i = 0; i < numHoneycombs; i++){
			toReturn.add(new Honeycomb());
		}
		return toReturn;
	}
}
