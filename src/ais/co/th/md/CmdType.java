package ais.co.th.md;

public class CmdType{
	
	static String[] Login (String cmdTL1) {
		String[] words = cmdTL1.split(",");
		String cmdType = cmdTL1.substring(0,cmdTL1.indexOf(":::"));
		String username = words[0].substring(words[0].lastIndexOf("=")+1);
		String password = words[1].substring(words[1].lastIndexOf("=")+1);
		String brand = words[2].substring(words[2].lastIndexOf("=")+1,words[2].length()-1);
		return new String[] { brand,cmdType,username,password } ;
	}
	
	
	static String[] AddOnu (String cmdTL1) {
		String[] words = cmdTL1.split(",");
		String cmdType = cmdTL1.substring(0,cmdTL1.indexOf("::"));
		String olt_name = words[0].substring(words[0].lastIndexOf("=")+1);
		String FN = words[1].substring(words[1].length()-1);
		String SN = words[2].substring(words[2].length()-1);
		String PN = words[3].substring(words[3].length()-1);
		String onu_id = words[4].substring(words[4].lastIndexOf("=")+1);
		String non = words[5].substring(words[5].lastIndexOf("=")+1);
		String lineProfile = words[6].substring(words[6].lastIndexOf("=")+1);
		//String servProf = words[7].substring(words[7].lastIndexOf("=")+1);
		String pwd = words[7].substring(words[7].lastIndexOf("=")+1);
		String onu_type = words[8].substring(words[8].lastIndexOf("=")+1,words[8].length()-1);
		String brand = olt_name.substring(olt_name.length()-2);
		
		return new String[] { brand,cmdType,olt_name,FN,SN,PN,onu_id,non,lineProfile,pwd,onu_type } ;
	}
	
	
	

}
