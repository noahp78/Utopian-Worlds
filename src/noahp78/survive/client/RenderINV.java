package noahp78.survive.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class RenderINV {
	public static Image Overlay;
	
	public static void init() throws SlickException{
		Overlay = new Image("assets/textures/InvOverlay.png");
	}
	public static void render(GameContainer gc, Graphics g) throws SlickException {
		Overlay.draw(0, 0);
		
	}
	

}
