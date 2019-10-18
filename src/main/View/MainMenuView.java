package main.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Controller.GameController;

public class MainMenuView {

	GameController  gc;
	JFrame frame;
	Container con;
	FlowLayout borderLayout;
	
	private JPanel panel;
	private JLabel snakesAndLaddersLbl;
	private JButton newGameBtn, loadGameBtn, loginBtn, exitProgramBtn;
	
	
	
	public MainMenuView(GameController gc) {
		this.gc = gc;
		run();
	}
	
	public void run() {
		setup();
		//addActionListeners();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setSize(400, 150);
		frame.setVisible(true);
	}
	
	public void setup() {
		
		frame = new JFrame();
		con = new Container();
		borderLayout = new FlowLayout();
		
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
	
		
		
		
		con.setLayout(borderLayout);
		frame.setContentPane(con);
		
	}
	
	/*
	
	public void addActionListeners() {
		newGameBtn.addActionListener(gc);
		loadGameBtn.addActionListener(gc);
		loginBtn.addActionListener(gc);
		exitProgramBtn.addActionListener(gc);
	}
	*/
	
	public JButton getLoginBtn() {
		return loginBtn; 
	}
	
	public JButton getNewGameBtn() {
		return newGameBtn;
	}

	
	public JFrame getFrame() {
		return frame;
	}

	
	public JButton getLoadGameBtn() {
		// TODO Auto-generated method stub
		return loadGameBtn;
	}


}
