package noahp78.survive.client.networking;

import java.io.IOException;
import java.util.HashMap;

import noahp78.survive.client.main;
import noahp78.survive.client.render.MultiplayerRender;
import noahp78.survive.client.render.timeRender;
import noahp78.survive.networking.NetworkingUtil;
import noahp78.survive.util.logManager;
import noahp78.survive.networking.requests.*;
import noahp78.survive.networking.responses.*;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class mainClient {
	public static HashMap TempWorldMap = new HashMap();
	public static int charID = 1;
	public static Connection Connect;
	//public static Client client;
	
	
	
	public static void Connect(String IP, int Port){
		final Client client;
		client = new Client(65536,65536);
	    client.start();
	    Port = 51213;
	    
	    Kryo kryo = client.getKryo();
	    NetworkingUtil.register(client);
	    //kryo.register(SomeResponse.class);
	    try {
			client.connect(5000, IP, Port, (Port+1));
		} catch (IOException e) {
			logManager.LogCrash(e.getStackTrace().toString());
		}
	    //Send our first packet. INIT packet :D
	    //charID++;
	    //MultiplayerRender.PlayerCount++;
	    initRequest request = new initRequest();
	    request.ClientVersion="Dev1";
	    client.sendTCP(request);
	    
	    
	    client.addListener(new Listener() {
	        public void received (Connection connection, Object object) {
	        	if (object instanceof initResponse){
	        		Connect = connection;
	        		if (((initResponse) object).mayConnect){
	        			logManager.LogInfo("Connecting to server running " + ((initResponse) object).ServerVersion);
	        			MultiplayerRender.PlayerCount = ((initResponse) object).playercount;
	        			
	        			charID = ((initResponse) object).playercount;
	        			MultiplayerRender.PlayerCount=((initResponse) object).playercount;
	        			
	        			int tempPlayerCount = 1;
	        			if (charID != 1){
	        				while (tempPlayerCount != charID){
	        					MultiplayerRender.playerjoin(tempPlayerCount);
	        					tempPlayerCount++;
	        					
	        				}
	        				
	        			}
	        			MultiplayerRender.playerjoin(((initResponse) object).playercount);
	        			authRequest request = new authRequest();
	        			request.token = main.token;
	        			request.username = main.username;
	        			request.ip = main.ip;
	        			
	        			
	        			connection.sendTCP(request);
	        			
	        		}
	        	}
	        	if (object instanceof authResponse){
	        		logManager.LogDebug("Got: " + (((authResponse) object).GoOn) + " on my auth request");
	        		if (((authResponse) object).GoOn){
	        			//TODO Future Connection
	        			logManager.LogDebug("[clientconnection] Allowed to connect to server");
	        			gamedataRequest request = new gamedataRequest();
	        			request.username = main.username;
	        			connection.sendTCP(request);
	        			
	        		}
	        	}
	        	if (object instanceof gamedataResponse){
	        		HashMap TempWorldMap2 = ((gamedataResponse) object).WorldMap;
	        		int x1=0;
	        		int y1=0;
	        		//charID = (((gamedataResponse) object).PlayerCount);
	        		int PlayerTempCount = 0;
	        		while(PlayerTempCount != (((gamedataResponse) object).PlayerCount)) {
	        			MultiplayerRender.playerjoin(charID);
	        			logManager.LogDebug("[client] Adding player");
	        			PlayerTempCount++;
	        		}
	        		
	        				while( x1 < 100 ) {
	        					x1++;
	        					while (y1<100){
	        						y1++;
	        						String Combined = (y1 + ":" + x1);
	        						String Value = (String) TempWorldMap2.get(Combined);
	        						//System.out.println(Value);
	        						
	        						//if (((gamedataResponse) object).WorldMap.get(Combined) != null){
	        							if (Value != null){
	        								TempWorldMap.put(Combined,Value);
	        								//System.out.println("Got " + Combined + ":" + Value);
	        								
	        							//TempWorldMap.put(Combined, ((gamedataResponse) object).WorldMap.get(Combined));
	        						}
	        						
	        						//main.m.put(Combined, (TempWorldMap.get(Combined)));
	        						//System.out.println(TempWorldMap.get((Combined)));
	        						
	        						
	        					}
	        					y1=0;
	        					//System.out.println("Doing"+ x1);
	        					
	        				}
	        				
	        				main.UpdateGrassMap();
	        				main.Menu = 0;
	        				main.FrameCount = 0;
	        				
	        				
	        	}
	        	if (object instanceof moveResponse){
	        		int CharID = ((moveResponse) object).CharID;
	        		if (CharID != 1){
	        			MultiplayerRender.playerMove(((moveResponse) object).CharID, ((moveResponse) object).x, ((moveResponse) object).y);
	    	        		
	        		}
	        		if (CharID==1){
	        			MultiplayerRender.playerMove(((moveResponse) object).CharID, ((moveResponse) object).x, ((moveResponse) object).y);
	        		}
	        	}
	        	if (object instanceof playerJoinEvent){
	        		int newCharID = 0;
	        		MultiplayerRender.PlayerCount = (((playerJoinEvent) object).charID);
	        		newCharID = ((playerJoinEvent) object).charID;
	        		//System.out.println("[MainClient][playerjoinEvent] Player with id: " + newCharID + " joined the game world");
	        		
	        		//MultiplayerRender.PlayerCount = (MultiplayerRender.PlayerCount);
	        		MultiplayerRender.playerjoin(newCharID);
	        		logManager.LogDebug("Player Joined game with gameID");
	        		
	        	}
	           //if (object instanceof SomeResponse) {
	             // SomeResponse response = (SomeResponse)object;
	             //System.out.println(response.text);
	           //}
	        	if (object instanceof timeResponse){
	        		timeRender.Time = ((timeResponse) object).newTime;
	        		
	        	}
	        	
	        }
	     });
	    
		
	}
	public static void MovePlayer(int x, int y){
		//int x2 = x/32;
		//int y2 = y/32;
	    moveRequest request = new moveRequest();
	    request.CharID = charID;
	    request.tileX = x;
	    request.tileZ = y;
	    //System.out.println("making request with ID: " + charID);
		Connect.sendTCP(request);
	}
}
