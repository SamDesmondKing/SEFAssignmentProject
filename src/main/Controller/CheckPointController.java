package main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JOptionPane;

import main.View.CheckPointGui;

public class CheckPointController implements ActionListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	GameController gc;
	CheckPointGui cpg;
	
	public CheckPointController(GameController gc) {
		this.gc = gc;
		this.cpg = new CheckPointGui(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getCpg().getSaveBtn())){
			getCpg().getBox().dispose();
			getCpg().saveDialog();
		}
		else if (e.getSource().equals(getCpg().getCloseBtn())) {
			getCpg().getBox().dispose();
			getGc().checkStage();
		}
		else if (e.getSource().equals(getCpg().getSubmitBtn())){
			if (getCpg().getSaveTxt().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Invalid option. Save textfield is empty. Please try again");
			}
			else {
				getCpg().getBox2().dispose();
				try {
					ResourceManager.save(this.gc, getCpg().getSaveTxt().getText());
					JOptionPane.showMessageDialog(null, "Save Successfully As" + getCpg().getSaveTxt().getText());
					getCpg().checkPointDialog();
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			
		}
		else if (e.getSource().equals(getCpg().getLoadBtn())) {
			getCpg().getBox().dispose();
			getCpg().loadDialog();
		}
		else if (e.getSource().equals(getCpg().getCloseBtn2())) {
			getCpg().getBox2().dispose();
			getCpg().checkPointDialog();
		}
		else if (e.getSource().equals(getCpg().getCloseBtn3())) {
			getCpg().getBox3().dispose();
			getCpg().checkPointDialog();
		}
	}
	
	public void loadGame() {
		try {
			this.gc = (GameController) ResourceManager.load(getCpg().getLoadTxt().getText());
			getCpg().getBox3().dispose();
			JOptionPane.showMessageDialog(null, "Loaded " + getCpg().getLoadTxt().getText() + " Successfully.");
			gc.initialise();
			gc.control2();	
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Could not load, because " + e1);
			
		}
	}
	
	
	

	public GameController getGc() {
		return gc;
	}

	public void setGc(GameController gc) {
		this.gc = gc;
	}

	public CheckPointGui getCpg() {
		return cpg;
	}

	public void setCpg(CheckPointGui cpg) {
		this.cpg = cpg;
	}
}
