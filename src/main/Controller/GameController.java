package main.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import exceptions.SnakePlacementException;
import main.Model.Board;
import main.Model.Dice;
import main.Model.HumanPiece;
import main.Model.Ladder;
import main.Model.Player;
import main.Model.Snake;
import main.Model.Trap;

public class GameController {

	private static final int maxSnakeGuard = 3;
	
	ArrayList<Snake> snakes = new ArrayList<Snake>();    	
	ArrayList<Ladder> ladders = new ArrayList<Ladder>();  	
	
	//Trap traps[] = new Trap[10];       	// array can store up to 10 Trap objects
	String name[] = new String[2];  		// array for storing the names
	
	int snakesCount = 0;				 
	int laddersCount = 0;	
	int trapsCount = 0;
	private String admin;
	private String humanPlayer;
	private String snakePlayer;
	private Player adminController;
	private Player humanController;
	private Player snakeController;
	private Player[] players = new Player[2];
	private HumanPiece[] pieces = new HumanPiece[4];
	private HumanPiece piece;
	private Snake snake;
	private int snakeNumber;
	private int pieceNumber;
	static boolean stage1 = false;
	   
	   
	// Creating a Board, dice and a Scanner objects
	Board bd = new Board();
	BoardController boardController;
	GraphicsController graphicsController = new GraphicsController(bd);
	Dice dice = bd.getDice();
	Scanner scan = new Scanner(System.in);
	
	public GameController() {
		
	}
/*	      
	public void setup(Board bd) throws Exception {
		
		
		boardController = new BoardController(bd);
		//int choice = 0;
		//boardController.add(new Trap(25,3));
		//boardController.add(new Trap(95,3));
		trapsCount = 1;
	
		boardController.add(new Snake(92,34));
		boardController.add(new Snake(62,12));	  
		boardController.add(new Snake(41,3));  
		boardController.add(new Snake(99,10));  
	  
		snakesCount = 3;

		boardController.add(new Ladder(7,49));
		boardController.add(new Ladder(55,90));
		boardController.add(new Ladder(38,86));
		laddersCount = 3;
			  
	}	   
*/	     
	   // A method to print a message and to read an int value in the range specified
	   int getInt(String message, int from, int to)
	   {
		   String s;
		   int n = 0;
		   boolean invalid;
		   do {
			 invalid = false;
		     s = (String)JOptionPane.showInputDialog(
		      graphicsController,  message,  "Customized Dialog",
		          JOptionPane.PLAIN_MESSAGE);	
		      try {
		         n = Integer.parseInt(s);
		         if (n < from || n > to )
		    	     plainMessage("Re-enter: Input not in range " + from + " to " + to);
		      }
		      catch (NumberFormatException nfe)
		      {
		    	  plainMessage("Re-enter: Invalid number");
		    	  invalid = true;
		      }
		   } while ( invalid || n < from || n > to);
		   return n;
	   } 
	   
	   // A method to print a message and to read a String
	   String getString(String message)
	   {
		   String s;
		   do {
			   s = (String)JOptionPane.showInputDialog(
					      graphicsController,  message,  "Enter Player Name",
					          JOptionPane.PLAIN_MESSAGE);
		   } while(s.trim().equals(""));
		   
		   return s;
	   }   

	   // A method to print a message
	   void plainMessage(String message)
	   {
	        JOptionPane.showMessageDialog(graphicsController,
			    message, "A prompt message",
			    JOptionPane.PLAIN_MESSAGE);
	   }
	   
	   public void initialStage() {
		   int count = 1,snakeHead,snakeTail,ladderTop,ladderBottom;
		   
		   while (count < 6) {
			   snakeHead = getInt(admin + ": Enter position for Snake " + count + "'s head",0,100);
			   snakeTail = getInt(admin + ": Enter position for Snake " + count + "'s tail",0,100);
			   try {
				   boardController.add(new Snake(snakeHead,snakeTail));
			   }
			   catch(Exception e) {
				   plainMessage(e.getMessage());
				   continue;
			   }
			   count++;
		   }
		   count = 1;
		   while (count < 6) {
			   ladderTop = getInt(admin + ": Enter position for Ladder " + count + "'s top",0,100);
			   ladderBottom = getInt(admin + ": Enter position for Ladder " + count + "'s bottom",0,100);
			   try {
				   boardController.add(new Ladder(ladderBottom,ladderTop));
			   }
			   catch(Exception e) {
				   plainMessage(e.getMessage());
				   continue;
			   }
			   count++;
		   }
		   stage1 = true;
	   }
	   
	   public void updateParalysedPieces() {
		   int turns;
		   boolean isParalysed;
		   for (HumanPiece piece: pieces) {
			   isParalysed = piece.getParalyse();
			   turns = piece.getParalysedTurns();
			   if (isParalysed) {
				   if (turns + 1 == 3) {
					   piece.setParalyse(false);
					   piece.setParalysedTurns(0);
				   }
				   else {
					   piece.setParalysedTurns(turns + 1);
				   }
			   }
		   }
	   }
	   
	   public boolean checkAllPieceParalysed() {
		   for (HumanPiece piece: pieces) {
			   if (!piece.getParalyse()) {
				   return false;
			   }
		   }
		   return true;
	   }
	   
	   public void updateGame() {
		   this.pieces = bd.getPieces();
		   this.snakes = bd.getSS();
		   this.ladders = bd.getLS();
	   }
	   
