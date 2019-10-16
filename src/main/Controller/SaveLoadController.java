package main.Controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.Model.Board;
import main.View.Game;

public class SaveLoadController {
	Board board;
	Game game;
	GameController gameController;
	
	public SaveLoadController(Board board, Game game, GameController gameController) {
		this.board = board;
		this.game  = game;
		this.gameController = gameController;
	}
	public static void save(Board board, String fileName) throws Exception {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName + "board")))){
			oos.writeObject(board);
			oos.close();
		}
	}
	
	public static void save(Game game, String fileName) throws Exception {
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName + "game")))){
			oos.writeObject(game);
			oos.close();
		}
	}
	
	public static void save(GameController gameController, String fileName) throws Exception {
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName + "gameController")))){
			oos.writeObject(gameController);
			oos.close();
		}
	}
	
	
	public static Object load(String fileName) throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
			return ois.readObject();
		}
	}
}
