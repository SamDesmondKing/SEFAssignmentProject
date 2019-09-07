package main.Controller;

import java.util.Arrays;
import exceptions.SnakePlacementException;
import main.Model.Entity;
import main.Model.Player;
import main.Model.Snake;

public class SnakeController {
	
	private static final int[] left = {1,20,21,40,41,60,61,80,81,100};
	private static final int[] right = {10,11,30,31,50,51,70,71,90,91};

	//Tells the selected Snake to move to the target location. Throws error if any issues
	public boolean move(Snake thisSnake, int target) throws SnakePlacementException {
		
		//Check for snake guard
		//Check for tail out of bounds
		//Change head position
		//Change tail position
		
		if (thisSnake.getHead() - target == -1 || thisSnake.getHead() - target == 1) {
			//You've moved left or right. Left or right doesn't relate to number size. 
		} else {
			//You've moved up or down. Up or down does relate to number size. 
		}
		
		
		return true;
	}	
	
	//1 is up, 2 is down, 3 is left, 4 is right
	//only checks for snake head out of bounds error, rest should be 
	//checked in snake move function
	public static int getTarget(Snake snake,int direction) throws SnakePlacementException {
		int location = snake.getHead(), index = location, i = 0;
		
		if (direction == 1 && location > 90) {
			throw new SnakePlacementException("Can't move up, already at the top of board");
		}
		else if (direction == 2 && (location >= 11 && location <= 20)) {
			throw new SnakePlacementException("Can't move down, already at the bottom of board");
		}
		else if (direction == 3 && (Arrays.stream(left).anyMatch(x -> x == location))) {
			throw new SnakePlacementException("Can't move left, already at the left side of board");
		}
		else if (direction == 4 && (Arrays.stream(right).anyMatch(x -> x == location))) {
			throw new SnakePlacementException("Can't move right, already at the right side of board");
		}
		if (direction == 1) {
			while (index % 10 != 0) {
				index++;
				i++;
			}
			return location + ((i * 2) + 1);
		}
		else if (direction == 2) {
			while (index % 10 != 1) {
				index--;
				i++;
			}
			return location - ((i * 2) + 1);
		}
		else if (direction == 3) {
			index = Integer.parseInt(Integer.toString(location).substring(0, 1));
			if (index % 2 == 0) {
				return location - 1;
			}
			return location + 1;
		}
		else {
			index = Integer.parseInt(Integer.toString(location).substring(0, 1));
			if (index % 2 == 0) {
				return location + 1;
			}
			return location - 1;
		}
	}
	
}


