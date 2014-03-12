package noahp78.survive.client.render;

import noahp78.survive.util.logManager;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class timeRender {
	public static int Time;
	private static float lightLevel = 0.0F;
	public static void render(GameContainer gc, Graphics g) throws SlickException {
		RecalculateLight();
		g.setColor(new Color(0.1f, 0.1F, 0.1f, lightLevel));
		g.fillRect(0, 0, 640, 800);
	}
	public static void TimeTick(){
		Time++;
	}
	public static void RecalculateLight(){
		if (Time < 180){
			//It's day!
			lightLevel = 0.0F;
		}else if (Time > 180){
			if (Time > 300){
				// It's night
				lightLevel =0.9F;
				
			}else{
				lightLevel = (float) ((float)(Time-180.0)*(1.0/120.0f));
			}
		}
		
		
		
	}
}
