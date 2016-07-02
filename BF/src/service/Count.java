package service;

public class Count {
public static String count(String str){
	int[] c=new int[8];
	
	for(int i=0;i<str.length();i++){
		switch(str.charAt(i)){
		case'>':c[0]++;
		break;
		case'<':c[1]++;
		break;
		case',':c[2]++;
		break;
		case'.':c[3]++;
		break;
		case'+':c[4]++;
		break;
		case'-':c[5]++;
		break;
		case'[':c[6]++;
		break;
		case']':c[7]++;
		break;
		default:break;
		}
	}
	String s="";
	for(int i=0;i<8;i++){
		s+=Integer.toString(c[i]);
		s+=" ";
	}
	s=s.substring(0, s.length()-1);
	return s;
}
}
