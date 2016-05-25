package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import rmi.RemoteHelper;


public class MainFrame extends JFrame {
	private JTextArea textArea;
	private JTextArea dataArea;
	private JLabel resultLabel;

	public MainFrame() {
		// 创建窗体
		JFrame frame = new JFrame("BF Client");
		frame.setSize(800, 600);
		frame.setLocation(200, 200);
		frame.setLayout(null);
		Font fm=new Font("Comic Sans MS",Font.PLAIN,18);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(fm);
		menuBar.add(fileMenu);
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.setFont(fm);
		fileMenu.add(newMenuItem);
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.setFont(fm);
		fileMenu.add(openMenuItem);
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setFont(fm);
		fileMenu.add(saveMenuItem);
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setFont(fm);
		fileMenu.add(exitMenuItem);
		JMenu runMenu = new JMenu("Run");
		runMenu.setFont(fm);
		menuBar.add(runMenu);
		JMenuItem executeMenuItem = new JMenuItem("Execute");
		executeMenuItem.setFont(fm);
		runMenu.add(executeMenuItem);
		frame.setJMenuBar(menuBar);
		JMenu versionMenu = new JMenu("Version");
		versionMenu.setFont(fm);
		menuBar.add(versionMenu);
		

		newMenuItem.addActionListener(new MenuItemActionListener());
		openMenuItem.addActionListener(new MenuItemActionListener());
		saveMenuItem.addActionListener(new SaveActionListener());
		exitMenuItem.addActionListener(new MenuItemActionListener());
		executeMenuItem.addActionListener(new MenuItemActionListener());
		textArea = new JTextArea();
		textArea.setMargin(new Insets(20, 20, 20, 20));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(0, 0, 800, 300);
		textArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 5, false));
		textArea.setLineWrap(true);
		Font f=new Font("Comic Sans MS",Font.PLAIN,20);
        textArea.setFont(f);
		frame.add(textArea);
		dataArea = new JTextArea();
		dataArea.setMargin(new Insets(20, 20, 20, 20));
		dataArea.setBackground(Color.PINK);
		dataArea.setBounds(0, 300, 400, 250);
		dataArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 5, false));
		dataArea.setLineWrap(true);
		dataArea.setFont(f);
		frame.add(dataArea);
		// 显示结果
		resultLabel = new JLabel();
		resultLabel.setBackground(Color.PINK);
		resultLabel.setBounds(400, 300, 400, 250);
		resultLabel.setBorder(new LineBorder(new java.awt.Color(127,157,185), 5, false));
		resultLabel.setFont(f);
		frame.add(resultLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	class MenuItemActionListener implements ActionListener {
		/**
		 * 子菜单响应事件
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Open")) {
				textArea.setText("Open");
			} else if (cmd.equals("Save")) {
				textArea.setText("Save");
			} else if (cmd.equals("Execute")) {
				String code = textArea.getText();
				String param=dataArea.getText()+"\n";
				String result=execute(code,param);
					System.out.println(result);
				resultLabel.setText("Hello, result: "+result);
			} else if(cmd.equals("Exit")){
				System.exit(0);
			}
		}
	}

	class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String code = textArea.getText();
			try {
				RemoteHelper.getInstance().getIOService().writeFile(code, "admin", "code");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}
	public static String execute(String code, String param) {
		char[] pr=new char[5000];
		int i=0;
		int d=0;
		int sgn=0;
		String res=null;
		int[] s=new int[500];
		
		for(int j=0;j<code.length();j++){
			switch(code.charAt(j)){
			case' ':
				break;
			case'>':i++;
			break;
			case'<':i--;
			break;
			case',':{pr[i]=param.charAt(d);d++;}
			break;
			case'.':res+=(pr[i]);
			break;
			case'+':pr[i]++;
			break;
			case'-':pr[i]--;
			break;
			case'[':{
				sgn+=1;
				s[sgn]=j;
				if(pr[i]<=0){
					j++;
				}
			}
			break;
			case']':if(pr[i]>0){
				j=s[sgn];
			}else{
				sgn--;
			}
	}
	}
	
	
		return res.substring(4, res.length());
	}
}
