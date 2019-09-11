package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Controller.GraphicsController;
import main.Model.Board;
import main.Model.Dice;

public class DiceTest {
	Board b = new Board();
	GraphicsController g = new GraphicsController(b);
	Dice d = new Dice(g);
	
	@Test
	//check if rolls are within bounds (1-6)
	public void testRoll() {
		int n;
		n = d.roll();
		
		if ((n > 6) || (n<1)) {
			fail("Not yet implemented");
		}
		else {
			System.out.println("Success 1!");
		}
	}

	@Test
	public void testSet() {
		int n;
		n = d.set(-1);
		if (n != 1) {
			fail("Not yet implemented");
		}
		
		n = d.set(7);
		if (n != 6) {
			fail("Not yet implemented");
		}
		
		n = d.set(4);
		if (n != 4) {
			fail("Not yet implemented");
		}
		System.out.println("Success2!");
	}

	@Test
	public void testGetThrow() {
		for(int i = 1; i<=6; i++) {
			if (Dice.getThrow() > 6 || Dice.getThrow() <1) {
				fail("Not yet implemented");
			}else {
				System.out.println("Success3!");
			}
		}
	}
}
