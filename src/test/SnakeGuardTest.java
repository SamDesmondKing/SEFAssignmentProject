package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.Model.Entity;
import main.Model.SnakeGuard;

public class SnakeGuardTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		SnakeGuard sg = new SnakeGuard(2);
		boolean move = sg.move(2);
		System.out.print(move+"--------------"+sg.getLocation());
		
	}
	
	@Test
	public void test2() {
		SnakeGuard sg = new SnakeGuard(50);
		boolean move = sg.move(2);
		System.out.print(move+"--------------"+sg.getLocation());
		
	}
	
	@Test
	public void test3() {
		SnakeGuard sg = new SnakeGuard(80);
		boolean move = sg.move(2);
		System.out.print(move+"--------------"+sg.getLocation());
		
	}

}