	   public void humanPlayerTurn() {
		   int val, location;
		   
		   if (checkAllPieceParalysed()) {
			   updateParalysedPieces();
			   return;
		   }
		   while (true) {
			   pieceNumber = getInt(humanPlayer + ": Enter piece to move ",1,4);
			   piece = pieces[pieceNumber - 1];
			   if (!piece.getParalyse()) {
				   break;
			   }
			   plainMessage("Piece is paralysed!");
		   }
		   location = piece.getLocation();
		   val = getInt(humanPlayer + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
		   if ( val == 0)
		          val = dice.roll();
		      else
		    	  dice.set(val);
		   location += val;
		   graphicsController.setPiece(piece,location);
		   loop:
		   for (Snake snake: snakes) {
			   if (snake.getHead() == location) {
				   location = snake.getTail();
				   graphicsController.setPiece(piece,location);
				   piece.setParalyse(true);
				   piece.setParalysedTurns(0);
				   break loop;
			   }
		   }
		   newloop:
		   for (Ladder ladder: ladders) {
			   System.out.println(ladder.getBottom());
			   if (ladder.getBottom() == location) {
				   if (!piece.getLaddersClimbed().contains(ladder)) {
					   piece.setLaddersClimbed(ladder);
					   location = ladder.getTop();
					   graphicsController.setPiece(piece,location);
					   return;
				   }
				   break newloop;
			   }
		   }
		   updateParalysedPieces();
	   }
	   
	   public void snakePlayerTurn() {
		   int direction;
		   snakeNumber = getInt(humanPlayer + ": Enter Snake number to move ",1,5);
		   snake = snakes.get(snakeNumber - 1);
		   while (true) {
			   direction = getInt(snakePlayer + ": Enter number for direction - 1 for up, "
							+ "2 for down, 3 for left, 4 for right ",1,4);
			   
			   if (snake.move(direction)) {
				   break;
			   }
		   }
		   for (HumanPiece piece: pieces) {
			   if (snake.getHead() == piece.getLocation()) {
				   piece.setLocation(snake.getTail());
				   graphicsController.setPiece(piece,piece.getLocation());
				   piece.setParalyse(true);
				   piece.setParalysedTurns(0);
			   }
		   }
	   }
	   
	   public void secondStage() {
		   int humansTurn = 0;
		   
		   while (humansTurn != 50) {
			   for (Player player: players) {
				   updateGame();
				   if (player.getType().equals("HUMANCONTROLLER")) {
					   humanPlayerTurn();
				   }
				   /*
				   else {
					   snakePlayerTurn();
				   }
				   */
			   }
			   humansTurn++;
		   }
	   }
	   
	   
	   // The main method implementing the game logic for Part A
	   // For Part A you may use the hard coded values in the setup() method 
	   // You will need to change the code for Part B
	   // For user interaction use the methods getString, getInt and plainMessage
	   // For display/erase on the board use bd.addMessage(), bd.clearMessages()

	public void control() { 
		
		//int numPlayers = 2;
		   
		//setup(bd);
		   
		boardController = new BoardController(bd);
		graphicsController.clearMessages();  // clears the display board  
		
		admin = getString("Admin name : ");
		humanPlayer = getString("Human player name : ");
		snakePlayer = getString("Snake Player name : "); 
		adminController = new Player(admin,"Admin");
		humanController = new Player(humanPlayer,"Human");
		players[0] = humanController;
		snakeController = new Player(admin,"Snake");
		players[1] = snakeController;
	      
		graphicsController.clearMessages();
		graphicsController.addMessage("Current Players are");
		graphicsController.addMessage("Admin : "); 
		graphicsController.addMessage(admin);
		graphicsController.addMessage("Human Controller : ");
		graphicsController.addMessage(humanPlayer);
		graphicsController.addMessage("Snake Controller : ");
		graphicsController.addMessage(snakePlayer);
		      
		initialStage();
		
		secondStage();
/*	      
	      int p1Location = 1;
	      int p2Location = 1;
	      graphicsController.setPiece(1,p1Location);
	      graphicsController.setPiece(2,p2Location);
	      int val = getInt(humanPlayer + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
	      if ( val == 0)
	          val = dice.roll();
	      else 
	    	  dice.set(val);
	      p1Location += val;
	      plainMessage(humanPlayer + ": moving to " + p1Location);
	      graphicsController.setPiece(1, p1Location);
	      if ( p1Location == 7 )
	      {
	    	  p1Location = 49; // going up the first  ladder
	          plainMessage(humanPlayer + ": goin up a ladder to " + p1Location);
	          graphicsController.setPiece(1, p1Location);
	      } 
	    	  
	      // here we are allowing use to set the dice value for testing purposes
	      val = getInt(snakePlayer + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.",0,6);
	      if ( val == 0)
	          val = dice.roll();
	      else
	    	  dice.set(val);
	      p2Location += val;
	      plainMessage(snakePlayer + ": moving to " + p2Location);
	      graphicsController.setPiece(2, p2Location);
	      if ( p2Location == 7 )
	      {
	    	  p2Location = 49; // going up the first ladder
	          plainMessage(snakePlayer + ": going up a ladder to " + p2Location);
	          graphicsController.setPiece(2, p2Location);
	      }
*/
	      
	      plainMessage("The rest is up to you. You may have to introduce additional variables.");

	      // Complete the game logic
	      // throwing or setting the dice 
	      // moving by dice value and showing the pieces at new position 
	      // moving up the ladder, going down the snake or being trapped (lose 3 moves)  
	      
	      graphicsController.addMessage("Continue until");
	      graphicsController.addMessage("a player gets to 100");
	      graphicsController.addMessage("Remember to have fun!");   
	      graphicsController.addMessage("Danger: Traps,Snakes");    
	      graphicsController.addMessage("Trap: lose 3 moves");
	   }
	
	public static boolean getStage1() {
		return stage1;
	}
}
