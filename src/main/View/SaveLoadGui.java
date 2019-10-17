package main.View;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Controller.GameController;
import main.Controller.SaveLoadController;
import main.Model.Board;

public class SaveLoadGui implements Serializable {
private static final long serialVersionUID = 1L;
	
	GameController gc;
	Board bd;
	Game g;
	
	// Initial Window Variables
	private JFrame frame;
	private Container con;
	private FlowLayout flowLayout;
	private JLabel snakesAndLaddersLbl;
	private JButton newGameBtn;
	private JButton loadGameBtn;
	private JButton loginBtn;
	private JButton exitProgramBtn;
	SaveLoadController slc;
	
	// Load Dialog Variables
	private JDialog box3;
	private JPanel panel3;
	private JLabel loadGameLbl;
	private JTextField loadTxt;
	private JButton loadSubmitBtn, closeBtn3;
	
	
	public SaveLoadGui() {
		slc = new SaveLoadController(this);
	}
	
	public void initialWindow() {
		frame = new JFrame();
		con = new Container();
		flowLayout = new FlowLayout();
		
		JLabel line = new JLabel("            		");
		
		snakesAndLaddersLbl = new JLabel("Snakes and Ladders");
		snakesAndLaddersLbl.setFont(new Font("Courier", Font.PLAIN, 20));
		
		JLabel line1 = new JLabel("            		");
		
		newGameBtn = new JButton("New Game");
		newGameBtn.setSize(25, 25);
		
		loadGameBtn = new JButton("Load Game");
		loadGameBtn.setSize(25, 25);
		
		loginBtn = new JButton("Login");
		loginBtn.setSize(25, 25);
		
		exitProgramBtn = new JButton("Exit Program");
		exitProgramBtn.setSize(25, 25);;
		
		con.add(line);
		con.add(snakesAndLaddersLbl);
		con.add(line1);
		con.add(newGameBtn);
		con.add(loadGameBtn);
		con.add(loginBtn);
		con.add(exitProgramBtn);
		
		newGameBtn.addActionListener(slc);
		loadGameBtn.addActionListener(slc);
		loginBtn.addActionListener(slc);
		exitProgramBtn.addActionListener(slc);
		
		con.setLayout(flowLayout);
		frame.setContentPane(con);
		frame.setVisible(true);
		frame.setSize(400, 150);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}
	
	// Load windows
	
	public void loadDialog() {
		setBox3(new JDialog());
		setPanel3(new JPanel());
		setLoadGameLbl(new JLabel("Load Game"));
		setLoadTxt(new JTextField(10));
		setLoadSubmitBtn(new JButton("Load"));
		setCloseBtn3(new JButton("Close"));
		
		getLoadSubmitBtn().addActionListener(getSlc());
		getCloseBtn3().addActionListener(getSlc());
		
		getPanel3().add(getLoadGameLbl());
		getPanel3().add(getLoadTxt());
		getPanel3().add(getLoadSubmitBtn());
		getPanel3().add(getCloseBtn3());
		
		getBox3().add(getPanel3());
		
		getBox3().setSize(200, 200);
		getBox3().setLocationRelativeTo(null);
		getBox3().setResizable(false);
		getBox3().setVisible(true);
		
	}
	
	
	
	// Getters and Setters

	public GameController getGc() {
		return gc;
	}

	public void setGc(GameController gc) {
		this.gc = gc;
	}

	public Board getBd() {
		return bd;
	}

	public void setBd(Board bd) {
		this.bd = bd;
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Container getCon() {
		return con;
	}

	public void setCon(Container con) {
		this.con = con;
	}

	public FlowLayout getFlowLayout() {
		return flowLayout;
	}

	public void setFlowLayout(FlowLayout flowLayout) {
		this.flowLayout = flowLayout;
	}

	public JLabel getSnakesAndLaddersLbl() {
		return snakesAndLaddersLbl;
	}

	public void setSnakesAndLaddersLbl(JLabel snakesAndLaddersLbl) {
		this.snakesAndLaddersLbl = snakesAndLaddersLbl;
	}

	public JButton getNewGameBtn() {
		return newGameBtn;
	}

	public void setNewGameBtn(JButton newGameBtn) {
		this.newGameBtn = newGameBtn;
	}

	public JButton getLoadGameBtn() {
		return loadGameBtn;
	}

	public void setLoadGameBtn(JButton loadGameBtn) {
		this.loadGameBtn = loadGameBtn;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public Component getExitProgramBtn() {
		return exitProgramBtn;
	}

	public void setExitProgramBtn(JButton exitProgramBtn) {
		this.exitProgramBtn = exitProgramBtn;
	}

	public SaveLoadController getSlc() {
		return slc;
	}

	public void setSlc(SaveLoadController slc) {
		this.slc = slc;
	}

	public JDialog getBox3() {
		return box3;
	}

	public void setBox3(JDialog box3) {
		this.box3 = box3;
	}

	public JPanel getPanel3() {
		return panel3;
	}

	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}

	public JLabel getLoadGameLbl() {
		return loadGameLbl;
	}

	public void setLoadGameLbl(JLabel loadGameLbl) {
		this.loadGameLbl = loadGameLbl;
	}

	public JTextField getLoadTxt() {
		return loadTxt;
	}

	public void setLoadTxt(JTextField loadTxt) {
		this.loadTxt = loadTxt;
	}

	public JButton getLoadSubmitBtn() {
		return loadSubmitBtn;
	}

	public void setLoadSubmitBtn(JButton loadSubmitBtn) {
		this.loadSubmitBtn = loadSubmitBtn;
	}

	public JButton getCloseBtn3() {
		return closeBtn3;
	}

	public void setCloseBtn3(JButton closeBtn3) {
		this.closeBtn3 = closeBtn3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
