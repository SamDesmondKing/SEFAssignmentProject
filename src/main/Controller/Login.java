package main.Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

import exceptions.LoginException;
import main.Controller.GameController;
import main.Model.DatabaseConnection;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Login extends JDialog{

	private JDialog frame;
	private JTextField uName;
	private JPasswordField password;
	
	private JTextField uNameHuman;
	private JPasswordField passwordHuman;
	
	private JTextField uNameSnake;
	private JPasswordField passwordSnake;
	
	private boolean success;
	private int count;
	
	private static String userName = "";
	private static String pwd = "";
	private static String userNameHuman = "";
	private static String humanpwd = "";
	private static String userNameSnake = "";
	private static String snakepwd = "";


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Login() {
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		this.success = false;
		frame = new JDialog();
		frame.setVisible(true);
		frame.setBounds(300, 300, 450, 600);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setModal(true);
		
		JLabel loginBox = new JLabel("Login Window");
		loginBox.setBounds(159, 13, 141, 26);
		frame.getContentPane().add(loginBox);
		
		JLabel lblNewLabel = new JLabel("Admin User");
		lblNewLabel.setBounds(60, 95, 120, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin pass");
		lblNewLabel_1.setBounds(60, 145, 80, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel2 = new JLabel("Human user");
		lblNewLabel2.setBounds(60, 195, 95, 16);
		frame.getContentPane().add(lblNewLabel2);
		
		JLabel lblNewLabel_2 = new JLabel("Human pass");
		lblNewLabel_2.setBounds(60, 250, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel3 = new JLabel("Snake user");
		lblNewLabel3.setBounds(62, 300, 95, 16);
		frame.getContentPane().add(lblNewLabel3);
		
		JLabel lblNewLabel_3= new JLabel("Snake pass)");
		lblNewLabel_3.setBounds(62, 350, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		uName = new JTextField();
		uName.setBounds(60, 115, 193, 22);
		frame.getContentPane().add(uName);
		uName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(60, 160, 193, 19);
		frame.getContentPane().add(password);
		
		uNameSnake = new JTextField();
		uNameSnake.setBounds(60, 325, 193, 22);
		frame.getContentPane().add(uNameSnake);
		uNameSnake.setColumns(10);
		
		passwordSnake = new JPasswordField();
		passwordSnake.setBounds(60, 375, 193, 19);
		frame.getContentPane().add(passwordSnake);
		
		uNameHuman = new JTextField();
		uNameHuman.setBounds(60, 225, 193, 22);
		frame.getContentPane().add(uNameHuman);
		uNameHuman.setColumns(10);
		
		passwordHuman = new JPasswordField();
		passwordHuman.setBounds(60, 275, 193, 19);
		frame.getContentPane().add(passwordHuman);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
				userName = uName.getText();
				pwd = String.valueOf(password.getPassword());
				
				userNameHuman = uNameHuman.getText();
				humanpwd = String.valueOf(passwordHuman.getPassword());
				
				userNameSnake = uNameSnake.getText();
				snakepwd = String.valueOf(passwordSnake.getPassword());

				//signup for admin;
				try{
					loginCheckerAdmin(userName, pwd);
					frame.dispose();
				} catch(Exception e) {
						//System.out.println("CHUDURBUDUR");
				}
				GameController.setAdmin(userName);
				
				try {
					loginCheckerHuman(userNameHuman, humanpwd);
					frame.dispose();
				} catch(Exception e) {
						
				}
				GameController.setHumanPlayer(userNameHuman);
				
				try {
					loginCheckerSnake(userNameSnake, snakepwd);
					frame.dispose();
				} catch(Exception e) {
				GameController.setSnakePlayer(userName);
				}
				/*
				else if(humanbtn.isSelected()) {
					//signup for human
					loginCheckerHuman(userName, pwd);
					GameController.setHuman(userName);
				}else if (snakebtn.isSelected()){
					//signup for snake
					loginCheckerSnake(userName, pwd);
					GameController.setSnake(userName);
				}else {
					JOptionPane.showMessageDialog(null, "no option selected");
				}
				*/
			}
		});
		loginBtn.setBounds(159, 500, 97, 25);
		frame.getContentPane().add(loginBtn);
	}
	
	public void loginCheckerSnake(String uname, String pass) throws LoginException {
		PreparedStatement ps;
        ResultSet rs;

        
        String query = "SELECT * FROM users.snakeplayer WHERE userName =? AND password =?";
        
        try {
            ps =  DatabaseConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, uname);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
           
            
            if(rs.next())
            {
            	//String s1 = (String) rs.getObject(1);
            	//String s2 = (String) rs.getObject(2);
            	
            	JOptionPane.showMessageDialog(null, "Welcome < "+uname+" >");
            	success = true;
            }
            else{   
            	JOptionPane.showMessageDialog(null, "Incorrect snake Username Or Password", "Login Failed", 2);
            	throw new LoginException("fail");
                }
            
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } catch(LoginException e){
        	System.out.println("throwing login exception in method");
        	throw e;
        }
	}
	
	public void loginCheckerAdmin(String uname, String pass) throws LoginException {
		PreparedStatement ps;
        ResultSet rs;

        
        String query = "SELECT * FROM users.admin WHERE userName =? AND password =?";
        
        try {
            ps =  DatabaseConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, uname);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
           
            
            if(rs.next())
            {
            	//String s1 = (String) rs.getObject(1);
            	//String s2 = (String) rs.getObject(2);
            	
            	JOptionPane.showMessageDialog(null, "Welcome < "+uname+" >");
            	success = true;
            }
            else{   
            	JOptionPane.showMessageDialog(null, "Incorrect admin Username Or Password", "Login Failed", 2);
            	throw new LoginException("fail");
                }
            
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } catch(LoginException e){
        	System.out.println("throwing login exception in method");
        	throw e;
        }
	}
	
	public void loginCheckerHuman(String uname, String pass) throws LoginException {
		PreparedStatement ps;
        ResultSet rs;

        
        String query = "SELECT * FROM users.humanplayer WHERE userName =? AND password =?";
        
        try {
            ps =  DatabaseConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, uname);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
           
            
            if(rs.next())
            {
            	//String s1 = (String) rs.getObject(1);
            	//String s2 = (String) rs.getObject(2);
            	
            	JOptionPane.showMessageDialog(null, "Welcome < "+uname+" >");
            	success = true;
            }
            else{   
            	JOptionPane.showMessageDialog(null, "Incorrect human Username Or Password", "Login Failed", 2);
            	throw new LoginException("fail");
                }
            
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } catch(LoginException e){
        	System.out.println("throwing login exception in method");
        	throw e;
        }
	}
	
	public boolean getSuccess() {
		return this.success;
	}
	
	public JDialog getFrame() {
		return this.frame;
	}
	
	public static String getusername() {
		return userName;
	}
	
	public static String getpassword() {
		return pwd;
	}
}
