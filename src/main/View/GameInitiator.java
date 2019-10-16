package main.View;

import main.Controller.GameController;
import main.Controller.SaveLoadController;
import main.Model.Board;

public class GameInitiator {

   
	
	
	
   // The very first method to be called
   // This method constructs a GameController object and calls its control method 
   public static void main(String args[])
   {
	   Board board = new Board();
	   Game game = new Game(board);
       GameController gameController = new GameController(board,game);
       SaveLoadController saveLoadController = new SaveLoadController(board, game, gameController);
       
	   
   }


}