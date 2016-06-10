package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




public class DialogCreator {
	static JDialog dialog = new JDialog();
	static JOptionPane dialogPane;
	public static void successDialog(String name){
		JButton okButton;
		ImageIcon dialogBgIcon = new ImageIcon("image/dialogBg.png");
		ImageIcon okIcon = new ImageIcon("image/ok.png");
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());
		/*JLabel wordLabel = new JLabel();
		wordLabel.setText(message);
		wordLabel.setForeground(Color.WHITE);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		wordLabel.setBounds(10,40,400,100);*/
		
		okButton = new JButton();
		okButton.setIcon(okIcon);
		okButton.setBounds(170,180,okIcon.getIconWidth(),okIcon.getIconHeight());
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		//dialogPane.add(wordLabel);
		dialogPane.add(okButton);
		dialogPane.add(imageLabel);
		//wordLabel-top;okButton-middle;imageLabel-bottom
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(okButton,name);
	    dialog.setVisible(true);
	    //how to set a dialog as Opaque?
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(okButton); 
	}
	public static void failDialog(String name){
		JButton okButton;
		ImageIcon dialogBgIcon = new ImageIcon("image/dialogBg0.png");
		ImageIcon okIcon = new ImageIcon("image/ok0.png");
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());
		/*JLabel wordLabel = new JLabel();
		wordLabel.setText(message);
		wordLabel.setForeground(Color.WHITE);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		wordLabel.setBounds(10,40,400,100);*/
		
		okButton = new JButton();
		okButton.setIcon(okIcon);
		okButton.setBounds(170,180,okIcon.getIconWidth(),okIcon.getIconHeight());
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		//dialogPane.add(wordLabel);
		dialogPane.add(okButton);
		dialogPane.add(imageLabel);
		//wordLabel-top;okButton-middle;imageLabel-bottom
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(okButton,name);
	    dialog.setVisible(true);
	    //how to set a dialog as Opaque?
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(okButton); 
	}
	public static void successDialog0(String name){
		JButton okButton;
		ImageIcon dialogBgIcon = new ImageIcon("image/dialogBg1.png");
		ImageIcon okIcon = new ImageIcon("image/ok.png");
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());
		/*JLabel wordLabel = new JLabel();
		wordLabel.setText(message);
		wordLabel.setForeground(Color.WHITE);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		wordLabel.setBounds(10,40,400,100);*/
		
		okButton = new JButton();
		okButton.setIcon(okIcon);
		okButton.setBounds(170,180,okIcon.getIconWidth(),okIcon.getIconHeight());
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		//dialogPane.add(wordLabel);
		dialogPane.add(okButton);
		dialogPane.add(imageLabel);
		//wordLabel-top;okButton-middle;imageLabel-bottom
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(okButton,name);
	    dialog.setVisible(true);
	    //how to set a dialog as Opaque?
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(okButton); 
	}
	public static void failDialog0(String name){
		JButton okButton;
		ImageIcon dialogBgIcon = new ImageIcon("image/dialogBg2.png");
		ImageIcon okIcon = new ImageIcon("image/ok0.png");
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());
		/*JLabel wordLabel = new JLabel();
		wordLabel.setText(message);
		wordLabel.setForeground(Color.WHITE);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		wordLabel.setBounds(10,40,400,100);*/
		
		okButton = new JButton();
		okButton.setIcon(okIcon);
		okButton.setBounds(170,180,okIcon.getIconWidth(),okIcon.getIconHeight());
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		//dialogPane.add(wordLabel);
		dialogPane.add(okButton);
		dialogPane.add(imageLabel);
		//wordLabel-top;okButton-middle;imageLabel-bottom
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(okButton,name);
	    dialog.setVisible(true);
	    //how to set a dialog as Opaque?
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(okButton); 
	}
	public static  String InputDialog(String name,String message){
		String input = null;
		JButton okButton;
		JTextField inputField;
		ImageIcon dialogBgIcon = new ImageIcon("image/dialogBg.png");
		ImageIcon okIcon = new ImageIcon("image/CHN-okButton.png");
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());
		JLabel wordLabel = new JLabel();
		wordLabel.setText(message);
		wordLabel.setForeground(Color.WHITE);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		wordLabel.setBounds(10,40,400,100);
		
		okButton = new JButton();
		okButton.setIcon(okIcon);
		okButton.setBounds(170,190,okIcon.getIconWidth(),okIcon.getIconHeight());
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		inputField = new JTextField("localhost");
		inputField.setBounds(80, 120, 250, 30);
		inputField.setFocusable(true);
		
		dialogPane.add(inputField);
		dialogPane.add(wordLabel);
		dialogPane.add(okButton);
		dialogPane.add(imageLabel);
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(okButton,name);
	    dialog.setVisible(true);
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(okButton); 
		
		input = inputField.getText();
		System.out.println(input);
		return input;
	}
}
