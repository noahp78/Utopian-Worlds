package noahp78.survive.server.commands;

public class CommandHelp{

	public static String response(String Sender, String Command) {
		// TODO Auto-generated method stub
		String[] splited = Sender.split("\\s+");
		System.out.println(splited[0]);
		System.out.println(splited[1]);
		if (splited[1] != null) {
			if (splited[1].equals("help")){
				return "Simple command to get help for all other commands";
			}
		//	System.out.println("Noah Mode");
	    //	  return "usage: help <command>";
	    	  
	    }

		return "Usage: help <command";
		
	}

}
