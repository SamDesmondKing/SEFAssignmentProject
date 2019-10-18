package main.View;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Controller.CheckPointController;

public class CheckPointGui implements Serializable {

	
	// Checkpoint variables
	
	private JDialog box;
	private JPanel panel;
	private JLabel saveGameLbl;
	private JButton saveBtn;
	private JButton loadBtn;
	private JButton closeBtn;
	private JButton closeExitBtn;
	
	
	// Save Dialog variables
	
	private JDialog box2;
	private JPanel panel2;
	private JLabel saveGameLbl2;
	private JTextField saveTxt;
	private JButton submitBtn, closeBtn2;
	
	// Load Dialog variables
	
	private JDialog box3;
	private JPanel panel3;
	private JLabel loadGameLbl;
	private JTextField loadTxt;
	private JButton loadSubmitBtn, closeBtn3;
	
	private CheckPointController cpc;
	
	
	public CheckPointGui(CheckPointController cpc) {
		this.cpc = cpc;
	}
	
	public void checkPointDialog() {
		box = new JDialog();
		box.setTitle("Check Point!!");
		panel = new JPanel();
		
		saveGameLbl = new JLabel("CheckPoint Reached");
		
		saveBtn = new JButton("Save");
		saveBtn.addActionListener(cpc);
		
		loadBtn = new JButton("Load Saved Game");
		loadBtn.addActionListener(cpc);
		
		closeBtn = new JButton("Close and continue");
		closeBtn.addActionListener(cpc);
		
		closeExitBtn = new JButton("Close and Exit");
		closeExitBtn.addActionListener(cpc);
		
		panel.add(saveGameLbl);
		
		panel.add(saveBtn);
		panel.add(loadBtn);
		panel.add(closeBtn);
		panel.add(closeExitBtn);
		box.add(panel);
		
		box.setSize(200, 200);
		box.setLocationRelativeTo(null);
		box.setResizable(false);
		box.setVisible(true);	
	}
	
	public void saveDialog() {
		box2 = new JDialog();
		panel2 = new JPanel();
		
		setSaveGameLbl2(new JLabel("Save game"));
		setSaveTxt(new JTextField(10));
		setSubmitBtn(new JButton("Save"));
		setCloseBtn2(new JButton("Close"));
		
		getSubmitBtn().addActionListener(getCpc());
		getCloseBtn2().addActionListener(getCpc());
		
		getPanel2().add(getSaveGameLbl2());
		getPanel2().add(getSaveTxt());
		getPanel2().add(getSubmitBtn());
		getPanel2().add(getCloseBtn2());
		
		getBox2().add(getPanel2());
		
		box2.setSize(200, 200);
		box2.setLocationRelativeTo(null);
		box2.setResizable(false);
		box2.setVisible(true);	
		
	}
	
	
	
	public void loadDialog() {
		setBox3(new JDialog());
		setPanel3(new JPanel());
		setLoadGameLbl(new JLabel("Load Game"));
		setLoadTxt(new JTextField(10));
		setLoadSubmitBtn(new JButton("Load"));
		setCloseBtn3(new JButton("Close"));
		
		getLoadSubmitBtn().addActionListener(getCpc());
		getCloseBtn3().addActionListener(getCpc());
		
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
	
	
	

	public JDialog getBox() {
		return box;
	}

	public void setBox(JDialog box) {
		this.box = box;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getSaveGameLbl() {
		return saveGameLbl;
	}

	public void setSaveGameLbl(JLabel saveGameLbl) {
		this.saveGameLbl = saveGameLbl;
	}

	public JButton getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(JButton saveBtn) {
		this.saveBtn = saveBtn;
	}

	public JButton getLoadBtn() {
		return loadBtn;
	}

	public void setLoadBtn(JButton loadBtn) {
		this.loadBtn = loadBtn;
	}

	public JButton getCloseBtn() {
		return closeBtn;
	}

	public void setCloseBtn(JButton closeBtn) {
		this.closeBtn = closeBtn;
	}

	public JButton getCloseExitBtn() {
		return closeExitBtn;
	}

	public void setCloseExitBtn(JButton closeExitBtn) {
		this.closeExitBtn = closeExitBtn;
	}

	public CheckPointController getCpc() {
		return cpc;
	}

	public void setCpc(CheckPointController cpc) {
		this.cpc = cpc;
	}

	public JDialog getBox2() {
		return box2;
	}

	public void setBox2(JDialog box2) {
		this.box2 = box2;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JLabel getSaveGameLbl2() {
		return saveGameLbl2;
	}

	public void setSaveGameLbl2(JLabel saveGameLbl2) {
		this.saveGameLbl2 = saveGameLbl2;
	}

	public JTextField getSaveTxt() {
		return saveTxt;
	}

	public void setSaveTxt(JTextField saveTxt) {
		this.saveTxt = saveTxt;
	}

	public JButton getSubmitBtn() {
		return submitBtn;
	}

	public void setSubmitBtn(JButton submitBtn) {
		this.submitBtn = submitBtn;
	}

	public JButton getCloseBtn2() {
		return closeBtn2;
	}

	public void setCloseBtn2(JButton closeBtn2) {
		this.closeBtn2 = closeBtn2;
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
	
	
}
