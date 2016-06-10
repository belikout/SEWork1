package ui;



import java.awt.Font;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import rmi.RemoteHelper;


public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JTextArea textArea;
	//private JTextArea dataArea;
	private DataPanel dataPanel;
	//private JLabel resultLabel;
	private ResultPanel resultPanel;
	private LoginFrame loginFrame;
	private TextPanel textPanel;
	public MainFrame() {
		// 创建窗体
		JFrame frame = new JFrame("BF Client");
		ImageIcon bl=new ImageIcon("image/BrainLight.png");
		frame.setIconImage(bl.getImage());
		frame.setSize(800, 600);
		frame.setLocation(150, 100);
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
		JMenu versionMenu = new JMenu("Version");
		versionMenu.setFont(fm);
		menuBar.add(versionMenu);
		JMenu logMenu = new JMenu("Log");
		logMenu.setFont(fm);
		menuBar.add(logMenu);
		JMenuItem loginMenuItem = new JMenuItem("Login");
		loginMenuItem.setFont(fm);
		logMenu.add(loginMenuItem);
		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.setFont(fm);
		logMenu.add(logoutMenuItem);
		frame.setJMenuBar(menuBar);
		
		newMenuItem.addActionListener(new MenuItemActionListener());
		openMenuItem.addActionListener(new MenuItemActionListener());
		saveMenuItem.addActionListener(new SaveActionListener());
		exitMenuItem.addActionListener(new MenuItemActionListener());
		executeMenuItem.addActionListener(new MenuItemActionListener());
		loginMenuItem.addActionListener(new LoginActionListener());
		logoutMenuItem.addActionListener(new MenuItemActionListener());
		/*textArea = new JTextArea("Input Code Area");
		textArea.setMargin(new Insets(20, 20, 20, 20));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(0, 0, 800, 300);
		textArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 5, false));
		textArea.setLineWrap(true);
        textArea.setFont(f);
		frame.add(textArea);*/
		textPanel=new TextPanel();
		textPanel.setLocation(0, 0);
		frame.add(textPanel);
		/*dataArea = new JTextArea("Input Data Area");
		dataArea.setMargin(new Insets(20, 20, 20, 20));
		dataArea.setBackground(Color.PINK);
		dataArea.setBounds(0, 300, 400, 250);
		dataArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 5, false));
		dataArea.setLineWrap(true);
		dataArea.setFont(f);
		frame.add(dataArea);*/
		dataPanel=new DataPanel();
		dataPanel.setLocation(0, 300);
		frame.add(dataPanel);
		// 显示结果
		resultPanel=new ResultPanel();
		resultPanel.setLocation(400,300);
		frame.add(resultPanel);
		/*resultLabel = new JLabel("Console");
		resultLabel.setBackground(Color.PINK);
		resultLabel.setBounds(400, 300, 400, 250);
		resultLabel.setBorder(new LineBorder(new java.awt.Color(127,157,185), 5, false));
		resultLabel.setFont(f);
		frame.add(resultLabel);*/

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		loginFrame=new LoginFrame();
		loginFrame.setResizable(false);
		loginFrame.setVisible(false);
	}

	class MenuItemActionListener implements ActionListener {
		/**
		 * 子菜单响应事件
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Open")) {
				
			} else if (cmd.equals("Save")) {
				
			} else if (cmd.equals("Execute")) {
				String code = textPanel.text.getText();
				String param=dataPanel.text.getText()+"\n";
				String result=execute(code,param);
				System.out.println(result);
				resultPanel.cl.show(ResultPanel.jCards, "afterPanel");
				resultPanel.afterPanel.text.setText("Hello, result: "+result);
			} else if(cmd.equals("Exit")){
				System.exit(0);
			}
		}
	}

	class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String code = textPanel.text.getText();
			try {
				RemoteHelper.getInstance().getIOService().writeFile(code, "admin", "code");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}
	class LoginActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			loginFrame.setVisible(true);
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
			default:break;
	}
	}
	
	
		return res.substring(4, res.length());
	}
}
