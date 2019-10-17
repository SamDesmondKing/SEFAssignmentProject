package main.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import exceptions.LadderPlacementException;
import exceptions.SnakeGuardPlacementException;
import exceptions.SnakePlacementException;
import main.Model.Board;
import main.Model.Dice;
import main.Model.HumanPiece;
import main.Model.Ladder;
import main.Model.Player;
import main.Model.Snake;
import main.Model.SnakeGuard;
import main.View.CheckPointGui;
import main.View.Game;
import main.View.SaveLoadGui;

public class GameController implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int maxSnakeGuard = 3;

	ArrayList<Integer> moves = new ArrayList<Integer>();

	int snakesCount = 0;
	int laddersCount = 0;
	int snakeGuardCount = 0;
	private String admin;
	private String humanPlayer;
	private String snakePlayer;
	private Player[] players = new Player[2];

	private HumanPiece piece;
	private Snake snake;
	private int snakeNumber;
	private int pieceNumber;
	static boolean stage1 = false;
	static boolean reached100 = false;
	static boolean finalStageHumanPlayerTurn = false;

	// Creating a Board, dice and a Scanner objects
	Board bd;
	Game game;
	BoardController boardController;
	SnakeController snakeController;
	HumanController humanController;
	SaveLoadGui saveLoadGui;
	Dice dice;
	
	
	CheckPointController cpc;


	public GameController() {
		
		this.bd = new Board();
		this.game = new Game(bd);
		this.dice = bd.getDice();
		
		this.cpc = new CheckPointController(this);
		
		
		
		
		
		
		
		
	}
	
	public void initialise() {
		
		
		this.game = new Game(bd);
		
	
	}
	

	/*
	 * public void setup(Board bd) throws Exception {
	 * 
	 * 
	 * boardController = new BoardController(); //int choice = 0;
	 * //boardController.add(new Trap(25,3)); //boardController.add(new Trap(95,3));
	 * 
	 * 
	 * boardController.add(new Snake(92,34), bd); boardController.add(new
	 * Snake(62,12), bd); boardController.add(new Snake(41,3), bd);
	 * boardController.add(new Snake(99,10), bd);
	 * 
	 * snakesCount = 3;
	 * 
	 * boardController.add(new Ladder(7,49), bd); boardController.add(new
	 * Ladder(55,90), bd); boardController.add(new Ladder(38,86), bd); laddersCount
	 * = 3;
	 * 
	 * }
	 */

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	// A method to print a message and to read an int value in the range specified
	int getInt(String message, int from, int to) {
		String s;
		int n = 0;
		boolean invalid;
		do {
			invalid = false;
			s = (String) JOptionPane.showInputDialog(null, message, "Customized Dialog", JOptionPane.PLAIN_MESSAGE);
			try {
				n = Integer.parseInt(s);
				if (n < from || n > to)
					plainMessage("Re-enter: Input not in range " + from + " to " + to);
			} catch (NumberFormatException nfe) {
				plainMessage("Re-enter: Invalid number");
				invalid = true;
			}
		} while (invalid || n < from || n > to);
		return n;
	}

	// A method to print a message and to read a String
	String getString(String message) {

		String s;

		do {

			s = (String) JOptionPane.showInputDialog(null, message, "Enter Player Name", JOptionPane.PLAIN_MESSAGE);
		} while (s.trim().equals(""));

		/*
		 * JOptionPane optionPane = new JOptionPane("Its me" , JOptionPane.PLAIN_MESSAGE
		 * , JOptionPane.DEFAULT_OPTION , null, null, "Please ENTER your NAME here");
		 * optionPane.setWantsInput(true); JDialog dialog =
		 * optionPane.createDialog(null, "Enter Player Name"); dialog.setLocation(150,
		 * 475); dialog.setVisible(true); s = (String) optionPane.getInputValue();
		 */
		return s;
	}

	// A method to print a message
	void plainMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "A prompt message", JOptionPane.PLAIN_MESSAGE);
	}

	public void initialStage() {
		int count = 1, snakeHead, snakeTail, ladderTop, ladderBottom;

		while (count < 6) {
			snakeHead = getInt(admin + ": Enter position for Snake " + count + "'s head", 0, 100);
			snakeTail = getInt(admin + ": Enter position for Snake " + count + "'s tail", 0, 100);
			try {
				boardController.add(new Snake(snakeHead, snakeTail), bd);
				// Gives snake to BoardController, which verifies conditions
				// BoardController adds snake to Board.
			} catch (SnakePlacementException e) {
				plainMessage(e.getMessage());
				continue;
			}
			count++;
		}
		count = 1;
		while (count < 6) {
			ladderTop = getInt(admin + ": Enter position for Ladder " + count + "'s top", 0, 100);
			ladderBottom = getInt(admin + ": Enter position for Ladder " + count + "'s bottom", 0, 100);
			try {
				boardController.add(new Ladder(ladderBottom, ladderTop), bd);
				// Gives ladder to BoardController, which verifies conditions
				// BoardController adds ladder to Board.
			} catch (LadderPlacementException e) {
				plainMessage(e.getMessage());
				continue;
			}
			count++;
		}
		
	}

	public void updateParalysedPieces() {
		int turns;
		boolean isParalysed;
		for (HumanPiece piece : bd.getPieces()) {
			isParalysed = piece.getParalyse();
			turns = piece.getParalysedTurns();
			if (isParalysed) {
				if (turns + 1 == 3) {
					piece.setParalyse(false);
					piece.setParalysedTurns(0);
				} else {
					piece.setParalysedTurns(turns + 1);
				}
			}
		}
	}

	public boolean checkAllPieceParalysed() {
		for (HumanPiece piece : bd.getPieces()) {
			if (!piece.getParalyse()) {
				return false;
			}
		}
		return true;
	}

	public void snakeInfo() {
		if (!stage1) {
			return;
		}
		int count = 1;
		for (Snake snake : bd.getSS()) {
			game.addMessage("Snake " + count + "'s Head: " + snake.getHead());
			count++;
		}
	}

	public void secondStageHumanPlayerTurn() {
		int val, location, snakeGuard;

		if (checkAllPieceParalysed() && snakeGuardCount == maxSnakeGuard) {
			updateParalysedPieces();
			plainMessage("All pieces paralysed and no snake gaurds left. Humans' turn skipped.");
			return;
		}
		while (true) {
			pieceNumber = getInt(humanPlayer + ": Enter piece number to move or " + "5 to place snake guard ", 1, 5);
			if (pieceNumber == 5 && snakeGuardCount == maxSnakeGuard) {
				plainMessage("Maximum number of snake guards already on the board");
				continue;
			} else if (pieceNumber == 5) {
				while (true) {
					snakeGuard = getInt(humanPlayer + ": Enter location for Snake " + "Guard", 1, 100);
					try {
						boardController.add(new SnakeGuard(snakeGuard), bd);
						plainMessage("Snake Guard placed! No moves this turn.");
						return;
					} catch (SnakeGuardPlacementException e) {
						plainMessage(e.getMessage());
						continue;
					}
				}
			}
			piece = bd.getPiece(pieceNumber - 1);

			if (!piece.getParalyse()) {
				break;
			}
			plainMessage("Piece is paralysed!");
		}
		location = piece.getLocation();
		val = getInt(humanPlayer + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
		if (val == 0)
			val = dice.roll();
		else
			dice.set(val);
		location += val;
		if (location > 100) {
			updateParalysedPieces();
			plainMessage("Cannot move there!");
			return;
		}
		if (location == 100) {
			if (piece.getLaddersClimbed().size() >= 3) {
				reached100 = true;
				piece.activate();
				game.setPiece(piece, location);
				updateParalysedPieces();
				return;
			}
			updateParalysedPieces();
			plainMessage("This piece can't land on 100 as it did not climb 3 distinct ladders");
			return;
		}
		game.setPiece(piece, location);
		loop: for (Snake snake : bd.getSS()) {
			if (snake.getHead() == location) {
				location = snake.getTail();
				game.setPiece(piece, location);
				piece.setParalyse(true);
				piece.setParalysedTurns(0);
				break loop;
			}
		}
		newloop: for (Ladder ladder : bd.getLS()) {
			System.out.println(ladder.getBottom());
			if (ladder.getBottom() == location) {
				if (!piece.getLaddersClimbed().contains(ladder)) {
					piece.setLaddersClimbed(ladder);
					location = ladder.getTop();
					game.setPiece(piece, location);
					return;
				}
				break newloop;
			}
		}
		updateParalysedPieces();
	}

	public void secondStageSnakePlayerTurn() {
		int direction, target;
		snakeNumber = getInt(snakePlayer + ": Enter Snake number to move ", 1, 5);
		snake = bd.getSS().get(snakeNumber - 1);
		while (true) {
			direction = getInt(
					snakePlayer + ": Enter number for direction - 1 for up, " + "2 for down, 3 for left, 4 for right ",
					1, 4);
			try {
				target = snakeController.getTarget(snake, direction);
			} catch (Exception e) {
				plainMessage(e.getMessage());
				continue;
			}
			try {
				snakeController.move(snake, target, bd);
			} catch (SnakePlacementException e) {
				plainMessage(e.getMessage());
				continue;
			}
			break;

		}
		for (HumanPiece piece : bd.getPieces()) {
			if (snake.getHead() == piece.getLocation()) {
				piece.setLocation(snake.getTail());
				game.setPiece(piece, piece.getLocation());
				piece.setParalyse(true);
				piece.setParalysedTurns(0);
			}
		}
	}

	public boolean secondStage() {

		int humansTurn = 0;
		plainMessage("Board has been set! Second stage has commenced.");
		while (humansTurn != 50 && reached100 == false) {
			for (Player player : players) {

				if (player.getType().equals("HUMANCONTROLLER")) {
					secondStageHumanPlayerTurn();
				} else {
					if (reached100 != false) {
						break;
					}
					snakeInfo();
					secondStageSnakePlayerTurn();
					game.clearMessages(5);
				}
			}
			humansTurn++;
		}
		if (humansTurn == 50 && reached100 == false) {
			plainMessage("50 turns finished without reaching 100, Snakes win!");
			return false;
		}
		game.addMessage("100 reached! Final stage has commenced.");
		return true;
	}

	public void finalStageHumanPlayerTurn() {
		int move;
		while (true) {
			pieceNumber = getInt(humanPlayer + ": Enter piece number to move", 1, 4);
			piece = bd.getPiece(pieceNumber - 1);
			if (piece.getisActivated()) {
				plainMessage("This piece has reached 100 and cannot move!");
				continue;
			}
			moves = humanController.finalStageMoveOptions(piece);
			System.out.println(moves.toString());
			game.setMoves(moves);
			game.addMessage("Moves: " + moves.toString());
			move = getInt(humanPlayer + ": Enter legible location to move to", 1, 100);
			if (!moves.contains(move)) {
				game.clearMoves();
				if (("Moves: " + moves.toString()).length() > 30) {
					game.clearMessages(2);
				} else {
					game.clearMessages(1);
				}
				plainMessage("Can't move there, pick from greyed boxes");
				continue;
			}
			if (("Moves: " + moves.toString()).length() > 30) {
				game.clearMessages(2);
			} else {
				game.clearMessages(1);
			}
			game.setPiece(piece, move);
			break;
		}
		loop: for (Snake snake : bd.getSS()) {
			if (snake.getTail() == move) {
				bd.removeSnake(snake);
				if (bd.getSS().size() != 0) {
					plainMessage("Snake destroyed! Only " + bd.getSS().size() + " more to go!");
				}
				break loop;
			} else if (snake.getHead() == move) {
				bd.removePiece(pieceNumber - 1);
				game.clearMoves();
				return;
			}
		}
		game.clearMoves();

	}

	public void finalStageSnakePlayerTurn() {
		int direction, target;

		while (true) {
			snakeNumber = getInt(snakePlayer + ": Enter Snake number to move ", 1, bd.getSS().size());
			snake = bd.getSS().get(snakeNumber - 1);
			direction = getInt(
					snakePlayer + ": Enter number for direction - 1 for up, " + "2 for down, 3 for left, 4 for right ",
					1, 4);
			try {
				target = snakeController.getTarget(snake, direction);
			} catch (Exception e) {
				plainMessage(e.getMessage());
				continue;
			}
			try {
				snakeController.move(snake, target, bd);
			} catch (SnakePlacementException e) {
				plainMessage(e.getMessage());
				continue;
			}
			break;
		}
		for (HumanPiece piece : bd.getPieces()) {
			if (snake.getTail() == piece.getLocation()) {
				bd.removeSnake(snake);
				plainMessage("Snake destroyed! Poor move!");
			} else if (snake.getHead() == piece.getLocation()) {
				bd.removePiece(pieceNumber - 1);
				plainMessage("Human piece destroyed!");
				return;
			}
		}
	}

	// checks stage 2 win condition (Snakes' win)
	public boolean stage2WinCheck(int humansTurn) {
		return (humansTurn == 50 && !reached100);
	}

	// checks stage 3 win condition for both snakes and humans
	public boolean stage3WinCheck(int humansTurn) {
		boolean humansWin = bd.getSS().size() == 0;
		boolean snakesWin = Arrays.stream(bd.getPieces()).anyMatch(x -> x == null)
				|| (humansTurn == 20 && bd.getSS().size() != 0);
		return (humansWin || snakesWin);
	}

	public void finalStage() {
		bd.clearLadders();
		bd.clearSnakeGuards();

		int humansTurn = 0;
		while (!stage3WinCheck(humansTurn)) {
			for (Player player : players) {

				if (player.getType().equals("HUMANCONTROLLER")) {
					game.addMessage(humanPlayer + "'s turn (Humans)");
					game.addMessage("------------------------------");
					finalStageHumanPlayerTurn();
					game.clearMessages(2);
					if (stage3WinCheck(humansTurn)) {
						break;
					}
				} else {

					game.addMessage(snakePlayer + "'s turn (Snakes)");
					game.addMessage("------------------------------");
					snakeInfo();
					finalStageSnakePlayerTurn();
					game.clearMessages(bd.getSS().size() + 2);
				}
			}
			humansTurn++;
		}
		if (humansTurn == 20 && bd.getSS().size() != 0) {
			plainMessage("20 turns finished without killing all snakes, Snakes win!");
			return;
		} else if (Arrays.stream(bd.getPieces()).anyMatch(x -> x == null)) {
			plainMessage("Humans lost a piece, Snakes win!");
			return;
		}
		plainMessage("The snakes have been defeated! Humans win!");
	}
	
	private int stage;
	
	public void addMessages() {
		game.clearMessages(); // clears the display board
		game.addMessage("Current Players Are - ");
		game.addMessage("Admin : ");
		game.addMessage(admin);
		game.addMessage("Human Player : ");
		game.addMessage(humanPlayer);
		game.addMessage("Snake Player : ");
		game.addMessage(snakePlayer);
		game.addMessage("------------------------------");
	}
	
	public void checkStage() {
		
		if (stage == 1) {
			control();
		}
		if (stage == 2) {
			control2();
		}
		else if (stage == 3) {
			control3();
		}
	}
	
	public void getPlayers() {
		
		admin = getString("Admin name : ");
		humanPlayer = getString("Human player name : ");
		snakePlayer = getString("Snake Player name : ");
		addMessages();
		stage = 1;
		control();
		
	}

	public void control() {
		
		
		players[0] = new Player(humanPlayer, "Human");
		players[1] = new Player(admin, "Snake");
		boardController = new BoardController();
		snakeController = new SnakeController();
		humanController = new HumanController();
		
		
		addMessages();
		//Set up the board
		initialStage();
		stage = 2;
		cpc.getCpg().checkPointDialog();
		
		try {
			ResourceManager.save(this, "3. Save");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//saveLoadGui.checkPointDialog();
		//Place all the pieces on the board
		bd.updateBoard();
		
		
		//control2();
		
		/*
		
		*/
	}
	
	public void control2() {
		bd.updateBoard();
		stage1 = true;
		addMessages();
		
		secondStage();
		stage = 3;
		cpc.getCpg().checkPointDialog();
		
		
	}
	
	public void control3() {
		game.setPiece(bd.getPiece(0), 100);
		finalStage();
		stage = 4;
	}

	public static boolean getStage1() {
		return stage1;
	}

	public static boolean getfinalStageHumanPlayerTurn() {
		return finalStageHumanPlayerTurn;
	}

	public ArrayList<Integer> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<Integer> moves) {
		this.moves = moves;
	}

	public int getSnakesCount() {
		return snakesCount;
	}

	public void setSnakesCount(int snakesCount) {
		this.snakesCount = snakesCount;
	}

	public int getLaddersCount() {
		return laddersCount;
	}

	public void setLaddersCount(int laddersCount) {
		this.laddersCount = laddersCount;
	}

	public int getSnakeGuardCount() {
		return snakeGuardCount;
	}

	public void setSnakeGuardCount(int snakeGuardCount) {
		this.snakeGuardCount = snakeGuardCount;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getHumanPlayer() {
		return humanPlayer;
	}

	public void setHumanPlayer(String humanPlayer) {
		this.humanPlayer = humanPlayer;
	}

	public String getSnakePlayer() {
		return snakePlayer;
	}

	public void setSnakePlayer(String snakePlayer) {
		this.snakePlayer = snakePlayer;
	}

	public HumanPiece getPiece() {
		return piece;
	}

	public void setPiece(HumanPiece piece) {
		this.piece = piece;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public int getSnakeNumber() {
		return snakeNumber;
	}

	public void setSnakeNumber(int snakeNumber) {
		this.snakeNumber = snakeNumber;
	}

	public int getPieceNumber() {
		return pieceNumber;
	}

	public void setPieceNumber(int pieceNumber) {
		this.pieceNumber = pieceNumber;
	}

	public static boolean isReached100() {
		return reached100;
	}

	public static void setReached100(boolean reached100) {
		GameController.reached100 = reached100;
	}

	public static boolean isFinalStageHumanPlayerTurn() {
		return finalStageHumanPlayerTurn;
	}

	public static void setFinalStageHumanPlayerTurn(boolean finalStageHumanPlayerTurn) {
		GameController.finalStageHumanPlayerTurn = finalStageHumanPlayerTurn;
	}

	public Board getBd() {
		return bd;
	}

	public void setBd(Board bd) {
		this.bd = bd;
	}

	public BoardController getBoardController() {
		return boardController;
	}

	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}

	public SnakeController getSnakeController() {
		return snakeController;
	}

	public void setSnakeController(SnakeController snakeController) {
		this.snakeController = snakeController;
	}

	public HumanController getHumanController() {
		return humanController;
	}

	public void setHumanController(HumanController humanController) {
		this.humanController = humanController;
	}

	public SaveLoadGui getSaveLoadGui() {
		return saveLoadGui;
	}

	public void setSaveLoadGui(SaveLoadGui saveLoadGui) {
		this.saveLoadGui = saveLoadGui;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static int getMaxsnakeguard() {
		return maxSnakeGuard;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public static void setStage1(boolean stage1) {
		GameController.stage1 = stage1;
	}
}
