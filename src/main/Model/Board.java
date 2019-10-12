package main.Model;
import java.util.ArrayList;
import java.util.HashMap;


public class Board {
	
	private HumanPiece[] pieces = new HumanPiece[4];
	private Dice dice;
	private ArrayList<Snake> ss;
	private ArrayList<Ladder> ls;
	private ArrayList<SnakeGuard> snakeGuards;
	public HashMap<Entity,Integer> board;
	int snakesCount = 0;
	int laddersCount = 0;
	int snakeGuardCount = 0;

	
	public Board() {
		
		for (int i = 0; i < 4; i++) {
			pieces[i] = new HumanPiece("Piece " + (i+1),1);
		}
		ss = new ArrayList<Snake>();
		ls = new ArrayList<Ladder>();
		snakeGuards = new ArrayList<SnakeGuard>();
		board = new HashMap<Entity,Integer>();
		
	}

	//Adds entity to board HashMap
	public void updateBoard(Entity entity) {
		if (entity != null) {
			board.put(entity, entity.getLocation());
		}
	}
	
	//Updates board with contents of entity arrays
	public void updateBoard() {
		
		board.clear();
		
		for (Snake i : this.ss) {
			board.put(i, i.getLocation());
		}
		for (Ladder i : this.ls) {
			board.put(i, i.getLocation());
		}
		for (SnakeGuard i : this.snakeGuards) {
			board.put(i, i.getLocation());
		}
		for (HumanPiece i : this.pieces) {
			board.put(i, i.getLocation());
		}
	
	}
	
	public HashMap<Entity,Integer> getBoard() {
		return this.board;
	}
	
	public Dice getDice() {
		return dice;
	}
   
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	public ArrayList<Snake> getSS() {
		return this.ss;
	}
	
	public ArrayList<SnakeGuard> getSG() {
		return this.snakeGuards;
	}
	
	public void setSS(int index, Snake snake) {
		this.ss.add(index,snake);
		updateBoard(snake);
	}
   
	public ArrayList<Ladder> getLS() {
		return this.ls;
	}
	
	public void setLS(int index, Ladder ladder) {
		this.ls.add(index, ladder);
		updateBoard(ladder);
	}
   
	public ArrayList<SnakeGuard> getSnakeGuards() {
		return this.snakeGuards;
	}
   
	public void setSnakeGuards(int index, SnakeGuard snakeGuard) {
		this.snakeGuards.add(index,snakeGuard);
		updateBoard(snakeGuard);
	}
	
	public int getSnakesCount() {
		return this.snakesCount;
	}
	
	public void setSnakesCount(int snakesCount) {
		this.snakesCount = snakesCount;
	}
   
	public int getLaddersCount() {
		return this.laddersCount;
	}
	
	public void setLaddersCount(int laddersCount) {
		this.laddersCount = laddersCount;
	}
   
	public int getSnakeGuardCount() {
		return this.snakeGuardCount;
	}
	
	public void setSnakeGuardCount(int snakeGuardCount) {
		this.snakeGuardCount = snakeGuardCount;
	}
   
	public HumanPiece[] getPieces() {
		return this.pieces;
	}
	
	public HumanPiece getPiece(int index) {
		return this.pieces[index];
	}
   
	public void setPiece(HumanPiece piece, int pos) {
		piece.setLocation(pos);
		updateBoard(piece);
	}
	
	public void clearLadders() {
		this.ls.clear();
		this.laddersCount = 0;
	}
	
	public void clearSnakeGuards() {
		this.snakeGuards.clear();
		this.snakeGuardCount = 0;
	}
	
	public void removeLadder(Ladder ladder) {
		this.ls.remove(ladder);
		this.laddersCount--;
	}
	
	// Bug here - snake removed from array but not graphically. 
	public void removeSnake(Snake snake) {
		this.ss.remove(snake);
		this.snakesCount--;
		this.updateBoard();
	}
	
	public void removePiece(int index) {
		this.pieces[index] = null;
	}
}