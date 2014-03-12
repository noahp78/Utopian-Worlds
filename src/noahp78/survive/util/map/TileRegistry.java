package noahp78.survive.util.map;

import java.util.HashMap;

import noahp78.survive.util.logManager;

public class TileRegistry {
	private static HashMap<Integer, BasicTile>TileRegister = new HashMap<Integer, BasicTile>();
	private static int tileCount = 0;
	/**
	 * Adds a tile to the WorldRegistry, Returns the specific ID of the tile
	 * @param tile = the BasicTile to add to the registers
	 */
	public static int Register(BasicTile tile){
		tileCount++;
		TileRegister.put(tileCount, tile);
		return tileCount;
	}
	/** Remove a tile from the registry.
	 *  (Why would you want to use this?)
	 * @param TileID
	 */
	public static void RemoveTile(int TileID){
		TileRegister.remove(TileID);
	}
	/** Get's the tile from the TileRegistry
	 * 
	 */
	public static BasicTile getTile(int TileID){
		BasicTile tile = TileRegister.get(TileID);
		if (tile!= null){
			return tile;
		}else{
			logManager.LogCritWarning("TileRegistry Couldn't find tileID " + TileID + " sending null back and hoping that mod can handle it.");
			return null;
		}
		
		
		
	}
	public static int getTileCount(){
		return tileCount;
		
	}
}
