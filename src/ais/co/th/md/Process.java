package ais.co.th.md;

public class Process {
	static String cmdType ;
	
	public static String[] getInputParam (String cmdTL1){
		String[] inputParam;
		
		try { 
		 cmdType = cmdTL1.substring(0,cmdTL1.indexOf("::"));
		 //System.out.println("intry "+cmdType);
		 
		}catch (Exception e) {
			//System.out.println("## ClassName Process Error : "+e);
			cmdType = "False";
		}
		
		
		switch (cmdType) {
		case "LOGIN" :
				inputParam = CmdType.Login(cmdTL1);
			debug(inputParam);
			return inputParam;
		
		case "ADD-ONU" : 
				inputParam = CmdType.AddOnu(cmdTL1);	
			debug(inputParam);
			return  inputParam;

		case "CRT-SERVICEPORT" :
			//
			return null;

		case "MOD-ONT" :
			return null;

		case "" :
			//ZtCmd tl1Cmd = new ZtCmd(cmdTL1);
			return null;

		default :
			System.out.println("## ClassName Process Error");
			System.out.println("   |-> ERROR method getInputParam | cmdType is invalid "+cmdType);
		    return new String[] {"False"} ;

		}
			
	}

	private static String debug(String[] inputParam) {
		System.out.println("## ClassName Process" );
		System.out.println("   |-> case cmdType = "+cmdType);
		for (int i=0 ; i < inputParam.length ; i++ ){
			System.out.println("      |-> inputParam["+i+"] = "+inputParam[i]);
		}
		//System.out.println("==========END==========");
		return null;
	}

		
}
