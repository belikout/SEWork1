package serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import service.IOService;

public class IOServiceImpl implements IOService{
	 ArrayList<String> l=new ArrayList<String>(); 
	@Override
	public boolean writeFile(String file, String userId, String fileName) {
		l.clear();
		File f = new File(userId + "_" + fileName+"_"+"code");
		try{
			
			FileReader fileReader=new FileReader(f);
			BufferedReader reader=new BufferedReader(fileReader);
			String str=null;
			while ((str=reader.readLine())!=null){
				if(str!=" "){
				l.add(str);
				}
			}
			reader.close();
		}catch(Exception ex){
		
			ex.printStackTrace();
		}
		l.add(file);
		 try{
				FileWriter writer=new FileWriter(f);
				for(int i=0;i<l.size();i++){
					writer.write(l.get(i)+"\r\n");
				}
				writer.close();
				return true;
			}catch(IOException ex){
				ex.printStackTrace();	
			return false;
			}
	}

	@Override
	public boolean writeIDFile(String s) {
		l.clear();
		try{
			File file=new File("admin_UserID");
			FileReader fileReader=new FileReader(file);
			BufferedReader reader=new BufferedReader(fileReader);
			String str=null;
			while ((str=reader.readLine())!=null){
				if(str!=" "){
				l.add(str);
				}
			}
			reader.close();
		}catch(Exception ex){
		
			ex.printStackTrace();
		}
		l.add(s);
		 try{
				FileWriter writer=new FileWriter("admin_UserID");
				for(int i=0;i<l.size();i++){
					writer.write(l.get(i)+"\r\n");
				}
				writer.close();
				return true;
			}catch(IOException ex){
				ex.printStackTrace();	
			return false;
			}
	}
	@Override
	public boolean readIDFile(String userId,String userPassword) {
		// TODO Auto-generated method stub
		File f = new File( "admin_UserID" );
		boolean k=false;
		try {
			
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line;
			while((line=br.readLine())!=null){
				String id;
				String key;
				String[] split = line.split(";");
				
				id = split[0];
				key = split[1];
				if(userId.equals(id)&&key.equals(userPassword)) {
					k = true;
					break;
				}
			}
			br.close();
			return k;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean readIDFile0(String userId) {
		// TODO Auto-generated method stub
		File f = new File( "admin_UserID" );
		boolean k=false;
		try {
			
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line;
			while((line=br.readLine())!=null){
				String id;		
				String[] split = line.split(";");
				id = split[0];
				if(userId.equals(id)) {
					k = true;
					break;
				}
			}
			br.close();
			return k;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public String readFile(String userId, String fileName) {
		// TODO Auto-generated method stub
		return "OK";
	}
	@Override
	public boolean createFile(String userId,String fileName) {
		// TODO Auto-generated method stub
		 try{
			 File file=new File(userId+"_"+fileName+"_"+"code"); 
			 file.createNewFile();
			 }catch(IllegalArgumentException e){
			 }catch(SecurityException e){}
			 catch(IOException e){}
		return true;
	}
	@Override
	public String readFileList(String userId) {
		// TODO Auto-generated method stub
		return "OK";
	}
	
}
