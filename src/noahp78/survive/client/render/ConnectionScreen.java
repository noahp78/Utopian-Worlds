package noahp78.survive.client.render;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


	
public class ConnectionScreen {
	private static Image background;
	private static Image bulb;
	
	public static void Init(){
		try {
			background = new Image("assets/textures/ConnectingBackground.png");
			bulb = new Image("assets/textures/ConnectingBulb.png");
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void render(GameContainer gc, Graphics g) throws SlickException {
		background.draw(0,0);
		
		//bulb.draw(50,250);
		//bulb.draw(100,250);
		//bulb.draw(150,250);
		
		//Render a nice GUI to show our server connection progress
		// A bar with points going to a server
	}
}
