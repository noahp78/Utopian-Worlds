package noahp78.survive.server.managers;

import java.util.HashMap;

import noahp78.survive.server.managers.ServerSidePlayer;
import noahp78.survive.util.authUtils;

public class PlayerManager {
	private static HashMap players = new HashMap();
	
	
	@SuppressWarnings("unchecked")
	public static boolean AddPlayerToServer(ServerSidePlayer player, String Username, String Token, String IP){
		try {
			if (authUtils.CheckAuth(Username, Token, IP)!=false){
				System.out.println(Username + " is connecting to this server!");
				players.put(player, Username);
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	}
	public static ServerSidePlayer getPlayer(String Username){
		return (ServerSidePlayer) players.get(Username);
	}
	
	
}
