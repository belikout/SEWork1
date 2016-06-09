package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ResultPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public JLabel text = null;
	 private ImageIcon imageIcon = null;
	public ResultPanel(){
			imageIcon = new ImageIcon("image/resultbg.png");
			this.setOpaque(false);
		    this.setLayout(new BorderLayout());
		    text = new JLabel();
		    Font fm=new Font("Comic Sans MS",Font.PLAIN,20);
		    text.setOpaque(false);
		    text.setFont(fm);
		    text.setBounds(0, 0, WIDTH, HEIGHT);
		    this.add(text);
		    this.setSize(400, 250);
		    this.setVisible(true);
	}
	@Override
	 public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
