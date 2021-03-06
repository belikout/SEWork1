//服务器IOService的Stub，内容相同
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IOService extends Remote{
	public boolean writeFile(String file, String userId, String fileName)throws RemoteException;
	
	public boolean writelistFile( String userId, String fileName)throws RemoteException;
	
	public String readFile(String userId, String fileName)throws RemoteException;
	
	public String[] readFileList(String userId)throws RemoteException;
	
	public boolean readIDFile(String userId,String userPassword)throws RemoteException;
	
	public boolean writeIDFile(String s)throws RemoteException;
	
	public boolean readIDFile0(String userId)throws RemoteException;
	
	public boolean createFile(String userId,String fileName)throws RemoteException;

	public boolean createlistFile(String userId) throws RemoteException;
	
	public String readFileVersion(String userId, String fileName,int v)throws RemoteException;

	public int readFileVersionNum(String userId, String fileName)throws RemoteException;
	
}
