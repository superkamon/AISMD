package ais.co.th.initial;

import org.apache.log4j.PropertyConfigurator;


import ais.co.th.md.Main;

public class log4j_initial {
	
	//public static final Logger logger = LoggerFactory.getLogger( log4j_initial.class );	
	public static void initial_log_probperty () {
		
		try {
			
			//PropertyConfigurator.configure("/Users/KengKamon/Desktop/config/log4j.properties");	//
			PropertyConfigurator.configure("etc/log4j.properties");
		
		}catch(Exception e){
			
			e.printStackTrace();
			Main.logger.error(""+e);
		}
				
	}

}
