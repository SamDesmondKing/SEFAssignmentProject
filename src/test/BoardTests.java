package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.SnakePlacementException;
import main.Controller.GraphicsController;
import main.Controller.SnakeController;
import main.Model.Board;
import main.Model.Dice;
import main.Model.Snake;

import static org.hamcrest.CoreMatchers.instanceOf;


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
		GraphicsController g = new GraphicsController(board);
		assertThat(board.getDice(),instanceOf(Dice.class));
	}
	/*
	@Test (expected = SnakePlacementException.class)
	public void test3() throws SnakePlacementException {
		Snake snake = new Snake(91,73);
		SnakeController.getTarget(snake,2);
	}
	*/
	
	@Test
	//Mashrur test parts
	public void test3() {
		//test piece  location
		Board b = new Board();
		b.setPiece(b.getPieces()[0], 50);
		assertEquals(b.getPieces()[0].getLocation(), 50);
	}
}
