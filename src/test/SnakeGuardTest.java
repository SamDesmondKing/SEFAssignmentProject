package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.SnakeGuardPlacementException;
import exceptions.SnakePlacementException;
import main.Model.Entity;
import main.Model.HumanPiece;
import main.Model.SnakeGuard;

public class SnakeGuardTest {

	@Test
	public void test1() {
		SnakeGuard g = new SnakeGuard(50);
		assertEquals(g.getLocation(), 50);
	}

	@Test (expected = SnakeGuardPlacementException.class) 
	public void test2() {
		SnakeGuard g1 = new SnakeGuard(20);
		SnakeGuard g2 = new SnakeGuard(30);
		SnakeGuard g3 = new SnakeGuard(40);
		SnakeGuard g4 = new SnakeGuard(50);
	}
	
	@Test
	public void test3() {
	    SnakeGuard g = new SnakeGuard(60);
		g.move(60);
		assertEquals(g.getLocation(), 60);
	}

}
