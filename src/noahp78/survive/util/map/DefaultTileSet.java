package noahp78.survive.util.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DefaultTileSet {
	public static void init() throws SlickException{
		BasicTile GrassTile = new BasicTile();
		GrassTile.Humanname="Grass";
		GrassTile.techName="game.GrassTile";
		GrassTile.tileImage = new Image("assets/textures/grassMap.png");
		TileRegistry.Register(GrassTile);
		TileRegistry.Register(GrassTile);
	}
}
