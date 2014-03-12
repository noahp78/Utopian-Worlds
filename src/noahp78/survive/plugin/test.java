package noahp78.survive.plugin;

import noahp78.survive.plugin.events.ClientStartEvent;
import noahp78.survive.plugin.loader.BasicPlugin;

public class test implements BasicPlugin {
	
	@EventHandler
	public static void handle(ClientStartEvent event){
		
	}

	@Override
	public String GetVersion() {
		// TODO Auto-generated method stub
		return "V0.1";
	}
}
