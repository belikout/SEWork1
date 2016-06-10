package ui;

import java.awt.BorderLayout;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeforePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public JLabel text = null;
	private ImageIcon imageIcon = null;
	public BeforePanel(){
			imageIcon = new ImageIcon("image/resultbg.png");
			this.setOpaque(false);
		    this.setLayout(new BorderLayout());
		    this.setSize(400, 250);
		    this.setVisible(true);
	}
	@Override
	 public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
