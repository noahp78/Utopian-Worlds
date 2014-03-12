package noahp78.survive.server.generators;

import java.util.Random;

import noahp78.survive.server.serverStart;

public class WorldGenV1 {
	/** Generate a simple world. Only trees are spawned.
	 * 
	 */
	public static void GenerateWorld(){
		int x = 0;
		int y = 0;
		while( x < 100 ) {
			x++;
			while (y<100){
				y++;
				String Combined = (y + ":" + x);
				serverStart.worldMap.put(Combined,"1");
				
			}
			y=0;
		}
		int treegen=0;
		while(treegen < 200){
	treegen++;
	Random randomGenerator = new Random();
	int randomX = randomGenerator.nextInt(100);
	int randomY = randomGenerator.nextInt(100);
	String Combined = (randomX + ":" + randomY);
	//worldMap.remove(Combined);
	serverStart.worldMap.put(Combined, "2");
	//System.out.println(Combined + " : 2");
	
	serverStart.getWorldGenMap().put(Combined, "2");
	
}
	}
}
