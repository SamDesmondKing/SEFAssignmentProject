package main.Model;
import java.util.ArrayList;
import java.util.HashMap;



public class Board {
	
	private HumanPiece[] pieces = new HumanPiece[4];
	private Dice dice;
	private ArrayList<Snake> ss;
	private ArrayList<Ladder> ls;
	private ArrayList<SnakeGuard> snakeGuards;
	private HashMap<Integer,Entity> board;
	int snakesCount = 0;
	int laddersCount = 0;
	int snakeGuardCount = 0;

	
	public Board() {
		
		for (int i = 0; i < 4; i++) {
			pieces[i] = new HumanPiece("Piece" + (i+1),1);
		}
		ss = new ArrayList<Snake>();
		ls = new ArrayList<Ladder>();
		snakeGuards = new ArrayList<SnakeGuard>();
		board = new HashMap<Integer,Entity>();
		
	}

	public void updateBoard() {
		if (ss.size() != 0) {
			for (Snake snake: ss) {
				board.put(snake.getLocation(), snake);
			}
		}
		if (ls.size() != 0) {
			for (Ladder ladder: ls) {
				board.put(ladder.getLocation(), ladder);
			}
		}
		if (snakeGuards.size() != 0) {
			for (SnakeGuard snakeGuard: snakeGuards) {
				board.put(snakeGuard.getLocation(), snakeGuard);
			}
		}
		for (HumanPiece piece: pieces) {
			if (piece != null) {
				board.put(piece.getLocation(), piece);
			}
		}
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
		updateBoard();
	}
   
	public ArrayList<Ladder> getLS() {
		return this.ls;
	}
	
	public void setLS(int index, Ladder ladder) {
		this.ls.add(index, ladder);
		updateBoard();
	}
   
	public ArrayList<SnakeGuard> getSnakeGuards() {
		return this.snakeGuards;
	}
   
	public void setSnakeGuards(int index, SnakeGuard snakeGuard) {
		this.snakeGuards.add(index,snakeGuard);
		updateBoard();
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
		updateBoard();
	}
	
	public void clearLadders() {
		this.ls.clear();
		this.laddersCount = 0;
		updateBoard();
	}
	
	public void clearSnakeGuards() {
		this.snakeGuards.clear();
		this.snakeGuardCount = 0;
		updateBoard();
	}
	
	public void removeSnake(Snake snake) {
		this.ss.remove(snake);
		this.snakesCount--;
		updateBoard();
	}
	
	public void removePiece(int index) {
		this.pieces[index] = null;
		updateBoard();
	}
}