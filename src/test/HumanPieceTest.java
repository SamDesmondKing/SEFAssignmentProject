package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.Model.Board;
import main.Model.HumanPiece;
import main.Model.Ladder;
import main.Model.Snake;
import main.Model.SnakeGuard;

public class HumanPieceTest {

	@Test
	public void test1() {
		HumanPiece hp=new HumanPiece("1", 1);
		System.out.println("location:"+hp.getLocation());
		
	}

	@Test
	public void test2() {
		HumanPiece hp=new HumanPiece("2", 25);
		Ladder l = new Ladder(25,35);
		l.activate(hp);
		assertEquals(hp.getLaddersClimbed(), 1);
	}
	
	@Test
	public void test3() {
		HumanPiece hp=new HumanPiece("3", 50);
		Snake s = new Snake(20,10);
		s.activate(hp);
		assertEquals(hp.getParalysedTurns(), 3);
	}
}
