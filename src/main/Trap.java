package main;

public class Trap extends Entity {
	private int location;
	private int duration;

	public Trap(int loc, int dur) {
		location = loc;
		duration = dur;
	}

	// Applies paralyse effect
	public boolean activate(Entity HumanPiece) {
		return true;
	}

	public boolean move(int target) {
		return true;
	}

	public int getLocation() {
		return location;
	}

	public int getDuration() {
		return duration;
	}
}
