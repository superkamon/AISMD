package ais.co.th.md;


import java.net.ServerSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ais.co.th.initial.log4j_initial;
import ais.co.th.md.ServerSite.*;


public class Main {

	private static  int PORT = 0;
	//private static HashSet<String> names = new HashSet<String>();
	//private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	public static final Logger logger = LoggerFactory.getLogger( log4j_initial.class );	


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		initail_config();

		System.out.println("now port value is "+PORT);
		System.out.println("The chat server is running.");

		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				new Handler(listener.accept()).start();
			}
		}
		catch(Exception e){
			System.out.println("in main catch "+e);
		} finally {
			System.out.println("The chat server is stop.");
			listener.close();
		}


	}

	private static void initail_config (){

//		log4j_initial.initial_log_probperty();
		//String port = JsonReadFromFile.JsonReader("/Users/KengKamon/Desktop/config/port_config.txt");//
//		String port = JsonReadFromFile.JsonReader("etc/port_config.txt");
//		PORT = Integer.parseInt(port);
		PORT = Integer.parseInt("1272");

	}


}
