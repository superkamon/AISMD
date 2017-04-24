package ais.co.th.md;

public class TL1process {
	String inTL1;
	String brand;
	String[] Gateway;
	String[] inputParam;
	String outTl1;

	
	public TL1process (String cmdTL1) {
		this.inTL1=cmdTL1;
		debug(inTL1);
		inputParam = Process.getInputParam(cmdTL1);		
		
		if (inputParam.length > 0 && inputParam[0] != "False"){	
			Gateway = getGateway(inputParam[0]);			
			if (Gateway[0] != "False" ){
				outTl1 = refomat(inputParam);
			}else{
				outTl1 = "False";			
			}			
		}else{
			Gateway = new String [] {"False"};
			outTl1 = "False";
		}			
	}

	
	private String refomat ( String[] inputParam){
		brand = inputParam[0];
		
		switch (brand) {
		case "HW":
				outTl1 = HuaweiCmd.getOutputTl1(inputParam);			
			return outTl1;
			
		case "ZT":
			outTl1 = ZteCmd.getOutputTl1(inputParam);		
			return outTl1;
		
		case "FH":
			outTl1 = FiberHomeCmd.getOutputTl1(inputParam);		
			return outTl1;
		
		default:
			System.out.println("## ClassName "+getClass().getEnclosingMethod().getName());
		  	System.out.println("   |-> ERROR method refomat");
			return "False";
		}	
	}
	
	
	private String[] getGateway (String brand) {
		String ip;
		String port;
		
		switch (brand) {
		
		case "HW" :  ip = "10.104.140.93" ;  port = "9819";
			return new String[] {ip,port} ;
			
		case "FH" :	 ip = "10.104.140.92" ;  port = "3337";
			return new String[] {ip,port} ;
			
		case "ZT" :  ip = "10.104.140.94" ;  port = "9830";
			return  new String[] {ip,port} ;
			
		default : 
			System.out.println("## ClassName "+getClass().getSimpleName());
			System.out.println("   |-> ERROR method getGateway | Brand = "+brand);
			return  new String[] {"False"};
		}
						
	}
	

	private String debug(String inputParam) {
		System.out.println("## ClassName "+getClass().getSimpleName());
		System.out.println("   |-> input Tl1 = "+inputParam);
		//System.out.println("==========END==========");
		return null;
	}
}
