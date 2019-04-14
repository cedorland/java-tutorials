package Chapter3;

import Chapter3.main.*;

import java.util.ArrayList;
import java.util.Scanner;

import Chapter3.items.*;
import Chapter3.npc.*;

public class Part2_ObjectsAndInheritance {

	public static Scanner sc = new Scanner(System.in);
	
	// In this section, we'll be going over objects and how to use them (a bit more in depth), as well as covering the
	// property of inheritance.
	
	// Here, we will be doing a bit of hands-on work with some objects.
	// We're going to create a simple text adventure for the rest of this chapter,
	// using a multitude of objects (as well as going back over all of the stuff we've already covered).
			
	// We're going to start off by creating some fields. Most of these will be objects,
	// and you'll be directed to open and read specific objects' class files at certain
	// points in this code.
	
	// We'll be making an object called a Map object.
	// Jump over to the Chapter3.main.Map java file to keep reading.
	public static Map map = new Map(8,3);
	
	// These will be a few rooms. Notice that we're making a bunch of room objects at once, just by adding a comma between them!
	public static Room field00, field01, field02, field10, field11, field12, field20, field21, field22, bunker, road00, road01, road02, house0, house1, house2;
	
	// Now, go over to the Chapter3.item.Item java file to keep reading.
	// This is our inventory. Note that, since it's of type item, we can add ANY item to it - equippable, consumable, key, etc.
	// Any Item object, or anything that EXTENDS the type Item, can be held by this arraylist.
	public static ArrayList<Item> inventory;
	
	// We'll make another arraylist for our armor and weapons.
	// Note that since this one is of type Equippable, it can only hold equippable items!
	// This means that we can't store any consumable types here, but any objects of a type which extends the Equippable type can be held by it.
	public static ArrayList<Equippable> equipment;
	
	// Now, before you continue, go read the Chapter3.npc.Monster java file.
	
	// Here, we'll make some baddies. Feel free to check out their java files if you want.
	public static Bear bear = new Bear();
	public static Wolf wolf = new Wolf();
	public static Human someGuy = new Human();
	
	
	public static final int STD_DEF = 9;
	public static final String FISTS = "2d3";
	public static String atkDie = FISTS;
	public static int defDie = STD_DEF;
	
	// This method will initialize all of our rooms and such.
	public static void initialize(){
		// This makes all of the rooms exist.
		field00 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small clearing in the trees.\nThe edge of the forest lies to the south and west, covered in thick,\nimpassable brush. It looks like there's a break\nin the brush to the west.");
		field01 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small clearing in the trees.\nThe edge of the forest lies to the south, covered in thick,\nimpassable brush.");
		field02 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small clearing in the trees.\nThe edge of the forest lies to the south and east,\ncovered in thick, impassable brush.");
		field10 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small clearing in the trees.\nThe edge of the forest lies to the west, covered in thick,\nimpassable brush.");
		field11 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small clearing in the trees.\nThe field extends in all directions.\nThere seems to be a crate buried in the ground.\nMaybe you should take a look at it.");
		field12 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small clearing in the trees.\nThe edge of the forest lies to the east, covered in thick,\nimpassable brush.");
		field20 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small clearing in the trees.\nThe edge of the forest lies to the north and west, covered in thick,\nimpassable brush.");
		field21 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small clearing in the trees.\nThe edge of the forest lies to the north, covered in thick,\nimpassable brush.");
		field22 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small clearing in the trees.\nThe edge of the forest lies to the north and east, covered in thick,\nimpassable brush.");
		road02 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're on a small road through the forest.\nA clearing lies to the east, and the road continues west.");
		road01 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're on a small road through the forest.\nThick, impassable brush lines the road to the north and south.");
		road00 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're on a small road through the forest.\nThe road extends to the east. There's a small, two-story\nhouse to the west.");
		house0 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in the basement of the house.\nThere's a box in the corner.\nIt smells musty down here...");
		house1 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in a small house. There are stairs going both up and down.\nThere's a road to the east.");
		house2 = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "You're in the attic of the house. It's dusty up here,\nand there are a ton of cobwebs. There's a big, worn sign that reads,\n\"Congratulations, you know some java or something!\" in the corner.");
		bunker = new Room(new ArrayList<Monster>(), new ArrayList<Item>(), "There's a whole room down here!\nThere's a small cot with a notepad on it.\nThe field is above you.");
		
		// This adds our baddies to the rooms.
		field00.monsterList.add(bear);
		field21.monsterList.add(wolf);
		road01.monsterList.add(someGuy);
		
