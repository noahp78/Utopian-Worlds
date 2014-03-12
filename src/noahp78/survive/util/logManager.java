package noahp78.survive.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Random;

public class logManager {
	private static int LogLevel = 6;
	private static HashMap messages = new HashMap();
	private static int LinesinError = 0;
	
	
	// 6 is debug
	// 5 is all warnings
	// 4 is information
	// 3 is Only Critical warnings
	// 2 is only Crash reports
	public static void init(){
		try {
			new logManager().ReadNiceCrashDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void ReadNiceCrashDetails() throws Exception{
		InputStream in = getClass().getResourceAsStream("/assets/crashmessages.txt");
		//System.out.println(in);
		
		Reader freader = new InputStreamReader(in, "utf-8");
		BufferedReader br = new BufferedReader(freader);
		String line = "test";
		
		//String line = br.readLine();
		while ((line) != null) {
			line = br.readLine();
		   // process the line.
			LinesinError++;
			messages.put(LinesinError, line);
			//System.out.println(line);
			
		}
		br.close();
		//LogCrash("Test");
		//LogCrash("Test");
		//LogCrash("Test");
		
	}
	public static void LogDebug(String Message){
		if (LogLevel>5){
			System.out.println("[Debug] " + Message );
		}
	}
	
	public static void LogWarning(String Message){
		if (LogLevel>4){
			System.out.println("[Warning] " + Message);
		}
		
	}
	public static void LogInfo(String Message){
		if (LogLevel>3){
			System.out.println("[Info] " + Message);
		}
	}
	public static void LogCritWarning(String Message){
		if (LogLevel>2){
			System.out.println("[!Critical Warning!] " + Message + " [!Critical Warning!]");
			
		}
	}
	public static void LogCrash(String Message){
		System.out.println("-------- Utopian Worlds --------");
	    Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(LinesinError);
	    System.out.println(messages.get(randomInt));
	    //TODO add PC and World Information to log
	    System.out.println("Stack Trace:");
	    System.out.println(Message);
	    System.out.println("Debug information from the Enviroment");
	    
	    
	    
	}

}
