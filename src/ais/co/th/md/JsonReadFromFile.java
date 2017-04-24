package ais.co.th.md;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;




public class JsonReadFromFile {
	
	public static String JsonReader(String path) {
		// TODO Auto-generated method stub
		
        JSONParser parser = new JSONParser();
        String port = null;
        
        try {
 
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;            
            port = (String) jsonObject.get("Port");
            
            Main.logger.debug("######### get Port = "+port+" from config ");
 
        } catch (Exception e) {
            e.printStackTrace();
            Main.logger.error(""+e);
        }
        
        
        return port;
	}
	

}
