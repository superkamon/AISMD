package ais.co.th.md;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//import java.util.HashSet;
import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;



/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */

public class ServerSite { 	

	// The set of all names of clients in the chat room.   
	//private static HashSet<String> names = new HashSet<String>();

	public static class Handler extends Thread {
		private String name ;
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;

		/**
		 * Constructs a handler thread, squirreling away the socket.
		 * All the interesting work is done in the run method.
		 */
		public Handler(Socket socket) {			
			this.socket = socket;

			try {// Create character streams for the socket.
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
			}catch(IOException e){
				System.out.println("Error While Initiate BufferReader and PrintWriter : " + e);
			}

		}

		public void run() {
			try {
				// Request a name from this client.  
//				name = checkLogin();//(in, out);	                
//				Main.logger.info("User "+name+" Login | Port = "+socket.getPort());
//				System.out.println("User "+name+" Login | Port = "+socket.getPort());  
				
				// Accept messages from this client and broadcast them.				
				while (true) {					
					String input = in.readLine();

					if (input == null) { 
						System.out.println("input user "+name+" == null " + input);
						break;					
						
					}else{
				//String process function	
					TL1process TL1process =	new TL1process(input); 
					String outTl1 = TL1process.outTl1;	
					String gateway = TL1process.Gateway[0];
										
						if (gateway == "False") { 							
							System.out.println("ERROR EMS gateway is invalid ");
							break ;
							
						}else {	
							int port = Integer.parseInt(TL1process.Gateway[1]);
				//make connection to NMS
							ArrayList<String> response = ConnectEMS.makeConnection(gateway,port,outTl1);							
							for (int i=0;i<response.size();i++)	{
								out.println(response.get(i));
							}												

							break;
						}										
					}

					
					//Receive input

				}

			} catch (Exception e) {	            	
				System.out.println("## ClassName ServerSite");
				System.out.println("   |-> Error in Catch " + e);
				//Main.logger.error(""+e);

			} finally {// This client is going down! by close session 

				try {					
					socket.close();
				} catch (IOException e) {
					//Main.logger.error("Canot close Socket : "+e);
					System.out.println("cannot close socket "+e);
				}
				System.out.println("Socket Closed");
			}
		}

		private String checkLogin() {//(BufferedReader in,PrintWriter out) {//throws IOException {
			String Username ="";

			try {
				//check whitespace & null value // should edit to login function 
				do{
					out.println("== Please Input Your Name ==");
					Username = in.readLine();
				}while (Username.isEmpty() || Username.trim().length()==0 );  

			}catch (Exception e) {
				System.out.println(e);
			}

			return Username;

		}
	}
}





