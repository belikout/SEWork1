package ui;


import java.awt.Container;

import javax.swing.ImageIcon;

import javax.swing.JFrame;


public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container ct;
	private LoginPanel loginPanel;
	public LoginFrame(){
		
		
		ImageIcon bl=new ImageIcon("image/BrainLight.png");
		ImageIcon lb=new ImageIcon("image/login.png");
		this.setIconImage(bl.getImage());
		loginPanel=new LoginPanel(lb.getImage());
		loginPanel.setBounds(0, 0, 200,600);
		ct = this.getContentPane();
		ct.add(loginPanel);
		this.setTitle("Login");
		this.setLocation(1000, 200);
		this.setSize(200, 600);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(false);
	}
	/*public static void main(String args[]){
		LoginFrame loginFrame=new LoginFrame();
	}*/
}
