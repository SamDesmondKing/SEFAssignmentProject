package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.LadderPlacementException;
import exceptions.SnakePlacementException;
import main.View.Game;
import main.Controller.BoardController;
import main.Controller.SnakeController;
import main.Model.Board;
import main.Model.Dice;
import main.Model.Snake;
import main.Model.Ladder;

import static org.hamcrest.CoreMatchers.instanceOf;

//Snake/ladder horizontal check


public class BoardTests {
	
	@Test
	//check if board is constructed
	public void test1() {
		Board board = new Board();
		assertNotNull(board);
	}
	
	@Test
	//check if dice exists
	public void test2() {
		Board board = new Board();
		Game g = new Game(board);
		assertThat(board.getDice(),instanceOf(Dice.class));
	}
	
	@Test
	//Checks adding a snake
	//
	public void test3() {
		
		Board b = new Board();
		BoardController  bc = new BoardController();
		Snake s = new Snake(24,18);
		boolean pass = false;
		
		//Giving snake to BoardController
		try {
			bc.add(s, b);
		}
		catch (Exception e) {
			fail("Snake adding failed (board controller exception)");
		}
		
		//Checking BoardController gave Snake to Board
		for (Snake i : b.getSS()) {
			if (i.getHead() == 24 && i.getTail() == 18) {
				pass = true;
			}
		}
		
		//Checking pass condition
		if (pass == false) {
			fail("Snake adding failed (snake not in expected position)");
		}
	}
	
	@Test
	//Check adding a ladder
	//Checks ladder object is passed to Board 
	//via BoardController, and that top and
	//Bottom are in expected position. 
	public void test4() {
		
		Board b = new Board();
		BoardController  bc = new BoardController();
		Ladder l = new Ladder(18,24);
		boolean pass = false;
		
		//Giving ladder to BoardController
		try {
			bc.add(l, b);
		}
		catch (Exception e) {
			fail("Ladder adding failed (board controller exception)");
		}
		
		//Checking BoardController gave Snake to Board
		for (Ladder i : b.getLS()) {
			if (i.getTop() == 24 && i.getBottom() == 18) {
				pass = true;
			}
		}
		
		//Checking pass condition
		if (pass == false) {
			fail("Ladder adding failed (ladder not in expected position)");
		}
	}
	
	//Tests Exception thrown when adding a sixth Ladder
	@Test (expected = LadderPlacementException.class)
	public void test5() throws LadderPlacementException {
		
		Board b = new Board();
		BoardController  bc = new BoardController();
		
		try {
			bc.add(new Ladder(18,24), b);
			bc.add(new Ladder(7,29), b);
			bc.add(new Ladder(55,65), b);
			bc.add(new Ladder(38,58), b);
			bc.add(new Ladder (9,21), b);
		} catch (Exception e)  {
			System.out.println(e);
			fail("Adding ladders failed");
		}
		
		bc.add(new Ladder(42,56), b);
	}
	
	//Tests exception thrown when adding a sixth Snake
	@Test (expected = SnakePlacementException.class)
	public void test6() throws SnakePlacementException {
		
		Board b = new Board();
		BoardController  bc = new BoardController();
		
		try {
			bc.add(new Snake(24,18), b);
			bc.add(new Snake(29,7), b);
			bc.add(new Snake(65,55), b);
			bc.add(new Snake(58,38), b);
			bc.add(new Snake(21,9), b);
		} catch (Exception e)  {
			System.out.println(e);
			fail("Adding snakes failed");
		}
		
		bc.add(new Snake(56,42), b);
	}
	
	//Tests snake head/tail distance check
	@Test (expected = SnakePlacementException.class)
	public void test7() throws SnakePlacementException {
		
		Board b = new Board();
		BoardController  bc = new BoardController();
	
		bc.add(new Snake(90,24), b);
		
	}	
	
	//Tests ladder head/tail distance check
	@Test (expected = LadderPlacementException.class)
	public void test8() throws LadderPlacementException {
		
		Board b = new Board();
		BoardController  bc = new BoardController();
	
		bc.add(new Ladder(24,90), b);
		
	}	
	
	
	@Test (expected = SnakePlacementException.class)
	public void test9() throws SnakePlacementException {
		
		Board b = new Board();
		BoardController  bc = new BoardController();
		
		bc.add(new Snake(38, 32), b);
	
	}
	
	
	//Tests Ladder horizontal entity check
	@Test (expected = LadderPlacementException.class)
	public void test10() throws LadderPlacementException {
		
		Board b = new Board();
		BoardController  bc = new BoardController();
		
		bc.add(new Ladder(32,38), b);
	
	}

}
