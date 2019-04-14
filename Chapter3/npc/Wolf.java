package Chapter3.npc;

public class Wolf extends Monster {

	// These are the standard Wolf attributes.
	public static final String NAME = "grey wolf";
	public static final int HP = 20;
	public static final int XP = 75;
	public static final String[] DICE = {"2d3","1d4"};
	
	// This creates a wolf. Notice that we're not giving it any loot to drop. You can do this if you want.
	public Wolf() {
		super(NAME, HP, AtkType.MAGIC, AtkType.MELEE, XP, DICE, randomizeLoot());
	}
}
