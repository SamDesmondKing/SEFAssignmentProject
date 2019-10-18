package main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JOptionPane;

import main.Model.Board;
import main.View.Game;
import main.View.SaveLoadGui;

public class SaveLoadController implements ActionListener, Serializable {

	private static final long serialVersionUID = 1L;

	GameController gc;
	Board bd;
	Game g;
	SaveLoadGui slg;
	ActionEvent e;
	
	public SaveLoadController(SaveLoadGui slg) {
		this.slg = slg;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.e = e;
		
		if (e.getSource().equals(slg.getNewGameBtn())) {
			slg.getFrame().dispose();
			this.gc = new GameController();
			gc.getPlayers();
		}
		else if (e.getSource().equals(slg.getLoadGameBtn())) {
			slg.getFrame().dispose();
			slg.loadDialog();
		}
		else if (e.getSource().equals(slg.getLoadSubmitBtn())) {
			loadGame();
		}
		else if (e.getSource().equals(slg.getCloseBtn3())) {
			slg.getBox3().dispose();
			slg.initialWindow();
		}
	}
	
	public void loadGame() {
		try {
			this.gc = (GameController) ResourceManager.load(slg.getLoadTxt().getText());
			slg.getBox3().dispose();
			JOptionPane.showMessageDialog(null, "Loaded " + slg.getLoadTxt().getText() + " Successfully.");
			gc.initialise();
			gc.checkStage();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Could not load, because " + e1);
			
		}
		
	}
}
