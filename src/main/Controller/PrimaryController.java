package main.Controller;

import java.io.Serializable;

public class PrimaryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameController gc;
	public PrimaryController(GameController gc) {
		
		this.gc = gc;
	}
}
