package Chapter3.npc;

import java.util.ArrayList;

import Chapter3.items.Item;

// As we saw earlier with items, this will be the parent object for anything you can fight.
/** A generic baddie. */
public class Monster {

	// All of the requisite components of a videogame enemy.
	public String name;
	public int maxHP;
	public int curHP;
	public AtkType weakness;
	public AtkType strength;
	public int XP;
	public ArrayList<Item> loot;
	
	// We're going to make random damage a thing, so we'll use a DnD-style die-rolling system.
	// The first number tells you how many dice will be rolled for their attack,
	// and the second number gives the number of sides of those dice.
	public String atkDie = "1d4";
	
	// We're gonna use another one for defense. A single 4-sided die will be our basic die.
	public String defDie = "1d4";
	
	// This enum will serve as the attack/defense type of the monster.
	public enum AtkType{
		NONE, MELEE, RANGED, MAGIC;
	}
	
	// Here's a fully-defined monster for when we extend the class.
	public Monster(String nm, int hp, AtkType weak, AtkType str, int xp, String[] dice, ArrayList<Item> l00t){
		this.name = nm;
		this.maxHP = hp;
		this.curHP = hp;
		this.weakness = weak;
		this.strength = str;
		this.XP = xp;
		this.atkDie = dice[0];
		this.defDie = dice[1];
		this.loot = l00t;
	}
	
	/** This method rolls for this monster's attack based on {@link #atkDie}, and returns the result as an integer. */
	public int rollAtk(){
		String[] numbers = this.atkDie.split("d");
		int numDice = Integer.parseInt(numbers[0]);
		int numSides = Integer.parseInt(numbers[1]);
		int toReturn = 0;
		for(int i = 0; i < numDice; i++){
			toReturn += ((int) Math.round( Math.floor(Math.random() * numSides)) ) + 1;
		}
		return toReturn;
	}
	
	/** This method rolls for this monster's defense based on {@link #defDie}, and returns the result as an integer. */
	public int rollDef(){
		String[] numbers = this.defDie.split("d");
		int numDice = Integer.parseInt(numbers[0]);
		int numSides = Integer.parseInt(numbers[1]);
		int toReturn = 0;
		for(int i = 0; i < numDice; i++){
			toReturn += ((int) Math.round( Math.floor(Math.random() * numSides)) ) + 1;
		}
		return toReturn;
	}
	
	// This method will be used by each monster to generate randomized loot.
	// This is another important topic in extension / inheritance.
	// We will *override* this method in our Monster subclasses (objects which extend the Monster type).
	public static ArrayList<Item> randomizeLoot(){
		return new ArrayList<Item>();
	}
	
}
