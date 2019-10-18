package main.Model;
import java.util.ArrayList;
import java.util.HashMap;


public class Board {
	
	private HumanPiece[] pieces = new HumanPiece[4];
	private ArrayList<Snake> ss;
	private ArrayList<Ladder> ls;
	private ArrayList<SnakeGuard> snakeGuards;
	public HashMap<Entity,Integer> board;
	int snakesCount = 0;
	int laddersCount = 0;
	int snakeGuardCount = 0;

	
	public Board() {
		board = new HashMap<Entity,Integer>();
		for (int i = 0; i < 4; i++) {
			pieces[i] = new HumanPiece("Piece " + (i+1),1);
			updateBoard(pieces[i]);
		}
		ss = new ArrayList<Snake>();
		ls = new ArrayList<Ladder>();
		snakeGuards = new ArrayList<SnakeGuard>();
		
		
	}

	public void updateBoard(Entity entity) {
		if (entity != null) {
			board.put(entity, entity.getLocation());
		}
	}
	
	public void removeEntity(Entity entity) {
		if (board.containsKey(entity)) {
			board.remove(entity);
		}
	}
	
	public HashMap<Entity,Integer> getBoard() {
		return this.board;
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
   
	public void setPiece(HumanPiece piece, int pos) {
		piece.setLocation(pos);
		updateBoard(piece);
	}
	
	public void clearLadders() {
		for (Ladder ladder: ls) {
			removeEntity(ladder);
		} 
		this.ls.clear();
		this.laddersCount = 0;
	}
	
	public void clearSnakeGuards() {
		for (SnakeGuard snakeGuard: snakeGuards) {
			removeEntity(snakeGuard);
		} 
		this.snakeGuards.clear();
		this.snakeGuardCount = 0;
	}
	
	public void removeLadder(Ladder ladder) {
		this.ls.remove(ladder);
		removeEntity(ladder);
		this.laddersCount--;
	}
	
	public void removeSnake(Snake snake) {
		this.ss.remove(snake);
		removeEntity(snake);
		this.snakesCount--;
	}
	
	public void removePiece(int index) {
		this.pieces[index] = null;
		removeEntity(pieces[index]);
	}
}