		// This adds all of our rooms to the right spots on the map.
		map.add(field00, 4, 0, 1);
		map.add(field01, 5, 0, 1);
		map.add(field02, 6, 0, 1);
		map.add(field10, 4, 1, 1);
		map.add(field11, 5, 1, 1);
		map.add(field12, 6, 1, 1);
		map.add(field20, 4, 2, 1);
		map.add(field21, 5, 2, 1);
		map.add(field22, 6, 2, 1);
		map.add(road00, 1, 0, 1);
		map.add(road01, 2, 0, 1);
		map.add(road02, 3, 0, 1);
		map.add(house0, 0, 0, 0);
		map.add(house1, 0, 0, 1);
		map.add(house2, 0, 0, 2);
		map.add(bunker, 5, 1, 0);
		
		// This sets up locked doors - don't cheat until you've tried playing the game first!
		bunker.locked = true;
		house0.locked = true;
		house2.locked = true;
		
		map.setCurRoom(6, 2, 1);
		inventory = new ArrayList<Item>();
		equipment = new ArrayList<Equippable>();
	}
	
	// Don't read this until you've tried to play the game!
	public static void main(String[] args){
		// Run through this and practice writing your own comments to explain what stuff does.
		// This is a useful skill when you're analyzing undocumented code from someone else.
		
		// What does this do?
		initialize();
		
		// How about this?
		boolean doneYet = false;
		
		// This boolean keeps track of whether the room's description should be printed on the next loop.
		boolean shouldPrintD = true;
		
		System.out.println("Welcome! Type in your commands to play the game. Try to find and solve the short puzzle.\nTo exit, type 'exit' or 'end' or whatever.\n");
		
		// This will be our main game loop.
		// We'll print out some text every loop, then wait for user input
		// and react to that input to continue the game.
		while(!doneYet){
			
			if(shouldPrintD){
				System.out.println("\n"+map.curRoom.descr+"\n");
				if(!map.curRoom.itemList.isEmpty()){
					System.out.println("There's something on the floor:");
					for(Item i : map.curRoom.itemList){
						System.out.println("   "+capFirstChar(i.name));
					}
				}
			}
			
			if(!map.curRoom.monsterList.isEmpty()){
				inBattle = true;
				System.out.println("\nThere's danger nearby!\n");
			}else{
				inBattle = false;
			}
			
			// This is our battle system.
			if(inBattle){
				
				//Prints your HP and Mana.
				System.out.println("HP: "+curHP+"/"+maxHP+"   |   Mana: "+curMana+"/"+maxMana+"\n");
				
				// Print the names and HPs of all monsters in the room.
				for(Monster m : map.curRoom.monsterList){
					System.out.println(m.name.toUpperCase().charAt(0)+m.name.substring(1)+": "+m.curHP+"/"+m.maxHP);
				}
				
				System.out.println("\nWhat would you like to do?");
				String[] inputs = sc.nextLine().trim().toLowerCase().split(" ");
				ArrayList<String> strs = new ArrayList<String>();
				for(int i = 0; i < inputs.length; i++){
					if (!inputs[i].equals("the") && !inputs[i].equals("of") && !inputs[i].equals("at")
							&& !inputs[i].equals("") && !inputs[i].equals("an") && !inputs[i].equals("and")
							&& !inputs[i].equals("a") && !inputs[i].equals("in") && !inputs[i].equals("under")
							&& !inputs[i].equals("over") && !inputs[i].equals("behind") && !inputs[i].equals("front")
							&& !inputs[i].equals("its") && !inputs[i].equals("my"))
						strs.add(inputs[i].toLowerCase());
				}
				String cmd = strs.get(0);
				switch(cmd){
				case "attack":
				case "fight":
					if (strs.size() > 1) {
						boolean found = false;
						for (Monster m : map.curRoom.monsterList) {
							if (m.name.contains(strs.get(1))) {
								int result = runAttackSequence(m);
								switch(result){
								case -1:
									doneYet = true;
									break;
								case 1:
									runLootSequence(m);
									break;
								}
								found = true;
								break;
							}
						}
						if(!found) System.out.println("Sorry, I couldn't find an enemy whose name matched \"" + strs.get(1) + "\".");
					} else {
						Monster m = map.curRoom.monsterList.get(0);
						int result = runAttackSequence(m);
						switch(result){
						case -1:
							doneYet = true;
							break;
						case 1:
							runLootSequence(m);
							break;
						}
					}
					break;
				case "drink":
				case "eat":
				case "use":
					if (strs.size() > 1) {
						Consumable i =getConsumableFromInventory(strs.get(1));
						if(i != null){
							useItem(i);
							break;
						}
						System.out.println("Sorry, I couldn't find an item whose name matched \"" + strs.get(1) + "\".");
					} else
						System.out.println("Sorry, I didn't catch that. Try again.");
					break;
				case "run":
					System.out.println("You can't run away! You're being attacked!");
					break;
				default:
					System.out.println("You can't do that! You're being attacked!");
					break;
				}
				shouldPrintD = false;
				continue;
			}
			if(map.pos[0]==0 && map.pos[1] == 0 && map.pos[2] == 2) break;
			shouldPrintD = true;
			System.out.println("\nWhat would you like to do?\n");
			String in = sc.nextLine();
			String[] inputs = in.split(" ");
			ArrayList<String> strs = new ArrayList<String>();
			for(int i = 0; i < inputs.length; i++){
				if (!inputs[i].equals("the") && !inputs[i].equals("of") && !inputs[i].equals("at")
						&& !inputs[i].equals("") && !inputs[i].equals("an") && !inputs[i].equals("and")
						&& !inputs[i].equals("a") && !inputs[i].equals("in") && !inputs[i].equals("under")
						&& !inputs[i].equals("over") && !inputs[i].equals("behind") && !inputs[i].equals("front")
						&& !inputs[i].equals("its") && !inputs[i].equals("my"))
					strs.add(inputs[i].toLowerCase());
			}
			String cmd = strs.get(0);
			if(cmd.equals("whatever")||cmd.equals("exit")||cmd.equals("end")||cmd.equals("stop")) break;
			
			switch(cmd){
			
			case "look":
				if (strs.size() < 2)
					break;
				if (strs.get(1).equals("crate") && bunkerFound == false) {
					if (map.pos[0] == 5 && map.pos[1] == 1 && map.pos[2] == 1) {
						shouldPrintD = false;
						System.out.println("You take a closer look at the crate and see that it's actually a trapdoor!\n"
								+ "You pull at its edge and it easily flips open, revealing a ladder leading down to a bunker.");
						bunker.locked = false;
						bunkerFound = true;
						field11.descr = "You're in a small clearing in the trees.\nThe field extends in all directions.\nThere's an open trapdoor in the ground,\nrevealing a ladder which leads down into a small bunker.";
					}
				}
				if (strs.get(1).equals("box") && keyFound == false) {
					if (map.pos[0] == 0 && map.pos[1] == 0 && map.pos[2] == 0) {
						shouldPrintD = false;
						System.out.println("You open the box and find a key inside.\nThe box crumbles to bits.");
						bunker.locked = false;
						keyFound = true;
						house0.descr = "You're in the basement of the house.\nIt smells musty down here...";
					}
				}
				if (strs.get(1).equals("notepad") && map.pos[0] == 5 && map.pos[1] == 1 && map.pos[2] == 0) {
					System.out.println("There's some stuff scribbled on the notepad...\n"
							+ "It looks like it says, \n\n\"Haha yo 420/69 lol betski like a jetski\" \n\n...\n"
							+ "\n...weird.");
					shouldPrintD = false;
				}
				if (strs.get(1).equals("inventory")){
					System.out.println("Inventory:");
					for(Item i : inventory){
						System.out.println("    "+capFirstChar(i.name)+" : "+i.descr);
					}
					shouldPrintD = false;
				}
				break;
			case "get":
			case "grab":
			case "take":
			case "pick":
			case "pull":
				if (strs.get(1).equals("crate") && bunkerFound == false) {
					if (map.pos[0] == 5 && map.pos[1] == 1 && map.pos[2] == 1) {
						shouldPrintD = false;
						System.out.println("You take a closer look at the crate and see that it's actually a trapdoor!\n"
										+ "You pull at its edge and it easily flips open, revealing a ladder leading down to a bunker.");
						bunker.locked = false;
						bunkerFound = true;
						field11.descr = "You're in a small clearing in the trees.\nThe field extends in all directions.\nThere's an open trapdoor in the ground,\nrevealing a ladder which leads down into a small bunker.";
					}
				} else if (strs.get(1).equals("box") && keyFound == false) {
					if (map.pos[0] == 0 && map.pos[1] == 0 && map.pos[2] == 0) {
						shouldPrintD = false;
						System.out.println("You open the box and find a key inside.\nThe box crumbles to bits.");
						inventory.add(key);
						bunker.locked = false;
						keyFound = true;
						house0.descr = "You're in the basement of the house.\nIt smells musty down here...";
					}
				}else{
					getItemFromRoom(strs.get(1));
				}
				break;
			case "walk":
			case "travel":
			case "move":
			case "go":
				if(strs.size() < 2) break;
				if(strs.get(1).charAt(0) == 'n'){
					int canMove = map.canMoveNorth();
					if(canMove == -1) {
						System.out.println("You can't go there!");
						shouldPrintD = false;
						break;
					}
					else if(canMove == 0) {
						System.out.println("Hmm... it's locked.");
						shouldPrintD = false;
						break;
					}
					else
						map.moveNorth();
				}
				else if(strs.get(1).charAt(0) == 's'){
					int canMove = map.canMoveSouth();
					if(canMove == -1) {
						System.out.println("You can't go there!");
						shouldPrintD = false;
						break;
					}
					else if(canMove == 0) {
						System.out.println("Hmm... it's locked.");
						shouldPrintD = false;
						break;
					}
					else
						map.moveSouth();
				}
				else if(strs.get(1).charAt(0) == 'e'){
					int canMove = map.canMoveEast();
					if(canMove == -1) {
						System.out.println("You can't go there!");
						shouldPrintD = false;
						break;
					}
					else if(canMove == 0) {
						System.out.println("Hmm... it's locked.");
						shouldPrintD = false;
						break;
					}
					else
						map.moveEast();
				}
				else if(strs.get(1).charAt(0) == 'w'){
					int canMove = map.canMoveWest();
					if(canMove == -1) {
						System.out.println("You can't go there!");
						shouldPrintD = false;
						break;
					}
					else if(canMove == 0) {
						System.out.println("Hmm... it's locked.");
						shouldPrintD = false;
						break;
					}
					else
						map.moveWest();
				}
				else if(strs.get(1).charAt(0) == 'u'){
					int canMove = map.canMoveUp();
					if(canMove == -1) {
						System.out.println("You can't go there!");
						shouldPrintD = false;
						break;
					}
					else if(canMove == 0) {
						System.out.println("Hmm... it's locked.");
						if(map.pos[0] == 0 && map.pos[1] == 0 && map.pos[2] == 1){
							System.out.println("There's a keyhole in the ceiling! maybe there's a key somewhere...");
						}
						shouldPrintD = false;
						break;
					}
					else
						map.moveUp();
				}
				else if(strs.get(1).charAt(0) == 'd'){
					int canMove = map.canMoveDown();
					if(canMove == -1) {
						System.out.println("You can't go there!");
						shouldPrintD = false;
						break;
					}
					else if(canMove == 0) {
						System.out.println("Hmm... it's locked.");
						if(map.pos[0] == 0 && map.pos[1] == 0 && map.pos[2] == 1 && basementUnlocked == false){
							System.out.println("There's a combination lock here. Would you like to try enter a code? (yes/no)");
							char yn = sc.nextLine().trim().toLowerCase().charAt(0);
							if(yn == 'y'){
								System.out.println("Enter a 5-digit code: (xxxxx)");
								int combo = Integer.parseInt(sc.nextLine().trim());
								if(combo == ((int)0xA455)){
									house0.locked = false;
									basementUnlocked = true;
									System.out.println("You enter the combination and the door creaks open.");
								}else System.out.println("You enter the combination, but the door won't budge.\nMaybe there's a clue somewhere...");
							}
						}
						shouldPrintD = false;
						break;
					}
					else
						map.moveDown();
				}
				break;
			case "climb":
				if(strs.size() < 2){
					if(map.canMoveUp() == -1 && map.canMoveDown() == -1){
						System.out.println("Looks like you can't do that...");
						break;
					}
					else if(map.canMoveUp() != -1){
						int canMove = map.canMoveUp();
						if(canMove == 0) {
							System.out.println("Hmm... it's locked.");
							shouldPrintD = false;
							break;
						}
						else
							map.moveUp();
					}else if(map.canMoveDown() != -1){
						int canMove = map.canMoveDown();
						if(canMove == 0) {
							System.out.println("Hmm... it's locked.");
							shouldPrintD = false;
							break;
						}
						else
							map.moveDown();
					}
				}else{
					if(strs.get(1).charAt(0) == 'u'){
						int canMove = map.canMoveUp();
						if(canMove == -1) {
							System.out.println("You can't go there!");
							shouldPrintD = false;
							break;
						}
						else if(canMove == 0) {
							System.out.println("Hmm... it's locked.");
							shouldPrintD = false;
							break;
						}
						else
							map.moveUp();
					}
					else if(strs.get(1).charAt(0) == 'd'){
						int canMove = map.canMoveDown();
						if(canMove == -1) {
							System.out.println("You can't go there!");
							shouldPrintD = false;
							break;
						}
						else if(canMove == 0) {
							System.out.println("Hmm... it's locked.");
							shouldPrintD = false;
							break;
						}
						else
							map.moveDown();
					}
				}
				break;
			case "drink":
			case "eat":
				if (strs.size() > 1) {
					Consumable i =getConsumableFromInventory(strs.get(1));
					if(i != null){
						useItem(i);
						break;
					}
					System.out.println("Sorry, I couldn't find an item whose name matched \"" + strs.get(1) + "\".");
				} else
					System.out.println("Sorry, I didn't catch that. Try again.");
				break;
			case "use":
				if(strs.size() < 2) break;
				if(strs.get(1).equals("key")){
					if(map.pos[0]==0 && map.pos[1] == 0 && map.pos[2]==1 && atticUnlocked == false){
						if(inventoryContains("key")){
							System.out.println("You use the key and hear the latch click open.");
							house2.locked = false;
							atticUnlocked = true;
						}else System.out.println("You need a key first.");
					}
				}else{
					if (strs.size() > 1) {
						Consumable i =getConsumableFromInventory(strs.get(1));
						if(i != null){
							useItem(i);
							break;
						}
						System.out.println("Sorry, I couldn't find an item whose name matched \"" + strs.get(1) + "\".");
					} else
						System.out.println("Sorry, I didn't catch that. Try again.");
					break;
				}
				break;
			case "unlock":
				if(map.pos[0]==0 && map.pos[1] == 0 && map.pos[2]==1 && atticUnlocked == false){
					if(inventoryContains("key")){
						System.out.println("You use the key and hear the latch click open.");
						house2.locked = false;
						atticUnlocked = true;
					}else System.out.println("You need a key first.");
				}
				break;
			case "inventory":
			case "items":
				System.out.println("Inventory:");
				for(Item i : inventory){
					System.out.println(capFirstChar(i.name));
				}
				shouldPrintD = false;
				break;
			case "equip":
				if (strs.size() > 1 && inventoryContains(strs.get(1))) {
					Equippable i = getEquippableFromInventory(strs.get(1));
					if (i != null) {
						equip(i);
						break;
					}
				}
			default:
				System.out.println("Sorry, I didn't catch that - come again?");
				shouldPrintD = false;
				break;
			}
			if(!map.curRoom.monsterList.isEmpty()){
				inBattle = true;
			}
		}
		System.out.println("Thanks for playing!");
		sc.close();
	}
	
	public static boolean bunkerFound = false;
	public static boolean keyFound = false;
	public static boolean basementUnlocked = false;
	public static boolean atticUnlocked = false;
	public static Key key = new Key();
	public static boolean inBattle = false;
	
	public static int maxHP = 100;
	public static int curHP = 100;
	public static int maxMana = 100;
	public static int curMana = 100;
	
	/* TODO: 
	 * - Add 'inventory' keyword to display your inventory
	 */
	
	public static boolean inventoryContains(String item){
		//System.out.println("Input item name: \""+item+"\"");
		for(Item i : inventory){
			//System.out.println("\""+i.name+"\"");
			if(i.name.contains(item)) return true;
		}
		return false;
	}
	
	public static Item getItemFromInventory(String item){
		for(Item i : inventory){
			if(i.name.contains(item)) return i;
		}
		return null;
	}
	
	public static Equippable getEquippableFromInventory(String item){
		Item i = getItemFromInventory(item);
		return (i.type == Item.Type.EQUIPPABLE ? (Equippable) i : null);
	}
	
	public static Consumable getConsumableFromInventory(String item){
		Item i = getItemFromInventory(item);
		return (i.type == Item.Type.CONSUMABLE ? (Consumable) i : null);
	}
	
	public static void equip(Equippable i){
		if(equipment.isEmpty()){
			equipment.add(i);
			inventory.remove(i);
			System.out.println(capFirstChar(i.name)+" has been equipped to the "+i.area.name().toLowerCase()+" slot.");
			updateDice();
			return;
		}
		else {
			for (Equippable e : equipment) {
				if (e.area == i.area) {
					inventory.add(e);
					equipment.remove(e);
					equipment.add(i);
					inventory.remove(i);
					System.out.println(capFirstChar(i.name)+" has replaced "+capFirstChar(e.name)+" in the "+i.area.name().toLowerCase()+" slot.");
					updateDice();
					return;
				}
			}
			equipment.add(i);
			inventory.remove(i);
			System.out.println(capFirstChar(i.name)+" has been equipped to the "+i.area.name().toLowerCase()+" slot.");
			updateDice();
			return;
		}
	}
	
	public static String capFirstChar(String in){
		return (""+in.toUpperCase().charAt(0)+in.toLowerCase().substring(1));
	}
	
	public static int runAttackSequence(Monster monster){
		for(Monster m : map.curRoom.monsterList){
			int monsterAtk = monster.rollAtk();
			int monsterDef = monster.rollDef();
			int atk = rollAtk();
			boolean enemyHitCheck = (3*monsterAtk) > defDie;
			boolean myHitCheck = (2*atk) > monsterDef;
			if(enemyHitCheck){
				System.out.println("The "+m.name+" strikes you, dealing "+monsterAtk+" damage!");
				curHP -= monsterAtk;
			}else{
				System.out.println("The "+m.name+"'s attack misses, dealing 0 damage.");
			}
			if(m.equals(monster)){
				if(myHitCheck){
					System.out.println("Your attack lands on the "+m.name+", dealing "+atk+" damage.");
					m.curHP -= atk;
				}else{
					System.out.println("The "+m.name+" dodged your attack!");
				}
			}
		}
		if(monster.curHP <= 0){
			map.curRoom.monsterList.remove(monster);
			System.out.println("You've killed the "+monster.name+"!");
			return 1;
		}
		if(curHP <= 0){
			System.out.println("YOU DIED!");
			return -1;
		}
		return 0;
	}
	
	public static void runLootSequence(Monster m){
		if(!m.loot.isEmpty()){
			map.curRoom.itemList.addAll(m.loot);
			System.out.println("The "+m.name+" dropped something:");
			for(Item i : m.loot){
				System.out.println("    "+capFirstChar(i.name));
			}
		}
	}
	
	public static void useItem(Consumable item){
		switch(item.healType){
		case MANA:
			if(curMana == maxMana){
				System.out.println("Your mana is already full!");
				return;
			}
			else curMana += item.healAmt; 
			break;
		case HP:
			if(curHP == maxHP){
				System.out.println("Your health is already full!");
				return;
			}
			else curHP += item.healAmt;
			break;
		case NONE: System.out.println("It doesn't look like you can use that..."); return;
		}
		System.out.println("You use the "+item.name+", healing "+item.healAmt+" "+item.healType.name().toLowerCase()+".");
		inventory.remove(item);
		System.out.println("\nHP: "+curHP+"/"+maxHP+"   |   Mana: "+curMana+"/"+maxMana+"\n");
	}
	
	public static void updateDice(){
		if(equipment.isEmpty()){
			atkDie = FISTS;
			defDie = STD_DEF;
			return;
		}
		for(Equippable e : equipment){
			if(e.area == Equippable.Area.PRIMARY){
				atkDie = e.atkDie;
			}
		}
		int allDefs = 6;
		for(Equippable e : equipment){
			if(e.area == Equippable.Area.BODY || e.area == Equippable.Area.HEAD || e.area == Equippable.Area.SECONDARY){
				allDefs += e.val;
			}
		}
		defDie = allDefs;
		return;
	}
	
	public static int rollAtk(){
		String[] numbers = atkDie.split("d");
		int numDice = Integer.parseInt(numbers[0]);
		int numSides = Integer.parseInt(numbers[1]);
		int toReturn = 0;
		for(int i = 0; i < numDice; i++){
			toReturn += ((int) Math.round( Math.floor(Math.random() * numSides)) ) + 1;
		}
		return toReturn;
	}
	
	public static void getItemFromRoom(String item){
		Item thisI = null;
		for(Item i : map.curRoom.itemList){
			if(i.name.contains(item)){
				thisI = i;
				break;
			}
		}
		if(thisI != null){
			inventory.add(thisI);
			map.curRoom.itemList.remove(thisI);
			System.out.println("You got the "+thisI.name+".");
			return;
		}
		System.out.println("I couldnt find what you were looking for, sorry.");
		return;
	}
}
