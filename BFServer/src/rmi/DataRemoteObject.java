package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import service.IOService;
import service.UserService;
import serviceImpl.IOServiceImpl;
import serviceImpl.UserServiceImpl;

public class DataRemoteObject extends UnicastRemoteObject implements IOService, UserService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private IOService iOService;
	private UserService userService;
	protected DataRemoteObject() throws RemoteException {
		iOService = new IOServiceImpl();
		userService = new UserServiceImpl();
	}

	@Override
	public boolean writeFile(String file, String userId, String fileName) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.writeFile(file, userId, fileName);
	}
	@Override
	public boolean writeIDFile(String s) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.writeIDFile(s);
	}

	@Override
	public String readFile(String userId, String fileName) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFile(userId, fileName);
	}
	@Override
	public boolean createFile(String userId,String fileName) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.createFile(userId,fileName);
	}
	@Override
	public boolean readIDFile(String userId, String userPassword) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readIDFile(userId, userPassword);
	}
	@Override
	public boolean readIDFile0(String userId) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readIDFile0(userId);
	}
	@Override
	public String readFileList(String userId) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFileList(userId);
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.login(username, password);
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.logout(username);
	}

}
