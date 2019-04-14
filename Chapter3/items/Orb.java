package Chapter3.items;

import Chapter3.npc.Monster.AtkType;

public class Orb extends Equippable {

	// All shields will be Melee items and Secondary equip.
	public Orb() {
		super("glass orb", "A magical orb which channels defensive magic.", 9, AtkType.MAGIC, Area.SECONDARY);
	}
	
}
