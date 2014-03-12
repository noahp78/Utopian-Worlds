package noahp78.survive.client.render;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class MainMenu {
	private static Image buttonDisabled;
	private static Image buttonEnabled;
	private static Image background;
	public static int SelectedMenu = 1;
	
	
	public static void Init()throws SlickException{

		System.out.println("Preparing Main Menu");
		buttonDisabled = new Image("assets/textures/buttonDisabled.png");
		buttonEnabled = new Image("assets/textures/buttonEnabled.png");
		background = new Image("assets/textures/BackgroundTemp.png");
		
	}
	
	public static void render(GameContainer gc, Graphics g) throws SlickException {
		background.draw(0,0);
		//buttonEnabled.draw(50,100);
		//buttonDisabled.draw(50,150);
		
		
		if (SelectedMenu==1){
			buttonEnabled.draw(50,100);
			buttonDisabled.draw(50,150);
		}
		if (SelectedMenu==2){
			buttonDisabled.draw(50,100);
			buttonEnabled.draw(50,150);
		}
		
		
		
		//Finaly, Draw text
		g.drawString("Play on DEV servers", 55, 106);
		
	
	}

}
