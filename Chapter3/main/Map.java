package Chapter3.main;


/** The Map object serves as our world's map, and holds all of the rooms and information about their positions and such. */
public class Map {
	
	/** This Room will keep track of the room we're currently in, and will be updated every time we change rooms. */
	public Room curRoom;
	
	// Before continuing, go read the Chapter3.main.Room java file, then come back here when you're done.
	
	// The blue comments here are called JavaDoc comments. When you place them just before a method, a variable, or an object,
	// they will pop up when you hover over that object later on in your code.
	// This is really useful and helps you to keep track of what variable/object does what, and exactly what a method returns or does.
	// I'm not going to explain much of the actual code in this java file. I want you to take a look at it and try to figure out how
	// everything works. This java file will serve to teach you JavaDoc.
	
	// This JavaDoc comment is a descriptive statement about this room array, in case we forget what it is or what it's used for later.
	/** This is the three-dimensional array containing all of our rooms. */
	public Room[][][] rooms;
	
	// Here, I've added a link. To check out what it does, hover over the word 'pos' in the variable declaration below.
	// You should then be able to click on the word 'rooms' inside the dialog box that pops up.
	/** This is the integer containing our current position coordinates within {@link #rooms}. */
	public int[] pos = new int[3];
	
	// You can add them to constructors as well.
	/** The Map constructor takes in the size and height of the map, then creates it to be (size x size) rooms North-South-East-West and (height) rooms deep. */
	public Map(int size, int height){
		rooms = new Room[size][size][height];
	}
	
	// And methods. Here's where stuff gets interesting - Notice the @param tag. This allows you to 
	// define all of the parameters you method takes in so that their definitions show up in the JavaDoc popup.
	// Hover over the name of this method ('add') to check it out.
	/** Adds the specified room to {@link #rooms} at the specified position. There's no error handling on this method. 
	 * @param thisRoom : The room to be added to this map.
	 * @param x : The x-coordinate at which it should be added.
	 * @param y : The y-coordinate at which it should be added.
	 * @param z : The z-coordinate at which it should be added. */
	public void add(Room thisRoom, int x, int y, int z){
		this.rooms[x][y][z] = thisRoom;
	}
	
	/** Sets the current room to the Room in {@link #rooms} specified by the given coordinates.
	 * Only use this method to start off the game.
	 * Use {@link #canMoveNorth()} and {@link #moveNorth()} otherwise. 
	 * @param x : The x-coordinate of the room to move to. 
	 * @param y : The y-coordinate of the room to move to.
	 * @param z : The z-coordinate of the room to move to.*/
	public void setCurRoom(int x, int y, int z){
		this.curRoom = this.rooms[x][y][z];
		this.pos[0] = x;
		this.pos[1] = y;
		this.pos[2] = z;
	}
	
	// And here's the @return tag. Use this to define exactly what the method returns.
	// Hover ver the method's name to check it out.
	/** Checks if it's possible to move north from the current room.
	 * @return 1 if it's possible, 0 if the room is locked, and -1 if the room doesn't exist. */
	public int canMoveNorth(){
		if(pos[1]+1 > rooms[0].length - 1) return -1;
		if(this.rooms[pos[0]][pos[1]+1][pos[2]] != null)
			if(!this.rooms[pos[0]][pos[1]+1][pos[2]].locked)
				return 1;
			else
				return 0;
		return -1;
	}
	
	// That's really it for JavaDoc right now - you can either keep reading the rest of these methods to figure out how they work,
	// or you can jump back to Part2_ObjectsAndInheritance.java to keep reading.
	
	/** Checks if it's possible to move south from the current room.
	 * @return 1 if it's possible, 0 if the room is locked, and -1 if the room doesn't exist. */
	public int canMoveSouth(){
		if(pos[1]-1 < 0) return -1;
		if(this.rooms[pos[0]][pos[1]-1][pos[2]] != null)
			if(!this.rooms[pos[0]][pos[1]-1][pos[2]].locked)
				return 1;
			else
				return 0;
		return -1;
	}
	
	/** Checks if it's possible to move east from the current room.
	 * @return 1 if it's possible, 0 if the room is locked, and -1 if the room doesn't exist. */
	public int canMoveEast(){
		if(pos[0] +1 > rooms.length-1) return -1;
		if(this.rooms[pos[0]+1][pos[1]][pos[2]] != null)
			if(!this.rooms[pos[0]+1][pos[1]][pos[2]].locked)
				return 1;
			else
				return 0;
		return -1;
	}
	
	/** Checks if it's possible to move west from the current room.
	 * @return 1 if it's possible, 0 if the room is locked, and -1 if the room doesn't exist. */
	public int canMoveWest(){
		if(pos[0]-1 < 0) return -1;
		if(this.rooms[pos[0]-1][pos[1]][pos[2]] != null)
			if(!this.rooms[pos[0]-1][pos[1]][pos[2]].locked)
				return 1;
			else
				return 0;
		return -1;
	}
	
	/** Checks if it's possible to move upward from the current room.
	 * @return 1 if it's possible, 0 if the room is locked, and -1 if the room doesn't exist. */
	public int canMoveUp(){
		if(pos[2]+1 > rooms[0][0].length-1) return -1;
		if(this.rooms[pos[0]][pos[1]][pos[2]+1] != null)
			if(!this.rooms[pos[0]][pos[1]][pos[2]+1].locked)
				return 1;
			else
				return 0;
		return -1;
	}
	
	/** Checks if it's possible to move downward from the current room.
	 * @return 1 if it's possible, 0 if the room is locked, and -1 if the room doesn't exist. */
	public int canMoveDown(){
		if(pos[2]-1 < 0) return -1;
		if(this.rooms[pos[0]][pos[1]][pos[2]-1] != null)
			if(!this.rooms[pos[0]][pos[1]][pos[2]-1].locked)
				return 1;
			else
				return 0;
		return -1;
	}
	
	/** Sets the current room to the room just north of the player. Call {@link #canMoveNorth()} before calling this method.*/
	public void moveNorth(){
		this.setCurRoom(pos[0], pos[1]+1, pos[2]);
	}
	
	/** Sets the current room to the room just south of the player. Call {@link #canMoveSouth()} before calling this method.*/
	public void moveSouth(){
		this.setCurRoom(pos[0], pos[1]-1, pos[2]);
	}
	
	/** Sets the current room to the room just east of the player. Call {@link #canMoveEast()} before calling this method.*/
	public void moveEast(){
		this.setCurRoom(pos[0]+1, pos[1], pos[2]);
	}
	
	/** Sets the current room to the room just west of the player. Call {@link #canMoveWest()} before calling this method.*/
	public void moveWest(){
		this.setCurRoom(pos[0]-1, pos[1], pos[2]);
	}
	
	/** Sets the current room to the room just above of the player. Call {@link #canMoveUp()} before calling this method.*/
	public void moveUp(){
		this.setCurRoom(pos[0], pos[1], pos[2]+1);
	}
	
	/** Sets the current room to the room just below of the player. Call {@link #canMoveDown()} before calling this method.*/
	public void moveDown(){
		this.setCurRoom(pos[0], pos[1], pos[2]-1);
	}
	
	
}
