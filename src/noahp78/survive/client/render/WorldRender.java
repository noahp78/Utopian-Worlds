package noahp78.survive.client.render;

import java.util.HashMap;

import noahp78.survive.util.map.BasicTile;
import noahp78.survive.util.map.TileRegistry;

import org.newdawn.slick.Image;

public class WorldRender {
	public static HashMap<String, BasicTile>WorldMap = new HashMap<String, BasicTile>();
	public static HashMap<Image, Integer>TileImage = new HashMap<Image, Integer>();
	
	public static void AddTileToMap(BasicTile tile, int x, int y){
		WorldMap.put(x + ":" + y, tile);
	}
	public static void init(){
		//Hoping all mods are loaded now and reading all the tileIDS and their tilemaps
		int TotalTiles = TileRegistry.getTileCount();
		while (TotalTiles!=0){
			TileImage.put(TileRegistry.getTile(TotalTiles).tileImage, TotalTiles);
			TotalTiles--;
			
		}
	}
	public static void Render(){
		//Loop the loop
		int x1=-1;
		int y1=-1;
		while( x1 < 100 ) {
			x1++;
			while ( y1 < 100){
				y1++;
				String Combined = (x1 + ":" + y1);
				//TODO implement viewport rendering
					BasicTile tile2 = WorldMap.get(Combined);
					tile2.tileImage.draw(x1*32,y1*32);
				}
				
			}
			y1=-1;
		}
		
	}
