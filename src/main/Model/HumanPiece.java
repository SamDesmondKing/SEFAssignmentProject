package main;

public class HumanPiece extends Entity {
	
	int location;
	int ladderCount;
	boolean paralysed;
	
	public HumanPiece(int location) {
		
		this.location = location;
		
	}
	
	//Activate stage three when location 100 is reached after climbing three ladders
	public boolean activate(Entity subject) {
		return true;
	}
	
	//Moves piece from location to target
	public boolean move(int target) {
		return true;
	}
	
	public int getLocation() {
		return this.location;
	}
	
	public void setParalyse(boolean status) {
		this.paralysed = status;
	}

}
