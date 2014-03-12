package noahp78.survive.server.tick.tiles;

import noahp78.survive.server.serverStart;

public class worldTick {
	public static int time=300;
	
	public static void TickWorld(){
		timeTick();
		
		//Go through ALL the worlds and find if they need a tick from the TickMap
		
	}
	/** Overwrites the MAXTILESFORTICK and adds another tile to be ticked.
	 * @param
	 * 
	 * 
	 */
	public static void timeTileTick(int TileX, int TileY){
		
	}
	/** Let the time jump forward a little bit.
	 *  Time can be anything between 0 and 480. And should reset to 0 after 480
	 * 
	 */
	public static void timeTick(){
		if (time==480){
			time=0;
			
		}else{
			time++;
		}
		serverStart.SendnewTime(time);
	}
}
