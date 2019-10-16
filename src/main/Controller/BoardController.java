package main.Controller;

import java.io.Serializable;

import exceptions.LadderPlacementException;
import exceptions.SnakeGuardPlacementException;
import exceptions.SnakePlacementException;
import main.Model.Board;
import main.Model.Ladder;
import main.Model.Snake;
import main.Model.SnakeGuard;

public class BoardController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private int snakesCount;
	private int laddersCount;
	private int snakeGuardsCount;
	private boolean topTwentySnake;
	

	// Constructor
	public BoardController() {
	}

	// Add Snake
	public void add(Snake thisSnake, Board board) throws SnakePlacementException {

		this.snakesCount = board.getSnakesCount();

		// Check max 5 Snakes
		if (this.snakesCount >= 5) {
			System.out.println("z");
			throw new SnakePlacementException("Snake limit reached");
		}

		// Check top/bottom difference
		if (thisSnake.getHead() - thisSnake.getTail() > 30) {
			System.out.println("x");
			throw new SnakePlacementException("Snake length invalid");
		}
		
		//Check top/bottom not in same place and top is above bottom
		if (thisSnake.getTail() >= thisSnake.getHead()) {
			throw new SnakePlacementException("Snake position invalid (tail on or above head");
		}

		// No snake head on existing ladder head/base
		for (Ladder i : board.getLS()) {
			System.out.println("c");
			if (thisSnake.getHead() == i.getTop() || thisSnake.getHead() == i.getBottom()) {
				throw new SnakePlacementException("Snake position invalid (No snake head allowed on existing ladder head/base)");
			}
		}

		// No snake head on another snake head / either side of another snake head
		for (Snake i : board.getSS()) {
			System.out.println("v");
			if (thisSnake.getHead() == i.getHead() || thisSnake.getHead() == (i.getHead() - 1)
					|| thisSnake.getHead() == (i.getHead() + 1)) {
				throw new SnakePlacementException("Snake position invalid (Snakes too close together)");
			}
		}
		
		// Only one snake head allowed in positions 81 to 100
		if (thisSnake.getHead() >= 81 && thisSnake.getHead() <= 100) {
			System.out.println("b");
			if (topTwentySnake == false) {
				this.topTwentySnake = true;
			}
			else {
				System.out.println("n");
				throw new SnakePlacementException("Snake position invalid (Only one snake allowed above location 79.)");
			}
		} 
		
		//Horizontal check
		if (this.horizontalCheck(thisSnake.getHead(), thisSnake.getTail())) {
			throw new SnakePlacementException("Snake position invalid (No horizontal snakes allowed.)");
		}

		// Adding snake to Board
		board.setSS(snakesCount, thisSnake);
		board.setSnakesCount(++snakesCount);
	
	}

	// Add Ladder
	public void add(Ladder thisLadder, Board board) throws LadderPlacementException {

		this.laddersCount = board.getLaddersCount();

		// Check max 5 Ladders
		if (this.laddersCount >= 5) {
			throw new LadderPlacementException("Ladder limit reached");
		}

		// Check top/bottom difference
		if (thisLadder.getTop() - thisLadder.getBottom() > 30) {
			throw new LadderPlacementException("Ladder length invalid");
		}
		
		//Check top/bottom not in same place and top is above bottom
		if (thisLadder.getBottom() >= thisLadder.getTop()) {
			throw new LadderPlacementException("Ladder position invalid (Bottom of ladder is on or above top)");
		}

		// Check ladder doesn't begin or end on a snake head
		for (Snake i : board.getSS()) {
			if (i.getHead() == thisLadder.getTop() || i.getHead() == thisLadder.getBottom()) {
				throw new LadderPlacementException("Ladder position invalid (Ladder clashes with existing snake)");
			}
		}

		// Check ladder top/bottom isn't placed on another ladder top
		for (Ladder i : board.getLS()) {
			if (i.getTop() == thisLadder.getBottom() || i.getTop() == thisLadder.getTop()) {
				throw new LadderPlacementException("Ladder position invalid (Ladders too close together)");
			}
		}

		// Check ladder top and bottom (no position 1 or 100)
		if (thisLadder.getBottom() == 1 || thisLadder.getTop() == 100) {
			throw new LadderPlacementException("Ladder position invalid (No laddet at position 1 or 100)");
		}
		
		//Horizontal check
		if (this.horizontalCheck(thisLadder.getTop(), thisLadder.getBottom())) {
			throw new LadderPlacementException("Ladder position invalid (Ladders can't be horizontal)");
		}

		// Adding ladder to Board
		board.setLS(laddersCount, thisLadder);
		board.setLaddersCount(++laddersCount);
	}
	
	public void add(SnakeGuard thisSnakeGuard, Board board) throws SnakeGuardPlacementException{
		this.snakeGuardsCount = board.getSnakeGuardCount();
		
		for (Snake s : board.getSS()) {
			if (thisSnakeGuard.getLocation() == s.getHead()) {
				throw new SnakeGuardPlacementException("Cannot place trap there!");
			}
		}
		
		board.setSnakeGuards(snakeGuardsCount, thisSnakeGuard);
		board.setSnakeGuardCount(++snakeGuardsCount);
	}
	
	//Check whether Entity is horizontal
	public boolean horizontalCheck(int top, int bottom) {
		
		int board[][] = new int[10][10];
		int square = 1;
		int targetRow = 0;
		boolean result = false;
		
		//2D Array representing the board
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				
				board[i][j] = square;
				square++;
			}
		}
		
		//Finding the index of the row which contains the Entity's top
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				
				if (top == board[i][j]) {
					targetRow = i;	
				}
			}
		}
		
		//Checking whether the bottom is also in that row.
		//If so, it's a horizontal entity and method returns true.
		for (int i = 0; i < 10; i++) {
			if (bottom == board[targetRow][i]) {
				result = true;
			} 
		}
		return result;
	}
}