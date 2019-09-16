package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.Model.Board;
import main.Model.HumanPiece;

public class HumanPieceTest {

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
		HumanPiece hp=new HumanPiece("test1", 100);
		
		System.out.println("location:"+hp.getLocation());
		System.out.println("ParalysedTurn:"+hp.getParalysedTurns());
		System.out.println("LaddersClimbed:"+hp.getLaddersClimbed());
		System.out.println("Paralyse:"+hp.getParalyse());
	}

	@Test
	public void test2() {
		HumanPiece hp=new HumanPiece("test2", 1);
		
		System.out.println("location:"+hp.getLocation());
		System.out.println("ParalysedTurn:"+hp.getParalysedTurns());
		System.out.println("LaddersClimbed:"+hp.getLaddersClimbed());
		System.out.println("Paralyse:"+hp.getParalyse());
		
	}
	
	@Test
	public void test3() {
		HumanPiece hp=new HumanPiece("test1", 50);
		
		System.out.println("location:"+hp.getLocation());
		System.out.println("ParalysedTurn:"+hp.getParalysedTurns());
		System.out.println("LaddersClimbed:"+hp.getLaddersClimbed());
		System.out.println("Paralyse:"+hp.getParalyse());
	}
}
