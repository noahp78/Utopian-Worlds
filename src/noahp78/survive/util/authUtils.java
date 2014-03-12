package noahp78.survive.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Scanner;

public class authUtils {
	
	
	public static boolean CheckAuth(String Username, String Tokens, String IP) throws Exception{
		//TODO REMOVE FAKE AUT
		
		/*
		URL url = null;
		
		try {
			url = new URL("http://www.noahp78.tk/CheckAuth.php?username=" + Username + "&token=" + Tokens +"&IP=" + IP);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner s = new Scanner(url.openStream());
		String Response = s.next();
		if (Response.equals("goodAuthKey")){
			return true;
		}
		System.out.println(Response);
		
		return false;
		*/
		
		//System.out.println("Making connection to: " + "http://www.utopianworlds.tk/CheckAuth.php?username=" + Username + "&token=" + Tokens +"&IP=" + IP);
		//URLConnection connection = new URL("http://www.utopianworlds.tk/CheckAuth.php?username=" + Username + "&token=" + Tokens +"&IP=" + IP).openConnection();
		//connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		//connection.connect();
/*
		BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = r.readLine()) != null) {
		    sb.append(line);
		}
		System.out.println(sb.toString());
		String Response = sb.toString();
		if (Response.equals("goodAuthKey")){
			return true;
		}
		//TODO remove dev option for good auth keys.
		 * 
		 */
		return true;
		
	}
	

}
