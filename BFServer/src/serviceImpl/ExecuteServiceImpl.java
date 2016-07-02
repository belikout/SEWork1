//请不要修改本文件名
package serviceImpl;



import service.ExecuteService;


public class ExecuteServiceImpl implements ExecuteService {

	/**
	 * 请实现该方法
	 */
	@Override
	public String execute(String code, String param)  {
		char[] pr=new char[5000];
		int i=0;
		int d=0;
		int sgn=0;
		String res="";
		int[] s=new int[500];
		try{
		for(int j=0;j<code.length();j++){
			switch(code.charAt(j)){
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
		}catch(Exception e){
			e.printStackTrace();
			return "Program Error";
		}
	
	
		return res;
	}
	
}
