package Chapter3.items;

import Chapter3.npc.Monster.AtkType;

public class Bow extends Equippable {
	public Bow() {
		super("longbow", "A simple wooden longbow.", "3d4", AtkType.RANGED, Area.PRIMARY);
	}
	
	public int rollAtk(String arrowDie){
		int toReturn = 0;
		String[] nums = arrowDie.split("d");
		int numDice = Integer.parseInt(nums[0]);
		int numSides = Integer.parseInt(nums[1]);
		for(int i = 0; i < numDice; i++){
			toReturn += (int)(Math.round(numSides - 1) + 1);
		}
		return toReturn;
	}
}
