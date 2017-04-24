package ais.co.th.md;

public class ZteCmd {	
	static String cmdType;
	static String output;


	public static String getOutputTl1(String[] inputParam) {
		// TODO Auto-generated method stub

		output = chkCmdType(inputParam);
		debug(output);
		return output;
	}

	private static  String chkCmdType(String[] inputParam) {
		cmdType = inputParam[1];
		String outputTl1;
		
		switch (cmdType) {
		
		case "LOGIN" :
			outputTl1 = "LOGIN:::CTAG::UN="+inputParam[2]+",PWD="+inputParam[3]+";";
			return outputTl1;
		
		case "ADD-ONU" : 
			outputTl1 ="ADD-ONU::OLTID="+inputParam[2]+",PONID=1-1-"+inputParam[4]+"-"+inputParam[5]+":200::AUTHTYPE=PASSWORD,ONUNO="+
							inputParam[6]+",ONTID="+inputParam[9]+",ONUTYPE="+inputParam[10]+",NAME="+inputParam[7]+";";
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
			System.out.println("## ClassName ZteCmd");
			System.out.println("   |-> ERROR method chkCmdTyp | cmdType = "+cmdType);
		return "FALSE" ;

		}
	}



	private static String debug(String inputParam) {
		System.out.println("## ClassName ZteCmd" );
		System.out.println("   |-> method chkCmdTyp | cmdType = "+cmdType);
		System.out.println("      |-> outputTl1 = "+output);
		//System.out.println("==========END==========");
		return null;
	}

}