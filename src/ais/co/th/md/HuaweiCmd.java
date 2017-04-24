package ais.co.th.md;

public class HuaweiCmd {
	static String cmdType;
	static String output;


	public static String getOutputTl1(String[] inputParam) {
		output = chkCmdType(inputParam);
		debug(output);
		return output;
	}

	private static String chkCmdType(String[] inputParam) {
		cmdType = inputParam[1];
		String outputTl1;

		switch (cmdType) {
		
		case "LOGIN" :
				outputTl1 = "LOGIN:::CTAG::UN="+inputParam[2]+",PWD="+inputParam[3]+";";
			return outputTl1;
			
		case "ADD-ONU" : 
				outputTl1 ="ADD-ONT::DEV="+inputParam[2]+",FN="+inputParam[3]+",SN="+inputParam[4]+",PN="+inputParam[5]
							+",ONTID="+inputParam[6]+":6::NAME="+inputParam[2]+"/"+inputParam[3]+"/"+inputParam[4]+"/"+inputParam[5]
							+"/"+inputParam[6]+",ALIAS="+inputParam[7]+",LINEPROF="+inputParam[8]+",SRVPROF="+inputParam[10]
							+",AUTH=ALWAYS_ON,PWD="+inputParam[9]+";";
			return outputTl1;

		case "CRT-SERVICEPORT" :
			//
			return null;

		case "MOD-ONT" :
			return null;

		case "" :
			//ZtCmd tl1Cmd = new ZtCmd(cmdTL1);
			return null;

		default : 
			System.out.println("## ClassName HuaweiCmd");
			System.out.println("   |-> ERROR method chkCmdTyp | cmdType = "+cmdType);
		return "FALSE" ;

		}
	}
	
	private static String debug(String inputParam) {
		System.out.println("## ClassName HuaweiCmd" );
		System.out.println("   |-> method chkCmdTyp | cmdType = "+cmdType);
		System.out.println("      |-> outputTl1 = "+output);
		//System.out.println("==========END==========");
		return null;
	}
}

