package Chapter3.items;

import Chapter3.npc.Monster.AtkType;

public class Staff extends Equippable {

	public Staff() {
		super("wooden staff", "A magical staff carved from the wood of an ancient elm.", "2d6", AtkType.MAGIC, Area.PRIMARY);
	}
	
}
