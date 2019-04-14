package Chapter3.items;

import Chapter3.npc.Monster.AtkType;

public class Shield extends Equippable {

	// All shields will be Melee items and Secondary equip.
	public Shield() {
		super("wood shield", "A simple wooden shield.", 10, AtkType.MELEE, Area.SECONDARY);
	}
	
}
