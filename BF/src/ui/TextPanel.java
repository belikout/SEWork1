package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea text = null;
	 private ImageIcon imageIcon = null;
	public TextPanel(){
			imageIcon = new ImageIcon("image/TextBg.png");
			this.setOpaque(false);
		    this.setLayout(new BorderLayout());
		    text = new JTextArea();
		    Font fm=new Font("Comic Sans MS",Font.PLAIN,20);
		    text.setOpaque(false);
		    text.setForeground(Color.WHITE);
		    text.setFont(fm);
		    text.setBounds(0, 0, WIDTH, HEIGHT);
		    text.setLineWrap(true);
		    this.add(text);
		    this.setSize(800, 300);
		    this.setVisible(true);
	}
	@Override
	 public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
