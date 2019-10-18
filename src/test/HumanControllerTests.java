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
		
		//initialize piece at a certain location, generate possible move set (final stage)
		HumanPiece piece = new HumanPiece("1",56);
		HumanController humanController= new HumanController();
		ArrayList<Integer> moves = humanController.finalStageMoveOptions(piece);
		System.out.println(moves);
		int move = 66;
		
		//verify move from move set (returns positive)
		try {
			humanController.moveVerifier(move, moves);
			System.out.println("Test passed!");
		}
		catch (HumanPiecePlacementException e) {
			System.out.println(e);
		}
		
	}
	
	@Test (expected = HumanPiecePlacementException.class)
	
	//negative version of test1 (incorrect move input)	
	public void test2() throws HumanPiecePlacementException{
		HumanPiece piece = new HumanPiece("1",56);
		HumanController humanController= new HumanController();
		ArrayList<Integer> moves = humanController.finalStageMoveOptions(piece);
		System.out.println(moves);
		int move = 99;
		
		humanController.moveVerifier(move, moves);
			
	}

}
