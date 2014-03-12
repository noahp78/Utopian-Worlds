package noahp78.survive.server.tick;

import java.util.TimerTask;

import noahp78.survive.server.tick.tiles.worldTick;
import noahp78.survive.util.logManager;

public class TickHandler{
	public static void Tick(){
		worldTick.TickWorld();
	}
	
}
