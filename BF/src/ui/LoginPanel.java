package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {	
	/**
	 * Menuͨ��
	 */
	private static final long serialVersionUID = 1L;
	
	private Image img;
	
	protected LoginPanel(Image img){
		ImageIcon lib=new ImageIcon("image/loginButton.png");
		ImageIcon rb=new ImageIcon("image/register.png");
		setOpaque(true);
		setLayout(null);
		this.img = img;
		Font f=new Font("Comic Sans MS",Font.PLAIN,20);
		
		Font fm=new Font("Comic Sans MS",Font.PLAIN,10);
		JTextField IdField = new JTextField("Please Input Your ID");
		JTextField KeyField = new JTextField("Please Input Your Password");
		IdField.setFont(fm);
		KeyField.setFont(fm);
		IdField.setBounds(30, 300, 140, 30);
		IdField.setFocusable(true);
		KeyField.setBounds(30, 380, 140, 30);
		KeyField.setFocusable(true);
		this.add(IdField);
		this.add(KeyField);
		JLabel IDLabel = new JLabel("ID");
		IDLabel.setBounds(90,260, 80, 30);
		IDLabel.setFont(f);
		IDLabel.setForeground(Color.WHITE);
		this.add(IDLabel);
		JLabel KeyLabel = new JLabel("Password");
		KeyLabel.setFont(f);
		KeyLabel.setBounds(60,340, 160, 30);
		KeyLabel.setForeground(Color.WHITE);
		this.add(KeyLabel);
		JButton loginButton = new JButton();
		loginButton.setBounds(40,440,120,40);
		loginButton.setIcon(lib);
		loginButton.setOpaque(true);
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
	});
		this.add(loginButton);
		JButton RegistButton = new JButton();
		RegistButton.setBounds(40,500,120,40);
		RegistButton.setIcon(rb);
		RegistButton.setOpaque(true);
		RegistButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
	});
		this.add(RegistButton);
		this.setVisible(true);
	}

	//��дpaintComponent���ñ���
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.img.getWidth(null), this.img.getHeight(null), this);
		
	}
}

