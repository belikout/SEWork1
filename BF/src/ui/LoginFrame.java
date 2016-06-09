package ui;


import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		this.setVisible(true);
	}
	/*public static void main(String args[]){
		LoginFrame loginFrame=new LoginFrame();
	}*/
}
