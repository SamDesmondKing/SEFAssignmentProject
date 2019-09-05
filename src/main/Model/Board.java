package main.Model;



public class Board {
	
	private int pieces[];
	private Dice dice;
	private Snake[] ss = new Snake[10];
	private Ladder[]ls = new Ladder[10];
	private Trap[] traps = new Trap[10];
	int snakesCount = 0;
	int laddersCount = 0;
	int trapsCount = 0;

	public Board() {
	   this(2);
   }

	public Board(int n) {
      if ( n > 4 || n < 2)
      {
         System.out.println("Minimum 2 players and Maximum 4 players");
         System.exit(0);
      }

      //  r.start();
         
	  pieces = new int[n];
      for (int i=0; i<n; i++)
          pieces[i] = 1;
	}

	public Dice getDice() {
		return dice;
	}
   
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	public Snake[] getSS() {
		return this.ss;
	}
	
	public void setSS(int index, Snake snake) {
		this.ss[index] = snake;
	}
   
	public Ladder[] getLS() {
		return this.ls;
	}
	
	public void setLS(int index, Ladder ladder) {
		this.ls[index] = ladder;
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
   
	public int[] getPieces() {
		return this.pieces;
	}
   
	public void setPiece(int piece, int pos) {
		pieces[piece-1] = pos;
	}
}