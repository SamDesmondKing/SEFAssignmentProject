package main.Controller;

import main.Model.Board;
import main.Model.Ladder;
import main.Model.Snake;
import main.Model.Trap;

public class BoardController {
	
	private Board board;
    int snakesCount;
    int laddersCount;
    int trapsCount;
	
	public BoardController(Board board) {
		this.board = board;
	}
	
	public void add(Snake s) {
		this.snakesCount = board.getSnakesCount();
		
		if (snakesCount < 10) {
			board.setSS(snakesCount, s);
			board.setSnakesCount(++snakesCount);
		}
	}
	   
	public void add(Ladder l) {
		this.laddersCount = board.getLaddersCount();
		
		if (laddersCount < 10) {
			board.setLS(laddersCount, l);
			board.setSnakesCount(++laddersCount);
		}
	}
	public void add(Trap t) {
		this.trapsCount = board.getTrapsCount();
		
		if (trapsCount < 10) {
			board.setTraps(trapsCount, t);
			board.setTrapsCount(++trapsCount);
		}
	}  
}
