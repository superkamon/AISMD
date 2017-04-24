package ais.co.th.md;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class ConnectEMS {
	static String res;

	//BufferedReader in;
	//PrintWriter out;
	
	
	
	/**
	 * Connects to the server then enters the processing loop.
	 * @throws InterruptedException 
	 */
	static ArrayList<String> makeConnection (String emsIP,int port,String cmd) throws IOException, InterruptedException{

		// Make connection and initialize streams
		String serverAddress = emsIP;
		Socket socket = new Socket(serverAddress,port);
		System.out.println("## ClssName ConnectEMS");
		System.out.println("   |-> method makeConnection => "+serverAddress+":"+port);	
		System.out.println("   |-> cmd sent to EMS = "+cmd);

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			//-> send tl1 to EMS			
			out.println(cmd);

			//-> get response 					
			ArrayList<String> output = new ArrayList<String>();	
			
			while (true){
				res = in.readLine();
				String msg = "ENDESC";

				if (res.contains(msg)) {
					System.out.println(res);
					output.add(res);
					break;
				}						
				System.out.println(res);
				output.add(res);										
			}


			//				debug(cmd,res);
			//				socket.close(); 
			return output;

		}catch (Exception e){
			e.printStackTrace();
			ArrayList<String> x = new ArrayList<String>();	
			x.add("Error when create connection to EMS : "+e) ;
			return x ;

		}finally {
			try {					
				socket.close();
			} catch (IOException e) {
				//Main.logger.error("Canot close Socket : "+e);
				System.out.println("cannot close socket : "+e);
			}
			System.out.println("Socket closed") ;



		}
	}
	
	private static String debug(String socket,String response) {
		System.out.println("## ClassName ConnectEMS" );
		System.out.println("   |-> Connect to  = "+socket);
		System.out.println("   |-> response = "+response);
		//System.out.println("==========END==========");
		return null;
	}
	
}




