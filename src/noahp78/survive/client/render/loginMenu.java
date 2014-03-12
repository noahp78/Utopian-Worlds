package noahp78.survive.client.render;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.gui.TextField;

public class loginMenu {
	private static Image background;
	private static Image bulb;
	private static UnicodeFont font;
	private static TextField textField;
	private static TextField passField;
	public static String username = null;
	public static String password = null;
	
	
	
	public static void Init(GameContainer gc){
		try {
			background = new Image("assets/textures/ConnectingBackground.png");
			bulb = new Image("assets/textures/ConnectingBulb.png");
			font = new UnicodeFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.ITALIC, 26));
		    //textField = new TextField(gc, [color=#4000FF]gc.getDefaultFont(), [/color]400, 300, 300, 50);  // <- i get a error here and the fix is to cast argument gc to GUIContext// i replaced your font in the constructor with the container's default font and it works.
		    textField = new TextField(gc, gc.getDefaultFont(), 120, 120, 150, 50);
			textField.setText("Username");
			passField = new TextField(gc, gc.getDefaultFont(), 120, 190, 150, 50);
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void render(GameContainer gc, Graphics g) throws SlickException {
	background.draw(0,0);
	g.drawString("Username", 20, 120);
	g.drawString("Press Enter to start the game.", 20, 190);
	textField.render(gc, g);
	//passField.render(gc, g);
	username = textField.getText();
	//password = passField.getText();
	
	}

}
