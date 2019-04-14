package Chapter3.items;

import Chapter3.npc.Monster.AtkType;

public class Armor extends Equippable {

	// Here, we know that all Armor objects will be equipped to the BODY area, 
	// but some will defend against MELEE, some against RANGED, some against MAGIC, so we'll still take in that variable.
	public Armor(String name, String descr, int val, AtkType etype) {
		super(name, descr, val, etype, Area.BODY);
	}

	
}
