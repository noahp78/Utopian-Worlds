package noahp78.survive.server;

import java.util.HashMap;

public class LocationManager {
	public static HashMap m = new HashMap();
	
	public static void moveChar(int ID, int Xcor, int Zcor){
		String Combined = (Integer.toString(Xcor) + ":" +   Integer.toString(Zcor));
		System.out.println("Character " + ID + " moved to " + Combined);
		m.put(ID,Combined);
		
		
		
	}
	public static String GetCharLocation(int ID){
		return m.get(ID).toString();
	}
	public static int GetCharID(int Xcor, int Zcor){
		String Combined = (Integer.toString(Xcor) + ":" +   Integer.toString(Zcor));
		
		
		return (int) m.get(Combined);
	}
	
}
