package Chapter3.items;

import Chapter3.npc.Monster.AtkType;

// We'll make a sword a type of Equippable, using the same inheritance properties as before.
public class Sword extends Equippable {

	public Sword() {
		super("steel sword", "A simple sword forged from steel.", "2d8", AtkType.MELEE, Area.PRIMARY);
	}

	// We'll be doing the same thing for a few other equippable types - Shield.java, Armor.java, Ring.java, etc.
	// Check those out if you want, or jump back to Chapter3.Part2_ObjectsAndInheritance.java to continue.
}
