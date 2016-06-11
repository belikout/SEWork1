package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DataPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public JTextArea text = null;
	 private ImageIcon imageIcon = null;
	public DataPanel(){
			imageIcon = new ImageIcon("image/databg.png");
			this.setOpaque(false);
		    this.setLayout(new BorderLayout());
		    text = new JTextArea();
		    Font fm=new Font("Comic Sans MS",Font.PLAIN,24);
		    text.setOpaque(false);
		    text.setFont(fm);
		    text.setBounds(0, 0, WIDTH, HEIGHT);
		    text.setLineWrap(true);
		    text.getCaret().setBlinkRate(800);
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
