package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.HumanPiece;
import main.Snake;

public class EntityTests {

	@Test
	// Testing HumanPiece.activate()
	public void test1() {
		// What does activate do?

	}

	@Test
	// Testing HumanPiece.move()
	public void test2() {

		HumanPiece h = new HumanPiece(1);
		h.move(3);
		assertEquals(h.getLocation(), 3);
	}

	@Test
	// Testing Snake.activate()
	public void test3() {
		
		Snake s = new Snake(20,10);
		HumanPiece h2 = new HumanPiece(20);
		s.activate(h2);
		assertEquals(h2.getLocation(), s.getTail());
	}

	@Test
	// Testing Snake.move()
	public void test4() {

	}

	// Testing Ladder.activate()
	public void test5() {

	}

	// Testing Ladder.move()
	public void test6() {

	}

	@Test
	// Testing Trap.activate()
	public void test7() {

	}

	// Testing Trap.move()
	public void test8() {

	}

}
