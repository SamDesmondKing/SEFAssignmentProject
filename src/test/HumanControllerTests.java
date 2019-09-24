package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.HumanPiecePlacementException;
import main.Controller.HumanController;
import main.Model.HumanPiece;

public class HumanControllerTests {

	@Test 
	public void test1() {
		
		HumanPiece piece = new HumanPiece("1",56);
		HumanController humanController= new HumanController();
		ArrayList<Integer> moves = humanController.finalStageMoveOptions(piece);
		int move = 66;
		try {
			humanController.moveVerifier(move, moves);
			System.out.println("Test passed!");
		}
		catch (HumanPiecePlacementException e) {
			System.out.println(e);
		}
		
	}
	
	@Test (expected = HumanPiecePlacementException.class)
	public void test2() {
		HumanPiece piece = new HumanPiece("1",56);
		HumanController humanController= new HumanController();
		ArrayList<Integer> moves = humanController.finalStageMoveOptions(piece);
		int move = 99;
		try {
			humanController.moveVerifier(move, moves);
			//System.out.println("Test passed!");
		}
		catch (HumanPiecePlacementException e) {
			System.out.println(e);
		}
	}

}
