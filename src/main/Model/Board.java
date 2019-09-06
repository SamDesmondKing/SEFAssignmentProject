package main.Model;
import java.util.ArrayList;



public class Board {
	
	private HumanPiece[] pieces = new HumanPiece[4];
	private Dice dice;
	private ArrayList<Snake> ss = new ArrayList<Snake>();
	private ArrayList<Ladder> ls = new ArrayList<Ladder>();
	private Trap[] traps = new Trap[10];
	int snakesCount = 0;
	int laddersCount = 0;
	int trapsCount = 0;

	public Board() {
	   this(4);
   }

	public Board(int n) {
      
		//  r.start();   
		for (int i=0; i<n; i++) {
			pieces[i] = new HumanPiece("Piece" + (i+1),1);
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
	
	public void setSS(int index, Snake snake) {
		this.ss.add(index,snake);
	}
   
	public ArrayList<Ladder> getLS() {
		return this.ls;
	}
	
	public void setLS(int index, Ladder ladder) {
		this.ls.add(index, ladder);
	}
   
	public Trap[] getTraps() {
		return this.traps;
	}
   
	public void setTraps(int index, Trap trap) {
		this.traps[index] = trap;
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
   
	public int getTrapsCount() {
		return this.trapsCount;
	}
	
	public void setTrapsCount(int trapsCount) {
		this.trapsCount = trapsCount;
	}
   
	public HumanPiece[] getPieces() {
		return this.pieces;
	}
   
	public void setPiece(HumanPiece piece, int pos) {
		piece.setLocation(pos);
	}
}