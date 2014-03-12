package noahp78.survive.client.render;

import java.util.HashMap;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class chatRender {
	private static HashMap<Integer,String> fullChat = new HashMap<Integer,String>();
	private static HashMap<Integer,Integer> ChatCountdown = new HashMap<Integer,Integer>();
	
	private static int MessagestoShowHigh;
	private static int MessagestoShowLow;
	
	/** Init method required before launching. If it's not called it WILL crash
	 * 
	 */
	public static void Init()throws SlickException{
		MessagestoShowHigh=0;
		MessagestoShowLow=0;
		sendChatMessage("Testing Stuff");
	}
	/**Render method used to render the Chat screen (Window with text entering system)
	 * if no user input is detected after 30 seconds it will auto close
	 */
	public static void render(GameContainer gc, Graphics g) throws SlickException {{
				String Message = fullChat.get(0);
				int y = 300;
				g.drawString(Message, 0, 0);
				
			}
			
		}
		
		
	/**
	 * 
	 * @param message: the message to add to the renderline
	 */
	public static void sendChatMessage(String message){
		fullChat.remove(0);
		fullChat.put(0, message);
	}
}
