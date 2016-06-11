package ui;



import java.awt.Font;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

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
	private String userId="";
	private String fileName="";
	private boolean isLogin;
	
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
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.setFont(fm);
		fileMenu.add(openMenuItem);
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setFont(fm);
		fileMenu.add(saveMenuItem);
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setFont(fm);
		fileMenu.add(exitMenuItem);
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
		JMenu runMenu = new JMenu("Run");
		runMenu.setFont(fm);
		menuBar.add(runMenu);
		JMenuItem executeMenuItem = new JMenuItem("Execute");
		executeMenuItem.setFont(fm);
		runMenu.add(executeMenuItem);
		executeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		JMenu versionMenu = new JMenu("Version");
		versionMenu.setFont(fm);
		menuBar.add(versionMenu);
		JMenuItem historyMenuItem = new JMenuItem("Open History Version");
		historyMenuItem.setFont(fm);
		versionMenu.add(historyMenuItem);
		JMenu logMenu = new JMenu("Log");
		logMenu.setFont(fm);
		menuBar.add(logMenu);
		JMenuItem loginMenuItem = new JMenuItem("Login");
		loginMenuItem.setFont(fm);
		logMenu.add(loginMenuItem);
		loginMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.setFont(fm);
		logMenu.add(logoutMenuItem);
		logoutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		frame.setJMenuBar(menuBar);
		
		newMenuItem.addActionListener(new NewActionListener());
		openMenuItem.addActionListener(new MenuItemActionListener());
		saveMenuItem.addActionListener(new SaveActionListener());
		exitMenuItem.addActionListener(new MenuItemActionListener());
		executeMenuItem.addActionListener(new MenuItemActionListener());
		loginMenuItem.addActionListener(new LoginActionListener());
		logoutMenuItem.addActionListener(new LogoutActionListener());
		historyMenuItem.addActionListener(new historyActionListener());
		
		textPanel=new TextPanel();
		textPanel.setLocation(0, 0);
		frame.add(textPanel);
		
		dataPanel=new DataPanel();
		dataPanel.setLocation(0, 300);
		frame.add(dataPanel);
		// 显示结果
		resultPanel=new ResultPanel();
		resultPanel.setLocation(400,300);
		frame.add(resultPanel);
		
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
				isLogin=loginFrame.loginPanel.isLogin;
				if(isLogin){
				try {
					String []a=RemoteHelper.getInstance().getIOService().readFileList(loginFrame.loginPanel.userId);
					String s = (String) JOptionPane.showInputDialog(null,"Choose Your File:\n", "File", JOptionPane.PLAIN_MESSAGE, new ImageIcon("image/bg0.png"), a, " ");
					fileName=s;
					String t=RemoteHelper.getInstance().getIOService().readFile(loginFrame.loginPanel.userId,s);
					t=t.replace('@', '\n');
					textPanel.text.setText(t);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				else
					DialogCreator.failDialog1("Login First");
			} 
			else if (cmd.equals("Execute")) {
				String code = textPanel.text.getText();
				String param=dataPanel.text.getText()+"\n";
				String result="";
				try {
					result = RemoteHelper.getInstance().getExecuteService().execute(code,param);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(result);
				resultPanel.cl.show(ResultPanel.jCards, "afterPanel");
				resultPanel.afterPanel.text.setText("Hello, result: \r\n"+result);
			} else if(cmd.equals("Exit")){
				System.exit(0);
			}
		}
	}

	class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			userId=loginFrame.loginPanel.userId;
			isLogin=loginFrame.loginPanel.isLogin;
			if(isLogin){
				if(fileName!=""){
			String code = textPanel.text.getText();
			code=code.replace('\n', '@');
			try {
				userId=loginFrame.loginPanel.userId;
				RemoteHelper.getInstance().getIOService().writeFile(code, userId, fileName);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
				}
				else{
					try {
						fileName=DialogCreator.InputDialog("New File");
						RemoteHelper.getInstance().getIOService().writelistFile(userId,fileName);
						RemoteHelper.getInstance().getIOService().createFile(userId,fileName);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					String code = textPanel.text.getText();
					try {
						userId=loginFrame.loginPanel.userId;
						RemoteHelper.getInstance().getIOService().writeFile(code, userId, fileName);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
			else
				DialogCreator.failDialog1("Login First");
				
		}

	}
	class NewActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			userId=loginFrame.loginPanel.userId;
			isLogin=loginFrame.loginPanel.isLogin;
			if(isLogin){
			textPanel.text.setText("");
			dataPanel.text.setText("");
			resultPanel.cl.show(ResultPanel.jCards, "beforePanel");
			try {
				fileName=DialogCreator.InputDialog("New File");
				RemoteHelper.getInstance().getIOService().writelistFile(userId,fileName);
				RemoteHelper.getInstance().getIOService().createFile(userId,fileName);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
			else
				DialogCreator.failDialog1("Login First");
		}
	}
	class LoginActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			loginFrame.setVisible(true);
		}

	}
	class historyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			userId=loginFrame.loginPanel.userId;
			isLogin=loginFrame.loginPanel.isLogin;
			if(isLogin&&fileName!=""){
			try {
				int vs=RemoteHelper.getInstance().getIOService().readFileVersionNum(userId,fileName);
				String []a=new String[vs];
				for(int i=0;i<vs;i++){
					a[i]="Version"+Integer.toString(i);
				}
				String s = (String) JOptionPane.showInputDialog(null,"Choose Your File:\n", "File", JOptionPane.PLAIN_MESSAGE, new ImageIcon("image/bg0.png"), a, " ");
				int v=Integer.parseInt(s.substring(7));
				String t=RemoteHelper.getInstance().getIOService().readFileVersion(userId,fileName,v);
				textPanel.text.setText(t);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}

	}
	class LogoutActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textPanel.text.setText("");
			dataPanel.text.setText("");
			resultPanel.cl.show(ResultPanel.jCards, "beforePanel");
			userId="";
			loginFrame.loginPanel.userId="";
			loginFrame.loginPanel.isLogin=false;
			fileName="";
		}

	}
	
}
