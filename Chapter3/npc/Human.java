package Chapter3.npc;

import java.util.ArrayList;

import Chapter3.items.*;

public class Human extends Monster {

	// These are the standard 'bear' attributes. Notice that they're all final variables.
	public static final String NAME = "guy";
	public static final int HP = 50;
	public static final int XP = 200;
	public static final String[] DICE = {"1d4","1d4"};
	
	// This creates a bear.
	public Human() {
		super(NAME, HP, AtkType.NONE, AtkType.NONE, XP, DICE, randomizeLoot(AtkType.NONE));
		AtkType newAtk = randomizeType();
		this.strength = newAtk;
		switch(newAtk){
		case MELEE: this.weakness = AtkType.MAGIC; this.atkDie = "1d8"; this.defDie = "1d6"; break;
		case RANGED: this.weakness = AtkType.MELEE; this.atkDie = "2d4"; this.defDie = "1d4"; break;
		case MAGIC: this.weakness = AtkType.RANGED; this.atkDie = "3d3"; this.defDie = "2d2"; break;
		default: break;
		}
		
		this.loot = randomizeLoot(this.strength);
		
	}

	// Here, we're overriding the Monster.randomizeLoot() method to generate specific loot for bears!
	public static ArrayList<Item> randomizeLoot(AtkType atype){
		// If no attack type has been selected yet, return nothing.
		if(atype == AtkType.NONE) return new ArrayList<Item>();
		
		ArrayList<Item> toReturn = new ArrayList<Item>();
		
		int willDropPotion = (int) Math.round(Math.random());
		int typeOfPotion = (int) Math.round(Math.random());
		int attackOrDefenseItem = (int) Math.round(Math.random());
		int amtOfAmmo = (int) Math.round(Math.random() * 5) + 1;
		int armorOrShield = (int) Math.round(Math.random());
		
		// Here's a nested switch statement!
		switch(attackOrDefenseItem){
		case 1:	{
					switch(atype){
					case MELEE: toReturn.add(new Sword()); break;
					case RANGED:toReturn.add(new Bow()); for(int i = 0; i < amtOfAmmo; i++) toReturn.add(new Arrow()); break;
					case MAGIC:toReturn.add(new Staff()); break;
					default:
					}
				}
				break;
		default:{
					switch(armorOrShield){
					case 1: {
								switch(atype){
								case MELEE: toReturn.add(new SuitOfArmor()); break;
								case MAGIC: toReturn.add(new Robe()); break;
								case RANGED:toReturn.add(new Cloak()); break;
								default:
								}
							}
							break;
					default:{
								switch(atype){
								case MELEE: toReturn.add(new Shield()); break;
								case MAGIC: toReturn.add(new Orb()); break;
								case RANGED:toReturn.add(new Gauntlets()); break;
								default:
								}
							}
							break;
					}
				}
				break;
		}
		
		if(willDropPotion == 1){
			if(atype == AtkType.RANGED) {
				if(typeOfPotion==1) toReturn.add(new ManaPotion(10));
				else toReturn.add(new HealthPotion(10));
			}
			else {
				if(atype == AtkType.MAGIC) toReturn.add(new ManaPotion(10));
				else toReturn.add(new HealthPotion(10));
			}
		}
		
		return toReturn;
	}
	
	public static AtkType randomizeType(){
		int rand = (int) Math.round(Math.random()*2);
		switch(rand){
		case 1: return AtkType.RANGED;
		case 2: return AtkType.MAGIC;
		default: return AtkType.MELEE;
		}
	}
}
