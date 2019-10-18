package test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.SnakePlacementException;
import main.Controller.BoardController;
import main.Controller.SnakeController;
import main.Model.Board;
import main.Model.Dice;
import main.Model.Ladder;
import main.Model.Snake;
import main.Model.SnakeGuard;

public class SnakeControllerTests {
	
	
	
	
	//Check SnakeController.move() to SnakeGuard location
	@Test (expected = SnakePlacementException.class)
	public void test1() throws SnakePlacementException {
		
		//Initializing controllers
		Board b = new Board();
		BoardController  bc = new BoardController();
		SnakeController sc = new SnakeController();
		Snake s = new Snake(24,18);
		SnakeGuard sg = new SnakeGuard(25);
		
		//Adding entities
		try {
			bc.add(s, b);
			bc.add(sg, b);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//Moving Snake to SnakeGuard location
		//Expecting SnakePlacementException
		sc.move(s, 25, b);	
	}
	
	
	//Check SnakeController.move(snake) to location 
	//which already has a snake head 
	@Test (expected = SnakePlacementException.class)
	public void test2() throws SnakePlacementException {
		
		//Initializing controllers
		Board b = new Board();
		BoardController  bc = new BoardController();
		SnakeController sc = new SnakeController();
		Snake s1 = new Snake(24,18);
		Snake s2 = new Snake(20,10);
		
		//Adding entities
		try {
			bc.add(s1, b);
			bc.add(s2, b);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//Moving snake to location of
		//other snake's head.
		sc.move(s1, 20, b);
	}
	/*
	//Testing exception thrown when snake moves to location of ladder head
	@Test (expected = SnakePlacementException.class)
	public void test3() throws SnakePlacementException {
		
		//Initializing controllers
		Board b = new Board();
		BoardController  bc = new BoardController();
		SnakeController sc = new SnakeController();
		Snake s1 = new Snake(24,18);
		Ladder l1 = new Ladder(10,20);
		
		//Adding entities
		try {
			bc.add(s1, b);
			bc.add(l1, b);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//Moving snake to location of
		//ladder head.
		sc.move(s1, 20, b);
	}
	
	//Testing exception thrown when snake moves to location of ladder bottom
	@Test (expected = SnakePlacementException.class)
	public void test4() throws SnakePlacementException {
		
		//Initializing controllers
		Board b = new Board();
		BoardController  bc = new BoardController();
		SnakeController sc = new SnakeController();
		Snake s1 = new Snake(24,18);
		Ladder l1 = new Ladder(10,20);
		
		//Adding entities
		try {
			bc.add(s1, b);
			bc.add(l1, b);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//Moving snake to location of
		//ladder bottom.
		sc.move(s1, 10, b);	
	}
	
			
	//Checking exception thrown when tail would go below zero
	@Test (expected = SnakePlacementException.class)
	public void test5() throws SnakePlacementException {
		
		//Initializing controllers
		Board b = new Board();
		BoardController  bc = new BoardController();
		SnakeController sc = new SnakeController();
		Snake s1 = new Snake(20,1);
		
		//Adding entities
		try {
			bc.add(s1, b);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//Moving snake such that tail would go below zero.
		sc.move(s1, 10, b);
	}		
	
	
	@Test
	//Checking SnakeController.getTarget() returns correct target when given direction
	public void test6() throws SnakePlacementException {
		
		//Initializing controllers
		Board b = new Board();
		BoardController  bc = new BoardController();
		SnakeController sc = new SnakeController();
		Snake s1 = new Snake(20,1);
		
		//Adding entities
		try {
			bc.add(s1, b);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		assertEquals(sc.getTarget(s1,1), 21);
	}
	
	@Test (expected = SnakePlacementException.class)
	//Checking SnakeController.getTarget() 
	//throws exception when given invalid direction
	public void test7() throws SnakePlacementException {
		
		//Initializing controllers
		Board b = new Board();
		BoardController  bc = new BoardController();
		SnakeController sc = new SnakeController();
		Snake s1 = new Snake(20,1);
		
		//Adding entities
		try {
			bc.add(s1, b);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		sc.getTarget(s1,3);
	}
	*/
	@Test
	//successfully move the snake up to a target location
	public void test8() throws SnakePlacementException{
		Board b = new Board();
		BoardController  bc = new BoardController();
		SnakeController sc = new SnakeController();
		Snake s1 = new Snake(25,6);
		
		try {
			bc.add(s1,b);
		} catch (SnakePlacementException e) {
			System.out.println(e);
		}
		sc.move(s1, 36, b);
	}
	
	@Test
	//check that snake length remains same after movement
	public void test9() throws SnakePlacementException{
		Board b = new Board();
		BoardController  bc = new BoardController();
		SnakeController sc = new SnakeController();
		Snake s1 = new Snake(36,27);
		int oldLength = s1.getHead() - s1.getTail();
		System.out.println(s1.getHead()+ ", " + s1.getTail());
		
		try {
			bc.add(s1,b);
		} catch (SnakePlacementException e) {
			System.out.println(e);
		}
		sc.move(s1, 45, b);
		int newLength = s1.getHead() - s1.getTail();
		System.out.println(s1.getHead()+ ", " + s1.getTail());
		assertEquals(oldLength,newLength);
	}
	
}
