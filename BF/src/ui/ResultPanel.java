package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class ResultPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public JLabel text = null;
	public static JPanel jCards=new JPanel();
	public static CardLayout cl=new CardLayout();
	public AfterPanel afterPanel;
	public BeforePanel beforePanel;
	private ImageIcon imageIcon = null;
	public ResultPanel(){
			afterPanel=new AfterPanel();
			beforePanel=new BeforePanel();
			imageIcon = new ImageIcon("image/resultbg.png");
			this.setOpaque(false);
		    this.setLayout(new BorderLayout());
		    jCards.setLayout(cl);
			jCards.add(beforePanel, "beforePanel");
			jCards.add(afterPanel, "afterPanel");
		    cl.show(jCards, "beforePanel");
		    text = new JLabel();
		    Font fm=new Font("Comic Sans MS",Font.PLAIN,24);
		    text.setOpaque(false);
		    text.setFont(fm);
		    text.setBounds(0, 0, WIDTH, HEIGHT);
		    this.add(text);
		    this.add(jCards);
		    this.setSize(400, 250);
		    this.setVisible(true);
	}
	@Override
	 public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
