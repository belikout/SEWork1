package ui;

import javax.swing.JFrame;

public class Test extends JFrame {
	public TextPanel textPanel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
	}
	public Test(){
		textPanel=new TextPanel();
		  this.getContentPane().add(textPanel);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setSize(800, 320);
		  this.setVisible(true);
	}
}
