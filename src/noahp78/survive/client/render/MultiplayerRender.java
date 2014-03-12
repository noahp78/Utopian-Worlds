package noahp78.survive.client.render;

import java.util.HashMap;

import noahp78.survive.client.clientSidePlayer;
import noahp78.survive.util.logManager;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;




public class MultiplayerRender {
	public static int PlayerCount = 20;
	public static HashMap<Integer,clientSidePlayer> PlayerMap = new HashMap<Integer,clientSidePlayer>();
	private static Image playerImage;
	public static void update(){
		
		
	}
	public static void init(){
		try {
			playerImage = new Image("assets/textures/Character.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void Render(GameContainer gc, Graphics g) throws SlickException{
		int PlayerCountdown = 0;
		//System.out.println("playercount= " + PlayerCount);
		while ( PlayerCountdown != PlayerCount ){
			clientSidePlayer p = PlayerMap.get(PlayerCountdown);
			if (p!=null){
			System.out.println("Drawing charID: " + PlayerCountdown + " at: (X,Y): " + p.CharX*32 + "," + p.CharY*32);	
			int x = p.CharX*32;
			int y = p.CharY*32;
			playerImage.draw(y,x);
			}
			if (p==null){
				
			}
			PlayerCountdown ++;
			}
		}

	
	public static void playerjoin(int CharID){
			clientSidePlayer p = new clientSidePlayer();
			p.CharID = CharID;
			p.CharX = 0;
			p.CharY = 0;
			//TODO implement Skin Systems
			PlayerMap.put(CharID, p);
	}
	public static void playerLeave(){
		PlayerCount--;
		
	}
	public static void playerMove(int charID, int x, int y){
		clientSidePlayer p = (clientSidePlayer) PlayerMap.get(charID);
		if (p==null){
			logManager.LogCritWarning("didn't find CharID: " + charID);
			logManager.LogCritWarning("Null In playerDataMap on client... This might crash client side!.");
			logManager.LogCritWarning("Reporting this with LogLevel Debug might help the developer fix this problem!");
			
		}
		if (p!=null){
		p.CharX = x;
		p.CharY = y;
		PlayerMap.remove(charID);
		PlayerMap.put(charID, p);
		}
	}
}
