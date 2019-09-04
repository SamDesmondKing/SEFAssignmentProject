package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.Model.Board;
import main.Model.Dice;

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
		assertThat(board.getDice(),instanceOf(Dice.class));
	}
}
